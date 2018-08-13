package ds.chapter04stack.implementation;

public class FixedSizeArrayStack {
	
	private int capacity;
	public static final int CAPACITY = 10;
	private int[] arrayStack;
	private int top = -1;
	
	public FixedSizeArrayStack(){
		this(CAPACITY);
	}

	public FixedSizeArrayStack(int capa) {
		this.capacity = capa;
		arrayStack = new int[capa];
	}

	public int size(){
		return (top +1);
	}
	
	public boolean isEmpty(){
		return top<0;
	}
	
	public void push(int data) throws Exception{
		if(size() == capacity){
			throw new Exception("Stack is full");
		}
		arrayStack[++top] = data;
	}
	
	public int top() throws Exception{
		if(isEmpty()){
			throw new Exception("stack is empty");
		}
		return arrayStack[top];
	}
	
	public int pop() throws Exception{
		int data;
		if(isEmpty()){
			throw new Exception("stack is empty");
		}
		data = arrayStack[top];
		arrayStack[top--] = 0;
		return data;
	}
	
	public String toString(){
		String s;
		s = "[";
		if(size() > 0 ){
			s += arrayStack[0];
		}
		
		if(size() > 1){
			for(int i = 0; i<size()-1; i++){
				s += " , " + arrayStack[i];
			}
		}
		return s +  " ]";
	}
}


