package puzzle.domain;

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
	 * Generate a size*size puzzle
	 * @throws SizeOutOfBoundsException 
	 */
	public void generate(int size) throws SizeOutOfBoundsException{
		grid.generate(size);
	}

	/**
	 * Find all valid words
	 * @param m
	 * @return
	 * @throws WordLengthNotValidException
	 */
	public Hashtable<String,String> findValidWords(int m) throws WordLengthNotValidException{
		Hashtable<String,String> results=new Hashtable<String,String>();
		for(String word: grid.findAllPermutaions(m)){
			if(dict.wordExists(word)){
				if(results.get(word)==null){//check repetitions
					results.put(word,word);
				}
			}
		}
		return results;
	}

	public Grid getGrid() {
		return grid;
	}

	public Dictionary getDict() {
		return dict;
	}
	
	
}
