package com.hanbit.utils;

public class FunctionExercise {

	public static void main(String[] args) {
		
		String firstName = "지훈";
		String lastName = "한";
		String fullName = getFullName(firstName, lastName);
		
		String names = "조영욱|김지룡";
		String[] nameArray = splitNames(names, "|");
		
		// 세 수의 합을 함수 1개를 호출하여 구하시오.
		int x = 1, y = 2, z = 3;
		int sum = plusThreeNumbers(x, y, z);
		sum = plus(x + y, z);
		sum = plus(x, y + z);
		
		// 세 수의 합을 함수 2개를 호출하여 구하시오.
		sum = plus(plus(x, y), z);
		
		boolean bigger = false;
		setBigger(bigger);
		setBigger(true);
		setBigger(1 < 4);
		setBigger(x > y);
		
		setBigger(plus(x, y) > 4);
	}
	
	static void setBigger(boolean bigger) {
		
	}
	
	/*
	 * 함수명: getFullName
	 * 매개변수1 : String firstName
	 * 매개변수2 : String lastName
	 * 리턴타입 : String
	 */
	static String getFullName(String firstName, String lastName) {
		
		return null;
	}
	
	/*
	 * 함수명: plusThreeNumbers
	 * 매개변수1: int first
	 * 매개변수2: int second
	 * 매개변수3: int third
	 * 리턴타입: int
	 */
	static int plusThreeNumbers(int first, int second, int third) {
		
		return 0;
	}
	
	/*
	 * 함수명: isTrue
	 * 리턴타입: boolean
	 */
	static boolean isTrue() {
		
		return false;
	}
	
	/*
	 * 함수명: printName
	 * 리턴타입: 없음
	 */
	static void printName() {
		
	}
	
	/*
	 * 함수명: logError
	 * 매개변수: String message
	 * 리턴타입: 없음
	 */
	static void logError(String message) {
		
	}
	
	/*
	 * 함수명: caculate
	 * 매개변수1: int left
	 * 매개변수2: String operator
	 * 매개변수3: int right
	 * 리턴타입: long
	 */
	static long caculate(int left, String operator, int right) {
		
		return 0;
	}
	
	/*
	 * 함수명: validatePassword
	 * 매개변수1: String password
	 * 매개변수2: int maxLength
	 * 매개변수3: int minLength
	 * 매개변수4: char[] allowedCharacters
	 * 리턴타입: boolean
	 */
	static boolean validatePassword(String password, int maxLength, int minLength,
			char[] allowedCharacters) {
		
		return false;
	}
	
	/*
	 * 함수명: splitNames
	 * 매개변수1: String names
	 * 매개변수2: String separator
	 * 리턴타입: String[]
	 */
	static String[] splitNames(String names, String separator) {
		
		return null;
	}
	
	/*
	 * 함수명: equal
	 * 매개변수1: Object obj
	 * 리턴타입: boolean
	 */
	static boolean equal(Object obj) {
		
		return false;
	}
	
	/*
	 * 함수명: cloneObj
	 * 리턴타입: Object
	 */
	static Object cloneObj() {
		
		return null;
	}
	
	/*
	 * 함수명: decode
	 * 매개변수1: String number
	 * 리턴타입: Integer
	 */
	static Integer decode(String number) {
		
		/* Primitive Type vs Wrapper Class Type
		byte Byte
		short Short
		int Integer
		long Long
		
		float Float
		double Double
		boolean Boolean
		char Character
		*/
		
		return null;
	}
	
	/*
	 * 함수명: search
	 * 매개변수1: double[] array
	 * 매개변수2: int fromIndex
	 * 매개변수3: int toIndex
	 * 매개변수4: double key
	 * 리턴타입: int	
	 */
	static int search(double[] array, int fromIndex, int toIndex, double key) {
		
		return 0;
	}
	
	/*
	 * 함수명이 getHashTags 이고 String 배열을 반환하는
	 * 함수의 원형을 작성하세요.
	 */
	static String[] getHashTags() {
		
		return null;
	}
	
	/*
	 * 함수명이 plus 이고 두개의 정수를 입력받아
	 * 정수형태의 값을 리턴하는 함수의 원형을 작성하세요.
	 */
	static int plus(int x, int y) {
		
		return 0;
	}
	
	/*
	 * 함수명이 println인 함수를 작성하세요.
	 */
	static void println(String str) {
		
	}
	
	
	
}
