package puzzle.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import puzzle.domain.*;

/**
 * This program will generate a letter matrix and find all valid words with a specific length
 * @author CDT
 *
 */
public class Controller {
	Model m;
	View v;
	
	/**
	 * Construct a new Controller instance
	 */
	public Controller(){
		m=new Model();
		v=new View(this);
		init();
		v.getWordP().getSubmit().addActionListener(new WordListener());
		v.getSizeButton().addActionListener(new SizeListener());
	}
	
	public void init(){
		
	}
	
	/**
	 * This ActionListener has following functions
	 * 1. Get a required length variable from the user 
	 * 2. Find all valid words with that specific length
	 * 3. Show all valid words on the ui
	 * @author CDT
	 *
	 */
	private class WordListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * This ActionListener has following functions
	 * 1. Get a required size variable from the user
	 * 2. Generate a size x size matrix with random words
	 * @author CDT
	 *
	 */
	private class SizeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//Get a required size variable from the user
			
			//Set the size of the Grid and the GridPanel 
			
			//Generate a size * size matrix with random words
			
		}
		
	}
	
	
	
	public Model getModel() {
		return m;
	}



	public View getView() {
		return v;
	}



	public static void main(String[] args){
		Controller c=new Controller();
	}

}
