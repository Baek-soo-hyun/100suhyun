package com.hanbit.utils;

public class StringUtils02 {
	
	public static void main(String[] args) {
		System.out.println(substring("hello", 0, 4));
		System.out.println(substring("", 5));
		System.out.println(substringBetween("char ch = 'z';", "'"));
	}
	
	
	
	
	/**
	 * 주어진 문자열에서 시작인덱스와 끝인덱스 사이의 문자열을 반환합니다. (시작 인덱스부터 시작 / 끝 인덱스 제외)
	 * 예1: substring("hello", 1, 4) -> "ell"
	 * 예2: substring("hello", 1, 10) -> "ello"
	 * 예3: substring("hello", 5, 9) -> ""
	 * 예4: substring("hello", -1, 4) -> null
	 * @param str
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	static String substring(String str, int beginIndex, int endIndex) {
		if (str == null || beginIndex < 0 || endIndex < 0) {
			return null;
		}
		
		if (beginIndex >= str.length() || beginIndex >= endIndex) {
			return ""; // String의 empty == "" == null
		}
		
		endIndex = endIndex > str.length() ? str.length() : endIndex;
		// 해당 조건을 걸어주지 않을 경우,
		//예2: substring("hello", 1, 10) -> "ellonullnullnullnullnullnull" 이렇게 됨
		//왜? hello는 총 길이가 5이고 4번째 인덱스 이후의 문자는 null인데 for문에서 null을 계속 더하라고 명령했으니까.
		
		char[] chars = str.toCharArray();
		String result = "";
		
		for (int i=beginIndex;i<endIndex;i++) {
			result += chars[i];
		}
		
		return result;
	}
	
	
	
	
	
	/**
	 * 메소드 오버로딩을 이용하여
	 * 주어진 문자열에서 시작인덱스부터의 문자열을 반환합니다.
	 * 
	 * 예1: substring("hello", 1) -> "ello"
	 * 예2: substring("hello", 3) -> "lo"
	 * 예3: substring("hello", 5) -> ""
	 * 예4: substring("hello", -1) -> null
	 * 
	 * @param str
	 * @param beginIndex
	 * @return
	 */
	static String substring(String str, int beginIndex) {
		
		return str == null ? null : substring(str, beginIndex, str.length());
		
	// 어차피 substring()함수에서 str이 null일 경우를 체크해줬는데
	// 또 다시 str == null ? null 이라고 체크해주는 이유는???????????????????????????????????????????????
	}
	
	
	
	/**
	 * 입력받은 문자열에서 구분자로 받은 문자열 뒤의 문자열을 반환합니다.
	 * 
	 * 예1: substringAfter("hello world", "hello") -> " world"
	 * 예2: substringAfter("banana", "ba") -> "nana"
	 * 예3: substringAfter("banana", "B") -> ""
	 * 예4: substringAfter("banana", null) -> ""
	 * 
	 * @param str
	 * @param separator 구분자
	 * @return
	 */
	static String substringAfter(String str, String separator) {
		if (str == null) {
			return null;
		}
		
		int beginIndex = StringUtils00.indexOf(str, separator);
		// separator가 일치하기 시작하는 index를 찾는다.
		
		if (beginIndex < 0) {
			// (beginIndex < 0)는 것은 separator와 일치하는 게 없다는 것
			// ("banana", "B") -> ""
			return ""; // "" ==  null
		}
		return substring(str, beginIndex + separator.length());
		// + separator.length() 해주는 이유는 문제에서 "구분자로 받은 문자열 ★뒤★의 문자열부터 반환" 이라고 했기 때문에
		// substring() 함수는 시작인덱스부터의 문자열을 반환하기 때문에
		// 구분자 뒤의 문자열부터 반환하려면, 구분자가 시작하는 인덱스 + 구분자 문자열의 길이를 해줘야 한다.
	}
	
	
	
	
	/**
	 * 입력받은 문자열에서 구분자로 받은 문자열 앞의 문자열을 반환합니다.
	 * 
	 * 예1: substringBefore("hello world", "world") -> "hello "
	 * 예2: substringBefore("banana", "na") -> "ba"
	 * 예3: substringBefore("banana", "B") -> ""
	 * 예4: substringBefore("banana", null) -> ""
	 * 
	 * @param str
	 * @param separator 구분자
	 * @return
	 */
	static String substringBefore(String str, String separator) {
		
		int endIndex = StringUtils00.indexOf(str, separator);
		
		if (endIndex < 0) {
			return "";
		}
		
		return substring(str, 0, endIndex);
		// str의 0번째(처음)부터 endIndex(separator가 시작하는 번째) 사이를 구하는 것
		// 이 말은 즉, endIndex 이전의 문자열을 구하는 것과 같다.
	}
	
	
	
	/**
	 * 입력받은 문자열에서 구분자로 받은 각 문자열 사이의 문자열을 반환합니다.
	 * 
	 * 예1: substringBetween("<div>hello</div>", "<div>", "</div>") -> "hello"
	 * 예2: substringBetween("<div>hello</div>", null, "</div>") -> null
	 * 예3: substringBetween("<div>hello</div>", "<div>", null) -> null
	 * 예4: substringBetween("chars[304]", "[", "]") -> "304"
	 * 예5: substringBetween("chars[304]", "[", "}") -> null
	 * 
	 * @param str
	 * @param open
	 * @param close
	 * @return
	 */
	static String substringBetween(String str, String open, String close) {
		if (str == null || open == null || close == null) {
			return null;
		}
		
		return substringBefore(substringAfter(str, open), close);
	}
	
	
	
	
	
	
	/**
	 * 입력받은 문자열에서 구분자로 받은 문자열로 둘러싸인 문자열을 반환합니다.
	 * 
	 * 예1: substringBetween("#hello#", "#") -> "hello"
	 * 예2: substringBetween("char ch = 'z';", "'") -> "z"
	 * 예3: substringBetween("char ch = 'z';", null) -> null
	 * 
	 * @param str
	 * @param tag
	 * @return
	 */
	static String substringBetween(String str, String tag) {
		
		return substringBetween(str, tag, tag);
	}
	
	
	
}
