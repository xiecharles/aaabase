package org.tkzc.aaabase.util.file.convert;

import java.io.File;

public abstract class AbstractFileConverter implements FileConverter {
	
	private FileConverter proxyConverter;

	protected void setProxyConverter(FileConverter proxyConverter) {
		this.proxyConverter = proxyConverter;
	}
	
	protected FileConverter getProxyConverter() {
		return proxyConverter;
	}
	
	@Override
	public FileConvertResult convert(File srcFile, EnumFileConvert convertType) {
		return proxyConverter.convert(srcFile, convertType);
	}
}
