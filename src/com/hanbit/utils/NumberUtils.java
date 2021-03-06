package com.hanbit.utils;

public class NumberUtils {

	public static void main(String[] args) {
		int x = 8;
		int y = 10;
		
		// compare 함수를 사용하여 결과값을 출력하세요.
		// 출력: compare(x, y)의 결과는 ? 입니다.
		String result = "compare(" + x + ", " + y + ")의 결과는 "; 
		result += compare(x, y) + " 입니다.";
		System.out.println(result);
		
		// isNumber 함수를 사용하여 다음 문자열이 숫자인지 출력하세요.
		// 출력: ? 은 숫자입니다. / ? 은 숫자가 아닙니다.
		String str = "-56.0";
		
		if (isNumber(str)) {
			System.out.println(str + " 은 숫자입니다.");
		}
		else {
			System.out.println(str + " 은 숫자가 아닙니다.");
		}
		
		// max 함수를 사용하여 가장 큰 값을 구하시오.
		// 출력: 가장 큰 수는 ? 입니다.
		int[] numbers = new int[] {100, 39, 55, 193, 98};
		System.out.println("가장 큰 수는 " + max(numbers) + " 입니다.");
		
		// min 함수를 사용하여 가장 큰 값을 구하시오.
		// 출력: 가장 작은 수는 ? 입니다.
		System.out.println("가장 작은 수는 " + min(numbers) + " 입니다.");
		
		// stringToInt 사용
		System.out.println(stringToInt("-4584.9"));
		
		// plusStringValue 사용
		System.out.println(plusStringValue("35", "47"));
	}
	
	/*
	 * 함수명: compare
	 * 매개변수: int left
	 * 매개변수: int right
	 * 리턴타입: int
	 * 설명: 두개의 정수를 입력받아 왼쪽정수가 크면 1
	 *       오른쪽 정수가 크면 -1, 같으면 0을 반환합니다.
	 * 예1: compare(1, 4) -> -1
	 * 예2: compare(50, 4) -> 1
	 * 예3: compare(7, 7) -> 0
	 */
	static int compare(int left, int right) {
		if (left > right) {
			return 1;
		}
		else if (left < right) {
			return -1;
		}
		
		return 0;
	}
	
	/*
	 * 함수명: isNumber
	 * 매개변수: String str
	 * 리턴타입: boolean
	 * 설명: 입력받은 문자열이 숫자 형태인지 여부를 반환합니다.
	 * 예1: isNumber("123") -> true
	 * 예2: isNumber("0.3") -> true
	 * 예3: isNumber("4시") -> false
	 */
	static boolean isNumber(String str) {
		char[] chars = str.toCharArray();
		boolean negative = false;
		boolean hasPoint = false;
		
		for (int i=0;i<chars.length;i++) {
			char ch = chars[i];
			
			if (!(ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5'
					|| ch == '6' || ch == '7' || ch == '8' || ch == '9')) {
				if (i == 0 && ch == '-') {
					negative = true;
					continue;
				}
				
				int pointMinPosition = 0;
				
				if (negative) {
					pointMinPosition = 1;
				}
				
				if (!hasPoint && i > pointMinPosition && ch == '.') {
					if (i == chars.length - 1) {
						return false;
					}
					
					hasPoint = true;
					continue;
				}
				
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * 함수명: max
	 * 매개변수: int[] numbers
	 * 리턴타입: int
	 * 설명: 입력받은 정수 배열의 값 중 가장 큰 값을 반환합니다.
	 * 힌트: int max = Integer.MIN_VALUE;
	 * 예1: max(new int[] {7, 10, 3}) -> 10
	 * 예2: max(new int[] {7, 10, 3, 99}) -> 99
	 * 예3: max(new int[] {107, 10, 3, 99, 100}) -> 107
	 */
	static int max(int[] numbers) {
		int max = Integer.MIN_VALUE;
		
		for (int i=0;i<numbers.length;i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		
		return max;
	}
	
	/*
	 * 함수명: min
	 * 매개변수: int[] numbers
	 * 리턴타입: int
	 * 설명: 입력받은 정수 배열의 값 중 가장 작은 값을 반환합니다.
	 * 힌트: int min = Integer.MAX_VALUE;
	 * 예1: min(new int[] {7, 10, 3}) -> 3
	 * 예2: min(new int[] {7, 10, 3, 99}) -> 3
	 * 예3: min(new int[] {107, -10, 3, 99, 100}) -> -10
	 */
	static int min(int[] numbers) {
		int min = Integer.MAX_VALUE;
		
		for (int i=0;i<numbers.length;i++) {
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}
		
		return min;
	}
	
	/*
	 * 함수명: stringToInt
	 * 매개변수: String str
	 * 리턴타입: int
	 * 설명: 숫자형태의 문자열을 입력받아 정수형태로 반환합니다.
	 *       단, 숫자형태가 아니면 0을 반환합니다.
	 * 예1: stringToInt("123") -> 123
	 * 예2: stringToInt("0011") -> 11
	 * 예3: stringToInt("9.9") -> 9
	 * 예3: stringToInt("5시") -> 0
	 * 예4: stringToInt("-123") -> -123
	 * 예5: stringToInt("-1.23") -> -1
	 */
	static int stringToInt(String str) {
		if (!isNumber(str)) {
			return 0;
		}
		
		
		/** 새로운 캐릭터의 배열의 길이 구하기 (. 뒤에는 카운트X / -는 건너뛰고 카운트) */
		char[] chars = str.toCharArray();
		int newLength = 0;
		boolean negative = false;

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '.') {
				break;
			} 
			else if (chars[i] == '-') {
				negative = true;
				continue;
			}
			newLength++;
		}
		
		
		/** 음수 양수일 때의 배열의 시작점 초기화하기 (음수 일 때는 맨 앞을 -로 표기함) */
		char[] newChars = new char[newLength];
		int startPos = 0;
		if (negative) {
			startPos = 1;
		}
		
		/** i = startPos 한다는 건 i번째 부터는 새로운 배열의 숫자가 들어간다는 것
		// i < newChars.length + startPos 음수일 경우에는 startPos = 1 만큼 검사를 해야 함
		// 새로운 배열의 각각의 인덱스의 글자를 구함  */
		for (int i = startPos; i < newChars.length + startPos; i++) {
			newChars[i - startPos] = chars[i]; //"-123 => 123"이 됨, 나중에 -1을 해서 음수로 만들어 줄거임
		}
		
		/** 구한 결과값들을 더해 정수 형태로 변환
		// 자리수를 계산해줌*/
		int result = 0;
		for (int i = 0; i < newChars.length; i++) {
			char ch = newChars[i];
			int pos = newChars.length - i; // i 번째 다음으로 남은 배열의 길이
			int num = 0;

			if (ch == '0') {
				continue; /** "0011" -> 11 */
			} 
			else if (ch == '1') {
				num = 1;
			} 
			else if (ch == '2') {
				num = 2;
			} 
			else if (ch == '3') {
				num = 3;
			} 
			else if (ch == '4') {
				num = 4;
			} 
			else if (ch == '5') {
				num = 5;
			} 
			else if (ch == '6') {
				num = 6;
			} 
			else if (ch == '7') {
				num = 7;
			} 
			else if (ch == '8') {
				num = 8;
			} 
			else if (ch == '9') {
				num = 9;
			}

			for (int j = 1; j < pos; j++) {
				num *= 10; /** i번째 뒤에 남은 배열의 길이 만큼 10을 곱해주는 걸 반복 */
			}

			result += num; /** result 뒤에 num을 더하면 num이 계속 result 값의 뒤로 붙음 */
		}

		if (negative) {
			result *= -1; /** 어떤 숫자든 -1를 곱하면 음수가 됨*/
		}

		return result;
	}
	
	/*
	 * 함수명: plusStringValue
	 * 매개변수1: String str1
	 * 매개변수2: String str2
	 * 리턴타입: int
	 * 설명: 두개의 숫자형태의 문자열을 받아 각 문자열의 숫자값의 합을 반환합니다.
	 * 예1: plusStringValue("23", "53") -> 76
	 * 예2: plusStringValue("45", "5시") -> 45
	 */
	static int plusStringValue(String str1, String str2) {
		
		return stringToInt(str1) + stringToInt(str2);
	}
	
}
