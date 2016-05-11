package org.tkzc.aaabase.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class StringUtil {

	/**
	 * 将提供的list列表中的对象的某个字段按照指定分隔符进行拼接
	 * @param list 提供的list列表
	 * @param clazz list列表的泛型类的类型
	 * @param symbol 指定分隔符, 不输入则默认为英文逗号","
	 * @param getMethodName list列表的泛型类中需要提取字段的get方法的名称
	 * @return 返回以指定分隔符拼接的字符串
	 * <pre>
	 * 例如:
	 * User类包含三个字段userid、username、gender 对应的get方法为 getUserid、getUsername、getGender
	 * 现有一个User的list, 我需要拼接其中的username字段, 则使用本方法即可
	 * List&lt;User&gt; userlist = new ArrayList&lt;User&gt;();
	 * userlist.add(new User("1", "zhangsan", "男"));
	 * userlist.add(new User("2", "lisi", "女"));
	 * userlist.add(new User("3", "wangwu", "男"));
	 * String str = StringUtil.concatStringBySymbol(userlist, User.class, ",", "getUsername");
	 * str 的值为 zhangsan,lisi,wangwu
	 * </pre>
	 */
	public static <T> String concatStringBySymbol(List<T> list, Class<T> clazz, String symbol, String getMethodName) {
		if(symbol == null) {
			symbol = ",";
		}
		StringBuffer strbuf = new StringBuffer();
		try {
			Method getMethod = null;
			if(clazz != null && getMethodName != null && !getMethodName.isEmpty()) {
				getMethod = clazz.getDeclaredMethod(getMethodName, new Class[] {});
			}
			for (T t : list) {
				strbuf.append(getMethod != null ? getMethod.invoke(t, new Object[] {}) : t);
				strbuf.append(symbol);
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		if(strbuf.length() > 0 && strbuf.toString().endsWith(symbol)) {
			strbuf.delete(strbuf.lastIndexOf(symbol), strbuf.length());
		}
		return strbuf.toString();
	}
}
