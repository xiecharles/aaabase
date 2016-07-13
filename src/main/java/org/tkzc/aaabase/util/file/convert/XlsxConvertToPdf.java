package org.tkzc.aaabase.util.file.convert;

public class XlsxConvertToPdf extends AbstractFileConverter 
		implements FileConverter {
	
	private XlsxConvertToPdf() {
		super();
	}

	public static XlsxConvertToPdf getInstance() {
		return getInstance(EnumFileConvertProxy.OPEN_OFFICE);
	}

	public static XlsxConvertToPdf getInstance(EnumFileConvertProxy fileConvertProxy) {
		XlsxConvertToPdf instance = new XlsxConvertToPdf();
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
