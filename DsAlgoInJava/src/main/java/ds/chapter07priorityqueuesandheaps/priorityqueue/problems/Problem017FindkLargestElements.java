package ds.chapter07priorityqueuesandheaps.priorityqueue.problems;

import ds.chapter07priorityqueuesandheaps.priorityqueue.implementation.Heap;
import ds.chapter07priorityqueuesandheaps.priorityqueue.implementation.HeapUtil;

public class Problem017FindkLargestElements {

	public void findKlargestElements(int[] array, int k){
		Heap heap = new Heap(array.length, 1);
		//heap.testHeap();
		for (int i=0; i<k; i++) {
	        heap.insert(array[i]);
	    }
		for(int i = k; i < array.length; i++){
			if(array[i] < heap.getMaximum()){
				heap.deleteMax();
				heap.insert(array[i]);
			}
		}
		heap.displayHeap();
		System.out.println("k largesnt elements :");
		for(int i = 0; i<k; i++){
			int max = heap.deleteMax();
			System.out.print( max + " ");
		}
	}
	
	
	public static void main(String[] args){
		Problem017FindkLargestElements kLargestElements = new Problem017FindkLargestElements();
		int[] array = new int[]{1, 23, 12, 9, 30, 2, 50};
		kLargestElements.findKlargestElements(array , 3);
		int[] array2 = new int[]{7,3,6,1,2,4,5};
		kLargestElements.findKlargestElementsInMaxHeap(array2, 3);
		Heap heap = new Heap(array.length, 1);
		
		System.out.println("before heapifying");
		heap.displayHeap();
		int[] arr = HeapUtil.buildHeap(heap,array, array.length);
		System.out.println("after heapifying");
		heap.displayHeap();
		kLargestElements.findKlargestElementsInMaxHeap(arr, 3);
	}
	
	public void findKlargestElementsInMaxHeap(int[] array, int k){
		Heap heap = new Heap(array.length, 1);
		for (int i=0; i<array.length; i++) {
	        heap.insert(array[i]);
	    }
		heap.displayHeap();
		System.out.println("k largesnt elements :");
		for(int i = 0; i<k; i++){
			int max = heap.deleteMax();
			System.out.print( max + " ");
		}
	}
	
}
