package com.briup.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.briup.bean.Environment;
import com.briup.util.ConnecitonUtils;
import com.briup.util.FileBackup;

public class StoreImpl implements IStore {
	
	private static final Logger logger = Logger.getLogger(StoreImpl.class);

	/**
	 * 实现这个方式，那么实现了数据的存储
	 * 	1.存储数据方案采用 jdbc
	 * 	2. jdbc 采用批处理提交sql执行效率
	 *  3. preparstatement 能够防止sql注入问题还支持动态的参数
	 *  4. 获取连接 所以采用数据库连接池  druid
	 *  5. 数据存储有可能存储成功还有可能存储失败
	 *  	如果存储过程中发生异常，将所有数据回滚，然后将数据进行备份
	 *  	如果下一次存储需要将备份的数据，加载进来然后一起存储
	 *  
	 *  要想进行存储：
	 *  1.
	 *  	导入oracle的驱动包
	 *  	还需要导入 druid连接池
	 *  	编写获取来连接工具类
	 *  2. 获取连接
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void store(Collection<Environment> collection) throws Exception {
		// 将备份的数据加载进来
		Object object = FileBackup.recover("src/main/resources/server-data.txt", true);
		if (object != null) {
			collection.addAll((Collection<? extends Environment>) object);
		}
		
		Connection connection = ConnecitonUtils.getConnection(false);
		try {
			// 获取连接
			
			// 用来记录往缓存池添加的sql条数
			int num = 0;
			// 用来记录天数
			String day = "0";
			
			PreparedStatement ps = null;
			
			// 根据Evironment的采集日期，然后获取到里面的天 最后拼接一下
			for (Environment enviroment : collection) {
				// 获取日期的天数
				String day1 = enviroment.getGatheDate().toString().substring(8);
				
				// 保证了同一天只有一个ps对象
				if (!day.equals(day1)) {
					// 上一次循环，ps缓存池里面还有没执行的sql
					if (ps != null) {
						ps.executeBatch();
						ps.clearBatch();
						// 执行完了以后应该及时关闭
						ps.close();
					}
					
					day = day1; 
					// 拼接sql
					String sql = "insert into tbl_data_" + day + " values(common_seq.nextval,?,?,?,?,?,?,?,?,?)";
					ps = connection.prepareStatement(sql);
				}
				
				ps.setString(1, enviroment.getSrcId());
				ps.setString(2, enviroment.getDevId());
				ps.setLong(3, enviroment.getRegionId());
				ps.setString(4,enviroment.getName());
				ps.setLong(5, enviroment.getCount());
				ps.setInt(6,enviroment.getState());
				ps.setDouble(7, enviroment.getData());
				ps.setInt(8, enviroment.getReviceState());
				ps.setDate(9, enviroment.getGatheDate());
				
				ps.addBatch();
				num ++;
				if (num % 100 == 0) {
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			
			// 等整个循环结束，ps里面有可能还存在没有执行的sql
			if (ps != null) {
				ps.executeBatch();
				ps.clearBatch();
			}
			
			logger.info("存储数据成功");
			connection.commit();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			
			// 执行到一半有可能发生异常 将事务回滚 并且备份数据
			connection.rollback();
			FileBackup.store("src/main/resources/server-data.txt", collection);
		}
	}

}
