package org.tkzc.aaabase.util;

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
		// 声明组织连接的字符串(返回的字符串)
		StringBuffer strbuf = new StringBuffer();
		// 传入的列表为空则直接返回空字符串
		if(list == null || list.isEmpty()) {
			return strbuf.toString();
		}
		// 连接字符为空则默认为英文逗号
		if(symbol == null) {
			symbol = ",";
		}
		try {
			// 声明get方法的对象
			Method getMethod = null;
			// 传入的class类型不为空并且get方法的方法名称也不位空, 则尝试利用反射获取get方法的对象
			if(clazz != null && getMethodName != null && !getMethodName.trim().isEmpty()) {
				getMethod = clazz.getDeclaredMethod(getMethodName.trim(), new Class[] {});
			}
			// 遍历list, 拼接字符串
			for (T t : list) {
				// get方法对象不为空则反射获取指定get方法的返回值进行拼接, 否则直接拼接当前遍历的对象
				strbuf.append(getMethod != null ? getMethod.invoke(t, new Object[] {}) : t);
				// 拼接连接符
				strbuf.append(symbol);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 任何异常返回空字符串(无非就是找不到方法的异常)
			return strbuf.delete(0, strbuf.length()).toString();
		}
		// 删除最后一个多余的连接符
		if(strbuf.length() > 0 && strbuf.toString().endsWith(symbol)) {
			strbuf.delete(strbuf.lastIndexOf(symbol), strbuf.length());
		}
		return strbuf.toString();
	}
}
