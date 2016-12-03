package com.hanbit.utils;

public class JavaCodeGenerator {

	public static void main(String[] args) {
		/*
		 * 다음과 같이 소스코드를 생성하여 출력하시오.
		 * 
		 * public class JavaCodeGenerator {
		 * 
		 * 		public static void main(String[] args) {
		 * 			System.out.println("Hello, Java");
		 *		}
		 *
		 *		static void print() {
		 *		
		 *		}
		 *
		 * }
		 */
		//System.out.println(generateSourceCode("Hello, Java", 5, "takeRest"));
	
		
		String template = "// [var]를 출력하는 코드입니다.\nSystem.out.println([var]);";
		/*
		 * 다음과 같이 출력하시오.
		 * 
		 * System.out.println("Hello, World");
		 * System.out.println(42.43);
		 * System.out.println("4번째");
		 */
		System.out.println(generatePrintln(template, "Hello, World"));
		System.out.println(generatePrintln(template, "42.43"));
		System.out.println(generatePrintln(template, "4번째"));
	}
	// "String..." 이처럼 String 뒤에 쩜3개를 붙이면 배열이 됨
	static String generateSourceCode(String string, int hour, String... functions) {
		String code = "public class JavaCodeGenerator {\n\n";
		code += "\tpublic static void main(String[] args) {\n";
		code += "\t\tSystem.out.println(\"" + string + "\");\n";
		for (int i=0;i<functions.length;i++) {
			code += "\t\t" + functions[i] +"(" + hour + ");\n";
		}		
		code += "\t}\n\n";
		for (int i=0;i<functions.length;i++) {
			code += "\tstatic void " + functions[i] + "(int hour) {\n";
			code += "\t\tSystem.out.println(hour + \"시까지 쉴게요.\");\n";
			code += "\t}\n\n";
		}
		code += "\n}";
		return code;
	}
	
	
	
	static String generatePrintln(String template, String var){
		if(!NumberUtils.isNumber(var)) {
		return StringUtils00.replace(template, "[var]", "\"" + var + "\"");
		}
		else {
		return StringUtils00.replace(template, "[var]", var);	
		}
	}
	
	
	
	
}
	