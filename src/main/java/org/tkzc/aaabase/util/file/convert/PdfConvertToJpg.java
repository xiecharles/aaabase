package org.tkzc.aaabase.util.file.convert;

public class PdfConvertToJpg extends AbstractFileConverter implements
		FileConverter {
	
	private PdfConvertToJpg() {
		super();
	}

	public static PdfConvertToJpg getInstance() {
		return getInstance(EnumFileConvertProxy.PDF_RENDERER);
	}

	public static PdfConvertToJpg getInstance(EnumFileConvertProxy fileConvertProxy) {
		PdfConvertToJpg instance = new PdfConvertToJpg();
		// 分情况设置代理
		switch(fileConvertProxy) {
		case PDF_RENDERER : 
			instance.setProxyConverter(new FileConverterProxyPdfRenderer());
			break;
		case PDF_BOX : 
			instance.setProxyConverter(new FileConverterProxyPdfbox());
			break;
		default : 
			instance.setProxyConverter(new FileConverterProxyPdfRenderer());
			break;
		}
		return instance;
	}
}
