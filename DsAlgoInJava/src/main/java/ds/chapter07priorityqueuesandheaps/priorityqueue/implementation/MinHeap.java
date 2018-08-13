package ds.chapter07priorityqueuesandheaps.priorityqueue.implementation;

public class MinHeap {
	public int[] array;
	public int count;
	public int capacity;
	public int heap_type;
	
	public MinHeap(int capacity){
		this.capacity = capacity;
		this.count = 0;
		this.array = new int[capacity];
	}
	
	public MinHeap(int[] arr, int size){
		this.array = arr;
		this.count = size;
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
	
	public int getMinimum(){
		if(this.count == 0){
			return -1;
		}
		return this.array[0];
	}
	public void minHeapify(int i){
		int left, right, temp;
		int smallest = i;
		left = leftChild(i);
		right = rightChild(i);
		
		if(left != -1 && this.array[left] < this.array[i]){
			smallest= left;
		}
		
		if(right != -1 && this.array[right] < this.array[smallest]){
			smallest = right;
		}
		
		if(smallest != i){  //swap this.array[i] and this.array[max]
			temp = this.array[i];
			this.array[i] = this.array[smallest];
			this.array[smallest] = temp;
			minHeapify(smallest);
		}
		
	}
	
	public int deleteMin(){
		if(this.count == 0){
			return Integer.MIN_VALUE;
		}
		if(this.count == 1){
			this.count--;
			return this.array[0];
		}
		int data = this.array[0];
		this.array[0] = this.array[count-1];
		this.count--;
		minHeapify(0);
		return data;
	}
	
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
		while(i != 0 && data < this.array[i-1/2]){ //For min heap condition will be reversed this.array[i-1/2] > data
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
	
	public void replaceMin(int x){
		this.array[0] = x;
		minHeapify(0);
	}
	
	public boolean isEmpty(){
		return this.count == 0;
	}
}
