package puzzle.ui;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GridPanel extends JPanel {
	private int size;
	
	public GridPanel(){
		super();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}

	public int getSizeVar() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	

}
