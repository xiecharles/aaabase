package org.tkzc.study.design.patterns.singleton.staticc;

/**
 * 本类是单例的静态变量写法
 * <ul>
 * <li>不支持延迟加载</li>
 * <li>但利用ClassLoader的特性, 保证了实例的唯一性, 是线程安全的</li>
 * </ul>
 * 考虑延迟加载不建议使用
 * @author xm
 *
 */
public class Singleton {

	/**
	 * 私有的静态变量, 持有单例唯一的实例
	 * 本示例初始化即创建实例, 天生线程安全且实例唯一, 但不能延迟加载
	 */
	private static Singleton instance = new Singleton();
	
	/**
	 * 私有的构造方法
	 */
	private Singleton() {}
	
	/**
	 * 静态方法获取单例的实例
	 * @return
	 */
	public static Singleton getInstance() {
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
