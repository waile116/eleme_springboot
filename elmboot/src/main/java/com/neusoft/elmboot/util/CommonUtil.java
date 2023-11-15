package com.neusoft.elmboot.util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.tomcat.util.codec.binary.Base64;

public class CommonUtil {
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		return sdf.format(calendar.getTime());
	}

	public static String getEndTime(int lifeSpan){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(calendar.getTime());
		calendar.add(Calendar.DATE,lifeSpan);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(calendar.getTime());
	}

	public static final String SALT = "afhu&9TawdhYCbsad*dawdh1dawdjhaj";

	public static String encodePassword(String strValue) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("MD5加密出错");
		}
		return Base64.encodeBase64String(md5.digest((strValue + CommonUtil.SALT).getBytes()));

	}
}
