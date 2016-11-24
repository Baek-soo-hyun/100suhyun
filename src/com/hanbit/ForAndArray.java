package com.hanbit;

public class ForAndArray {

	public static void main(String[] args) {
		
		// 1. 시작월부터 12월까지의 월명을 배열로 반환하세요.
		//  ex: startMonth = 3 -> {"3월", "4월", ... , "12월"}
		int startMonth = 3;
		String[] monthNames = getMonthNames(startMonth);
		
		for (String monthName : monthNames) {
			System.out.println(monthName);
		}
???????????????????????????????????????????????????????????????????????????????????????????????????
		for (int i=0;i<monthNames.length;i++) {
			String monthName = monthNames[i];
			
			System.out.println(monthName);
		}
		
		
		
		
		// 2. 주어진 배열의 부분 배열을 반환하는 함수를 작성하세요.
		int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int startIndex = 8;	// 시작인덱스
		int length = 4;		// 부분 배열의 길이
		int[] subNumbers = getSubArray(numbers, startIndex, length);
		
		System.out.print("[");
		for (int i=0;i<subNumbers.length;i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			
			System.out.print(subNumbers[i]);
		}
		System.out.println("]");
		
		
		
		
		
		// 3. AB형이 아닌 혈액형만 출력하세요.
		String[] bloodTypes = new String[] {"A", "B", "AB", "O"};
		printPureBloodType(bloodTypes);
		
		
		
		
		
		// 4. 배열의 길이와 첫번째 숫자를 입력받아
		//    1씩 증가하는 숫자로 채워진 배열을 반환하세요.
		int arrayLength = 10;
		int firstNumber = 7;
		int[] numberArray = createArray(arrayLength, firstNumber);
		
		System.out.print("[");
		for (int i=0;i<numberArray.length;i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			
			System.out.print(numberArray[i]);
		}
		System.out.println("]");
	}
	
	
	
	
	
	
	
	// 4. 배열의 길이와 첫번째 숫자를 입력받아
	//    1씩 증가하는 숫자로 채워진 배열을 반환하세요.
	static int[] createArray(int arrayLength, int firstNumber) {
		int[] array = new int[arrayLength];
		
		for (int i=0;i<arrayLength;i++) {
			array[i] = firstNumber + i;
		}

		return array;
	}
	
	
	
	
	
	// 3. AB형이 아닌 혈액형만 출력하세요.
	static void printPureBloodType(String[] bloodTypes) {
		for (int i=0;i<bloodTypes.length;i++) {
			if (!"AB".equals(bloodTypes[i])) {
			//if (!bloodTypes[i].equals("AB")) {	// anti-pattern
				System.out.println(bloodTypes[i]);
			}
		}
	}
	
	
	
	
	
	
	// 2. 주어진 배열의 부분 배열을 반환하는 함수를 작성하세요.
	static int[] getSubArray(int[] array, int startIndex, int length) {
		int[] subArray = new int[length];
		
		for (int i=0;i<length;i++) {
			int index = startIndex + i;
			
			if (index >= array.length) {
				break;
			}
			
			subArray[i] = array[index];
		}
		
		return subArray;
	}
	
	
	
	
	
	
	// 1. 시작월부터 12월까지의 월명을 배열로 반환하세요.
	//  ex: startMonth = 3 -> {"3월", "4월", ... , "12월"}
	static String[] getMonthNames(int startMonth) {
		String[] monthNames = new String[12 - startMonth + 1];
		
		for (int m=startMonth, i=0; m<=12; m++, i++) {
			monthNames[i] = m + "월";
		}
		
		return monthNames;
	}
	
}