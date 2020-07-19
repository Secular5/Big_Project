package com.briup;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.briup.recive.IRecive;
import com.briup.recive.ReciveImpl;

public class ReciveTest {
	/**
	 *  创建日志对象 
	 *  static final
	 */
	private static final Logger logger = Logger.getLogger(ReciveTest.class);
	
	@Test
	public void t1() {
		IRecive recive = new ReciveImpl();
		recive.recive();
	}
	
	@Test
	public void t2() {
		logger.debug("日志1");
		logger.info("日志2");
		logger.warn("日志3");
		logger.error("日志4");
		logger.fatal("日志5");
	}
	
	
	@Test
	public void t3() {
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date.toString().substring(8));
	}
}
