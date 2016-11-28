package com.hanbit.day_11_24;

public class ForExercise {
	
	public static void main(String[] args) {
		
		// 1. 1부터 10까지의 합을 구하는 함수를 작성하세요.
		System.out.println(getSumOneToTen());
		
		
		// 2. 두개의 정수를 입력받아
		//    첫번째 수 부터 두번째 수까지의 합을
		//    구하는 함수를 작성하세요.
		int from = 5, to = 10;
		System.out.println(getSum(from, to));
		
		
		// 3. 두개의 정수를 입력받아
		//    첫번째 수 부터 두번째 수까지 중 짝수의 합을
		//    구하는 함수를 작성하세요.
		System.out.println(getSumOnlyEven(from, to));
		
		
		// 4. 두개의 정수를 입력받아
		//    두수의 합이 홀수이면
		//    첫번째 수 부터 두번째 수까지의 합을 구하고
		//    두수의 합이 짝수이면
		//    두번째 수를 반환하는 함수를 작성하세요.
		System.out.println(getSumComplex(from, to));
		
	}
	
	
	


	// 4. 두개의 정수를 입력받아
	
	//    두수의 합이 홀수이면
	//    첫번째 수 부터 두번째 수까지의 합을 구하고
	//    두수의 합이 짝수이면
	//    두번째 수를 반환하는 함수를 작성하세요.
	static int getSumComplex(int from, int to) {
		int sum = 0;
		if ((from + to) % 2 != 0) {
			/* 여기서부터 */
			for (int i = from; i <= to; i++) {
				sum += i;
			}
			return sum;
			/* 여기까지를 이미 구한 함수를 리턴하면 훨씬 간편 => return getSum; */
		} else if ((from + to) % 2 == 0) {
			return to;
		}
		return 0;
	}
	
	
	
	


	// 3. 두개의 정수를 입력받아
	//    첫번째 수 부터 두번째 수까지 중 짝수의 합을
	//    구하는 함수를 작성하세요.
	static int getSumOnlyEven(int from, int to) {
		int i = 0;
		int sum = 0;
		for(i = from ; i <= to ; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}


	
	
	// 2. 두개의 정수를 입력받아
	//    첫번째 수 부터 두번째 수까지의 합을
	//    구하는 함수를 작성하세요.
	
	static int getSum(int from, int to) {
		int i = 0;
		int sum = 0;
			for(i = from ; i <= to ; i++ /* i++ => i = i+1 */) {
				sum += i;
			}
			return sum;
	}

	
	
	
	// 1. 1부터 10까지의 합을 구하는 함수를 작성하세요.
	
	static int getSumOneToTen() {
		int sum = 0;
		for(int i=1;i<=10;i++) {
			sum += i;
		}
		return sum;
	}
		
}
