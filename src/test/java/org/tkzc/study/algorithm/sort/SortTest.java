package org.tkzc.study.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import org.tkzc.study.algorithm.sort.BubbleSort;
import org.tkzc.study.algorithm.sort.InsertSort;
import org.tkzc.study.algorithm.sort.SelectSort;
import org.tkzc.study.algorithm.sort.Sorter;

public class SortTest {
	
	private List<Integer> list = new ArrayList<Integer>();
	
	Random random = new Random();
	
	private Sorter<Integer> sorter;
	
	@Test
	public void testBubbleSort() {
		StringBuffer strbuf = new StringBuffer();
		randList(10);
		for(Integer anum : list) {
			strbuf.append(anum + "\t");
		}
		System.out.println(strbuf.toString());
		strbuf.delete(0, strbuf.length());
		// 排序
		sorter = new BubbleSort<Integer>();
		long start = System.currentTimeMillis();
		sorter.sort(list);
		long end = System.currentTimeMillis();
		System.out.println("耗时: " + (end - start) + " ms");
		for(Integer anum : list) {
			strbuf.append(anum + "\t");
		}
		System.out.println(strbuf.toString());
	}
	
	@Test
	public void testSelectSort() {
		StringBuffer strbuf = new StringBuffer();
		randList(10);
		for(Integer anum : list) {
			strbuf.append(anum + "\t");
		}
		System.out.println(strbuf.toString());
		strbuf.delete(0, strbuf.length());
		// 排序
		sorter = new SelectSort<Integer>();
		long start = System.currentTimeMillis();
		sorter.sort(list);
		long end = System.currentTimeMillis();
		System.out.println("耗时: " + (end - start) + " ms");
		for(Integer anum : list) {
			strbuf.append(anum + "\t");
		}
		System.out.println(strbuf.toString());
	}
	
	@Test
	public void testInsertSort() {
		StringBuffer strbuf = new StringBuffer();
		randList(10);
		for(Integer anum : list) {
			strbuf.append(anum + "\t");
		}
		System.out.println(strbuf.toString());
		strbuf.delete(0, strbuf.length());
		// 排序
		sorter = new InsertSort<Integer>();
		long start = System.currentTimeMillis();
		sorter.sort(list);
		long end = System.currentTimeMillis();
		System.out.println("耗时: " + (end - start) + " ms");
		for(Integer anum : list) {
			strbuf.append(anum + "\t");
		}
		System.out.println(strbuf.toString());
	}
	
	public void randList(int length) {
		for(int i=0; i<length; i++) {
			list.add(new Integer(random.nextInt(1000)));
		}
	}
}
