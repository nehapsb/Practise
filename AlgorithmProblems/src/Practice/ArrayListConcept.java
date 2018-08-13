package Practice;
import java.util.*;
public class ArrayListConcept {
public void addToArrayList(ArrayList arr) {
	arr.add(1);
	arr.add(2);
	arr.add(3);
}
public void addToArrayList(List arr) {
	arr.add(4);
	arr.add(5);
	arr.add(6);
}
public void addAllToArrayList() {
	
}
public void addToIndex(int index) {
	
}
public void deleteFromArrayList() {
	
}
public void iterateTheArrayList(List list) {
}
public void displayArrayList(ArrayList arr) {
	Iterator itr = arr.iterator();
	while (itr.hasNext()) {
		System.out.println(itr.next());
	}
}
public void displayArrayList(List arr) {
	ListIterator itr=arr.listIterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
}
public static void main (String [] args) {

List arr = new ArrayList();
	ArrayListConcept obj = new ArrayListConcept();
	obj.addToArrayList(arr);
	obj.displayArrayList(arr);
}
}
