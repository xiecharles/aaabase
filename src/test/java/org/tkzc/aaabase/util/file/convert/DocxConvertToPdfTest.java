package org.tkzc.aaabase.util.file.convert;

import java.io.File;

import org.junit.Test;

public class DocxConvertToPdfTest {

	@Test
	public void testConvert() {
		File srcFile = new File("E:\\2pages.docx");
		FileConverter instance = DocxConvertToPdf.getInstance();
		FileConvertResult result = instance.convert(srcFile, EnumFileConvert.DOCX_TO_PDF);
		System.out.println(result.getResultMessage());
	}
}
