package org.tkzc.aaabase.util.file.convert;

public class XlsConvertToPdf extends AbstractFileConverter 
		implements FileConverter {
	
	private XlsConvertToPdf() {
		super();
	}

	public static XlsConvertToPdf getInstance() {
		return getInstance(EnumFileConvertProxy.OPEN_OFFICE);
	}

	public static XlsConvertToPdf getInstance(EnumFileConvertProxy fileConvertProxy) {
		XlsConvertToPdf instance = new XlsConvertToPdf();
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
