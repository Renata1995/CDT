package puzzle.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class View extends JFrame{
	Controller c;
	GridPanel gridP;
	WordPanel wordP;
	JButton sizeButton;
	
	public View(Controller c){
		super();
		this.c=c;
		wordP = new WordPanel();
		//You can use cardLayout if needed
		sizeButton=new JButton("Submit");
		this.setBackground(Color.blue);
		this.setMinimumSize(new Dimension(500,500));
		this.setMaximumSize(new Dimension(500,500));
		this.setPreferredSize(new Dimension(500,500));
		this.add(wordP);
		this.pack();
		this.setVisible(true);
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
