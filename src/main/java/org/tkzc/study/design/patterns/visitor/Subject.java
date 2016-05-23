package org.tkzc.study.design.patterns.visitor;

public interface Subject {

	void accept(Visitor visitor);
	
	String getSubject();
}
