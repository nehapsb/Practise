package Practice;

public class FibonacciSeriesNew {
	public void printFibonacciSeries (int range) {
		int [] array= new int [range];
		array[0]=0;
		array[1]=1;
		for (int i=2;i<array.length;i++) {
			array[i]=array[i-1]+array[i-2];
		}
		for (int i=0; i <array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}
	public static void main (String [] args) {
		FibonacciSeriesNew fb = new FibonacciSeriesNew();
		fb.printFibonacciSeries(20);
	}
}
