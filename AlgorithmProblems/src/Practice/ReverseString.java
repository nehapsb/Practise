package Practice;
public class ReverseString {
	String s1 = "";
public String reverseString(String str) {
int index = str.length();
if(index > 0 ) {
     s1 = s1 + str.charAt(index-1);
   //  System.out.println(s1);
     str = str.substring(0, index-1);
    // System.out.println(str);
     reverseString(str.substring(0, index-1));
}
return s1;
}
public static void main (String [] args) {
	ReverseString obj = new ReverseString();
	String s2=obj.reverseString("ashit");
}
}