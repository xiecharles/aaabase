package org.tkzc.aaabase.util.file.convert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

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
			// 加载openOffice管理配置类的类型
			Class<?> configurationClazz = Class.forName("org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration");
			// 获取openOffice管理配置类的构造方法
			Constructor<?> configurationConstructor = configurationClazz.getConstructor();
			// 反射执行构造方法
			Object configurationObject = configurationConstructor.newInstance();
			// 获取openOffice管理配置类的设置openOffice安装主目录的方法
			Method setOfficeHomeMethod = configurationClazz.getMethod("setOfficeHome", String.class);
			// 反射执行设置openOffice安装主目录的方法
			setOfficeHomeMethod.invoke(configurationObject, openOfficeHome);
			// 获取openOffice管理配置类的构建openOffice管理类实例的方法
			Method buildOfficeManagerMethod = configurationClazz.getMethod("buildOfficeManager");
			// 反射执行构建openOffice管理接口实例的方法
			Object officeManagerObject = buildOfficeManagerMethod.invoke(configurationObject);
			// 获取openOffice管理接口的类型
			Class<?> officeManagerClazz = Class.forName("org.artofsolving.jodconverter.office.OfficeManager");
			// 获取openOffice管理接口的启动和停止方法
			Method startMethod = officeManagerClazz.getMethod("start");
			Method stopMethod = officeManagerClazz.getMethod("stop");
			// 反射执行openOffice管理接口的启动方法
			startMethod.invoke(officeManagerObject);
			// 加载openOffice格式转化类的类型
			Class<?> converterClazz = Class.forName("org.artofsolving.jodconverter.OfficeDocumentConverter");
			// 获取openOffice格式转化类的构造方法
			Constructor<?> converterConstructor = converterClazz.getDeclaredConstructor(officeManagerClazz);
			// 反射执行构造方法
			Object converterObject = converterConstructor.newInstance(officeManagerObject);
			// 获取openOffice格式转化类的转化方法
			Method convertMethod = converterClazz.getMethod("convert", File.class, File.class);
			// 反射执行转化方法
			convertMethod.invoke(converterObject, srcFile, destFile);
			// 反射执行openOffice管理接口的停止方法
			stopMethod.invoke(officeManagerObject);
			// 返回格式转化正确结果
			result.setResultStatus(Boolean.TRUE);
			result.setResultMessage("文件格式转化成功");
			result.setConvertType(convertType.getConvertType());
			result.setSrcFilePath(srcFile.getAbsolutePath());
			result.setDestFilePath(destFile.getAbsolutePath());
		} catch (FileNotFoundException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("未找到原文件");
			result.setSrcFilePath(srcFile.getAbsolutePath());
		} catch (ClassNotFoundException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("使用openOffice进行文件格式转换，需要引入以下jar包："
					+ "jodconverter-core-1.0.5.jar、juh-3.2.1.jar、jurt-3.2.1.jar、"
					+ "ridl-3.2.1.jar、unoil-3.2.1.jar");
		} catch (NoSuchMethodException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("当前提取的构造方法不存在");
		} catch (SecurityException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("没有提取构造方法的权限");
		} catch (InstantiationException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("反射实例化错误");
		} catch (IllegalAccessException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("在反射中非法调用方法");
		} catch (IllegalArgumentException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("反射调用方法时参数错误");
		} catch (InvocationTargetException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("反射调用方法时，方法内部有未捕获的异常");
		}
		return result;
	}
}
