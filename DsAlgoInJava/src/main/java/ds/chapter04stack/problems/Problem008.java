package ds.chapter04stack.problems;

public class Problem008 {

	public boolean isPalindrome(String inputString){
		int length = inputString.length();
		for(int i=0; i<length/2; ++i){
			if(inputString.charAt(i) != inputString.charAt(length-i-1)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		Problem008 problem008 = new Problem008();
		System.out.println(problem008.isPalindrome("nitin"));
	}
}
