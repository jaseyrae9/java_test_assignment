package com.alasdoo.developercourseassignment.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {

	public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String digits = "0123456789";
	public static final String alphanum = letters + digits;
	public static final Integer stringLength = 11;

	public static String generateRandomString() {
		return RandomStringUtils.random(stringLength, alphanum); 
	}
}
