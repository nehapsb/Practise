package geeksforgeeks.algo.sorting;

public class QuickSort {

  public void quickSort(int[] A, int low, int high) {
    int pivot;
    if(high > low) {
      pivot=partition(A, low, high);
      quickSort(A, low, pivot-1);
      quickSort(A, pivot+1, high);
    }
  }

  private int partition(int[] a, int low, int high) {
    int left, right, pivot_item = a[low];
    left = low;
    right=high;
    while(left<right) {
      while(a[left]<pivot_item) {
        left++;
      }
      while(a[right]>pivot_item) {
        right--;
      }
      if(left<right) {
        swap(a, left, right);
      }
    }
    a[low]=a[right];
    a[right]=pivot_item;
    return right;

  }

  private void swap(int[] a, int left, int right) {
    int temp = a[left];
    a[left]=a[right];
    a[right]=temp;
  }

}
