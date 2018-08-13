package ds.chapter15stringalgorithms.string.algorithms;

public class BruteForceStringMatching {

	public int matString(char[] inputString, int n, char[] pattern, int m){
		for(int i = 0; i< n-m; i++){
			int j = 0;
			while(j < m && pattern[j] == inputString[i + j]){
				j = j +1;
			}
			if(j == m){
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		BruteForceStringMatching bruteForceStringMatching = new BruteForceStringMatching();
		int match = bruteForceStringMatching.matString(new char[]{'a','b','c', 'd','e','f'}, 6, new char[]{'e','c', 'd'}, 3);
		System.out.println("isMatched " + match );
	}
}
