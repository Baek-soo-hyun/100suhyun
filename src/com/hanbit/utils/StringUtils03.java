package com.hanbit.utils;

public class StringUtils03 {
	
	public static void main(String[] args) {
		printArray(split("이상윤|조영욱|| |", '|'));
		printArray(splitNotEmpty("hello, world", ','));
		
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
		// 새로운 결과의 스트링 배열은 separator의 개수 + 1
		// separator가 1개면, 2개의 문자로 쪼개지기 때문에 +1을 해주는 것
		
		int n = 0;
		result[n] = ""; 
		/* ㄴ seperator 가 null일 때를 잡아주기 위해서
		   ㄴ seperator 값이 맨 앞에 있을 때, null을 잡아 주기 위해 : ||hello 일때, null hello가 됨 */
		for (int i=0;i<chars.length;i++) {
			if (chars[i] == separator) {
				result[++n] = ""; // 왜 ++n해줘야 하고, sepearator가 [0]일 때 어떻게 처리되는 거지?????????????????????????????????????
				/* null 이 맨 앞에 안 붙게 하기 위해서 : nullhello / null world */
				continue;
			}
			
			result[n] += chars[i];
			//result의 n번째 배열의 스트링은 char[i]들의 합
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
	 * 배열을 반환합니다. ★★★ 단, empty을 제외합니다.
	 * ㄴ 빈문자열(empty) ≠ 공백
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
	 * 입력받은 문자열을 ★문자열 형태의 구분자★를 기준으로 분리한 문자열의 배열을 반환합니다.
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
			return new String[] { str };
		}

		char[] chars = str.toCharArray();
		String[] result = new String[StringUtils00.countMatches(str, separator) + 1];

		int n = 0;
		result[n] = "";

		for (int i = 0; i < chars.length; i++) {
			String candidate = ""; 

			for (int j = i; j < chars.length && j < i + separator.length(); j++) {
				// j = i 를 하는 이유는 한 칸씩 뒤로 밀려나면서 비교를 시작한다는 뜻
				// i가 1이 되면 1부터 검사를 하고, 2가 되면 j도 2부터 검사를 하는 것
				// j < chars.length 는 이유는, j도 chars의 길이 이후엔 비교를 할 대상이 없기 때문
				// i + separator.length() => i부터 시작했으니까 그거 더하기, separator의 길이만큼만 비교하겠다는 뜻
				candidate += chars[j];
				// candidate는 str을 separator.length만큼 떼어낸 문자
			}

			if (separator.equals(candidate)) {
				//candidate가 separator와 동일하다면,
				result[++n] = "";
				// 선위증감을 한 이유는 n이 +1이 된 후에 "";초기화를 시켜줘야 하기 때문에
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
