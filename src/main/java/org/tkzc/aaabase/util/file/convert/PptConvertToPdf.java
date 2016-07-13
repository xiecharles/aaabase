package org.tkzc.aaabase.util.file.convert;

public class PptConvertToPdf extends AbstractFileConverter implements
		FileConverter {
	
	private PptConvertToPdf() {
		super();
	}

	public static PptConvertToPdf getInstance() {
		return getInstance(EnumFileConvertProxy.OPEN_OFFICE);
	}

	public static PptConvertToPdf getInstance(EnumFileConvertProxy fileConvertProxy) {
		PptConvertToPdf instance = new PptConvertToPdf();
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
