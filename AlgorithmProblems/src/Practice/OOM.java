package Practice;

public class OOM {

	public static void main (String [] args) {
		char[] c1 = new char[20000000];
		String s = new String (c1);
		char[] c2 = new char[20000000];
		System.out.println(s.length());
		new StringBuilder(new String (c2));
		StringBuilder sb = new StringBuilder(s);
	}
}
