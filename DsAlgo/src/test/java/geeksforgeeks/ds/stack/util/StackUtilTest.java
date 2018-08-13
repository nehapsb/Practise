package geeksforgeeks.ds.stack.util;

import org.junit.Test;

public class StackUtilTest {

  @Test
  public void testReverseString() {
    System.out.println(StackUtil.reverseString("abcdef"));
  }

  @Test
  public void testAreParenthesisBalanced() {
    char[] exp = {'[', '{', 'a', 'b', '}', ']'};
    System.out.println(StackUtil.areParenthesisBalanced(exp));
  }

}
