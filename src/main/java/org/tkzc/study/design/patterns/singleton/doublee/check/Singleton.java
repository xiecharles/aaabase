package org.tkzc.study.design.patterns.singleton.doublee.check;

/**
 * 本类是单例的双重检查写法
 * <ul>
 * <li>支持延迟加载</li>
 * <li>在getInstance方法内添加synchronized块, 是线程安全的</li>
 * <li>只有当实例为null需要创建, 才进行加锁并创建, 比同步方法效率高</li>
 * </ul>
 * 大多情况都可兼容
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
	 * 只有在第一次创建对象时加锁
	 * @return
	 */
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized (instance) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
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
