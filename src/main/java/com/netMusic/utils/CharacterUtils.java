package com.netMusic.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符工具类
 */
public class CharacterUtils {


	public static String getRandomString(int length) {
		String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; ++i) {
			int number = random.nextInt(52);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	public static boolean isContainChinese(String str){
		Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = pattern.matcher(str);
		if(m.find()){
			return true;
		}
		return  false;
	}


	public static boolean isContainNumber(String str){
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher m = pattern.matcher(str);
		if(m.find()){
			return true;
		}
		return  false;
	}


//	public static void main(String[] args){
//		System.out.println(getRandomString(2));
//	}

}