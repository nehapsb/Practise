package Practice;

public class StringReverseRecursion {
	String reverse= "";
	public String reverseStringRecursively(String str) {
		if (str.length()==1) {
			return str;
		}
		reverse+=str.charAt(str.length()-1)+reverseStringRecursively(str.substring(0, str.length()-1));
		return reverse;
	}
	public static void main (String [] args) {
		StringReverseRecursion obj = new StringReverseRecursion();
		System.out.println(obj.reverseStringRecursively("abcdefghjk"));
	}
}