package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static Random r = new Random();
	private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);
	
	/**
	 * 将CommonsMultipartFile转化为file
	 * @param cFile
	 * @return
	 */
	public static File transferCommonsMultipartFile(CommonsMultipartFile cFile) {
		File newFile = new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(newFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
			e.printStackTrace();
		}
		return newFile;
	}
	/**
	 * 处理缩略图并返回生成图片的相对值路径
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateThumbnail(InputStream thumbnailInputStream,String fileName,String targetAddr) {
		String realFileName = getRandonFileName();
		String extension = getFileExtension(fileName);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		logger.debug("current relativeAddr is :" + PathUtil.getImgBasePath() + relativeAddr);
		File dest = new File(PathUtil.getImgBasePath()+relativeAddr);
		try {
			Thumbnails.of(thumbnailInputStream).size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath + File.separator + "water.png")),0.2f)
			.outputQuality(0.8f).toFile(dest);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return relativeAddr;
	}
	/**
	 * 创建目标路径所涉及到的目录，即/home/work/xiangze/xxx.jpg
	 * 那么 home,work,xiangze这三个文件夹都得自动创建
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		// TODO Auto-generated method stub
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * 获取输入文件流的扩展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(String fileName) {
		// TODO Auto-generated method stub
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 生成随机文件名
	 * @return
	 */
	public static String getRandonFileName() {
		// TODO Auto-generated method stub
		//获取随机的五位数
		int rannum = r.nextInt(89999)+10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<File> myFiles = new ArrayList<File>();
		File path = new File("D:\\\\chenlijun");
		if(path.isDirectory()) {
			File[] files = path.listFiles();
			myFiles.addAll(Arrays.asList(files));
			for(int i = 0; i < myFiles.size(); i++) {
				Thumbnails.of(new File("D:\\chenlijun\\" + myFiles.get(i).getName()))
				.size(700, 700)
				.watermark(Positions.BOTTOM_CENTER,ImageIO.read(new File(basePath+"\\water.png")),1f)
				.outputQuality(0.8f)
				.toFile("D:\\chenlijuns\\" + i + ".png");
			}
		}
		

		
	}
}
