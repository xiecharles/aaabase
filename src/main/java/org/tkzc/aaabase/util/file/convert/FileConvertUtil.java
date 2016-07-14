package org.tkzc.aaabase.util.file.convert;

import java.io.File;

public final class FileConvertUtil {

	private FileConvertUtil() {
		super();
	}
	
	/**
	 * word(97-03旧版)文档转pdf
	 * @param srcFile
	 * @return
	 */
	public static FileConvertResult docConvertToPdf(File srcFile) {
		return DocConvertToPdf.getInstance().convert(srcFile, EnumFileConvert.DOC_TO_PDF);
	}
	
	/**
	 * word(07+新版)文档转pdf
	 * @param srcFile
	 * @return
	 */
	public static FileConvertResult docxConvertToPdf(File srcFile) {
		return DocxConvertToPdf.getInstance().convert(srcFile, EnumFileConvert.DOCX_TO_PDF);
	}
	
	/**
	 * ppt(97-03旧版)演示文稿转pdf
	 * @param srcFile
	 * @return
	 */
	public static FileConvertResult pptConvertToPdf(File srcFile) {
		return PptConvertToPdf.getInstance().convert(srcFile, EnumFileConvert.PPT_TO_PDF);
	}
	
	/**
	 * ppt(07+新版)演示文稿转pdf
	 * @param srcFile
	 * @return
	 */
	public static FileConvertResult pptxConvertToPdf(File srcFile) {
		return PptxConvertToPdf.getInstance().convert(srcFile, EnumFileConvert.PPTX_TO_PDF);
	}
	
	/**
	 * excel(97-03旧版)表格转pdf
	 * @param srcFile
	 * @return
	 */
	public static FileConvertResult xlsConvertToPdf(File srcFile) {
		return XlsConvertToPdf.getInstance().convert(srcFile, EnumFileConvert.XLS_TO_PDF);
	}
	
	/**
	 * excel(07+新版)表格转pdf
	 * @param srcFile
	 * @return
	 */
	public static FileConvertResult xlsxConvertToPdf(File srcFile) {
		return XlsxConvertToPdf.getInstance().convert(srcFile, EnumFileConvert.XLSX_TO_PDF);
	}
	
	/**
	 * pdf文档转jpg图片
	 * @param srcFile
	 * @return
	 */
	public static FileConvertResult pdfConvertToJpg(File srcFile) {
		return PdfConvertToJpg.getInstance().convert(srcFile, EnumFileConvert.PDF_TO_JPG);
	}
}
