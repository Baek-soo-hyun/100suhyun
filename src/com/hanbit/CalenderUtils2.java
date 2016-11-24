package com.hanbit;

public class CalenderUtils2 {
	
	public static void main(String[] args) {
		
		// 해당 년월을 날짜 수를 출력하세요.
		int year = 2015;
		int month = 2;
		System.out.println(getDaysOfMonth(year, month));	
		
		
		// 해당 년의 총 날짜 수를 출력하세요.
		System.out.println(getDaysOfYear(year));
		
		
		// 3개의 정수 값을 받아 앞의 두 값을 더하고 세번째 값을 빼는 함수를 작성하세요.
		System.out.println(plusAndMinus(4, 5, 3));
		
		
		System.out.println(plusAndMinus1(4, 5, 3));
		
		
		// 3개의 정수 값을 받아 앞의 두 값을 더하고 세번째 값을 곱하는 함수를 작성하시오.
		System.out.println(plusAndMultiply(4, 5, 3));
		System.out.println(plusAndMultiply2(4, 5, 3));
		
		
		// 3개의 정수 값을 받아 앞의 두 값을 더하고
		// 짝수이면 세번째 값을 곱하고
		// 홀수이면 세번째 값을 빼는
		// 함수를 작성하시오.
		System.out.println(plusAndMultiplyOrMinus(4, 5, 3));
	}
	


	
	
	
	
	/* 함수 */
	
	
	
	static int getDaysOfMonth(int year, int month) {
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
			}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			return 30; 
		}
		else if(month == 2) {
			return year % 4 == 0 ? 29 : 28; 
		}
		return 0;
	}
	
	
	
	
	
	// 예1) 4의 배수 년도는 366일, 그 외에는 365일 
	// (but, -5년 같이 음수 년도가 있을 경우 에러 발생을 시켜야 한다.)
	static int getDaysOfYear(int year) {
		if(year % 4 == 0) {
			return 366;
		}
		else {
			return 365;
		}
	}
	
	
	// 예2) 각 월의 일 수 총합
	// int days = getDaysOfMonth(year, 1) + getDaysOfMonth(year, 2) +
	static int getDaysOfYear2(int year, int month) {
		int days = getDaysOfMonth(year, 1) + getDaysOfMonth(year, 2) + getDaysOfMonth(year, 3)
			+ getDaysOfMonth(year, 4) + getDaysOfMonth(year, 5) + getDaysOfMonth(year, 6) +
			getDaysOfMonth(year, 7) + getDaysOfMonth(year, 8) + getDaysOfMonth(year, 9) +
			getDaysOfMonth(year, 10) + getDaysOfMonth(year, 11) + getDaysOfMonth(year, 12);
		return days;
	}
	

	
	
	// 3개의 정수 값을 받아 앞의 두 값을 더하고 세번째 값을 빼는 함수를 작성하세요.
	static int plusAndMinus(int x, int y, int z) {		
		return x + y - z;
	}
		
	static int plusAndMinus1(int x, int y, int z) {		
		return minus(plus(x, y), z);
	}
	static int plus(int x, int y) {
		return x + y;
	}
	static int minus(int x, int y) {
		return x - y;
	}
	
	
	
	
	// 3개의 정수 값을 받아 앞의 두 값을 더하고 세번째 값을 곱하는 함수를 작성하시오.
	static int plusAndMultiply(int i, int j, int k) {
		return i + j * k;
	}	

	static int plusAndMultiply2(int i, int j, int k) {
		return multiply(plus(i, j), k);
	}
	
	static int multiply(int plus, int k) {
		return plus * k;	

	}
	
	
	
	
	
	
	// 3개의 정수 값을 받아 앞의 두 값을 더하고
	// 짝수이면 세번째 값을 곱하고
	// 홀수이면 세번째 값을 빼는
	// 함수를 작성하시오.
	static int plusAndMultiplyOrMinus(int i, int j, int k) {
		
		int sum = plus(i, j);
		
		if (sum % 2 == 0) {
			return multiply(sum, k);
		}
		else {
			return minus(sum, k);
		}
	}
	
}
	
	
