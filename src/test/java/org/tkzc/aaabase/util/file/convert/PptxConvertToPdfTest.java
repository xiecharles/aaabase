package org.tkzc.aaabase.util.file.convert;

import java.io.File;

import org.junit.Test;

public class PptxConvertToPdfTest {

	@Test
	public void testConvert() {
		File srcFile = new File("E:\\2ppt.pptx");
		FileConverter instance = PptxConvertToPdf.getInstance();
		FileConvertResult result = instance.convert(srcFile, EnumFileConvert.PPTX_TO_PDF);
		System.out.println(result.getResultMessage());
	}
}
