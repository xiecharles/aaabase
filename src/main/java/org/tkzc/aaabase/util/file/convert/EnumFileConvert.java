package org.tkzc.aaabase.util.file.convert;

public enum EnumFileConvert {

	DOC_TO_PDF("doc", "pdf"),
	DOCX_TO_PDF("docx", "pdf"),
	XLS_TO_PDF("xls", "pdf"),
	XLSX_TO_PDF("xlsx", "pdf"),
	PPT_TO_PDF("ppt", "pdf"),
	PPTX_TO_PDF("pptx", "pdf");
	
	private String srcExtName;
	
	private String destExtName;
	
	private EnumFileConvert(String srcExtName, String destExtName) {
		this.srcExtName = srcExtName;
		this.destExtName = destExtName;
	}

	public String getSrcExtName() {
		return srcExtName;
	}

	public String getDestExtName() {
		return destExtName;
	}
	
	public String getConvertType() {
		return srcExtName + "->" + destExtName;
	}
}
