package org.tkzc.study.spring.quartz;

public class MyJob {

	public void execTask() {
		long startTime = System.currentTimeMillis();
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("start task... " + currentThreadName);
		
		int randInt = (int) (Math.random() * 20) + 1;
		for (int i = 0; i < randInt; i++) {
			System.out.println("do something... " + currentThreadName);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("end task " + currentThreadName + ", current task running time(ms): " + time);
	}
	
}
