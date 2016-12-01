package com.hanbit.utils;

import java.math.BigDecimal;

public class Person {

	public static void main(String[] args) {
		int num1 = 543;
		int num2 = 715;
		int sum = plus(num1, num2);
		
		System.out.println(sum);
		System.out.println(minus(num1, num2));
		System.out.println(multiply(num1, num2));
		System.out.println(divide(num1, num2));	
	}
	
	/* 이 함수는 매계변수 x 와 y 를 받습니다. */
	
	static boolean isLesserThanOrEven(int x, int y) {
	
		return x <= y;
	}
	
	static boolean isGraterThanOrEven(int x, /* 비교값 */ int y) {
		
		return x >= y; // lte
	}
	
	static int plus(int x, int y) {
		return x + y; // gte
	}

	static int minus(int x, int y) {
		return x - y;
	}
  
	static int multiply(int x, int y) {
		return x * y;
	}
	
	
	
	?????????????????????????????????????????????????????????
	static BigDecimal divide(int x, int y) {
		return new BigDecimal(String.valueOf(x))
				.divide(new BigDecimal(String.valueOf(y)), 5, BigDecimal.ROUND_CEILING);
	}
	
}
	
	