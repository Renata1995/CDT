package puzzle.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SpinnerNumberModel;

import com.google.common.base.Stopwatch;

import puzzle.domain.*;
import puzzle.util.SizeOutOfBoundsException;
import puzzle.util.WordLengthNotValidException;

/**
 * This program will generate a letter matrix and find all valid words with a specific length
 * @author CDT
 *
 */
public class Controller {
	private Model m;
	private View v;
	private int size;//the size of the puzzle


	/**
	 * Execute the program
	 * @param args
	 */
	public static void main(String[] args){
		@SuppressWarnings("unused")
		Controller c = new Controller();
	}

	/**
	 * Construct a new Controller instance
	 */
	public Controller(){
		m=new Model();
		v=new View(this);
		v.getWordP().getSubmit().addActionListener(new WordListener());
		v.getSizeButton().addActionListener(new SizeListener());
		v.getGridP().getSubmitLetters().addActionListener(new LetterListener());
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
<<<<<<< HEAD
			Stopwatch timer = Stopwatch.createStarted();
			String[] words = m.findValidWords((int)(v.getWordP().getSpinner().getValue()));
			v.getWordP().getList().setListData(words);
			v.getWordP().getTimeLabel().setText("TIME ELAPSED: " + timer.stop()+ ".");



=======
			try {
				Stopwatch timer = Stopwatch.createStarted();
				String[] words = m.findValidWords((int)(v.getWordP().getSpinner().getValue()));
				if (words.length==0 || words==null){
					v.getWordP().getList().setListData(new String[] {"NO VALID WORDS FOUND"});
				}
				else{
					v.getWordP().getList().setListData(words);
				}
				v.getWordP().getTimeLabel().setText("TIME ELAPSED: " + timer.stop()+ ".");
			} catch (WordLengthNotValidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
>>>>>>> refs/remotes/upstream/master
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
			int gridSize=v.getSizeSpin().getValue();
			//Set the size of the Grid and the GridPanel 
			v.getGridP().generateGrid(gridSize);	
			size=gridSize;
			v.getWordP().getSpinner().setModel(new SpinnerNumberModel(2,2,size*size,1));
		}

	}

	/**
	 * Pass letters entered by the user to the model
	 *
	 */
	private class LetterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Get the letter 2d arraylist from the gridpanel
			ArrayList<ArrayList<String>> gridlist=new ArrayList<ArrayList<String>>();
			for(int i=0;i<size;i++){
				ArrayList<String> current=new ArrayList<String>();
				gridlist.add(current);
				for(int j=0;j<size;j++){
					JEditableLabel l=v.getGridP().getGrid().get(i).get(j);
					l.save();
					current.add(l.getText());
				}
			}


			try {
				//set the 2d arraylist to the model
				m.getGrid().setSize(size);
				m.getGrid().setPuzzle(gridlist);
			} catch (SizeOutOfBoundsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			//set submitLetters button and title instruction invisible
			v.getGridP().getSubmitLetters().setVisible(false);
			v.getGridP().getTitle().setVisible(false);
			v.getWordP().setVisible(true);
		}

	}






	public Model getModel() {
		return m;
	}



	public View getView() {
		return v;
	}

}
