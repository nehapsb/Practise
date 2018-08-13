package ds.chapter07priorityqueuesandheaps.priorityqueue.problems;

public class MatrixElementsSorter {

	public void printElementsOfMatrixInSortedOrder(int[][] matrix){
		int N = matrix[0].length;
		int[] array = new int[N];
		for(int i = 0; i<N; i++){
			array[i] = matrix[0][i];
			
		}
		
		
	}
	
	public static void main(String[] args){
		int[][]mat =  { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		System.out.println(mat.length);
		System.out.println(mat[0].length);
	}
}
