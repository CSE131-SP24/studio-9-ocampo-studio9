package studio9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import support.cse131.NotYetImplementedException;

public class WordCount {
	/**
	 * Constructs and returns a map of the distinct words in the specified list with
	 * each word associated with its accumulated count (that is: the number of
	 * occurrences of the word in the list).
	 * 
	 * For example, if passed a List<String> containing:
	 * 
	 * [to, be, or, not, to, be]
	 * 
	 * the resulting Map<String, Integer> would contain
	 * 
	 * key="to", value=2;
	 * key="be", value=2;
	 * key="or", value=1;
	 * key="not", value=1;
	 * 
	 * @param words
	 * @return a map which contains all of the distinct words as keys, each
	 *         associated with the number of occurrences of the word
	 */
	public static Map<String, Integer> countWords(List<String> words) {

		// FIXME
		
		HashMap<String, Integer> wordCount = new HashMap<>();
		for(String word: words) {
			if(wordCount.get(word) == null) { //if the word we're looking up and the map says null, then we've never seen this word before
				wordCount.put(word, 1);
			}
			else { //already in the map
				int count = wordCount.get(word); //occurrences of the word we're looking at
				wordCount.put(word, count + 1); //can't have the same key more than once. putting something into the map, and if the key already exists, it can override the value of what was in the map before
			}//else: whatever value was the original one (count) we're replacing it with one bigger (count + 1) because we've now seen the word one additional time
		}
		return wordCount;
		//throw new NotYetImplementedException();

	}
	
	public static void main(String[] args) {
		
		List<String> wordList = new LinkedList<>();
		wordList.add("to");
		wordList.add("be");
		wordList.add("or");
		wordList.add("not");
		wordList.add("to");
		wordList.add("be");
		Map<String, Integer> words = countWords(wordList);
		System.out.println(words);
		
		//TODO: Write code that will iterate over the words map
		//to verify its contents
		//you will always use a for each loop to iterate through maps
		for(String key: words.keySet()) {
			System.out.println(key + ": " + words.get(key));
		}
		
	}
}
