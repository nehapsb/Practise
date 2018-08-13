package Practice;

/*
 * http://howtodoinjava.com/2012/11/17/inter-thread-communication-using-piped-streams-in-java/
 */
import java.io.PipedReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class PipedWriterImpl {
	PipedWriterImpl() {
		String s = "07/07/13";
		DateFormat df=DateFormat.getInstance();
		 try {
			 DateFormat df1=df.getDateInstance();
			Date d=df1.parse(s);
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main (String [] args) {
		new PipedWriterImpl();
	}
}
class PipedReaderThread {
	PipedReader pw;
	String name=null;
	public PipedReaderThread(String name, PipedReader pw) {
		this.name=name;
		this.pw=pw;
	}
	
}