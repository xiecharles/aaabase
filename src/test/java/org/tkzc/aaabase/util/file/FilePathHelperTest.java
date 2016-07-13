package org.tkzc.aaabase.util.file;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class FilePathHelperTest {

	@Test
	public void testCostants() {
		System.out.println(FilePathHelper.separator);
	}
	
	@Test
	public void testGeneratePath() {
		File srcFile = new File("E:\\work\\EGIT操作规范.docx");
		try {
			// 转文件格式, 默认为存在同目录下的同名文件
			String destPath = FilePathHelper.generatePath(srcFile, "pdf");
			System.out.println(destPath);
			// 转文件格式, 指定文件名
			destPath = FilePathHelper.generatePath(srcFile, FilePathHelper.DESTFILE_SAMEDIR,
					null, "EGIT操作规范(pdf版)", "pdf");
			System.out.println(destPath);
			// 转文件格式, 指定存放目录
			destPath = FilePathHelper.generatePath(srcFile, FilePathHelper.DESTFILE_SAMENAME,
					"E:\\xm", null, "pdf");
			System.out.println(destPath);
			// 转文件格式, 自定义
			destPath = FilePathHelper.generatePath(srcFile, FilePathHelper.DESTFILE_CUSTOME, 
					"E:\\xm", "EGIT操作规范(pdf版)", "pdf");
			System.out.println(destPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
