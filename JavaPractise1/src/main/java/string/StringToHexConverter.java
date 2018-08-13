package main.java.string;

public class StringToHexConverter {
  public static void main(String[] args) {
    String hexString = "3ff";
    int i = 0;
    try {
      i = Integer.valueOf(hexString, 16);
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
    System.out.println(i);

    System.out.println(Integer.toHexString(1024).toUpperCase());

    // System.out.println(toUnsignedString(-1, 4));

    // System.out.println(21 >>> 4);

    System.out.println(0x3ff - 0x400);

    System.out.println("abc".equals(null));
  }

  private static String toUnsignedString(int i, int shift) {
    char[] buf = new char[32];
    int charPos = 32;
    int radix = 1 << shift;
    int mask = radix - 1;
    do {
      buf[--charPos] = digits[i & mask];
      i >>>= shift;
    } while (i != 0);

    return new String(buf, charPos, (32 - charPos));
  }

  final static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
      'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
      'v', 'w', 'x', 'y', 'z'};
}
