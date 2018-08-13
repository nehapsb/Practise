package ds.chapter07priorityqueuesandheaps.priorityqueue.implementation;

public class HeapUtil {

	public static int[] buildHeap(Heap h, int[] A, int n){
		if(h == null){
			return null;
		}
		
		while(n > h.capacity){
			h.resizeHeap();
		}
		for(int i = 0; i < n; i ++){
			h.array[i] = A[i];
		}
		h.count = n;
		for(int i = (n-1)/2; i >= 0; i--){
			h.percolateDown(i);
		}
		return h.array;
	}
}
