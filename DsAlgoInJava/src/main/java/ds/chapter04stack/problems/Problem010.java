package ds.chapter04stack.problems;

import java.util.Stack;

public class Problem010 {
	
	public boolean isPalindrome(String inputString){
		Stack<Character> inputStack = new Stack<Character>();
		
		int length = inputString.length();
		for(int i=0; i<length ; i++){
			inputStack.push(inputString.charAt(i));
		}
		String reverseString = "";
		while(!inputStack.isEmpty()){
			reverseString += inputStack.pop();
		}
		System.out.println("reverseoutput " + reverseString);
		if(reverseString.equals(inputString)){
			return true;
		}
		return false;
	}

	public static void main(String[] args){
		Problem010 problem010 = new Problem010();
		System.out.println(problem010.isPalindrome("nitinin"));
	}
}
