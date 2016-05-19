package org.tkzc.study.design.patterns.observer;

public interface Subject {

	void add(Observer observer);
	
	void remove(Observer observer);
	
	void notifyObservers();
	
	void operation();
}
