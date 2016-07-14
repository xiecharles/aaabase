package org.tkzc.aaabase.util.file.convert;

import org.tkzc.aaabase.util.file.FileResult;

public class FileConvertResult extends FileResult {
	
	protected String srcFilePath;
	
	protected String[] destFilePath;
	
	protected String convertType;

	public String getSrcFilePath() {
		return srcFilePath;
	}

	public void setSrcFilePath(String srcFilePath) {
		this.srcFilePath = srcFilePath;
	}

	public String[] getDestFilePath() {
		return destFilePath;
	}

	public void setDestFilePath(String[] destFilePath) {
		this.destFilePath = destFilePath;
	}

	public String getConvertType() {
		return convertType;
	}

	public void setConvertType(String convertType) {
		this.convertType = convertType;
	}
}
