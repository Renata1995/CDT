package puzzle.domain;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import puzzle.util.*;

/**
 * This class defines an n*n grid. The grid could find a list of letter combinations with 
 * a specific length
 * @author lenovo
 *
 */
public class Grid {
	private int size;//The size of the 2D arraylist and the size of each subarray
	private ArrayList<ArrayList<String>> puzzle;//Hold all letters
	private int repetitionMax;
	private ArrayList<String> results;//The results list
	private Random rand;

	/**
	 * Construct a new grid
	 */
	public Grid(){
		puzzle=new ArrayList<ArrayList<String>>();
		results=new ArrayList<String>();
		rand=new Random();
	}



	/**
	 * Generate a new grid 2D array. For testing Purpose
	 * @param s
	 * @throws SizeOutOfBoundsException
	 */
	public void generate(int s) throws SizeOutOfBoundsException{
		puzzle.clear();
		setSize(s);
		for(int i=0;i<size;i++){
			ArrayList<String> current=new ArrayList<String>();
			puzzle.add(current);
			for(int j=0;j<size;j++){
				current.add(Character.toString( (char)(65+rand.nextInt(25)) ));
			}
		}
	}



	/**
	 * Find all possible letter combinations of a specific length
	 * 
	 * Repetitions are allowed for testing purpose
	 * @return
	 * @throws WordLengthNotValidException 
	 */
	public ArrayList<String> findAllPermutaions(int m) throws WordLengthNotValidException{
		results.clear();

		//usedSet stores used positions by storing the sum of two indexes of each position
		Hashtable<String,String> usedSet=new Hashtable<String,String>(size*size*2);

		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				usedSet.clear();
				results.addAll(findPermutations(i,j,m,usedSet));
			}
		}

		return results;
	}


	/**
	 * Find all possible letter combinations of a specific length at a specific location
	 * @int i & int j: the indexes of the current position
	 * @m the length of target word
	 * 
	 * Repetitions are allowed for testing purpose
	 * @usedSet used positions
	 * @throws WordLengthNotValidException 
	 */
	public ArrayList<String> findPermutations(int i, int j, int m, Hashtable<String,String> usedSet) {
		ArrayList<String> allPermutations=new ArrayList<String>();
		/*
		 * Exceptions are used to make sure the initiation i and j are valid index. 
		 * 
		 * For valid position in the grid 2d arrayList, if the indexes of one of its neighbors are invalid,
		 * the exception thrown will be catched in this method.
		 */
		if(i<0||i>=size||j<0||j>=size){
			return allPermutations;
		}else if(m<=0||m>size*size ){
			return allPermutations;
		}

		//Current letter
		String letter=puzzle.get(i).get(j);
		String indexStr=i+""+j;
		usedSet.put(indexStr,indexStr);


		/*
		 * When the length of target words is equal to 1, return the letter itself
		 */
		if(m==1){
			allPermutations.add(letter);
			return allPermutations;
		}

		/* When the length of target words is not equal to 1, find possible permutations with m-1 length of its eight
		 * neighbors
		 */		
		for(int a=-1;a<2;a++){
			for (int b=-1;b<2;b++){
				String strIndex=(i+a)+""+(j+b);

				if(usedSet.get(strIndex)==null){
					Hashtable<String,String> newUsedSet=(Hashtable<String, String>) usedSet.clone();

					//Append permutations to the current letter
					ArrayList<String> results=append(letter,findPermutations(i+a,j+b,m-1,newUsedSet));
					allPermutations.addAll(results);


				}

			}
		}
		return allPermutations;
	}



	/**
	 * Add a letter to the beginning of each word in an arrayList
	 * @param letter
	 * @param words
	 */
	public ArrayList<String> append(String letter, ArrayList<String> words){
		ArrayList<String> newWords=new ArrayList<String>();
		for(String str:words){
			String newWord=letter+str;
			newWords.add(newWord);
		}
		return newWords;
	}



	/**
	 * Set the size of the 2D array
	 * @param size
	 * @throws SizeOutOfBoundsException
	 */
	public void setSize(int size)throws SizeOutOfBoundsException {
		if(size>=2&&size<20){
			this.size = size;
		}
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public int getSize() {
		return size;
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
