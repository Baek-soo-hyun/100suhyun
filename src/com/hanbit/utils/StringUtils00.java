package com.hanbit.utils;

public class StringUtils00 {
	public static void main(String[] args) {
		System.out.println("ABC".compareTo("aabc"));
		System.out.println(compare("ABC", "aabc", false));
		
		System.out.println(switchCase('!'));
		
		System.out.println(indexOf("hanbit", "NB"));
		
		System.out.println(replace("banana", "an", "o"));
		System.out.println(replace("banana", "an", "o", 1));
		System.out.println(equals ("str1", ""));
	}
	
	/*
	 * 함수명: compare
	 * 매개변수1: String left
	 * 매개변수2: String right
	 * 리턴타입: int
	 * 설명: 두개의 문자열을 입력받아 왼쪽이 크면 양수,
	 *       오른쪽이 크면 음수, 같으면 0을 반환합니다.
	 * 예1: compare("11", "2") -> -1
	 * 예2: compare("11111111111111", "2") -> -1
	 * 예3: compare("abc", "abcd") -> -1
	 * 예4: compare("ab", "ABC") -> -1
	 * 예5: compare("abc", "ABC") -> ?
	 */
	static int compare(String left, String right, boolean ignoreCase) {
		if (left == null && right == null) {
			return 0;
		}
		else if (left != null && right == null) {
			return 1;
		}
		else if (left == null && right != null) {
			return -1;
		}
		
		// compare("abc", "ABC") -> ? 여기서 "ABC"를 더 큰값이라고 여기고 -1을 나오게 하려고 ignoreCase를 변수로 지정해두는 것
		if (ignoreCase) {
			// 두 매개변수를 동일한 함수로 돌려서 비교하기 쉽게 한가지 case로 통일시켜주는 것
			left = toLowerCase(left);
			right = toLowerCase(right);
		}

		char[] leftChars = left.toCharArray();
		char[] rightChars = right.toCharArray();
		
		for (int i=0;i<leftChars.length;i++) {
			//만약 left 매개 변수의 길이가 더 크면 무조건 왼쪽 변수 값이 큰거임 
			if (i >= rightChars.length) {
				return 1;
			}
			
			if (leftChars[i] != rightChars[i]) {
				// 만약 오른쪽이 더 큰 수라면, 음수 / 왼쪽이 더 큰 수라면 양수가 나올 게 뻔함
				return leftChars[i] - rightChars[i];
			}
		}
		
		// 위에를 다 통과한다는 것은 두 매개변수를 어떤 case로 통일 시켜줬는데 문자도, 길이도 다 똑같다는 것임
		// 그럴 경우에는 문자열의 길이가 더 큰 쪽이 더 큰 값임
		return leftChars.length - rightChars.length;
	}
	
	
	
	
	
	
	/* compare 매소드 오버로딩
	(false 값을 항상 지정해주기 귀찮으니까 아예 false로 디폴트 시킨 함수 하나를 동일한 매소드면으로 추가 생성하는 것) */
	static int compare(String left, String right) {
		return compare(left, right, false);
	}
	
	
	
	
	/*
	 * 함수명: switchCase
	 * 매개변수: char ch
	 * 리턴타입: char
	 * 설명: 소문자를 입력받으면 대문자로, 대문자를 입력받으면 소문자로 반환합니다.
	 * 		 단, 영문자가 아니면 그대로 반환합니다.
	 * 예1: switchCase('a') -> 'A'
	 * 예2: switchCase('D') -> 'd'
	 * 예3: switchCase('!') -> '!'
	 */
	static char switchCase(char ch) {
		int gabOfCase = 'a' - 'A';
		
		if (ch >= 'A' && ch <= 'Z') {
			return (char) (ch + gabOfCase);
		}
		else if (ch >= 'a' && ch <= 'z') {
			return (char) (ch - gabOfCase);
		}
		
		return ch;
	}
	
	/*
	 * 함수명: toLowerCase
	 * 매개변수: char ch
	 * 리턴타입: char
	 * 설명: 입력받은 영문 대문자를 소문자로 반환합니다.
	 *       단, 영문 대문자가 아니면 그대로 반환합니다.
	 * 예1: toLowerCase('A') -> 'a'
	 * 예2: toLowerCase('a') -> 'a'
	 */
	static char toLowerCase(char ch) {
		if (ch >= 'A' && ch <= 'Z') {
			return (char) (ch + ('a' - 'A'));
		}
		
		return ch;
	}
	
	
	
	
	
	/*
	 * 함수명: toUpperCase
	 * 매개변수: char ch
	 * 리턴타입: char
	 * 설명: 입력받은 영문 소문자를 대문자로 반환합니다.
	 *       단, 영문 소문자가 아니면 그대로 반환합니다.
	 * 예1: toUpperCase('a') -> 'A'
	 * 예2: toUpperCase('A') -> 'A'
	 */
	static char toUpperCase(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			return (char) (ch + ('A' - 'a'));
		}
		
		return ch;
	}
	
	
	
	
	/*
	 * 함수명: toLowerCase
	 * 매개변수: String str
	 * 리턴타입: String
	 * 설명: 입력받은 영문 대문자를 소문자로 반환합니다.
	 *       단, 영문 대문자가 아니면 그대로 반환합니다.
	 * 예1: toLowerCase("ABC") -> "abc"
	 * 예2: toLowerCase("Java") -> "java"
	 */
	static String toLowerCase(String str) {
		if (str == null) {
			return null;
		}
		
		char[] chars = str.toCharArray();
		String result = "";
		
		for (int i=0;i<chars.length;i++) {
			result += toLowerCase(chars[i]);
		}
		
		return result;
	}
	
	
	
	
	/*
	 * 함수명: toUpperCase
	 * 매개변수: String str
	 * 리턴타입: String
	 * 설명: 입력받은 영문 소문자를 대문자로 반환합니다.
	 *       단, 영문 소문자가 아니면 그대로 반환합니다.
	 * 예1: toUpperCase("hello") -> "HELLO"
	 * 예2: toUpperCase("Java") -> "JAVA"
	 * 예3: toUpperCase(null) -> null
	 */
	static String toUpperCase(String str) {
		if (str == null) {
			return null;
		}
		
		char[] chars = str.toCharArray();
		String result = "";
		
		for (int i=0;i<chars.length;i++) {
			result += toUpperCase(chars[i]);
		}
		
		return result;
	}
	
	
	
	
	/*
	 * 함수명: switchCase
	 * 매개변수: String str
	 * 리턴타입: String
	 * 설명: 입력받은 영문 소문자를 대문자로, 대문자를 소문자로 반환합니다.
	 *       단, 영문이 아니면 그대로 반환합니다.
	 * 예1: switchCase("hello") -> "HELLO"
	 * 예2: switchCase("Java") -> "jAVA"
	 * 예3: switchCase(null) -> null
	 */
	static String switchCase(String str) {
		if (str == null) {
			return null;
		}
		
		char[] chars = str.toCharArray();
		String result = "";
		
		for (int i=0;i<chars.length;i++) {
			result += switchCase(chars[i]);
		}
		
		return result;
	}
	
	
	
	/*
	 * 함수명: contains
	 * 매개변수1: String str
	 * 매개변수2: String search
	 * 리턴타입: boolean
	 * 설명: 입력받은 문자열에 검색할 문자열이 있으면 true, 없으면 false를 반환합니다.
	 * 예1: contains("banana", "an") -> true
	 * 예2: contains("apple", "led") -> false
	 * 예3: contains("apple", "pa") -> false
	 * 예4: contains("hanbit", "NB") -> false
	 * 예5: contains(null, null) -> false
	 */
	static boolean contains(String str, String search) {
		if (str == null || search == null) {
			return false;
		}
		
		char[] chars = str.toCharArray();
		char[] searchChars = search.toCharArray();
		
		for (int i=0;i<chars.length;i++) {
			boolean match = isMatch(chars, searchChars, i);
			
			if (match) {
				return true;
			}
		}
		
		return false;
	}

	/*
	 * 함수명: countMatches
	 * 매개변수1: String str
	 * 매개변수2: String search
	 * 리턴타입: int
	 * 설명: 입력받은 문자열에 검색할 문자열이 몇번 포함되었는지 반환합니다.
	 * 예1: countMatches("banana", "an") -> 2
	 * 예2: countMatches("apple", "led") -> 0
	 * 예3: countMatches("apple", "ap") -> 1
	 * 예4: countMatches("hanbit", "NB") -> 0
	 * 예5: countMatches(null, null) -> 0
	 */
	static int countMatches(String str, String search) {
		if (str == null || search == null) {
			return 0;
		}
		
		int countMatches = 0;
		
		char[] chars = str.toCharArray();
		char[] searchChars = search.toCharArray();
		
		for (int i=0;i<chars.length;i++) {
			boolean match = isMatch(chars, searchChars, i);
			
			if (match) {
				i += searchChars.length - 1;
				//ismatch 함수 자체가 찾고자 하는 string과 같은 string 이 있는가를 확인하는 함수이니까
				//만약 match 한다면 searchChars.length의 길이(찾고자 하는 string 묶음의 길이)만큼 건너뛰고 그 뒤에 또 있는지 찾으면 되니{까
				countMatches++;
			}
		}
		
		return countMatches;
	}
	
	
	
	
	/*
	 * 함수명: isMatch
	 * 설명: 입력받은 문자열에 검색할 문자열이 포함되었는지 확인합니다.
	 */
	static boolean isMatch(char[] chars, char[] searchChars, int index) {
		boolean match = true;
		
		if (chars[index] != searchChars[0]) {
			match = false;
		}
		else if (chars.length - index < searchChars.length) {
			match = false;
		}
		else {
			for (int j=1;j<searchChars.length;j++) {
				if (searchChars[j] != chars[index+j]) {
					match = false;
					break;
				}
			}
		}
		
		return match;
	}
	
	
	
	
	/*
	 * 함수명: indexOf
	 * 매개변수1: String str
	 * 매개변수2: String search
	 * 리턴타입: int
	 * 설명: 입력받은 문자열에 검색할 문자열이 있으면 시작되는 위치를,
	 *       없으면 -1을 반환합니다.
	 * 예1: indexOf("banana", "an") -> 1
	 * 예2: indexOf("apple", "led") -> -1
	 * 예3: indexOf("apple", "ple") -> 2
	 * 예4: indexOf("hanbit", "NB") -> -1
	 * 예5: indexOf(null, null) -> -1
	 */
	static int indexOf(String str, String search) {
		if (str == null || search == null) {
			return -1;
		}
		
		char[] chars = str.toCharArray();
		char[] searchChars = search.toCharArray();
		
		for (int i=0;i<chars.length;i++) {
			boolean match = isMatch(chars, searchChars, i);
			
			if (match) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	
	/*
	 * 함수명: replace
	 * 매개변수1: String str
	 * 매개변수2: String search
	 * 매개변수3: String replaceStr
	 * 리턴타입: String
	 * 설명: 입력받은 문자열에서 주어진 문자열을 찾아 대체 문자열로 교체하여 반환합니다.
	 * 예1: replace("banana", "an", "o") -> "booa"
	 * 예2: replace("apple", "le", "lication") -> "application"
	 * 예3: replace("apple", "ple", "proach") -> "approach"
	 * 예4: replace("hanbit", "NB") -> "hanbit"
	 * 예5: replace(null, null) -> null
	 */	
	static String replace(String str, String search, String replaceStr) {
		if (str == null) {
			return null;
		}

		if (search == null || "".equals(search) || str.length() < search.length()) {
			return str;
		}

		if (replaceStr == null) {
			replaceStr = "";
		}

		String result = "";

		char[] chars = str.toCharArray();
		char[] searchChars = search.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			boolean match = isMatch(chars, searchChars, i);

			if (match) {
				i += searchChars.length - 1;
				result += replaceStr;
			} else {
				result += chars[i];
			}
		}

		return result;
	}
	


	
	
	/*
	 * 함수명: replace
	 * 매개변수1: String str
	 * 매개변수2: String search
	 * 매개변수3: String replaceStr
	 * 매개변수4: int limit
	 * 리턴타입: String
	 * 설명: 입력받은 문자열에서 주어진 문자열을 찾아 대체 문자열로 교체하여 반환합니다.
	 *       단, 교체 제한 수 만큼만 교체합니다. 제한이 -1 이면 제한을 두지 않습니다.
	 * 예1: replace("banana", "an", "o", 1) -> "boana"
	 * 예2: replace("apple", "le", "lication", 0) -> "apple"
	 * 예3: replace("apple", "ple", "proach", 5) -> "approach"
	 * 예4: replace("hanbit", "NB", "nba", -1) -> "hanbit"
	 * 예5: replace(null, null, null, -1) -> null
	 */
	static String replace(String str, String search, String replaceStr, final int limit) {
		if (str == null) {
			return null;
		}

		if (search == null || "".equals(search) || str.length() < search.length()) {
			return str;
		}
		
		if (replaceStr == null) {
			replaceStr = "";
		}
		
		if (limit == 0) {
			return str;
		}
		
		int _limit = limit;
		String result = "";
		
		char[] chars = str.toCharArray();
		char[] searchChars = search.toCharArray();
		
		for (int i=0;i<chars.length;i++) {
			boolean match = true;
			
			if (_limit < 0 || _limit > 0) /*_limit 제한이 0이다 == 0번 교체한다.*/{
				match = isMatch(chars, searchChars, i);
			}
			else /*_limit 제한이 0이다 == 0번 교체한다.*/{
				match = false;
				//다음 else로 넘어감 => chars[i]가 순차적으로 더해짐
			}
			
			if (match) {
				i += searchChars.length - 1; /* 다음번 i의 순서도 replaceStr된 길이만큼 건너 뛰어야 함 */
				result += replaceStr; /* 결과값에다가 replaceStr를 더해줘야함 */
				_limit--; /* _limit의 목숨이 1씩 줄어듦 */
			}
			else {
				result += chars[i];
			}
		}
		
		return result;

	}
	
	
	
	/*
	 * 함수명: equals
	 * 매개변수1: str1
	 * 매개변수2: str2
	 * 리턴타입: boolean
	 * 설명: 두개의 문자열이 같으면 true, 다르면 false를 반환합니다.
	 */
	static boolean equals(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return true;
		}
		
		if (str1 == null || str2 == null) {
			return false;
		}
		
		if (str1.length() != str2.length()) {
			return false;
		}
		
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		
		for (int i=0;i<chars1.length;i++) {
			if (chars1[i] != chars2[i]) {
				return false;
			}
		}
		
		return true;
	}
	

}