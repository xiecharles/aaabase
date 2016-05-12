package org.tkzc.study.design.patterns.singleton.sync.method;

/**
 * 本类是单例的同步方法写法
 * <ul>
 * <li>支持延迟加载</li>
 * <li>getInstance方法添加synchronized, 是线程安全的</li>
 * <li>但是效率低, 每次获取实例调用getInstance方法都要锁对象</li>
 * </ul>
 * 多线程情况下不考虑效率可以使用
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
	 * 静态方法获取单例的实例<br/>
	 * 任何时候获取实例都要加锁
	 * @return
	 */
	public static synchronized Singleton getInstance() {
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
