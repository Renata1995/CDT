package puzzle.domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Manage words cache. This class has a dictionary HashMap for searching and a file which
 * stores all words. When sorting the words list, this class puts all keys into an arrayList
 * and sort them.
 * @author CDT
 *
 */
public class Dictionary {
	private HashMap<String,String> dictionary;//All uppercase
	private File file;//stores words
	private int count;//the total amount of words
	public static final String FILE_NAME="dict/dictCache.txt";


	/**
	 * Initiate a cache object. Check whether dictionary cache exists and is updated. 
	 * If cache exists and is updated, read the cache file.
	 * Otherwise, create a new cache file.
	 */
	public Dictionary(){
		//Initiate the dictionary
		dictionary=new HashMap<String,String>(1000000);
		//Initiate the file
		file=new File(FILE_NAME);

		//Fill out the dictionary map
		if(file.exists()&&checkUpdate()){
			System.out.println("No Update");
			readCache();
		}else{
			createDictCache();
		}
		count=dictionary.size();
	}



	/**
	 * Check whether a specific word exists in the dictionary cache
	 * @param word
	 * @return
	 */
	public boolean wordExists(String word){
		word=word.toUpperCase();
		return dictionary.get(word)!=null;
	}



	/**
	 * Check whether the cache file is updated.
	 * @return
	 */
	public boolean checkUpdate(){
		if(file.exists()){
			long date=file.lastModified();
			File[] dictList=new File("dict").listFiles();
			for(File f:dictList){
				if(f.lastModified()>date){
					System.out.println("Update");
					return false;
				}
			}
			return true;
		}
		System.out.println("Need to create the file");
		return false;
	}



	/**
	 * Read the cache file and generate the dictionary map
	 */
	public void readCache(){
		dictionary.clear();

		try (FileReader fr = new FileReader(file); 
				BufferedReader br = new BufferedReader(fr);){

			String str = br.readLine(); //the first line is a number
			str = br.readLine();
			while (str!= null) {    
				str=str.toUpperCase();
				dictionary.put(str, str);
				str = br.readLine(); 
			}
		}  catch (IOException ex) {    
			System.err.println("WordList init error"); 

		}

	}



	/**
	 * Create a new dictionary cache file, write cache to the file, and generate
	 * dictionary hashmaps
	 */
	public void createDictCache(){
		//Read all dictionary files
		long start=System.nanoTime();
		readAllDictFiles();//ReadAllDictFiles put all words in the dictionary map without repetition 
		//sort all words
		ArrayList<String> allwords=sortWords();
		long end=System.nanoTime();
		System.out.println(end-start);
		//put words into a new cache file
		writeFile(allwords);
	}



	/**
	 * Read all words form all dictionary files into the dictionary map
	 * @return
	 */
	public void readAllDictFiles(){
		dictionary.clear();
		File[] dictList=new File("dict").listFiles();
		for(File f:dictList){
			if(f.isFile() && f.getName().endsWith(".txt"))
			readSpecialFile(f);
		}
	}


	/**
	 * Read a dictionary in which each line could contain multiple words
	 */
	public void readSpecialFile(File f){
		ArrayList<String> allwords=new ArrayList<String>();

		//Get all words into an arrayList of String
		try(FileReader fr1=new FileReader(f);
				BufferedReader br1=new BufferedReader(fr1);){

			String str=br1.readLine();
			while(str!=null){
				allwords.add(str);
				str=br1.readLine();
			}

		}catch(IOException e){
			System.err.println("Special Dictionary Reading Error");	
		}

		//Split each String in the arrayList and put new words in the dictionary map
		for(String wordString:allwords){
			String[] wordArray=wordString.split(" ");
			for(String str:wordArray){
				str=str.toUpperCase();//All words in the dictionary map are uppercase
				if(isWordValid(str)&&dictionary.get(str)==null){
					dictionary.put(str,str);
				}
			}
		}

	}


	/**
	 * Check whether the current word is a valid word
	 */
	public boolean isWordValid(String word){
		if(word.length()<2){
			return false;
		}
		char[] wordChar=word.toCharArray();
		for(char c:wordChar){
			if(!Character.isLetter(c)){
				return false;
			}
		}
		return true;
	}


	/**
	 * Sort keys of a hashmap<String,String>
	 * @return
	 */
	public ArrayList<String> sortWords(){
		/*
		 * Transform keys of a hashmap into an arraylist
		 * The following line is retrieved from http://www.java2s.com/Code/Java/Collections-Data-Structure/SortkeysinanHashtable.htm
		 */
		
		ArrayList<String> wordsList=new ArrayList<String>(dictionary.keySet());

		/*
		 * Sort a list alphabetically
		 * retrieved from http://stackoverflow.com/questions/11176227/simple-way-to-sort-strings-in-the-case-sensitive-alphabetical-order
		 */
		
		Collections.sort(wordsList,String.CASE_INSENSITIVE_ORDER);
		return wordsList;
	}

	/**
	 * Write contents to the cache file
	 */
	public void writeFile(ArrayList<String> allwords){
		//check whether the file exists. 
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//write the arrayList into the file
		try (
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);){
			pw.println(allwords.size());//print the total amount of words

			for(String str:allwords){
				pw.println(str);
			}

		}
		catch (IOException ex) {
			System.err.println("trouble with file :"+ex.getMessage());
		}
	}









	/**
	 * Getters and Setters
	 */

	public HashMap<String,String> getDictionary() {
		return dictionary;
	}
	public File getFile() {
		return file;
	}

	protected void setFile(File file) {
		this.file = file;
	}



	public int getCount() {
		return count;
	}








}
