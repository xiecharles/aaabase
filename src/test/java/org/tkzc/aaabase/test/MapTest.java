package org.tkzc.aaabase.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void test() {
		Map map = new HashMap();
		Object obj0 = map.put("1", "111");
		System.out.println(obj0);
		Object obj1 = map.remove("1");
		System.out.println(obj1);
		Object obj2 = map.remove("2");
		System.out.println(obj2);
		
		map.put("1", obj1);
		map.put("2", obj2);
		System.out.println(map);
	}
}
