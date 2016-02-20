package puzzle.domain;

import java.util.ArrayList;

public class Model {
	Grid grid;
	Dictionary dict;
	
	public Model(){
		grid=new Grid();
		dict=new Dictionary();
	}
	
	public ArrayList<String> findValidWords(int n){
		ArrayList<String> results=new ArrayList<String>();
		for(String word: grid.findPossibleWords()){
			if(dict.wordExists(word)){
				results.add(word);
			}
		}
		return results;
	}
}
