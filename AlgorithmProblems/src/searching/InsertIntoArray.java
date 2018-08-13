package searching;


public class InsertIntoArray {
boolean isDuplicateAllowed=false;
	
	public void insertElement(int index, int element, int [] array) {
		if(isDuplicateAllowed) {
		array[index]=element;
		} else {
			for (int i=0;i<array.length;i++) {
				if (array[i]==element) {
					System.out.println("Element Already Exists So Not Adding Again");
				}
			}
		}
		
	}
	public void setIsDuplicateAllowed (boolean value) {
		isDuplicateAllowed=value;
	}
}
