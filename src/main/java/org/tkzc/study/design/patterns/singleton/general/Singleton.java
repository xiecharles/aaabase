package org.tkzc.study.design.patterns.singleton.general;

/**
 * 本类是单例的最简单写法
 * <ul>
 * <li>支持延迟加载</li>
 * <li>但不是线程安全的</li>
 * </ul>
 * 多线程情况下不建议使用
 * @author xm
 *
 */
public class Singleton {

	/**
	 * 私有的静态变量, 持有单例唯一的实例
	 * 本示例初始化为null, 为了实现延迟加载
	 */
	private static Singleton instance = null;
	
	/**
	 * 私有的构造方法
	 */
	private Singleton() {}
	
	/**
	 * 静态方法获取单例的实例
	 * @return
	 */
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	/**
	 * 对象在被反序列化后不创建新的对象, 而依然使用单例
	 * @return
	 */
	public Object readResolve() {
		return instance;
	}
	
	/**
	 * 单例所要做的业务方法
	 */
	public void service() {
		// TODO
	}
}
