package geeksforgeeks.ds.stack.util;

import java.util.ArrayList;
import java.util.List;

import geeksforgeeks.ds.stack.impl.Stack;
import geeksforgeeks.ds.stack.impl.StackImpl;

public class StackUtil {
  /**
   * Reverse a String using stack
   *
   * @param str
   * @return
   */
  public static String reverseString(String str) {
    char[] strArr = str.toCharArray();
    Stack s = new StackImpl();
    for(char c: strArr) {
      s.push(c);
    }
    StringBuilder stBuilder = new StringBuilder();
    while(!s.isEmpty()) {
      stBuilder.append(s.pop());
    }
    return stBuilder.toString();
  }

  /**
   * http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
   *
   * Check for balanced paranthesis in an expression.
   *
   * @param exp
   */
  public static boolean areParenthesisBalanced(char[] exp) {
    Stack s = new StackImpl();
    for(int i=0; i<exp.length;i++) {
      if(exp[i]=='{'||exp[i]=='('||exp[i]=='[') {
        s.push(exp[i]);
      }

      if(exp[i]=='}'||exp[i]==')'||exp[i]==']') {
        if(s.isEmpty()) {
          return false;
        }
        char topOfStack = (Character) s.pop();
        if(!isMatching(exp[i], topOfStack)) {
          return false;
        }
      }
    }
    if(!s.isEmpty()) {
      return false;
    }
    return true;
  }

  private static boolean isMatching(char expp, char topOfStack) {
    if(expp =='}' &&  topOfStack=='{') {
      return true;
    } else if(expp==')' && topOfStack=='(') {
      return true;
    } else if(expp==']' && topOfStack=='[') {
      return true;
    }
    return false;
  }
  /**
   * 2+3-(3*4)
   *
   * @param expression
   * @return
   */
  public static int evaluateInfixExpression(String expression) {
    char[] expressionArr = expression.toCharArray();
    Stack operatorStack = new StackImpl();
    Stack operandStack = new StackImpl();
    int count = 0;
    List operators = new ArrayList();
      operators.add('*');
      operators.add('+');
      operators.add('-');
      operators.add('/');
      operators.add('(');
      operators.add(')');
    for(int i=0; i<expression.length();i++) {
      if(!operators.contains(expressionArr[i])){
        operandStack.push(expressionArr[i]);
      } else if(operators.contains(expressionArr[i])) {
        if(expressionArr[i]=='(') {

        } else if (expressionArr[i]==')') {

        } else {

        }
      }

    }



  }

}
