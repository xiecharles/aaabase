package org.tkzc.aaabase.util.file.convert;

import java.io.File;

import org.junit.Test;

public class XlsxConvertToPdfTest {

	@Test
	public void testConvert() {
		File srcFile = new File("E:\\2row.xlsx");
		FileConverter instance = XlsxConvertToPdf.getInstance();
		FileConvertResult result = instance.convert(srcFile, EnumFileConvert.XLSX_TO_PDF);
		System.out.println(result.getResultMessage());
	}
}
