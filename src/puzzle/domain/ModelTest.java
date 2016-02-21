package puzzle.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzle.util.SizeOutOfBoundsException;
import puzzle.util.WordLengthNotValidException;

public class ModelTest {
	
	private Model m=new Model();
	@Test
	public void testModel() {
		assertTrue(m.getDict()!=null);
		assertTrue(m.getGrid()!=null);
	}
	
	@Test
	public void testFindValidWords() throws SizeOutOfBoundsException, WordLengthNotValidException{
		m.getGrid().generate(3);
		int validSize=m.findValidWords(4).size();
		int permutationSize=m.getGrid().findAllPermutaions(4).size();
		assertTrue(validSize<permutationSize);
	}
	
	@Test
	public void testGenerate() throws SizeOutOfBoundsException{
		m.generate(6);
		assertTrue(m.getGrid().getSize()==6);
		assertTrue(m.getGrid().getPuzzle().get(0).size()==6);
	}
}
