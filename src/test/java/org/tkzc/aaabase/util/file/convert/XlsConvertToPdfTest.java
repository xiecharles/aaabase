package org.tkzc.aaabase.util.file.convert;

import java.io.File;

import org.junit.Test;

public class XlsConvertToPdfTest {

	@Test
	public void testConvert() {
		File srcFile = new File("E:\\4row.xls");
		FileConverter instance = XlsConvertToPdf.getInstance();
		FileConvertResult result = instance.convert(srcFile, EnumFileConvert.XLS_TO_PDF);
		System.out.println(result.getResultMessage());
	}
}
