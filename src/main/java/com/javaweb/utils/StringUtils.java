package com.javaweb.utils;

public class StringUtils {
	public static boolean checkstring(String value) {
		if(value != null && !value.equals("")) {
			return true;
		}
		else return false;
		
	}
}
