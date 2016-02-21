package puzzle.test;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzle.domain.Model;
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
		int permutationSize=m.getGrid().findAllPermutaions(4).size();
		assertTrue(m.findValidWords(4).length<permutationSize);
	}
}
