package com.hanbit.utils;

public class StringChecker {
	public static void main(String[] args) {
		
		String message = "hello java";
		char ch = 'j';
		
		// 주어진 메세지에 ch 가 포함되는지 여부를 출력하세요.
		// 출력: ch 가 있습니다. / ch 가 없습니다.
		if (hasChar(message, ch)) {
			System.out.println(ch + " 가(이) 있습니다.");
		} else {
			System.out.println(ch + " 가(이) 없습니다.");
		}
		
		
		// 주어진 메세지에 ch 가 몇개 포함되어있는지 출력하세요.
		// 출력: ch 가 n 개 있습니다.
		int count = countChar(message, ch);		
		System.out.println(ch + " 가(이) " + count + " 개 있습니다.");
		
		
		// 주어진 메세지에 ch 가 몇번째 문자인지 출력하세요.
		// 출력: ch 가 n 번째에 있습니다.
		int index = indexOf(message, ch);
		System.out.println(ch + " 가(이) " + index + " 번째에 있습니다.");
		
		
		// 주어진 메세지에 a 가 앞에서 몇번째, 뒤에서 몇번째인지 출력하세요.
		// 출력: a 가 앞에서 n 번째, 뒤에서 m 번째에 있습니다.
		message = "banana";
		index = indexOf(message, 'a');
		int lastIndex = lastIndexOf(message, 'a');
		System.out.println("a 가 앞에서 " + index + " 번째, 뒤에서 "
				+ lastIndex + "번째에 있습니다.");

	}

	
	
	/*
	 * 함수명: hasNumber
	 * 매개변수1: String str
	 * 리턴타입: boolean
	 * 설명: 문자열을 입력받아 숫자를 포함하고 있는지 여부를 반환합니다.
	 * 힌트1: char[] chars = str.toCharArray();
	 * 힌트2: if (chars[i] == '3') { ... }
	 * 예1: hasNumber("hello123") -> true
	 * 예2: hasNumber("박재홍") -> false
	 * 예3: hasNumber("A1") -> true
	 */
	static boolean hasNumber(String str) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			boolean isNumber = chars[i] == '0' || chars[i] == '1' || chars[i] == '2' || chars[i] == '3'
					|| chars[i] == '4' || chars[i] == '5' || chars[i] == '6' || chars[i] == '7' || chars[i] == '8'
					|| chars[i] == '9';
			if (isNumber) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	/*
	 * 함수명: hasChar
	 * 매개변수1: String str
	 * 매개변수2: char ch
	 * 리턴타입: boolean
	 * 설명: 문자열과 문자 1개를 입력받아 문자열이 해당 문자를 포함하고
	 *       있는지 여부를 반환합니다.
	 * 예1: hasChar("hello123", 'l') -> true
	 * 예2: hasNumber("박재홍", 'h') -> false
	 */
	static boolean hasChar(String str, char ch) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ch) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	/*
	 * 함수명: hasY
	 * 매개변수: String str
	 * 리턴타입: boolean
	 * 설명: 문자열을 입력받아 'Y' 또는 'y'를 포함하고 있는지 여부를 반환합니다.
	 * 예1: hasY("Yes") -> true
	 * 예1: hasY("merry") -> true
	 * 예3: hasY("no") -> false
	 */
	static boolean hasY(String str) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			boolean isY = chars[i] == 'Y' || chars[i] == 'y';
			if (isY) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	/*
	 * 함수명: countChar
	 * 매개변수1: String str
	 * 매개변수2: char ch
	 * 리턴타입: int
	 * 설명: 문자열과 문자 1개를 입력받아 문자열에 해당 문자가
	 *       몇개 포함되어있는지를 반환합니다.
	 * 예1: countChar("merry", 'r') -> 2
	 * 예2: countChar("merry", 'e') -> 1
	 * 예3: countChar("merry", 'Y') -> 0
	 */
	static int countChar(String str, char ch) {
		char[] chars = str.toCharArray();
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ch) {
				count++;
			}
		}
		return count;
	}
	
	
	
	
	/*
	 * 함수명: indexOf
	 * 매개변수1: String str
	 * 매개변수2: char ch
	 * 리턴타입: int
	 * 설명: 문자열과 문자 1개를 입력받아 해당 문자의 위치를 반환합니다.
	 *       단, 해당 문자가 없으면 -1 을 반환합니다.
	 * 예1: indexOf("hello", 'e') -> 1
	 * 예2: indexOf("christmas", 'd') -> -1
	 */
	static int indexOf(String str, char ch) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	
	
	
	/*
	 * 함수명: lastIndexOf
	 * 매개변수1: String str
	 * 매개변수2: char ch
	 * 리턴타입: int
	 * 설명: 문자열과 문자 1개를 입력받아 해당 문자의 위치를
	 *       뒤에서 부터 카운트하여 반환합니다.
	 *       단, 해당 문자가 없으면 -1 을 반환합니다.
	 * 예1: lastIndexOf("hello", 'l') -> 3
	 * 예2: lastIndexOf("hello", 'o') -> 4
	 * 예3: lastIndexOf("christmas", 'd') -> -1
	 */
	static int lastIndexOf(String str, char ch) {
		char[] chars = str.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] == ch) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	
	/*
	 * 함수명: charAt
	 * 매개변수1: String str
	 * 매개변수2: int index
	 * 리턴타입 char
	 * 설명: 문자열과 정수를 입력받아 정수번째 문자를 반환합니다.
	 *       단, 정수가 0보다 작거나 문자열의 길이와 같거나 크면 0을 반환합니다.
	 * 예1: charAt("hanbit", 3) -> 'b'
	 * 예2: charAt("hanbit", -1) -> 0
	 * 예3: charAt("hanbit", 6) -> 0
	 */
	/**
	 * 문자열과 정수를 입력받아 정수번째 문자를 반환합니다.
	 * 단, 정수가 0보다 작거나 문자열의 길이와 같거나 크면 0을 반환합니다.
	 * 
	 * @param str 문자열
	 * @param index 반환할 문자열 인덱스
	 * @return 정수번째 문자
	 */
	static char charAt(String str, int index) {
		if (index < 0) {
			return 0;
		}
		char[] chars = str.toCharArray();
		if (index >= chars.length) {
			return 0;
		}
		return chars[index];
	}
}