package com.briup.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.lang3.StringUtils;

public class FileBackup {
	/**
	 * 将数据备份到文件中
	 * @param path	文件的路径
	 * @param object 数据
	 * @throws Exception 
	 */
	public static void store(String path,Object object) throws Exception {
		if (StringUtils.isBlank(path)) {
			return;
		}
		// 1.创建文件
		File file = new File(path);
		
		// 文件不存在就创建一个
		if (!file.exists()) {
			file.createNewFile();
		}
		
		// 构建流
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(object);
		oos.flush();
		oos.close();
	}
	
	/**
	 * 从文件中读取数据
	 * @param path 文件路径
	 * @param isDelete 是否删除
	 * @return
	 * @throws Exception 
	 */
	public static Object recover(String path,boolean isDelete) throws Exception {
		// 判空处理
		if (StringUtils.isBlank(path)) {
			return null;
		}
		
		// 构建文件
		File file = new File(path);
		
		// 如果文件不存在也就是意味着数据为空
		if (!file.exists()) {
			return null;
		}
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object object = ois.readObject();
		ois.close();
		
		if (isDelete) {
			file.delete();
		}
		return object;
		
	}
}
