package com.briup.send;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.briup.bean.Environment;
import com.briup.send.SendImpl;
import com.briup.util.FileBackup;

public class SendImpl implements ISend {
	private static final Logger logger = Logger.getLogger(SendImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public void send(Collection<Environment> collection) {
		try {
			logger.info("客户端启动...");
			logger.info("正在采集并发送数据...");
			// 发送之前需要将之前备份的数据加载进来
			Object obj = FileBackup.recover("src/main/resources/client-data.txt", true);

			if (obj != null) {
				collection.addAll((Collection<? extends Environment>) obj);
			}
			// 创建Socket
			Socket socket = new Socket("127.0.0.1", 9999);

			// 构建对象输出流/序列化流
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			// 序列化
			oos.writeObject(collection);
			// 刷新
			oos.flush();

			// 关闭资源
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				FileBackup.store("src/main/resources/client-data.txt", collection);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
