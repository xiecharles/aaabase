package org.tkzc.study.design.patterns.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractSubject implements Subject {

	private List<Observer> observers = new ArrayList<Observer>();
	
	@Override
	public void add(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		Iterator<Observer> it = observers.iterator();
		while(it.hasNext()) {
			it.next().update();;
		}
	}
}
