package com.hanbit.day_11_25;

public class Calculator {

	public static void main(String[] args) {
		
		int c = 3;
		int d = 4;
		
		System.out.println(caculate(c, d, "+"));
		System.out.println(caculate(c, d, "-"));
		System.out.println(caculate(c, d, "*"));
		System.out.println(caculate(c, d, "/"));
		System.out.println(caculate(c, d, "%"));	
		System.out.println(calculateMore(3, 4, "*", "+", "-"));
		
		
	}
	
	
	// 함수명: calculateMore
	// 매개변수1: int x
	// 매개변수2: int y
	// 매개변수3: String[] operators ("+", "-", "*", "/", "%")
	// 리턴타입: int
	// 설명: 두개의 정수를 첫번째 연산자와 세번째 연산자로 계산한 후
	//       각 결과를 두번째 연산자로 계산하여 결과를 반환합니다.
	// 예: calculateMore(3, 4, new String[] {"*", "+", "-"}) -> 11
	
	static int calculateMore(int x, int y, String[] operators) {
		int result1 = caculate(x, y, operators[0]);
		int result2 = caculate(x, y, operators[2]);
		return caculate(result1, result2, operators[1]);
	//	return calculateMore(x, y, operators[0], operators[1], operators[2]);
	}
	
	
	

	// 함수명: calculateMore
	// 매개변수1: int x
	// 매개변수2: int y
	// 매개변수3: String operator1 ("+", "-", "*", "/", "%")
	// 매개변수4: String operator2
	// 매개변수5: String operator3
	// 리턴타입: int
	// 설명: 두개의 정수를 첫번째 연산자와 세번째 연산자로 계산한 후
	//       각 결과를 두번째 연산자로 계산하여 결과를 반환합니다.
	// 예: calculateMore(3, 4, "*", "+", "-") -> 11
	static int calculateMore(int x, int y, String operator1, String operator2, String operator3) {
		int result1 = caculate(x, y, operator1);
		int result2 = caculate(x, y, operator3);
		return caculate(result1, result2, operator2);
		// return caculate(caculate(x, y, operator1), caculate(x, y, operator3), operator2)
	}
	
	
	
	
	
	
	static int caculate(int a, int b, String operator) {
		if("+".equals(operator)) {
			return sum(a, b);
		}
		else if("-".equals(operator)) {
			return subtract(a, b);
		}
		else if("*".equals(operator)) {
			return multiply(a, b);
		}
		else if("/".equals(operator)) {
			return divide(a, b);
		}
		else if("%".equals(operator)) {
			return remain(a, b);
		}
		return 0;
	}
	

	

	static int sum(int x, int y) {
		return x + y;
	}

	static int subtract(int x, int y) {
		return x - y;
	}

	static int multiply(int x, int y) {
		return x * y;
	}

	static int divide(int x, int y) {
		return x / y;
	}

	static int remain(int x, int y) {
		return x % y;
	}
}
