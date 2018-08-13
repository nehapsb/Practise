package ds.chapter07priorityqueuesandheaps.priorityqueue.problems;


public class HeapPropertyChecker {

	public boolean isarrayRepresentHeap(int[] arr, int index){
		int heap_size = arr.length;
		 
		if(heap_size == 0){
			return true;
		}
		if(index > (heap_size - 2)/2){
			return true;
		}
		if(arr[index] > arr[2*index+1] && arr[index] > arr[2*index+2] && 
				isarrayRepresentHeap(arr, 2*index+1) && isarrayRepresentHeap(arr,2* index+2)){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		HeapPropertyChecker heapPropertyChecker = new HeapPropertyChecker();
		int arr[] = new int[]{50, 30, 12, 9, 23, 2, 1};
		System.out.println("is arr heap " +heapPropertyChecker.isarrayRepresentHeap(arr, 0));
		int arr2[] = new int[]{1, 23, 12, 9, 30, 2, 50};
		System.out.println("is arr2 heap " + heapPropertyChecker.isarrayRepresentHeap(arr2, 0));
	}
}
