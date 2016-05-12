package org.tkzc.study.design.patterns.singleton.inner.clazz;

/**
 * 本类是单例的最终写法, 以内部类实现延迟加载
 * <ul>
 * <li>支持延迟加载</li>
 * <li>是线程安全的</li>
 * </ul>
 * 建议使用
 * @author xm
 *
 */
public class Singleton {

	/**
	 * 私有的构造方法
	 */
	private Singleton() {}
	
	/**
	 * 静态内部类, 只有当调用getInstance方法获取实例时才加载内部类, 因此支持延迟加载
	 */
	private static class SingletonHolder {
		/**
		 * 私有的静态变量, 在加载内部类时就创建唯一的实例<br/>
		 * 内部类使用静态变量持有实例, 利用ClassLoader实现了实例创建的线程安全
		 */
		private static Singleton instance = new Singleton();
	}
	
	/**
	 * 静态方法从静态内部类获取单例的实例
	 * @return
	 */
	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}
	
	/**
	 * 对象在被反序列化后不创建新的对象, 而依然使用单例
	 * @return
	 */
	public Object readResolve() {
		return getInstance();
	}
	
	/**
	 * 单例所要做的业务方法
	 */
	public void service() {
		// TODO
	}
}
