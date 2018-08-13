package ds.chapter04stack.problems;

import java.util.Stack;
import java.util.StringTokenizer;

public class Problem002InfixToPostFix {

	public String convertInfixToPostFix(String expression){
		StringBuilder postfix = new StringBuilder();
		Stack<String> patternStack = new Stack<String>();
		
		StringTokenizer stringTokenizer = new StringTokenizer(expression);
		while(stringTokenizer.hasMoreTokens()){
			String nextToken = stringTokenizer.nextToken();
			if(isOperator(nextToken)){
				patternStack.push(nextToken);
			}
			else{
				postfix.append(nextToken);
			}
		}
		while(!patternStack.isEmpty()){
			postfix.append(patternStack.pop());
		}
		return postfix.toString();
	}
	
	private boolean isOperator(String nextToken) {
		if(nextToken.equals("+") || nextToken.equals("*") || nextToken.equals("-") || nextToken.equals("/")){
			return true;
		}
		return false;
	}
	public String convertInfixToPostFixExpression(String expression){
		StringBuffer postfix = new StringBuffer();
		Stack<Character> patternStack = new Stack<Character>();
		
		char[]  tokenArray = expression.toCharArray();
		for(char nextToken : tokenArray){
			//String nextToken = stringTokenizer.nextToken();
			if(checkOperator(nextToken)){
				int precedence = 0;
				if(!patternStack.isEmpty()){
					char op = patternStack.peek();
					if(op == '+' || op == '-'){
						precedence = 1;
					}else if(op == '*' || op == '/'){
						precedence = 2;
					}
					if(precedence == 2 && (nextToken == '+' || nextToken == '-')){
						postfix.append(patternStack.pop());
						patternStack.push(nextToken);
					}
					else{
						patternStack.push(nextToken);
					}
				}
				else{
					patternStack.push(nextToken);
				}
			}
			else if(nextToken == '('){
				patternStack.push(nextToken);
			}
			else if(nextToken == ')'){
				while(patternStack.peek() != '('){
					postfix.append(patternStack.pop());
				}
				patternStack.pop();
			}
			else{
				postfix.append(nextToken);
			}
		}
		while(!patternStack.isEmpty()){
			postfix.append(patternStack.pop());
		}
		return postfix.toString();
	}
	
	private boolean checkOperator(char nextToken) {
		if(nextToken == '+' || nextToken == '*' || nextToken == '-' || nextToken== '/'){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		Problem002InfixToPostFix infixToPostFix = new Problem002InfixToPostFix();
		String postfix = infixToPostFix.convertInfixToPostFix("A * B + C");//A + B - C + D
		System.out.println(postfix);
		
		System.out.println(infixToPostFix.convertInfixToPostFixExpression("A*(B+C*D)+E"));
	}
	
	
}
