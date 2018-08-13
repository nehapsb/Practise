package ds.chapter07priorityqueuesandheaps.priorityqueue.implementation;

/**
 * Max Heap implementation
 * @author pasbola
 *
 */
public class Heap {

	public int[] array;
	public int count;
	public int capacity;
	public int heap_type;
	
	public Heap(int capacity, int heap_type){
		this.capacity = capacity;
		this.heap_type = heap_type;
		this.count = 0;
		this.array = new int[capacity];
	}
	
	
	public int parent(int i){
		if(i <= 0 || i >= this.count){
			return -1;
		}
		return (i-1)/2;
	}
	
	public int leftChild(int i){
		int left = 2*i + 1;
		if(left >= count){
			return -1;
		}
		return left;
	}
	
	public int rightChild(int i){
		int right = 2*i + 2;
		if(right >= count){
			return -1;
		}
		return right;
	}
	
	public int getMaximum(){
		if(this.count == 0){
			return -1;
		}
		return this.array[0];
	}
	
	//Heapifying the array
	public void percolateDown(int i){
		int left, right, temp;
		int max = i;
		left = leftChild(i);
		right = rightChild(i);
		
		if(left != -1 && this.array[left] > this.array[i]){
			max= left;
		}
		
		if(right != -1 && this.array[right] > this.array[max]){
			max = right;
		}
		
		if(max != i){  //swap this.array[i] and this.array[max]
			temp = this.array[i];
			this.array[i] = this.array[max];
			this.array[max] = temp;
			percolateDown(max);
		}
		
	}
	
	//To delete an element from, heap we just have to delete the element from root.after deleting the root, 
	//copy the data of last element to root and delete the last element
	public int deleteMax(){
		if(this.count == 0){
			return Integer.MAX_VALUE;
		}
		if(this.count == 1){
			this.count--;
			return this.array[0];
		}
		int data = this.array[0];
		this.array[0] = this.array[count-1];
		this.count--;
		percolateDown(0);
		return data;
	}
	
	//Max heap
	public void insert(int data){
		int i;
		if(this.count == this.capacity){
			resizeHeap();
		}
		// First insert the new key at the end
		this.count++;
		i = this.count-1;
		this.array[i] = data;
		
		 // Fix the max heap property if it is violated
		while(i != 0 && data > this.array[i-1/2]){ //For min heap condition will be reversed this.array[i-1/2] > data
			int temp = this.array[i];
			this.array[i] = this.array[i-1/2];
			this.array[i-1/2] = temp;
			i = i-1/2;
		}
	}


	public void resizeHeap() {
		int[] array_old = new int[this.capacity];
		System.arraycopy(this.array, 0, array_old, 0, this.count-1);
		this.array = new int[this.capacity *2];
		if(this.array == null){
			System.out.println("Memory error");
			return;
		}
		
		for(int i = 0; i < this.capacity; i++){
			this.array[i] = array_old[i];
		}
		this.capacity *= 2;
		array_old = null;
	}
	
	public void displayHeap(){
		System.out.print("[ ");
		for(int i = 0; i<this.count; i++){
			System.out.print(this.array[i] + " " );
		}
		System.out.println(" ]");
	}
	
	public int testHeap()
	{   int a[] = {1, 23, 12, 9, 30, 2, 50};
	    int n = a.length; 
	    int k = 3, i;
	    	
	    Heap h = new Heap(n, 1);

	    for (i = 0; i<k;i++) {
	        h.insert(a[i]);
	    }
	    for (i=k;i<n;i++) {
	      if (a[i]>h.getMaximum()) {
	          h.deleteMax();
	          h.insert(a[i]);
	      }    
	    }
	    for (i=0;i<k;i++) {
	     System.out.println(" " + h.deleteMax());
	    }
		return 0;
	}
}
