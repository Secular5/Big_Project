package com.briup.gather;

import java.util.Collection;
import org.junit.Test;
import com.briup.bean.Environment;

public class GatherTest {
	@Test
	public void t1() {
		IGather gather = new GatherImpl();
		gather.gather();
	}

	@Test
	public void t2() {
		IGather gather = new GatherImpl();
		Collection<Environment> collection = gather.gather();
		collection.forEach(System.out::println);
	}
}
