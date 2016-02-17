package puzzle.domain;

import java.util.ArrayList;

public class Grid {
	private int size;
	private ArrayList<ArrayList<String>> puzzle;
	private int repetitionMax;
	private ArrayList<String> results;
	
	public Grid(){
		
	}
	
	public void init(){
		
	}
	
	public void regenerate(){
		
	}
	
	public ArrayList<String> findPossibleWords(){
		return results;
	}
	
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ArrayList<ArrayList<String>> getPuzzle() {
		return puzzle;
	}
	public void setPuzzle(ArrayList<ArrayList<String>> puzzle) {
		this.puzzle = puzzle;
	}
	public int getRepetitionMax() {
		return repetitionMax;
	}
	public void setRepetitionMax(int repetitionMax) {
		this.repetitionMax = repetitionMax;
	}
	public ArrayList<String> getResults() {
		return results;
	}
	public void setResults(ArrayList<String> results) {
		this.results = results;
	}
	
	
	
}
