package org.tkzc.aaabase.test;

public class VarLenParamTest {

	public static void main(String[] args) {
		VarLenParamTest vlpt = new VarLenParamTest();
		vlpt.print(0);
		vlpt.print(0, "hello", "world");
		
		vlpt.print1(0, new String[] {"hello", "world"});
	}
	
	public void print(int ai, String... params) {
		System.out.println(ai);
		for (String string : params) {
			System.out.println(string);
		}
	}
	
	public void print1(int ai, String[] params) {
		System.out.println(ai);
		for (String string : params) {
			System.out.println(string);
		}
	}
}
