package org.tkzc.aaabase.util.file.convert;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.imageio.ImageIO;

import org.tkzc.aaabase.util.file.FilePathHelper;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PDFRenderer;

public class FileConverterProxyPdfRenderer implements FileConverter {
	
	private static final String PDF_XREF_EXCEPTION = "Expected 'xref' at start of table";

	@Override
	public FileConvertResult convert(File srcFile, EnumFileConvert convertType) {
		FileConvertResult result = new FileConvertResult();
		RandomAccessFile raf = null;
		try {
			// 以随机读取的形式打开原文件
			raf = new RandomAccessFile(srcFile, "r");
			FileChannel channel = raf.getChannel();
			ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
			// 以pdf文件形式读取文件
			PDFFile pdfFile = new PDFFile(buf);
			if(pdfFile.getNumPages() > 0) {
				// 构造目标文件路径
				String[] destFilePath = new String[pdfFile.getNumPages()];
				String srcFilePrefixName = FilePathHelper.getPrefixName(srcFile.getName());
				String destParentPath = FilePathHelper.getPrefixName(srcFile.getAbsolutePath());
				// 循环获取pdf文档每页，并进行转换
				for(int i=1; i<=pdfFile.getNumPages(); i++) {
					// 生成每一页pdf对应图片的目标文件对象
					File destFile = FilePathHelper.generateFile(srcFile, FilePathHelper.DESTFILE_CUSTOME, 
							destParentPath, srcFilePrefixName + "_" + i, convertType.getDestExtName());
					destFilePath[i-1] = destFile.getAbsolutePath();
					// 获取pdf文档遍历的当前页
					PDFPage page = pdfFile.getPage(i);
					// 构造pdf文档页对应的矩形
					Rectangle rect = new Rectangle(0, 0, 
							(int) page.getBBox().getWidth(), 
							(int) page.getBBox().getHeight());
					// 按矩形宽高构造缓冲图片对象
					BufferedImage bufimg = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);
					// 从缓冲图片推向中获取2D图像
					Graphics2D g2d = bufimg.createGraphics();
					g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					// 构造PDFRenderer对象
					PDFRenderer renderer = new PDFRenderer(page, g2d, rect, null, Color.WHITE);
					page.waitForFinish();
					renderer.run();
					// 2D图像对象销毁
					g2d.dispose();
					// 将图片缓冲信息写入图片文件
					ImageIO.write(bufimg, convertType.getDestExtName(), destFile);
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
			if(PDF_XREF_EXCEPTION.equals(e.getMessage())) {
				result.setResultMessage("pdf文件版本高于1.4，无法解析");
			} else {
				result.setResultMessage("读取pdf文件出错");
			}
			result.setSrcFilePath(srcFile.getAbsolutePath());
		} catch (InterruptedException e) {
			result.setResultStatus(Boolean.FALSE);
			result.setResultMessage("读取pdf页的线程意外中断");
			result.setSrcFilePath(srcFile.getAbsolutePath());
		} finally {
			try {
				// 关闭随机读取文件对象
				if(raf != null) {
					raf.close();
				}
			} catch (IOException e) {
				
			}
		}
		return result;
	}
}
