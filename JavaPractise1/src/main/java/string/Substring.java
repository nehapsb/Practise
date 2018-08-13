package main.java.string;

public class Substring {
  private String getRootElement(String dn) {
    return dn.substring(0, dn.indexOf('/'));

  }

  private String getRootElementOptimized(String dn) {
    char[] dnCharArray = dn.toCharArray();
    StringBuilder rootElement = new StringBuilder();
    for (int i = 0; i < dnCharArray.length; i++) {
      if (dnCharArray[i] != '/') {
        rootElement.append(dnCharArray[i]);
      } else {
        break;
      }
    }
    // return dn.substring(0, dn.indexOf('/'));
    return rootElement.toString();

  }

  public static void main(String[] args) {
    String abc = "requetsinggggg/dbcontrol/dbcStateJson/PLMN-test";
    String str = "/dbcontrol/";
    int index = abc.indexOf(str);
    System.out.println("index is " + index);
    int endIndex = abc.indexOf("/", index + str.length());
    System.out.println("End Index " + endIndex);
    System.out.println(abc.substring(index + str.length(), endIndex));
    System.out.println(abc.substring(endIndex + 1, abc.length()));
    String dn = "PLMN-pet/NDSBDSA-1";
    Substring obj = new Substring();
    System.out.println(obj.getRootElement(dn));
    System.out.println(obj.getRootElementOptimized(dn));


    System.out.println("----------");

  }
}
