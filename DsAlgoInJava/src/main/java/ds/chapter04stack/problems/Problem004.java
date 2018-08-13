package ds.chapter04stack.problems;

import java.util.Stack;
import java.util.StringTokenizer;

public class Problem004 {
	public int expressionEvaluation(String expression){
		Stack<Integer> expressionStack = new Stack<Integer>();
		StringTokenizer stringTokenizer = new StringTokenizer(expression);
		while(stringTokenizer.hasMoreTokens()){
			String nextToken = stringTokenizer.nextToken();
			if(isOperator(nextToken)){
				int operand1 = expressionStack.pop();
				int operand2 = expressionStack.pop();
				expressionStack.push(evaluate(operand1, operand2, nextToken));
			}
			else if(nextToken.equals( ")")){
				int operand = expressionStack.pop();
				while(!expressionStack.peek().equals("(")){
					expressionStack.pop();
				}
				expressionStack.push(operand);
			}
			else{
				expressionStack.push(Integer.parseInt(nextToken));
			}
		}
		return expressionStack.pop();
		
	}

	private Integer evaluate(int operand1, int operand2, String nextToken) {
		if(nextToken.equals("+")) {
			return operand2+operand1;
		}
		else if(nextToken.equals("-")){
			return operand2-operand1;
		}
		else if(nextToken.equals("*")){
			return operand2*operand1;
		}
		else if(nextToken.equals("/")){
			return operand2/operand1;
		}else{
		return null;
		}
	}

	private boolean isOperator(String nextToken) {
		if(nextToken.equals("+") || nextToken.equals("*") || nextToken.equals("-") || nextToken.equals("/")){
			return true;
		}
		return false;
	}
	
	public int postFixExpressionEvaluation(String expression){
		Stack<Integer> expressionStack = new Stack<Integer>();
		String[] stringTokenizer = expression.split(" ");
		for(String nextToken : stringTokenizer){
			//String nextToken = stringTokenizer.nextToken();
			if(isOperator(nextToken)){
				int operand1 = expressionStack.pop();
				int operand2 = expressionStack.pop();
				expressionStack.push(evaluate(operand1, operand2, nextToken));
			}
			else if(nextToken.equals( ")")){
				int operand = expressionStack.pop();
				while(!expressionStack.peek().equals("(")){
					expressionStack.pop();
				}
				expressionStack.push(operand);
			}
			else{
				expressionStack.push(Integer.parseInt(nextToken));
			}
		}
		return expressionStack.pop();
		
	}

	
	
	public static void main(String[] args){
		Problem004 problem004 = new Problem004();
		//int result = problem004.expressionEvaluation("1 2 3 * + 5 - ");
		int result = problem004.expressionEvaluation("2 3  + ( 4 3 * )");
		System.out.println("result = " + result);
	}

}

