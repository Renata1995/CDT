package cache.domain;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class DictCacheTest {

	DictCache dc=new DictCache();
	@Test
	public void testDictCache() {
		assertNotNull(dc.getDictionary());
	}
	
	@Test
	public void testSortAllWords(){
		DictCache d=new DictCache();
		d.getDictionary().clear();
		
		d.getDictionary().put("Add","Add");
		d.getDictionary().put("wow","wow");
		d.getDictionary().put("soon","soon");
		d.getDictionary().put("haha","haha");
		d.getDictionary().put("apple","apple");
		d.getDictionary().put("life","life");
		d.getDictionary().put("wee","wee");
		
		ArrayList<String> list=d.sortWords();
		System.out.println(list);
		assertTrue("add".equalsIgnoreCase(list.get(0)));
		assertTrue("apple".equalsIgnoreCase(list.get(1)));
		assertTrue("haha".equalsIgnoreCase(list.get(2)));
		assertTrue("life".equalsIgnoreCase(list.get(3)));
		assertTrue("soon".equalsIgnoreCase(list.get(4)));
		assertTrue("wee".equalsIgnoreCase(list.get(5)));
		assertTrue("wow".equalsIgnoreCase(list.get(6)));
	}
	
	@Test
	public void testWordExists(){
		assertTrue(dc.wordExists("how"));
		assertTrue(dc.wordExists("hello"));
		assertTrue(dc.wordExists("profession"));
		assertFalse(dc.wordExists("xxxxxxxxxxxxxxxxxx"));
		assertFalse(dc.wordExists("A.M."));
		assertFalse(dc.wordExists("A"));
		assertFalse(dc.wordExists("1st"));
	}
	
	@Test
	public void testReadCache(){
		dc.setFile(new File("dicTesting.txt"));
		dc.readCache();
		assertTrue(dc.getDictionary().size()==5);
		assertTrue(dc.getDictionary().get("HI")!=null);
		
		dc.readCache();
		assertTrue(dc.getDictionary().size()==5);
	}
	
	@Test
	public void testReadDictFile(){
		dc.readDictFile("dicTesting.txt");
		assertTrue(dc.getDictionary().get("HI")!=null);
	}
	
	@Test
	public void testCreateDictCache(){
		File file=new File("cache.txt");
		assertFalse(file.exists());
		
		dc.setFile(file);
		dc.createDictCache();
		assertTrue(dc.getFile().exists());
		assertTrue(dc.getDictionary().size()!=0);
		
		file.delete();
	}
	
	@Test
	public void testIsWordValid(){
		assertFalse(dc.isWordValid("3"));
		assertTrue(dc.isWordValid("life"));
		assertFalse(dc.isWordValid("A"));
		assertFalse(dc.isWordValid("a.m."));
		assertFalse(dc.isWordValid("abdominal_wall"));
	}
	
	@Test
	public void testWriteFile(){
		dc.setFile(new File("cacheTesting.txt"));
		ArrayList<String> array=new ArrayList<String>();
		array.add("Hi");
		array.add("Ho");
		dc.writeFile(array);
		
		dc.getDictionary().clear();
		dc.readCache();
		assertTrue(dc.getDictionary().size()==2);	
	}
	
	@Test
	public void testReadSpecialFile(){
		dc.getDictionary().clear();
		dc.readSpecialFile("specialTesting.txt");
		assertTrue(dc.getDictionary().size()==12);
	}
	
	@Test
	public void testCheckUpdate() throws IOException{
		File file=new File("dict/updateTesting.txt");
		file.createNewFile();
		assertFalse(dc.checkUpdate());
		file.delete();
	}

}
