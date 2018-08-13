package ds.chapter04stack.problems;

import java.util.Stack;

public class Problem001 {

	public static boolean isValidSymbolPattern(String pattern){
		Stack<Character> patternStack = new Stack<Character>();
		if(pattern == null || pattern.isEmpty()){
			return true;
		}
		
		for(int i = 0; i<pattern.length(); i++){
			if(pattern.charAt(i) == ')'){
				if(!patternStack.isEmpty() && patternStack.peek() == '('){
					patternStack.pop();
				}
				else{
					return false;
				}
			}
			else if(pattern.charAt(i) == ']'){
				if(!patternStack.isEmpty() && patternStack.peek() == '['){
					patternStack.pop();
				}
				else{
					return false;
				}
			}
			else if(pattern.charAt(i) == '}'){
				if(!patternStack.isEmpty() && patternStack.peek() == '{'){
					patternStack.pop();
				}
				else{
					return false;
				}
			}
			else{
				patternStack.push(pattern.charAt(i));
			}
		}
		
		if(patternStack.isEmpty()){
			return true;
		}
			return false;
	}
	
	public static void main(String[] args){
		//String pattern = "()(()[()]))";
	//	String pattern = "({{[()]}}))";
		String pat = "[()]{}{[()()]()}";
		String pattern = "[(])";//[()]{}{[()()]()}
		System.out.println(isValidSymbolPattern(pattern));
		System.out.println(isValidSymbolPattern(pat));
	}
}
