package org.tkzc.aaabase.util.file.convert;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.tkzc.aaabase.util.file.FilePathHelper;

public class FileConverterProxyPdfbox implements FileConverter {

	@Override
	@SuppressWarnings("rawtypes")
	public FileConvertResult convert(File srcFile, EnumFileConvert convertType) {
		FileConvertResult result = new FileConvertResult();
		PDDocument pdDoc = null;
		try {
			// 加载pdf文档
			pdDoc = PDDocument.load(srcFile);
			// 获取pdf文档所有页的对象
			List pageList = pdDoc.getDocumentCatalog().getAllPages();
			if(pageList.size() > 0) {
				// 构造目标文件存放目录
				String[] destFilePath = new String[pageList.size()];
				String srcFilePrefixName = FilePathHelper.getPrefixName(srcFile.getName());
				String destParentPath = FilePathHelper.getPrefixName(srcFile.getAbsolutePath());
				// 循环将pdf文档页转化为图片
				for(int i=0; i<pageList.size(); i++) {
					// 生成每页pdf对应转成图片的目标文件
					File destFile = FilePathHelper.generateFile(srcFile, FilePathHelper.DESTFILE_CUSTOME, 
							destParentPath, srcFilePrefixName + "_" + (i+1), convertType.getDestExtName());
					destFilePath[i] = destFile.getAbsolutePath();
					// 获取pdf文档当前遍历到的页
					PDPage page = (PDPage) pageList.get(i);
					// 转化为缓冲图片对象
					BufferedImage bufimg = page.convertToImage();
					// 将缓冲图片内容写入到目标文件
					ImageIO.write(bufimg, convertType.getDestExtName(), destFile);
					page.clear();
				}
				// 返回格式转化正确结果
				result.setResultStatus(Boolean.TRUE);
				result.setResultMessage("文件格式转化成功");
				result.setConvertType(convertType.getConvertType());
				result.setSrcFilePath(srcFile.getAbsolutePath());
				result.setDestFilePath(destFilePath);
			} else {
				result.setResultStatus(Boolean.FALSE);
				result.setResultMessage("原文件内容错误，读取原文件失败");
				result.setSrcFilePath(srcFile.getAbsolutePath());
			}
		} catch (FileNotFoundException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("未找到原文件");
			result.setSrcFilePath(srcFile.getAbsolutePath());
		} catch (IOException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("读取pdf文件出错");
			result.setSrcFilePath(srcFile.getAbsolutePath());
		} finally {
			try {
				// 关闭pdf文档
				if(pdDoc != null) {
					pdDoc.close();
				}
			} catch (IOException e) {
				
			}
		}
		
		return result;
	}
}
