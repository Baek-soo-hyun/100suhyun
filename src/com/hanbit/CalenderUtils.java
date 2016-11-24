package com.hanbit;

public class CalenderUtils {

	public static void main(String[] args) {
	
		// 해당 년도의 월의 날짜 수를 출력하세요.
		int year = 2016;
		int month = 7;
		System.out.println(getDaysOfMonth(year, month));
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
		// 단 2월은 추가 로직을 적용해서 날짜 수를 리턴
		// 4의 배수 년도는 29일, 그 외는 28일
			case 2:
				return year % 4 == 0 ? 29 : 28;
		
		}
		
		return 0;
	}
	
	
	
	
	
	
	
	
	static int getDaysOfMonth2(int year, int month) {
		if (month == 1) {
			return 31;
		}
		else if (month == 2) {
			if (year % 4 == 0) {
				return 29;
			}
			else {
				return 28;			
			}
		}
		if (month == 3) {
			return 31;
		}
		if (month == 4) {
			return 30;
		}
		if (month == 5) {
			return 31;
		}
		if (month == 6) {
			return 30;
		}
		if (month == 7) {
			return 31;
		}
		if (month == 8) {
			return 31;
		}
		if (month == 9) {
			return 30;
		}
		if (month == 10) {
			return 31;
		}
		if (month == 11) {
			return 30;
		}
		if (month == 12) {
			return 31;
		}
		
		return 0;
	
	}	



	
	

	static int getDaysOfMonth3(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 12) {
			return 31;
		}
		else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		else if (month == 2) {
			return year % 4 == 0 ? 29 : 28;
		}
		
		return 0;
		
	}
	
	
	
	
	
	static int getDaysOfMonth4(int year, int month) {
		int days = 0;
		
		if (month == 1) {
			days = 31;
		}
		else if (month == 2) {
			if (year % 4 == 0) {
				days =29;
			}
			else {
				days =28;			
			}
		}
		if (month == 3) {
			days = 31;
		}
		if (month == 4) {
			days = 30;
		}
		if (month == 5) {
			days = 31;
		}
		if (month == 6) {
			days = 30;
		}
		if (month == 7) {
			days = 31;
		}
		if (month == 8) {
			days = 31;
		}
		if (month == 9) {
			days = 30;
		}
		if (month == 10) {
			days = 31;
		}
		if (month == 11) {
			days = 30;
		}
		if (month == 12) {
			days = 31;
		}
		
		return days;
	
	}	
	
}