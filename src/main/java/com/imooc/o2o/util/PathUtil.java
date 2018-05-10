package com.imooc.o2o.util;

import java.io.File;

public class PathUtil {
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:" + File.separator + "projectdev" + File.separator + "image" + File.separator;
		} else {
			basePath = File.separator + "home" + File.separator + "xiangze" + File.separator + "image" + File.separator;
		}
		return basePath;
	}

	public static String getShopImagePath(long shopId) {
		String imagePath = "upload" + File.separator + "item" + File.separator + "shop"
				+ File.separator + shopId + File.separator;
		return imagePath;
	}
}
