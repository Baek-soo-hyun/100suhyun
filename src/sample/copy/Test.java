package sample.copy;

public class Test {
public static void main(String[] args) {
	System.out.println(substring(null, 1));
}
static String substring(String str, int beginIndex) {
	
	return substring(str, beginIndex, str.length());
//	return str == null ? null : substring(str, beginIndex, str.length());

}
static  String substring(String str, int beginIndex, int endIndex) {
	if (str == null || beginIndex < 0 || endIndex < 0) {
		return null;
	}
	
	if (beginIndex >= str.length() || beginIndex >= endIndex) {
		return ""; // String의 empty == "" == null
	}
	
	endIndex = endIndex > str.length() ? str.length() : endIndex;
	// 해당 조건을 걸어주지 않을 경우,
	//예2: substring("hello", 1, 10) -> "ellonullnullnullnullnullnull" 이렇게 됨
	//왜? hello는 총 길이가 5이고 4번째 인덱스 이후의 문자는 null인데 for문에서 null을 계속 더하라고 명령했으니까.
	
	char[] chars = str.toCharArray();
	String result = "";
	
	for (int i=beginIndex;i<endIndex;i++) {
		result += chars[i];
	}
	
	return result;
}
}
