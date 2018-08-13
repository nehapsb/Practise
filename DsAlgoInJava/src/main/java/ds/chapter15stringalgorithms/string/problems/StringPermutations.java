package ds.chapter15stringalgorithms.string.problems;

public class StringPermutations {

	public void findPermutationsOfStringRecursively(String str){
		if(str.length() == 0){
			System.out.println("Not a valid String");
			return;
		}
		char[] permutations = str.toCharArray();
		permute(permutations, 0, permutations.length-1);
	}

	private void permute(char[] permutations, int left, int right) {
		if(left == right){
			System.out.println(permutations);
		}
		else{
			for(int i = left; i <= right; i++){
				swap(permutations, left, i);
				permute(permutations, left+1, right);
				swap(permutations, left, i);
			}
		}
	}

	private void swap(char[] permutations, int i, int j) {
		char temp = permutations[i];
		permutations[i] = permutations[j];
		permutations[j] = temp;
	}
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	    
	public void findPermutationsIteratively(String s){
		    char[] a = new char[s.length()];
		    //String temp = "";
		    for(int i = 0; i < s.length(); i++) {
		        a[i] = s.charAt(i);
		    }
		    for(int i = 0; i < s.length(); i++) {
		        String temp = "" + a[i];    
		 
		        for(int j = 0; j < s.length();j++) {
		            //int k = j;
		            if(i != j) {
		                //System.out.println(j);
		                temp += s.substring(0,j) + s.substring(j+1,s.length());
		            }               
		        }
		        System.out.println(temp);
			}
	}
	
	
	public static void main(String[] args){
		StringPermutations stringPermutations = new StringPermutations();
		stringPermutations.findPermutationsOfStringRecursively("123");
		System.out.println("----------------------------------");
	//	StringPermutations.permutation("", "ABC");
		stringPermutations.findPermutationsIteratively("ABC");
	}
}
