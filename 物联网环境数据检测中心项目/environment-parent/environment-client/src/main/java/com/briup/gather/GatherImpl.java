package com.briup.gather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.briup.bean.Environment;
import com.briup.util.FileBackup;
import com.briup.util.FileNameEnums;

public class GatherImpl implements IGather {

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Environment> gather() {
		// 1. 存储解析好的对象
		Set<Environment> set = new HashSet<>();
		try {

			// 2. 构建流
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/radwtmp"));

			// 用来记录字节数
			long count = 0;
			// 读取count.txt文件中记录的数据
			Object object = FileBackup.recover(FileNameEnums.CLIENT_COUNT_PATH.getPath(), true);
			if (object != null) {
				count += (Long) object;
			}

			reader.skip(count);

			String line = null;

			// 解析之前需要把原来存储在 data.txt里面的数据加在到set容器中
			Object oldData = FileBackup.recover("src/main/resources/data.txt", true);
			if (oldData != null) {
				// 将原来的数据放入到新的set集合中
				set.addAll((Collection<? extends Environment>) oldData);
			}

			// reader.readLine 返回值为 null 代表已经读取到文件末尾
			while ((line = reader.readLine()) != null) {

				// 回车\r跟换行\n属于两个字符
				count += line.length() + 2;

				String[] split = line.split("\\|");
				// 数组判空
				if (split == null || split.length == 0) {
					return null;
				}
				Environment enviroment = new Environment();
				// 设置发送端id
				enviroment.setSrcId(split[0]);
				// 设置树莓派id
				enviroment.setDevId(split[1]);
				// 设置试验箱区域id
				enviroment.setRegionId(Long.parseLong(split[2]));

				// 设置传感器个数
				enviroment.setCount(Long.parseLong(split[4]));

				// 设置数据状态 3代表接收 6代表发送
				enviroment.setState(Integer.parseInt(split[5]));

				// 设置数据接收成功的标志
				enviroment.setReviceState(Integer.parseInt(split[7]));

				// 设置数据采集时间
				enviroment.setGatheDate(new Date(Long.parseLong(split[8])));

				if ("16".equals(split[3])) {
					// 设置数据类型
					enviroment.setName("温度");
					// 前四位代表温度数据
					int wResult = Integer.parseInt(split[6].substring(0, 4), 16);
					double data = ((float) wResult * 0.00268127) - 46.85;
					enviroment.setData(data);

					set.add(enviroment);

					// 设置湿度数据
					enviroment = new Environment();
					// 设置发送端id
					enviroment.setSrcId(split[0]);
					// 设置树莓派id
					enviroment.setDevId(split[1]);
					// 设置试验箱区域id
					enviroment.setRegionId(Long.parseLong(split[2]));
					// 设置数据类型
					enviroment.setName("湿度");
					// 设置传感器个数
					enviroment.setCount(Long.parseLong(split[4]));

					// 设置数据状态 3代表接收 6代表发送
					enviroment.setState(Integer.parseInt(split[5]));

					// 设置湿度数据
					int sResult = Integer.parseInt(split[6].substring(4, 8), 16);
					data = ((float) sResult * 0.00190735) - 6;
					enviroment.setData(data);

					// 设置数据接收成功的标志
					enviroment.setReviceState(Integer.parseInt(split[7]));

					// 设置数据采集时间
					enviroment.setGatheDate(new Date(Long.parseLong(split[8])));

					set.add(enviroment);

				} else if ("1280".equals(split[3])) {
					enviroment.setName("二氧化碳");
					double data = Integer.parseInt(split[6].substring(0, 4), 16);
					enviroment.setData(data);

					set.add(enviroment);
				} else {
					enviroment.setName("光照强度");
					double data = Integer.parseInt(split[6].substring(0, 4), 16);
					enviroment.setData(data);
					set.add(enviroment);
				}
			}
			reader.close();
			FileBackup.store("src/main/resources/count.txt", count);
			return set;
		} catch (Exception e) {
			e.printStackTrace();
			/*
			 * 发生异常解析好的数据存储在set集合中
			 */
			try {
				FileBackup.store("src/main/resources/data.txt", set);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return null;
		}

	}

}
