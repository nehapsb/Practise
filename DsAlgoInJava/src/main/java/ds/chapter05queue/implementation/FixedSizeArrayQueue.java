package ds.chapter05queue.implementation;

public class FixedSizeArrayQueue {
	private int size;
	private static int CAPACITY;
	private int front;
	private int rear;
	private int[] arrayQueue;
	
	public FixedSizeArrayQueue(){
		CAPACITY = 16;
		front=0;
		rear=0;
		size = 0;
		arrayQueue=new int[CAPACITY];
	}
	
	public FixedSizeArrayQueue(int capacity){
		CAPACITY = capacity;
		front=0;
		rear=0;
		size=0;
		arrayQueue=new int[CAPACITY];
	}

	public void enqueue(int data) throws Exception{
		if(isFull()){
			throw new Exception("Queue is full");
		}
		arrayQueue[++rear] = data;
		size++;
	}
	
	public int dequeue() throws Exception{
		if(isEmpty()){
			throw new Exception("Queue is empty");
		}
		int data = arrayQueue[front];
		arrayQueue[front]=0;
		front++;
		size--;
		return data;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public boolean isFull(){
		return size==CAPACITY;
	}
	
	public int size(){
		return size;
	}
	
	public String toString(){
		String result = "";
		for(int i=0;i<size;i++){
			result += arrayQueue[front];
			front++;
			if(i < size-1) {
				result+=",";
			}
		}
		return result;
	}
}
