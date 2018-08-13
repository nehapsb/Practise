package ds.chapter07priorityqueuesandheaps.priorityqueue.problems;

import ds.chapter07priorityqueuesandheaps.priorityqueue.implementation.Heap;
import ds.chapter07priorityqueuesandheaps.priorityqueue.implementation.HeapUtil;

public class Problem007MaxInMinHeap {

	public int findMaxInMinHeap(Heap heap){
		int max = -1;
		
		for(int i=(heap.count+1)/2; i < heap.count; i++){
			if(heap.array[i] > max){
				max = heap.array[i];
			}
		}
		return max;
	}
	
	
	public static void main(String[] args){
		Heap heap = new Heap(10, 0);
		int[] array  = new int[]{1,15,2,16,17,4,3};
		HeapUtil.buildHeap(heap, array, 7);
		
		Problem007MaxInMinHeap problem007MaxInMinHeap = new Problem007MaxInMinHeap();
		System.out.println("max  "+problem007MaxInMinHeap.findMaxInMinHeap(heap));
	}
}
