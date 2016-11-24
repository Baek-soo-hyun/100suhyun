package com.hanbit;

public class Sample {
	
public static void main(String[] args) {
		
		// 1. 1월부터 12월까지 영문 월명을 담고있는
		//    배열을 만들어 반환하세요.
		//    단, {"January", ... "December"} 문법 제외
		String[] monthNames = createMonthNameArray();
		printArray(monthNames);
		
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
	
	static void printArray(String[] monthNames) {
		System.out.print("[");
		for (int i=0;i<monthNames.length;i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			
			
			System.out.print(monthNames[i]);
		}
		System.out.println("]");
	}

}
