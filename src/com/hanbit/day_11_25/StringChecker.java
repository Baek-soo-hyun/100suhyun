package com.hanbit.day_11_25;

public class StringChecker {

	/*
	 * 함수명: hasNumber 
	 * 매개변수1: String str 
	 * 리턴타입: boolean 
	 * 설명: 문자열을 입력받아 숫자를 포함하고 있는지 여부를 반환합니다.
	 * 힌트1: char[] chars = str.toCharArray(); 
	 * 힌트2: if (chars[i] =='3') { ... } 
	 * 예1: hasNumber("hello123") -> true 
	 * 예2: hasNumber("박재홍") -> false
	 */

	static boolean hasNumber(String str) {
//		char[] chars = str.toCharArray();
		
		char[] chars = new char[str.length()];
		
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '0' || chars[i] == '1' || chars[i] == '2' || chars[i] == '3' || chars[i] == '4'
					|| chars[i] == '5' || chars[i] == '6' || chars[i] == '7' || chars[i] == '8' || chars[i] == '9') {
				return true;
			}
		}
		return false;
	}
}
