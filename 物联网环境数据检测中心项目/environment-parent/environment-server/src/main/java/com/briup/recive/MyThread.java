package com.briup.recive;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Collection;

import com.briup.bean.Environment;
import com.briup.store.IStore;
import com.briup.store.StoreImpl;

public class MyThread extends Thread {

	private Socket socket;

	/**
	 * 创建这样一个线程对象就必须传入socket
	 * @param socket
	 */
	public MyThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		/*
		 * 将数据从socket里面把数据给反序列化出来
		 */
		try {
			// 构建反序列化流
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			// 反序列化为 Collection<Environment>
			Object object = ois.readObject();

			@SuppressWarnings("unchecked")
			Collection<Environment> coll = (Collection<Environment>) object;

			// 就需要对数据进行存储
			IStore store = new StoreImpl();

			// 存储数据
			store.store(coll);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
