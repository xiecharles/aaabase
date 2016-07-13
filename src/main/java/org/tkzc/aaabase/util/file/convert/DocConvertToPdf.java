package org.tkzc.aaabase.util.file.convert;

public class DocConvertToPdf extends AbstractFileConverter implements FileConverter {
	
	private DocConvertToPdf() {
		super();
	}

	public static DocConvertToPdf getInstance() {
		return getInstance(EnumFileConvertProxy.OPEN_OFFICE);
	}

	public static DocConvertToPdf getInstance(EnumFileConvertProxy fileConvertProxy) {
		DocConvertToPdf instance = new DocConvertToPdf();
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
