package org.tkzc.aaabase.util.file.convert;

import java.io.File;

import org.junit.Test;

public class PdfConvertToJpgTest {

	@Test
	public void testConvertProxyPdfRenderer() {
		File srcFile = new File("E:\\4pages.pdf");
		FileConverter instance = PdfConvertToJpg.getInstance(EnumFileConvertProxy.PDF_RENDERER);
		FileConvertResult result = instance.convert(srcFile, EnumFileConvert.PDF_TO_JPG);
		System.out.println(result.getResultMessage());
		if(result.getResultStatus()) {
			for (String destPath : result.getDestFilePath()) {
				System.out.println(destPath);
			}
		}
	}
	
	@Test
	public void testConvertProxyPdfbox() {
		File srcFile = new File("E:\\1467106111007_1467106139468.pdf");
		FileConverter instance = PdfConvertToJpg.getInstance(EnumFileConvertProxy.PDF_BOX);
		FileConvertResult result = instance.convert(srcFile, EnumFileConvert.PDF_TO_JPG);
		System.out.println(result.getResultMessage());
		if(result.getResultStatus()) {
			for (String destPath : result.getDestFilePath()) {
				System.out.println(destPath);
			}
		}
	}
}
