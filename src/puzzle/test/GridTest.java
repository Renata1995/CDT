package puzzle.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import org.junit.Test;
import puzzle.domain.Grid;
import puzzle.util.SizeOutOfBoundsException;
import puzzle.util.WordLengthNotValidException;

public class GridTest {
	Grid grid=new Grid();
	Random rand=new Random();

	@Test
	public void testGrid() {
		assertTrue(grid.getPuzzle()!=null);
		assertNotNull(grid.getResults());
	}

	@Test
	public void testSetSize(){
		try {
			grid.setSize(3);
		} catch (SizeOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAppend(){
		ArrayList<String> words=new ArrayList<String>();
		words.add("hello");
		words.add("world");
		words.add("life");
		words.add("cs");
		words=grid.append("s", words);


		assertTrue(words.get(0).equalsIgnoreCase("shello"));
		assertTrue(words.get(1).equalsIgnoreCase("sworld"));
		assertTrue(words.get(3).equalsIgnoreCase("scs"));
	}

	@Test
	public void testFindPermutations() throws SizeOutOfBoundsException {
		int size=3;
		grid.generate(size);

		for(int i=0;i<size;i++){
			int indexI=rand.nextInt(size);
			int indexJ=rand.nextInt(size);
			int m=1+rand.nextInt(size);

			int actualSize=grid.findPermutations(indexI, indexJ, m,new Hashtable<String,String>()).size();
			int expectSize=findPermutations(indexI,indexJ,size,m,new Hashtable<String,String>());
			assertTrue(actualSize==expectSize);
		}


	}


	@Test
	public void testFindPossibleWords() throws SizeOutOfBoundsException, WordLengthNotValidException{
		int size=4;
		grid.generate(size);

		int expect=0;
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				expect+=findPermutations(i, j, size, 8, new Hashtable<String,String>());
			}
		}
		long time1=System.nanoTime();
		int actual=grid.findAllPermutaions(8).size();
		long time2=System.nanoTime();
		System.out.println((time2-time1)/1000000000);
		assertTrue(expect==actual);

		assertTrue(expect==actual);
	}



	/**
	 * Calculate the amount of permutations at a specific position
	 * @param i
	 * @param j
	 * @param size
	 * @param m
	 * @param usedSet
	 * @return
	 * @throws WordLengthNotValidException
	 */
	public int findPermutations(int i, int j,int size, int m, Hashtable<String,String> usedSet){
		int sum = 0;

		if(i<0||i>=size||j<0||j>=size){
			return sum;
		}else if(m<=0||m>size*size ){
			return sum;
		}

		//Current letter
		String indexStr=i+""+j;
		usedSet.put(indexStr,indexStr);

		ArrayList<String> allPermutations=new ArrayList<String>();

		/*
		 * When the length of target words is equal to 1, add 1 to the sum
		 */
		if(m==1){
			sum+=1;
			return sum;
		}

		/* When the length of target words is not equal to 1, find numbers of permutations with m-1 length of its eight
		 * neighbors
		 */		
		for(int a=-1;a<2;a++){
			for (int b=-1;b<2;b++){
				String strIndex=(i+a)+""+(j+b);

				if(usedSet.get(strIndex)==null){
					Hashtable<String,String> newUsedSet=(Hashtable<String, String>) usedSet.clone();

					sum+=findPermutations(i+a,j+b,size,m-1,newUsedSet);

				}

			}
		}
		return sum;
	}
}
