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
	
	/**
	 * 根据原文件及目标文件扩展名生成新的目标文件对象
	 * @param srcFile
	 * @param destExtName
	 * @return
	 * @throws FileNotFoundException
	 */
	public static File generateFile(File srcFile, String destExtName) throws FileNotFoundException {
		return new File(generatePath(srcFile, destExtName));
	}
	
	/**
	 * 根据原文件及目标文件扩展名生成新的目标文件路径
	 * @param srcFile
	 * @param destExtName
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String generatePath(File srcFile, String destExtName) throws FileNotFoundException {
		return generatePath(srcFile, DESTFILE_SAMEPATH, null, null, destExtName);
	}
	
	/**
	 * 根据原文件、生成类型、目标文件扩展名及其他规则生成新的目标文件对象
	 * @param srcFile 原文件
	 * @param generateType 生成类型
	 * @param destParentPath 目标文件存放路径
	 * @param destName 目标文件名称
	 * @param destExtName 目标文件扩展名
	 * @return
	 * @throws FileNotFoundException
	 */
	public static File generateFile(File srcFile, int generateType, String destParentPath, String destName, String destExtName) throws FileNotFoundException {
		return new File(generatePath(srcFile, generateType, destParentPath, destName, destExtName));
	}
	
	/**
	 * 根据原文件、生成类型、目标文件扩展名及其他规则生成新的目标文件路径
	 * @param srcFile 原文件
	 * @param generateType 生成类型
	 * @param destParentPath 目标文件存放路径
	 * @param destName 目标文件名称
	 * @param destExtName 目标文件扩展名
	 * @return
	 * @throws FileNotFoundException
	 */
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
		String srcExtName = getExtName(srcFile);
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
	
	/**
	 * 获得文件扩展名
	 * <pre>
	 * eg: file.doc             -> doc
	 *     file.txt.bak         -> bak
	 *     /data/user1/file.zip -> zip
	 * </pre>
	 * @param file
	 * @return
	 */
	public static String getExtName(File file) {
		if(file == null) {
			return null;
		}
		return getExtName(file.getName());
	}
	
	/**
	 * 获得文件扩展名
	 * <pre>
	 * eg: file.doc             -> doc
	 *     file.txt.bak         -> bak
	 *     /data/user1/file.zip -> zip
	 * </pre>
	 * @param filename
	 * @return
	 */
	public static String getExtName(String filename) {
		if(filename == null || filename.isEmpty()) {
			return filename;
		}
		return filename.substring(filename.lastIndexOf(EXT_NAME_CONCAT_CHAR) + 1);
	}
	
	/**
	 * 获得文件前缀名
	 * <pre>
	 * eg: file.doc             -> file
	 *     file.txt.bak         -> file.txt
	 *     /data/user1/file.zip -> /data/user1/file
	 * </pre>
	 * @param file
	 * @return
	 */
	public static String getPrefixName(File file) {
		if(file == null) {
			return null;
		}
		return getPrefixName(file.getName());
	}
	
	/**
	 * 获得文件前缀名
	 * <pre>
	 * eg: file.doc             -> file
	 *     file.txt.bak         -> file.txt
	 *     /data/user1/file.zip -> /data/user1/file
	 * </pre>
	 * @param filename
	 * @return
	 */
	public static String getPrefixName(String filename) {
		if(filename == null || filename.isEmpty()) {
			return filename;
		}
		return filename.substring(0, filename.lastIndexOf(EXT_NAME_CONCAT_CHAR));
	}
}
