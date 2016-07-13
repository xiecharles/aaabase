package org.tkzc.aaabase.util.file.convert;

import java.io.File;

public interface FileConverter {

	FileConvertResult convert(File srcFile, EnumFileConvert convertType);
}
