package com.yj.sys.common.util;

import java.io.File;

/* 获取图片上传根路径 */
public class UploadUtil {
	private static final String BASE_PATH="pics";
	public static File getImgDirFile() {
		String fileDirPath = new String("/Tomcat/" + BASE_PATH);
		File file = new File(fileDirPath);
		if(!file.exists()) file.mkdirs();
		return file;
	}
}
