package com.briup;

import com.briup.recive.IRecive;
import com.briup.recive.ReciveImpl;
/**
 * 服务端程序入口
 * @author 璐华咪咪
 *
 */
public class Application {
	public static void main(String[] args) {
		IRecive recive = new ReciveImpl();
		recive.recive();
	}
}
