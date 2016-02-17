package puzzle.ui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class View extends JFrame{
	Controller c;
	GridPanel gridP;
	WordPanel wordP;
	JButton sizeButton;
	
	public View(Controller c){
		super();
		this.c=c;
		//You can use cardLayout if needed
		sizeButton=new JButton("Submit");
	}
	
	
	
	public GridPanel getGridP() {
		return gridP;
	}
	public WordPanel getWordP() {
		return wordP;
	}
	public JButton getSizeButton() {
		return sizeButton;
	}
	
	
	
	
	

}
