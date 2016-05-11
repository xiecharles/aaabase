package org.tkzc.aaabase.string;

import org.junit.Test;

public class StringParseTest {

	@Test
	public void testStringParse() {
		String str = "and $(/sqlMap/resultMap/result[2].attr.column)$ = #$(/sqlMap/resultMap/result[2].attr.property)$:$(/sqlMap/resultMap/result[2].attr.jdbcType)$#";
		int oldStart = 0;
		int oldEnd = 0;
		while(str.contains("$(")) {
			oldStart = str.indexOf("$(");
			oldEnd = str.indexOf(")$") + 2;
			String oldSubstr = str.substring(oldStart, oldEnd);
			System.out.println(oldSubstr);
			String expstr = oldSubstr.substring(2, oldSubstr.length() - 2);
			System.out.println(expstr);
			str = str.replace(oldSubstr, "text");
		}
		System.out.println(str);
	}
}
