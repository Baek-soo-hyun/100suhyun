
package com.hanbit.utils;

public class StringUtils01 {
	
	public static void main(String[] args) {
		System.out.println("trim" + " 함수 : " + "[" + StringUtils01.trim("   a  b  c   ") + "]");
		System.out.println("leftTrim" + " 함수 : " + "[" + StringUtils01.leftTrim("   a  b  c   ") + "]");
		System.out.println("rightTrim" + " 함수 : " + "[" + StringUtils01.rightTrim("   a  b  c   ") + "]");
		System.out.println("removeWhitespace" + " 함수 : " + "[" + StringUtils01.removeWhitespace("a b ") + "]");
		System.out.println("leftPad" + " 함수 : " + "[" + leftPad("abcd", 7, 'a') + "]");
		System.out.println("rightPad" + " 함수 : " + "[" + rightPad("abcd", 7, 'a') + "]");
	}

	
	/*
	 * 함수명: trim
	 * 매개변수: String str
	 * 리턴타입: String
	 * 설명: 입력받은 문자열의 앞뒤 공백을 제거하고 반환합니다.
	 * 예1: trim("   abc   ") -> "abc"
	 * 예2: trim("a b ") -> "a b"
	 * 예3: trim(null) -> null
	 */
	static String trim(final String str) {
		if (str == null) {
			return null;
		}

		char[] chars = str.toCharArray();
		String result = "";
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (result.length() == 0 && StringUtils.isWhitespace(ch)) {
				continue;
			}
			result += ch;
		}

		chars = result.toCharArray(); //[abc   ]//
		result = "";
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[chars.length - 1 - i]; //i가 0일 때의 문자는 맨 뒤의 문자부터 시작한다.
			//[chars.length - 1 - i] 0번째부터의 배열이니 -1을 해주고 for문이 돌 때마다 i는 커질테니,
			//결국 [chars.length - 1 - i]의 index는 점점 작아질 거임 -> 결국, 맨 뒤의 문자부터 시작한다는 뜻
			if (result.length() == 0 && StringUtils.isWhitespace(ch)) {
				//result.length() == 0 -> 문자가 나올 때까지라는 뜻, 문자가 나오는 순간 해당 문자열의 길이는 1이 됨 
				continue;
			}
			result = ch + result;
		}
		return result;
	}
	
	
	/* trim을 rightTrim과 lefttTrim 함수를 이용해서 간단하게 짜보기
	 * 
	static String trim(final String str) { 
	return lefttTrim(rightTrim(str));
	-> rightTrim을 한 str을 다시 lefttTrim한다는 뜻
	}	
	
	 */
	
	
	
	
	/*
	 * 함수명: rightTrim
	 * 매개변수: String str
	 * 리턴타입: String
	 * 설명: 입력받은 문자열의 뒤 공백을 제거하고 반환합니다.
	 * 예1: trim("   abc   ") -> "abc"
	 * 예2: trim("a b ") -> "a b"
	 * 예3: trim(null) -> null
	 */
	static String rightTrim(final String str) {
		if (str == null) {
			return null;
		}

		char[] chars = str.toCharArray();
		String result = "";
		for (int i = 0; i < chars.length; i++) {
			char ch = chars[chars.length - 1 - i];
			if (result.length() == 0 && StringUtils.isWhitespace(ch)) {
				continue;
			}
			result = ch + result;
		}
		return result;
	}
	
	
	
	/*
	 * 함수명: leftTrim
	 * 매개변수: String str
	 * 리턴타입: String
	 * 설명: 입력받은 문자열의 앞 공백을 제거하고 반환합니다.
	 * 예1: trim("   abc   ") -> "abc"
	 * 예2: trim("a b ") -> "a b"
	 * 예3: trim(null) -> null
	 */
	static String leftTrim(final String str) {
		if (str == null) {
			return null;
		}

		char[] chars = str.toCharArray();
		String result = "";
		for (int i = 0; i < chars.length; i++) {
			if (result.length() == 0 && StringUtils.isWhitespace(chars[i])) {
				continue;
			}
			result += chars[i];
		}
		return result;
	}
	
	
	
	
	/*
	 * 함수명: removeWhitespace
	 * 매개변수: String str
	 * 리턴타입: String
	 * 설명: 입력받은 문자열의 "공백 == Whitespace"을 제거하고 반환합니다.
	 * 예1: trim("   abc   ") -> "abc"
	 * 예2: trim("a b ") -> "ab"
	 * 예3: trim(null) -> null
	 */
	static String removeWhitespace(final String str) {
		if (str == null) {
			return null;
		}

		char[] chars = str.toCharArray();
		String result = "";
		for (int i = 0; i < chars.length; i++) {
			if (StringUtils.isWhitespace(chars[i])) {
				continue;
			}
			result += chars[i];
		}
		return result;
	}
	
	
	/*
	 * 함수: leftPad
	 * 매개변수1: String str
	 * 매개변수2: int size
	 * 매개변수3: char ch
	 * 리턴타입: String
	 * 설명: 문자열의 길이가 입력받은 사이즈보다 작으면 왼쪽에 입력받은 문자를
	 *       남은 사이즈만큼 더하여 반환합니다.
	 * 예1: leftPad("11", 4, '0') -> "0011"
	 * 예2: leftPad("abcd", 3 '_') -> "abcd" 
	 */
	static String leftPad(String str, int size, char ch) {
		if (str == null || str.length() >= size || ch == 0) {
			return str;
		}
		
		String result = "";
		
		for (int i=0;i<size-str.length();i++) {
			result += ch;
		}
		
		return result + str;
	}
	
	/* repeat 함수를 이용해서 leftPad 함수를 간편하게 짜기
	static String leftPad(String str, int size, char ch) {
		if (str == null || str.length() >= size) {
			return str;
		}
		return repeat(size-str.length(), ch) + str;
	}
	 */
	
	
	
	
	
	
	/*
	 * 함수: rightPad
	 * 매개변수1: String str
	 * 매개변수2: int size
	 * 매개변수3: char ch
	 * 리턴타입: String
	 * 설명: 문자열의 길이가 입력받은 사이즈보다 작으면 입력받은 문자를 
	 *       남은 사이즈만큼 문자열의 오른쪽에 더하여 반환합니다.
	 * 예1: rightPad("11", 4, '0') -> "1100"
	 * 예2: rightPad("abcd", 3 '_') -> "abcd" 
	 */
	static String rightPad(String str, int size, char ch) {
		if (str == null || str.length() >= size || ch == 0) {
			return str;
		}
		
		String result = "";
		for (int i=0;i<size-str.length();i++) {
			result += ch;
		}
		
		return str + result;
	}
	
	/* repeat 함수를 이용해서 rightPad 함수를 간편하게 짜기
	 * 
	static String rightPad(String str, int size, char ch) {
		if (str == null || str.length() >= size) {
			return str;
		}
		return str + repeat(size-str.length(), ch);
	}
	 */
	
	
	
	
	
	
	
	/**
	 * 길이와 문자를 입력받아 길이만큼 문자를 반복한 문자열을 반환합니다.
	 * @param size 반복할 길이
	 * @param ch 반복할 문자
	 * @return 문자를 길이만큼 반복한 문자열
	 * @deprecated 그냥 쓰지마
	 */
	static String repeat(int size, char ch) {
		String result = "";
		
		for (int i=0;i<size;i++) {
			result += ch;
		}
		
		return result;
	}
	
}