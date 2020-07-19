package com.briup.recive;

import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class ReciveImpl implements IRecive {
			
		private static final Logger logger  = Logger.getLogger(ReciveImpl.class);
			
		@Override
		public void recive() {
			try {
				logger.info("服务器启动");
				// 1. 创建ServerSocket对象
				@SuppressWarnings("resource")
				ServerSocket serverSocket = new ServerSocket(9999);
					
			   /*
				* 当accept执行完成，那么三次握手就会建立成功
				* 返回的socket里面就包含了客户端发送过来的数据
				* 服务器是永远开启的
				*/
			logger.info("准备接收" + serverSocket.getInetAddress() + "发送过来的数据...");
			while(true) {
				Socket socket = serverSocket.accept();
			   /*
				*  对socket进行处理
				*  将socket里面存储的客户端发送过来的数据进行反序列化，得到一个Collection
				* 	为了提供程序的效率，我们需要开启一个线程 去处理socket
				*/
			logger.info("正在接收" + serverSocket.getInetAddress()  +"发送过来:数据");
			new MyThread(socket).start();
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
