package geeksforgeeks.algo.sorting;

public class MergeSort {

  public void mergerSort(int[] a, int[] temp, int left, int right) {
    int mid;
    if(right>left) {
      mid =(right+left)/2;
      mergerSort(a, temp, left, right);
      mergerSort(a, temp, mid+1, right);
      merge(a, temp, left, mid, right);
    }

  }

  private void merge(int[] a, int[] temp, int left, int mid, int right) {
    int left_end, temp_pos;
    left_end=mid-1;
    temp_pos=left;
    int size = right-left+1;
    while(left<=left_end&&mid<=right) {
      if(a[left]<=a[mid]) {
        temp[temp_pos]=a[left];
        temp_pos++;
        left++;
      } else {
        temp[temp_pos]=a[mid];
        temp_pos++;
        mid++;
      }
    }
    while(left<=left_end) {
      temp[temp_pos++]=a[left++];
    }
    while(mid<=right) {
      temp[temp_pos++]=a[mid++];
    }

    for(int i=0; i<size; i++) {
      a[right]=temp[right];
      right--;
    }


  }

}
