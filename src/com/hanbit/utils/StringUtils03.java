package com.hanbit.utils;

public class StringUtils03 {
	
	public static void main(String[] args) {
		printArray(split("hello, world", ','));
	}
	
	
	
	
	/**
	 * 입력받은 문자열을 구분자를 기준으로 분리한 문자열의
	 * 배열을 반환합니다.
	 * 
	 * 예1: split("hello, world", ',') -> ["hello", "world"]
	 * 예2: split("5,4,3,2,1", ',') -> ["5", "4", "3", "2", "1"]
	 * 예3: split("이상윤|조영욱", '|') -> ["이상윤", "조영욱"]
	 * 
	 * @param str
	 * @param separator 구분자
	 * @return String[] ★★ 리턴 타입이 스트링의 배열!!
	 */
	static String[] split(String str, char separator) {
		if (str == null) {
			return null;
		}
		
		if (!StringChecker.hasChar(str, separator)) {
			return new String[] {str};
			// 리턴 타입이 스트링의 배열이라서
		}
		
		char[] chars = str.toCharArray();
		String[] result = new String[StringChecker.countChar(str, separator) + 1];
		
		int n = 0;
		result[n] = "";  // ""; <- 요거를 왜 해주는 지 모르겠다. ?????????????????????????????????????????????
		// ㄴ seperator 가 null일 때를 잡아주기 위해서
		for (int i=0;i<chars.length;i++) {
			if (chars[i] == separator) {
				result[++n] = ""; /* null 이 맨 앞에 안 붙게 하기 위해서 : nullhello / null world?????????????????????? */
				continue;
			}
			
			result[n] += chars[i];
		}
		
		return result;
	}
	
	
	
	/**
	 * String[]을 출력하는 함수 
	 * (String의 배열을 println으로 출력이 안 됨)
	 */
	static void printArray(String[] array) {
		for(int i=0 ; i<array.length; i++) {
		System.out.println(array[i]);
		}
	}
	
	
	
	
	/**
	 * 입력받은 문자열을 구분자를 기준으로 분리한 문자열의
	 * 배열을 반환합니다. 단, 빈문자열을 제외합니다. <- 위에 문제랑 무슨 차이가 있는 거징?????????????????????????????????????????
	 * 
	 * 예1: splitNotEmpty("hello, world", ',') -> ["hello", " world"]
	 * 예2: splitNotEmpty("5,4,3,2,1", ',') -> ["5", "4", "3", "2", "1"]
	 * 예3: splitNotEmpty("이상윤|조영욱|| |", '|') -> ["이상윤", "조영욱", " "]
	 * 
	 * @param str
	 * @param separator 구분자
	 * @return
	 */
	static String[] splitNotEmpty(String str, char separator) {
		int count = 0;
		
		String[] split = split(str, separator);
		
		for (int i=0;i<split.length;i++) {
			if (!StringUtils.isEmpty(split[i])) {
				count++;
			}
		}
		
		String[] result = new String[count];
		
		for (int i=0, n=0;i<split.length;i++) {
			if (StringUtils.isEmpty(split[i])) {
				continue;
			}
			
			result[n++] = split[i];
		}		
		
		return result;
	}
	
	
	
	
	/**
	 * 입력받은 문자열을 구분자를 기준으로 분리한 문자열의
	 * 배열을 반환합니다. 단, 공백으로만 이루어진 문자열을 제외합니다.
	 * 
	 * 예1: splitNotBlank("hello, world", ',') -> ["hello", " world"]
	 * 예2: splitNotBlank("5,4,3,2,1", ',') -> ["5", "4", "3", "2", "1"]
	 * 예3: splitNotBlank("이상윤|조영욱|  | |", '|') -> ["이상윤", "조영욱"]
	 * 
	 * @param str
	 * @param separator
	 * @return
	 */
	static String[] splitNotBlank(String str, char separator) {
		int count = 0;

		String[] split = split(str, separator);

		for (int i = 0; i < split.length; i++) {
			if (!StringUtils.isBlank(split[i])) {
				count++;
			}
		}

		String[] result = new String[count];

		for (int i = 0, n = 0; i < split.length; i++) {
			if (StringUtils.isBlank(split[i])) {
				continue;
			}

			result[n++] = split[i];
		}

		return result;
	}
	
	
	
	
	
	/**
	 * 입력받은 문자열을 구분자를 기준으로 분리한 문자열의
	 * 배열을 반환합니다.
	 * 
	 * 예1: split("hello, world", ",") -> ["hello", " world"]
	 * 예2: split("5,4,3,2,1", ",") -> ["5", "4", "3", "2", "1"]
	 * 예3: split("이상윤||조영욱|||", "||") -> ["이상윤", "조영욱", "|"]
	 * 
	 * @param str
	 * @param separator 구분자
	 * @return
	 */
	static String[] split(String str, String separator) {
		if (str == null) {
			return null;
		}
		
		if (!StringUtils00.contains(str, separator)) {
			return new String[] {str};
		}

		char[] chars = str.toCharArray();
		String[] result = new String[StringUtils00.countMatches(str, separator) + 1];
		
		int n = 0;
		result[n] = "";
		
		for (int i=0;i<chars.length;i++) {
			String candidate = "";
			
			for (int j=i;j<chars.length && j<i+separator.length();j++) {
				candidate += chars[j];
			}
			
			if (separator.equals(candidate)) {
				result[++n] = "";
				i += separator.length() - 1;
				continue;
			}
			
			result[n] += chars[i];
		}
		
		return result;
	}
	
	
	
	
	
	/**
	 * 입력받은 문자열을 구분자를 기준으로 분리한 문자열의
	 * 배열을 반환합니다. 단, 빈문자열을 제외합니다.
	 * 
	 * 예1: splitNotEmpty("hello, world", ",") -> ["hello", " world"]
	 * 예2: splitNotEmpty("5,4,3,2,1", ",") -> ["5", "4", "3", "2", "1"]
	 * 예3: splitNotEmpty("이상윤|조영욱|| ||", "||") -> ["이상윤|조영욱", " "]
	 * 
	 * @param str
	 * @param separator 구분자
	 * @return
	 */
	static String[] splitNotEmpty(String str, String separator) {
		int count = 0;

		String[] split = split(str, separator);

		for (int i = 0; i < split.length; i++) {
			if (!StringUtils.isEmpty(split[i])) {
				count++;
			}
		}

		String[] result = new String[count];

		for (int i = 0, n = 0; i < split.length; i++) {
			if (StringUtils.isEmpty(split[i])) {
				continue;
			}

			result[n++] = split[i];
		}

		return result;
	}
	
	
	
	
	
	/**
	 * 입력받은 문자열을 구분자를 기준으로 분리한 문자열의
	 * 배열을 반환합니다. 단, 빈문자열을 제외합니다.
	 * 
	 * 예1: splitNotBlank("hello, world", ",") -> ["hello", " world"]
	 * 예2: splitNotBlank("5,4,3,2,1", ",") -> ["5", "4", "3", "2", "1"]
	 * 예3: splitNotBlank("이상윤|조영욱|| ||", "||") -> ["이상윤|조영욱"]
	 * 
	 * @param str
	 * @param separator 구분자
	 * @return
	 */
	static String[] splitNotBlank(String str, String separator) {
		int count = 0;

		String[] split = split(str, separator);

		for (int i = 0; i < split.length; i++) {
			if (!StringUtils.isBlank(split[i])) {
				count++;
			}
		}

		String[] result = new String[count];

		for (int i = 0, n = 0; i < split.length; i++) {
			if (StringUtils.isBlank(split[i])) {
				continue;
			}

			result[n++] = split[i];
		}

		return result;
	}
	
	
	
	
	
	/**
	 * 입력받은 문자열을 구분자를 기준으로 분리한 문자열의
	 * 배열 중 빈문자열을 제외하고, 빈문자열이 아닌 문자열의
	 * 앞뒤 공백도 제거한 문자열의 배열을 반환합니다.
	 * 
	 * 예1: splitNotBlankAndTrim("hello, world", ",") -> ["hello", "world"]
	 * 예2: splitNotBlankAndTrim("5,4,3,2,1", ",") -> ["5", "4", "3", "2", "1"]
	 * 예3: splitNotBlankAndTrim("이상윤|조영욱|| ||", "||") -> ["이상윤|조영욱"]
	 * 
	 * @param str
	 * @param separator
	 * @return
	 */
	static String[] splitNotBlankAndTrim(String str, String separator) {
		int count = 0;
		
		String[] split = split(str, separator);
		
		for (int i=0;i<split.length;i++) {
			if (!StringUtils.isBlank(split[i])) {
				count++;
			}
		}
		
		String[] result = new String[count];
		
		for (int i=0, n=0;i<split.length;i++) {
			if (StringUtils.isBlank(split[i])) {
				continue;
			}
			result[n++] = StringUtils01.trim(split[i]);
		}		
		return result;
	}
	

}
