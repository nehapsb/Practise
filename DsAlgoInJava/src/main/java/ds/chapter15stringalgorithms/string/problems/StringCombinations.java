package ds.chapter15stringalgorithms.string.problems;
/**
 * n!/r!(n-r)!
 * @author pasbola
 *
 */

public class StringCombinations {

	public void stringCombinations(String str,StringBuffer outputString, int start){
		if(str.length() == 0 || str == null){
			System.out.println("No combination found");
			return;
		}
		for(int i = start; i<str.length(); i++){
			outputString.append(str.charAt(i));
			System.out.println(outputString);
			
			//if(i < str.length()){
				stringCombinations(str,outputString, i+1);
				outputString.deleteCharAt(outputString.length() - 1);
			//}
		}
		
		/*if(str.length() > 0){
			System.out.println(prefix + str.charAt(0));
			stringCombinations(prefix + str.charAt(0), str.substring(1));
			stringCombinations(prefix, str.substring(1));
		}*/
	}
	
	static void printAllKLengthRec(String str, String prefix, int n, int k) {
		char[] set = str.toCharArray();
        // Base case: k is 0, print prefix
        if (k == 0) {
            System.out.println(prefix);
            return;
        }
 
        // One by one add all characters from set and recursively 
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {
             
            // Next character of input added
            String newPrefix = prefix + set[i]; 
             
            // k is decreased, because we have added a new character
            printAllKLengthRec(str, newPrefix, n, k - 1); 
        }
    }
	public void stringCombinationsIteratively(String str,StringBuffer outputString, int start){
		
	}
	
	public static void main(String[] args){
		StringCombinations combinations = new StringCombinations();
	//	combinations.printCombinations("abc", " ");
		System.out.println("--------------------------");
		StringBuffer outputString = new StringBuffer();
		//combinations.stringCombinations("ABC",outputString, 0);
		StringCombinations.printAllKLengthRec("ABC", " ", 3, 2);
		
		String[] str = new String[]{"ca","lb"};
		System.out.println(str.toString());
	}
}
