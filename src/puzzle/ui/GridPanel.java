package puzzle.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GridPanel extends JPanel {	

	private static final Color C1=Color.WHITE;
	private static final Color C2=Color.GRAY;
	private int width;
	private ArrayList<ArrayList<JEditableLabel>> grid;
	private JPanel editableGrid;
	private JButton submitLetters;
	private JLabel title;

	/**
	 * Initiation
	 * @param width
	 */
	public GridPanel(int width){
		super();	
		
		grid=new ArrayList<ArrayList<JEditableLabel>>();
		this.width=width;
		this.setLayout(new BorderLayout(0,40));
		
		//title
		title=new JLabel("Select a letter for each cell in the grid");
		this.add(title,BorderLayout.NORTH);
		View.setFont(title, 30);
		
		//grid
		editableGrid=new JPanel();	
		this.add(editableGrid,BorderLayout.CENTER);
		
		//submit button
		submitLetters=new JButton("SUBMIT");
		this.add(submitLetters,BorderLayout.SOUTH);
		View.setFont(submitLetters, 30);
	}
	
	public void generateGrid(int size){
		grid.clear();
		editableGrid.setLayout(new GridLayout(size,size,20,20));
		editableGrid.setPreferredSize(new Dimension(width,width));
		
		for(int i=0;i<size;i++){
			ArrayList<JEditableLabel> current=new ArrayList<JEditableLabel>();
			grid.add(current);
			for(int j=0;j<size;j++){
				JEditableLabel l=new JEditableLabel("A");
				current.add(l);
				editableGrid.add(l);
				
			}
		}
	}

	public JButton getSubmitLetters() {
		return submitLetters;
	}

	public ArrayList<ArrayList<JEditableLabel>> getGrid() {
		return grid;
	}

	public JLabel getTitle() {
		return title;
	}

	public JPanel getEditableGrid() {
		return editableGrid;
	}
	
	
	
	
	


}
