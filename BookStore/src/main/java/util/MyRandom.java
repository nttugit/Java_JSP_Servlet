package util;

import java.util.Random;

public class MyRandom {
	public static String randomVerificationCode(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String characterArray[] = characters.split("");
		String result=  "";
		Random random = new Random();
		
		while(length >0) {
			int randomIndex = random.nextInt(characters.length());
			result += characterArray[randomIndex];
			length--;
		}
		return result;
	}
}
