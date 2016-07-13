package org.tkzc.aaabase.util.file.convert;

public class PptxConvertToPdf extends AbstractFileConverter implements
		FileConverter {
	
	private PptxConvertToPdf() {
		super();
	}

	public static PptxConvertToPdf getInstance() {
		return getInstance(EnumFileConvertProxy.OPEN_OFFICE);
	}

	public static PptxConvertToPdf getInstance(EnumFileConvertProxy fileConvertProxy) {
		PptxConvertToPdf instance = new PptxConvertToPdf();
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
