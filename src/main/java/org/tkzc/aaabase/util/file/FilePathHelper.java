package org.tkzc.aaabase.util.file;

import java.io.File;
import java.io.FileNotFoundException;

public final class FilePathHelper {

	/**
	 * 目标文件路径模式-自定义 {@value}
	 */
	public static final int DESTFILE_CUSTOME = 0;
	
	/**
	 * 目标文件路径模式-与原文件同目录 {@value}
	 */
	public static final int DESTFILE_SAMEDIR = 1;
	
	/**
	 * 目标文件路径模式-与原文件同名 {@value}
	 */
	public static final int DESTFILE_SAMENAME = 2;
	
	/**
	 * 目标文件路径模式-与原文件同路径(仅扩展名不同) {@value}
	 */
	public static final int DESTFILE_SAMEPATH = DESTFILE_SAMEDIR + DESTFILE_SAMENAME;
	
	/**
	 * 文件系统目录分隔符
	 */
	public static final String separator = File.separator;
	
	/**
	 * 扩展名连接字符 {@value}
	 */
	public static final String EXT_NAME_CONCAT_CHAR = ".";
	
	/**
	 * 私有化构造方法, 不允许实例化
	 */
	private FilePathHelper() {}
	
	public static File generateFile(File srcFile, String destExtName) throws FileNotFoundException {
		return new File(generatePath(srcFile, destExtName));
	}
	
	public static String generatePath(File srcFile, String destExtName) throws FileNotFoundException {
		return generatePath(srcFile, DESTFILE_SAMEPATH, null, null, destExtName);
	}
	
	public static File generateFile(File srcFile, int generateType, String destParentPath, String destName, String destExtName) throws FileNotFoundException {
		return new File(generatePath(srcFile, generateType, destParentPath, destName, destExtName));
	}
	
	public static String generatePath(File srcFile, int generateType, String destParentPath, String destName, String destExtName) throws FileNotFoundException {
		// srcFile 判断
		if(srcFile == null) {
			throw new IllegalArgumentException("srcFile is null");
		}
		if(! srcFile.exists()) {
			throw new FileNotFoundException("srcFile is not exists");
		}
		if(srcFile.isDirectory()) {
			throw new IllegalArgumentException("srcFile is a directory, srcFile must be file");
		}
		// destExtName 判断
		if(destExtName == null || destExtName.isEmpty()) {
			throw new IllegalArgumentException("destExtName is null or empty");
		}
		destExtName = destExtName.toLowerCase();
		// 截取原文件的扩展名
		String srcExtName = srcFile.getName().substring(srcFile.getName().lastIndexOf(EXT_NAME_CONCAT_CHAR) + 1);
		if(destExtName.equals(srcExtName.toLowerCase())) {
			throw new IllegalArgumentException("destExtName equals with srcFile extension name");
		}
		// 分情况处理
		switch(generateType) {
		case DESTFILE_SAMEPATH : 
			// 目标文件和原文件在同一目录且文件名相同, 仅扩展名不同
			// 替换扩展名并返回
			return srcFile.getAbsolutePath().replace(srcExtName, destExtName);
		case DESTFILE_SAMENAME : 
			// 目标文件和原文件文件名相同, 扩展名不同, 需要主调函数提供目标文件指定存放目录
			if(destParentPath == null || destParentPath.isEmpty()) {
				throw new IllegalArgumentException("destPath is null or empty");
			}
			// 创建目标文件指定存放目录的文件对象
			File destParentDirectory = new File(destParentPath);
			// 目录不存在则创建
			if(! destParentDirectory.exists()) {
				if(destParentDirectory.isFile() || (! destParentDirectory.mkdirs())) {
					throw new IllegalArgumentException("destPath is an illegal path");
				}
			}
			// 返回存放目录下的扩展名被替换的路径字符串
			return destParentPath + separator + srcFile.getName().replace(srcExtName, destExtName);
		case DESTFILE_SAMEDIR : 
			// 目标文件和原文件在同一目录, 需要主调函数提供目标文件名和扩展名
			if(destName == null || destName.isEmpty()) {
				throw new IllegalArgumentException("destName is null or empty");
			}
			// 连接存放目录、文件名、文件扩展名并返回
			return srcFile.getParent() + separator + destName + EXT_NAME_CONCAT_CHAR + destExtName;
		case DESTFILE_CUSTOME : 
			// 目标文件的路径、文件名、扩展名, 都需要主调函数提供
			if(destParentPath == null || destParentPath.isEmpty()) {
				throw new IllegalArgumentException("destPath is null or empty");
			}
			if(destName == null || destName.isEmpty()) {
				throw new IllegalArgumentException("destName is null or empty");
			}
			// 创建目标文件指定存放目录的文件对象
			destParentDirectory = new File(destParentPath);
			// 目录不存在则创建
			if(! destParentDirectory.exists()) {
				if(destParentDirectory.isFile() || (! destParentDirectory.mkdirs())) {
					throw new IllegalArgumentException("destPath is an illegal path");
				}
			}
			// 连接存放目录、文件名、文件扩展名并返回
			return destParentPath + separator + destName + EXT_NAME_CONCAT_CHAR + destExtName;
		default : 
			throw new IllegalArgumentException("generateType is undefined : " + generateType);
		}
	}
}
