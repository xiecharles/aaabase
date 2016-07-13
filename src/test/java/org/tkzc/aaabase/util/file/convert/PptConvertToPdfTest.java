package org.tkzc.aaabase.util.file.convert;

import java.io.File;

import org.junit.Test;

public class PptConvertToPdfTest {

	@Test
	public void testConvert() {
		File srcFile = new File("E:\\4ppt.ppt");
		FileConverter instance = PptConvertToPdf.getInstance();
		FileConvertResult result = instance.convert(srcFile, EnumFileConvert.PPT_TO_PDF);
		System.out.println(result.getResultMessage());
	}
}
