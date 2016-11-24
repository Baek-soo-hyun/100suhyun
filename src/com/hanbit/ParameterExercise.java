?????????????????????????
		
		
		
		package com.hanbit;

public class ParameterExercise {

	public static void main(String[] args) {
		
		String str = "한빛";
		int number = 1;
		
		changeParameter(str); // call by value
		changeParameter(number); // call by value
		
		System.out.println(str);
		System.out.println(number);
		
	}
	
	static void changeParameter(String str) {
		str = str + "교육센터";
	}
	
	static void changeParameter(int number) {
		number = number + 1;
	}
	
}
