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
	private Grid grid;
	private Dictionary dict;
	private int number;
	
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
	public String[] findValidWords(int m){
		Hashtable<String,String> results=new Hashtable<String,String>();
		ArrayList<String> permutations=grid.findAllPermutaions(m);
		number=permutations.size();
		for(String word: permutations){
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

	public int getNumberOfPermutations(){
		return number;
	}
	
	public Grid getGrid() {
		return grid;
	}

	public Dictionary getDict() {
		return dict;
	}
	
	
}
