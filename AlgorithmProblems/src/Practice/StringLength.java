package Practice;

public class StringLength {
public int getLength (String str) {
	char[] c = str.toCharArray();
	int count =0;
	for (char c1 : c) {
		count++;
		}
	return count;
}
public int getLengthApproach2 (String str) {
	int count=0;
	try {
	while (true) {
		
	}
	} catch (Exception e) {
		
	}
	return count;
	
}
public static void main (String [] args) {
	StringLength obj = new StringLength();
	System.out.println("Length is "+obj.getLength("abcdef"));
}
}
