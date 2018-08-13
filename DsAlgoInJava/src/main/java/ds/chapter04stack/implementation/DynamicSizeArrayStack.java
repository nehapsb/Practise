package ds.chapter04stack.implementation;

public class DynamicSizeArrayStack {

	private int capacity;
	private static final int CAPACITY = 15;
	public static final int MIN_CAPACITY = 1<<15;
	private int[] dynamicArrayStack;
	private int top = -1;
	
	public DynamicSizeArrayStack(){
		this(CAPACITY);
	}
	
	public DynamicSizeArrayStack(int capacity2) {
		this.capacity = capacity2;
		dynamicArrayStack = new int[capacity];
	}

	public int size(){
		return top+1;
	}
	 
	public boolean isEmpty(){
		return (top < 0);
	}
	
	public void push(int data){
		if(size() == capacity){
			expand();
		}
		dynamicArrayStack[top++] = data;
	}

	private void expand() {
		int[] stackCopy = new int[size() *2];
		System.arraycopy(dynamicArrayStack, 0, stackCopy, 0,size());
		dynamicArrayStack = stackCopy;
	}
	
	public int top() throws Exception{
		if(isEmpty()){
			throw new Exception();
		}
		return dynamicArrayStack[top];
	}
	
	public int pop() throws Exception{
	int data;
		if(isEmpty()){
			throw new Exception();
		}
		data  = dynamicArrayStack[top];
		dynamicArrayStack[top--] = 0;
		return data;
	}
	
	public String toString() {
		String s;
		s="[";
		if(size() >0) {
			s += dynamicArrayStack[0];
		}
		if(size() >1) {
			for(int i=1;i<size(); i++) {
				s += ", "+dynamicArrayStack[i];
			}
		}
		return s+"]";
	}
}
