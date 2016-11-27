package sample.copy;

public class Practice {

	public static void main(String[] args) {

	}
	
	
	
	
	
	
	
	
	static String[] getMonthNames(int startMonth) {
		String[] monthNames = new String[12 - startMonth + 1];
		
		for (int m=startMonth, i=0; m<=12; m++, i++) {
			monthNames[i] = m + "월";
		}
		
		return monthNames;
	}
	
	
	
	
	
	static int[] getSubArray(int[] array, int startIndex, int length) {
		int[] subArray = new int[length];
		
		for (int i=0;i<length;i++) {
			int index = startIndex + i;
			
			if (index >= array.length) {
				break;
			}
			
			subArray[i] = array[index];
		}
		
		return subArray;
	}
	
	
	
	
	
	
	static void printPureBloodType(String[] bloodTypes) {
		for (int i=0;i<bloodTypes.length;i++) {
			if (!"AB".equals(bloodTypes[i])) {
			//if (!bloodTypes[i].equals("AB")) {	// anti-pattern
				System.out.println(bloodTypes[i]);
			}
		}
	}
}