package org.tkzc.aaabase.util.file.convert;

public class DocxConvertToPdf extends AbstractFileConverter implements
		FileConverter {

	private DocxConvertToPdf() {
		super();
	}
	
	public static DocxConvertToPdf getInstance() {
		return getInstance(EnumFileConvertProxy.OPEN_OFFICE);
	}

	public static DocxConvertToPdf getInstance(EnumFileConvertProxy fileConvertProxy) {
		DocxConvertToPdf instance = new DocxConvertToPdf();
		// 分情况设置代理
		switch(fileConvertProxy) {
		case OPEN_OFFICE : 
			instance.setProxyConverter(new FileConverterProxyOpenOffice());
			break;
		default : 
			instance.setProxyConverter(new FileConverterProxyOpenOffice());
			break;
		}
		return instance;
	}
}
