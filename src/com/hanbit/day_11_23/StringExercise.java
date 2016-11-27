package com.hanbit.day_11_23;

public class StringExercise {

	public static void main(String[] args) {

		// 1. 입력받은 문자열의 길이를 구해서 출력하시오.
		String name = "한빛";
		int lengthOfName = getLengthOfString(name);
		System.out.println(name + " : " + lengthOfName);

		// 2. 입력받은 문자열의 길이가 10개 이상이면
		// "길이가 너무 길어요" 를 출력하세요.
		boolean validLength = isShorterThan10("안녕하세요. 한빛입니다.");
		if (!validLength) {
			System.out.println("길이가 너무 길어요");
		} else {
			System.out.println("유효합니다");

			String hanbit = "aBc";

			if (!"ABc".equalsIgnoreCase(hanbit)) {
				System.out.println("다릅니다.");
			} else {
				System.out.println("같습니다.");
			}
		}

		// 3. 문자열과 최소길이, 최대길이를 입력받아
		// 유효한 길이의 문자열인지 판단하는 함수를 작성하세요.
		String str = "자바 참 쉬워요.";
		int minLength = 4;
		int maxLength = 12;
		boolean validString = validateStringLength(str, minLength, maxLength);
		if (validString) {
			System.out.println("유효한 스트링");
		} else {
			System.out.println("유효하지 않은 스트링");
		}
	}

	static boolean validateStringLength(String str, int minLength, int maxLength) {
		int stringLength = str.length();

		if (stringLength >= minLength && stringLength <= maxLength) {
			return true;
		}

		return false;
	}

	static boolean isShorterThan10(String str) {

		return getLengthOfString(str) < 10;
	}

	static int getLengthOfString(String str) {

		return str.length();
	}

}
