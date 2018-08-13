package ds.chapter15stringalgorithms.string.problems;

public class ReverseWordsInSentence {

	public String reverseWords(String sentence){
		if(sentence == null || sentence.equals("")){
			return "";
		}
		StringBuilder reverseSentence = new StringBuilder();
		String[] wordsArray = sentence.split(" ");
		System.out.println(wordsArray.length);
		for(int i =wordsArray.length-1; i>=0; i--){
			reverseSentence.append(wordsArray[i]).append(" ");
		}
		return reverseSentence.toString();
		
	}
	
	public static void main(String[] args){
		ReverseWordsInSentence reverseWordsInSentence = new ReverseWordsInSentence();
		System.out.println(reverseWordsInSentence.reverseWords("This is a career monk string"));
	}
}
