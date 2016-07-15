package org.tkzc.aaabase.util.file.convert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;
import org.tkzc.aaabase.util.file.FilePathHelper;

public class FileConverterProxyOpenOffice implements FileConverter {
	
	private static String openOfficeHome;
	
	static {
		InputStream inStream = FileConverterProxyOpenOffice.class
				.getClassLoader()
				.getResourceAsStream("file_convert.properties");
		Properties properties = new Properties();
		try {
			properties.load(inStream);
			openOfficeHome = properties.getProperty("converter.proxy.openoffice.home", "C:\\Program Files (x86)\\OpenOffice 4");
		} catch (IOException e) {
			e.printStackTrace();
			openOfficeHome = "C:\\Program Files (x86)\\OpenOffice 4";
		}
	}
	
	@Override
	public FileConvertResult convert(File srcFile, EnumFileConvert convertType) {
		FileConvertResult result = new FileConvertResult();
		// 生成目标文件
		try {
			File destFile = FilePathHelper.generateFile(srcFile, convertType.getDestExtName());
			// 实例化openOffice管理配置类
			DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
			// 设置openOffice安装主目录的方法
			configuration.setOfficeHome(openOfficeHome);
			// 构建openOffice管理接口的实例
			OfficeManager officeManager = configuration.buildOfficeManager();
			// 执行openOffice管理接口的启动方法
			officeManager.start();
			// 实例化openOffice格式转化类
			OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
			// 执行转化方法
			converter.convert(srcFile, destFile);
			// 执行openOffice管理接口的停止方法
			officeManager.stop();
			// 返回格式转化正确结果
			result.setResultStatus(Boolean.TRUE);
			result.setResultMessage("文件格式转化成功");
			result.setConvertType(convertType.getConvertType());
			result.setSrcFilePath(srcFile.getAbsolutePath());
			result.setDestFilePath(new String[] { destFile.getAbsolutePath() });
		} catch (FileNotFoundException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("未找到原文件");
			result.setSrcFilePath(srcFile.getAbsolutePath());
		}
		return result;
	}
}
