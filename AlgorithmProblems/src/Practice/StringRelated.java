package Practice;

public class StringRelated {

public static void main (String [] args ) {
String s= new String ("abd");
System.out.println(s.hashCode());
String s2= "abd";
System.out.println(s==s2);
System.out.println(s2.hashCode());
s.intern();
System.out.println(s==s2);
System.out.println(s.hashCode());
}
}
