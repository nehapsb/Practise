package searching;


public class MainProgram {
static int [] array = new int [30];
	public static void main (String [] args) {
		InsertIntoArray insert = new InsertIntoArray();
		insert.insertElement(0, 10, array);
	}
}
