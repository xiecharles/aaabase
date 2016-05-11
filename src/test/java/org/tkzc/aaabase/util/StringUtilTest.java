package org.tkzc.aaabase.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.tkzc.aaabase.util.StringUtil;

public class StringUtilTest {

	@Test
	public void testConcatStringBtSymbol() {
//		List<String> strlist = new ArrayList<String>();
//		strlist.add("zhangsan");
//		strlist.add("lisi");
//		strlist.add("wangwu");
		
		List<User> userlist = new ArrayList<User>();
		userlist.add(new User("1", "zhangsan", "男"));
		userlist.add(new User("2", "lisi", "女"));
		userlist.add(new User("3", "wangwu", "男"));
		String str = StringUtil.concatStringBySymbol(userlist, User.class, ";", "getUsername");
		System.out.println(str);
	}
}
