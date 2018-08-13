/**
 * Need to form a following pattern
 * 1 2 3 8 9 4 7 6 5
 * swap last and middle (9 and 5)
 * 1 2 3 4 5 6 7 8 9
 * swap(middle+1, last-1)
 * 1 2 3 4 9 6 7 8 5
 * swap(middle+2, last-2)
 * 1 2 3 4 9 8 7 6 5
 * in the end swap (middle+1 and middle -1)
 * 1 2 3 8 9 4 7 6 5
 * 
 * 1 2 3 4 5 6 7 8 9 10 11
 * 1 2 3 4 5 11 7 8 9 10 6
 * 1 2 3 4 5 11 10 8 9 7 6
 * 1 2 3 4 5 11 10 9 8 7 6 
 * 1 2 3 4 10 11 5 9 8 7 6 
 * 
 * 0 1 2 3 4 5 6 7 8
 */

package Patterns;

public class NumberPattern1 {
int[] array= new int[9];
	public void createPattern2 () {
		int middleElement=array.length/2; // 4
		for (int i=1; i<middleElement;i++ ) {
			swap(middleElement+i, array.length-i);
		}
		swap(middleElement,middleElement+1);
	}
	public void swap (int x, int y) {
		int temp=array[x-1];
		array[x-1]=array[y];
		array[y]=temp;
	}
	public void insert() {
		for (int i=0;i<array.length;i++)
		array[i]=i+1;
	}
	public void display () {
		for (int i=0;i<array.length;i++) {
			System.out.print(array[i]);
		}
	}

	public static void main (String [] args) {
		NumberPattern1 obj = new NumberPattern1();
		obj.insert();
		obj.display();
		System.out.println("");
		obj.createPattern2();
		obj.display();
	}
}
