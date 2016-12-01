package com.hanbit.utils;

public class ArrayExercise {

public static void main(String[] args) {
		
	
		// 1. 1월부터 12월까지 영문 월명을 담고있는
		//    배열을 만들어 반환하세요.
		//    단, {"January", ... "December"} 문법 제외
		String[] monthNames = createMonthNameArray();
		printArray(monthNames);
		
		// 2. 월명 배열의 각 글자 수를 배열로 만들어 반환하세요.
		//  hint: int lengthOfString = "March".length();
		int[] monthNamesLength = countMonthNamesLength(monthNames);
		printArray(monthNamesLength);

		// 3. 월명이 5자 이하인 월명을 배열로 만들어 반환하세요.
		String[] shortMonthNames = getShortMonthNames(monthNames);
		printArray(shortMonthNames);

		// 4. 월명이 5자 이하이면 월명을 배열에 넣고
		//    6자 이상이면 "Long" 문자열을 넣어서 배열을 반환하세요.
		shortMonthNames = getShortMonthNamesOrLong(monthNames);
		printArray(shortMonthNames);
	}
	
	static String[] getShortMonthNamesOrLong(String[] monthNames) {
		String[] shortMonthNames = new String[monthNames.length];
		
		for (int i=0;i<monthNames.length;i++) {
			if (monthNames[i].length() <= 5) {
				shortMonthNames[i] = monthNames[i];
			}
			else {
				shortMonthNames[i] = "Long";
			}
		}
		
		return shortMonthNames;
	}

		static String[] getShortMonthNames(String[] monthNames) {
		int countOfShortMonthName = 0;
		
		for (int i=0;i<monthNames.length;i++) {
			if (monthNames[i].length() <= 5) {
				countOfShortMonthName++;
			}
		}
		
		String[] shortMonthNames = new String[countOfShortMonthName];
		
		int s = 0;
		
		for (int i=0;i<monthNames.length;i++) {
			if (monthNames[i].length() <= 5) {
				shortMonthNames[s++] = monthNames[i];
			}
		}
		
		return shortMonthNames;
	}

	static int[] countMonthNamesLength(String[] monthNames) {
		int[] monthNamesLength = new int[monthNames.length];
		
		for (int i=0;i<monthNamesLength.length;i++) {
			monthNamesLength[i] = monthNames[i].length();
		}
		
		return monthNamesLength;
	}

	static String[] createMonthNameArray() {
		String[] monthNames = new String[12];
		
		monthNames[0] = "January";
		monthNames[1] = "February";
		monthNames[2] = "March";
		monthNames[3] = "April";
		monthNames[4] = "May";
		monthNames[5] = "June";
		monthNames[6] = "July";
		monthNames[7] = "August";
		monthNames[8] = "September";
		monthNames[9] = "October";
		monthNames[10] = "November";
		monthNames[11] = "December";
		
		return monthNames;
	}

	static void printArray(int[] array) {
		System.out.print("[");
		for (int i=0;i<array.length;i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			
			System.out.print(array[i]);
		}
		System.out.println("]");
	}
	
	static void printArray(String[] array) {
		System.out.print("[");
		for (int i=0;i<array.length;i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			
			System.out.print(array[i]);
		}
		System.out.println("]");
	}
}
