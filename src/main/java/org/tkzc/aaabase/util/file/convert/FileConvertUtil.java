package org.tkzc.aaabase.util.file.convert;

import java.io.File;

public final class FileConvertUtil {

	private FileConvertUtil() {
		super();
	}
	
	public static FileConvertResult docConvertToPdf(File srcFile) {
		return DocConvertToPdf.getInstance().convert(srcFile, EnumFileConvert.DOC_TO_PDF);
	}
	
	public static FileConvertResult docxConvertToPdf(File srcFile) {
		return DocxConvertToPdf.getInstance().convert(srcFile, EnumFileConvert.DOCX_TO_PDF);
	}
}
