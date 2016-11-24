package com.hanbit;

public class StudyFunctions {

	public static void main(String[] args) {
		
		// 1. 변수로 받은 문자열을 출력하는 함수를 작성하세요.
		printString("Hello");

		// 2. 변수로 받은 월에 따라 영문 월명을 출력하세요.
		//   ex: month = 1 -> January
		//   ex: month = 2 -> February
		int month = 1;
		printMonthName(month);
		
		// 3. 변수로 받는 년, 월에 따라 영문 월명과
		//    해당 년월의 날짜 수를 출력하세요.
		//   출력예: 2016년 5월 : May (31일)
		int year = 2016;
		printMonthNameAndDays(year, month);

		// 4. 변수로 받는 년, 월에 따라 영문 월명과
		//    해당 년월의 날짜 수를 출력하세요.
		//    (단, 날짜 수가 31일이 아닐 경우에만 날짜 수를 출력하세요.)
		//   출력예: 2016년 1월 : January
		//   출력예: 2016년 2월 : May (29일)
		printMonthNameAndDays2(year, month);
	}
	
	static void printMonthNameAndDays2(int year, int month) {
		// 월의 영문 월명을 구한다.
		String monthName = getMonthNameUsingIf(month);
		// 년 월의 날짜 수를 구한다.
		int days = getDaysOfMonth(year, month);
		// 출력형식에 맞추어 출력한다.
		// (단, 날짜 수가 31일이 아닐 경우에만 날짜 수를 출력하세요.)
		String yearAndMonthName = year + "년 " + monthName;
		
		System.out.print(yearAndMonthName);
		
		if (days != 31) {
			System.out.print(" (" + days + "일)");
		}
		
		System.out.println();
	}
	
	static void printMonthNameAndDays(int year, int month) {
		// 월의 영문 월명을 구한다.
		String monthName = getMonthNameUsingIf(month);
		// 년 월의 날짜 수를 구한다.
		int days = getDaysOfMonth(year, month);
		// 출력형식에 맞추어 출력한다.
		System.out.println(year + "년 " + monthName + " (" + days + "일)");
	}
	
	static int getDaysOfMonth(int year, int month) {
		
		switch (month) {
		// 월 별로 비교해서 각 월에 맞는 날짜 수를 리턴
		// 1, 3, 5, 7, 8, 10, 12월은 31일
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
		// 4, 6, 9, 11월은 30일
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
		// 단, 2월은 추가 로직을 적용해서 날짜 수를 리턴
		// 4의 배수 년도는 29일, 그 외는 28일
			case 2:
				return year % 4 == 0 ? 29 : 28;
		}
		
		return 0;
	}
	
	private static void printMonthName(int month) {
		String monthName = getMonthNameUsingArray(month);
		
		System.out.println(monthName);
	}

	static String getMonthNameUsingArray(int month) {
		String[] monthNames = new String[] {
				"January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December"
		};
		
		return getKeyAndValue(month + "월", monthNames[month - 1]);
	}

	static String getMonthNameUsingIf(int month) {
		String monthName = "";
		
		if (month == 1) {
			monthName = "January";
		}
		else if (month == 2) {
			monthName = "February";
		}
		else if (month == 3) {
			monthName = "March";
		}
		else if (month == 4) {
			monthName = "April";
		}
		else if (month == 5) {
			monthName = "May";
		}
		else if (month == 6) {
			monthName = "June";
		}
		else if (month == 7) {
			monthName = "July";
		}
		else if (month == 8) {
			monthName = "August";
		}
		else if (month == 9) {
			monthName = "September";
		}
		else if (month == 10) {
			monthName = "October";
		}
		else if (month == 11) {
			monthName = "November";
		}
		else if (month == 12) {
			monthName = "December";
		}
		
		return getKeyAndValue(month + "월", monthName);
	}

	static String getKeyAndValue(String key, String value) {
		
		return key + " : " + value; 
	}
	
	static void printString(String string) {
		System.out.println(string);
	}
	
}
