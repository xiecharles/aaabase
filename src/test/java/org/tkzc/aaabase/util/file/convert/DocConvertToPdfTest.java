package org.tkzc.aaabase.util.file.convert;

import java.io.File;

import org.junit.Test;

public class DocConvertToPdfTest {

	@Test
	public void testConvert() {
		File srcFile = new File("E:\\4pages.doc");
		FileConverter instance = DocConvertToPdf.getInstance();
		FileConvertResult result = instance.convert(srcFile, EnumFileConvert.DOC_TO_PDF);
		System.out.println(result.getResultMessage());
	}
}
