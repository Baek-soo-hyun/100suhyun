package com.hanbit.utils;

import java.util.Arrays;

public class AttendanceBook {

	public static void main(String[] args) {
		final String students = "정동건, 문재승, 한지훈"
			+ ", 백수현,조영욱,이상윤"
			+ ", 백미리,박재홍,김지룡"
			+ " ,노상민, 김한슬,채성주";

		/*
		 * 다음처럼 출력하시오. (추가로, 한글의 오름차순으로 정렬하시오.)
		 * 
		 * 1. 정동건
		 * 2. 문재승
		 * 3. 한지훈
		 * ...
		 * 12. 채성주
		 */		
		System.out.println(createAttendaceBook(students));
		
		// 다음 학생이 몇번인지 출력하세요.
		System.out.println(getStudentNumber(students, "백미리"));
	}
	
	
	
	
	
	static String createAttendaceBook(String students) {
		if (students == null) {
			return "";
		}
		String result = "";
		String[] studentsArray = StringUtils03.splitNotBlankAndTrim(students, ",");
		Arrays.sort(studentsArray); // 이름을 ㄱㄴㄷ 순으로 정렬하기 위해 사용
		int size = (studentsArray.length + "").length() + 2;
		// 여기서 +2를 하는 이유는 ". "를 세기 위해서
		// 여기서 (studentsArray.length + "").length() 를 하는 이유는 01/001/0001 등의 제한을 두지 않기 위해서
		// + "" 를 하는 이유는 studentsArray.length가 숫자인데 이거에 String을 더해서 studentsArray.length + ""를 String으로 만들어서 그 길이를 알려고
		// (studentsArray.length + "")를 String.valueOf(studentsArray.length)라고 표현해도 된다.
		// String.valueOf() => 모든 숫자를 문자화시켜주는 함수 (ex: 숫자 12를  String.valueOf(12) 하면 "12"라는 문자가 된다.
		for (int i = 0; i < studentsArray.length; i++) {
			String student = studentsArray[i];
			result += StringUtils01.leftPad((i + 1) + ". ", size, '0') + student + '\n';
			//size를 변수로 든 이유는 이름 앞에 붙는 번호를 줄 맞춤 해주고 싶은데, 100번째든 1000번째든 size의 제한을 두지 않기 위해서
		}
		return result;
	}
	
	
	
	// 다음 학생이 몇번인지 출력하세요.
	static int getStudentNumber(String students, String name) {
		if (StringUtils.isBlank(students) || StringUtils.isBlank(name)) {
			return -1;
		}
		String[] studentsArray = StringUtils03.splitNotBlankAndTrim(students, ",");
		Arrays.sort(studentsArray);
		return Arrays.binarySearch(studentsArray, name) + 1;
	}

}
