package puzzle.domain;

import java.util.ArrayList;
import java.util.Hashtable;

import puzzle.util.SizeOutOfBoundsException;
import puzzle.util.WordLengthNotValidException;

/**
 * Model that controls all data
 * @author lenovo
 *
 */
public class Model {
	Grid grid;
	Dictionary dict;

	/**
	 * Construct a model instance
	 */
	public Model(){
		grid=new Grid();
		dict=new Dictionary();
	}
	
	/**
	 * Find all valid words
	 * @param m
	 * @return
	 * @throws WordLengthNotValidException
	 */
	public String[] findValidWords(int m) throws WordLengthNotValidException{
		Hashtable<String,String> results=new Hashtable<String,String>();
		for(String word: grid.findAllPermutaions(m)){
			if(dict.wordExists(word)){
				if(results.get(word)==null){//check repetitions
					results.put(word,word);
				}
			}
		}
		String[] finalList=new String[results.size()];
		results.keySet().toArray(finalList);
		
		return finalList;
	}

	public Grid getGrid() {
		return grid;
	}

	public Dictionary getDict() {
		return dict;
	}
	
	
}
