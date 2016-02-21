package puzzle.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class View extends JFrame{
	private GridPanel gridP;
	private WordPanel wordP;
	private JButton sizeButton;
	private JSlider sizeSpin;
	private Controller c;
	public static final int WIDTH=1200;
	public static final int HEIGHT=800;

	/**
	 * Initiation
	 */
	public View(Controller c){
		super();
		this.c=c;
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wordP = new WordPanel();
		gridP = new GridPanel(HEIGHT*9/10);
		//You can use cardLayout if needed
		sizeButton=new JButton("Submit");
		JPanel main=new JPanel();
		CardLayout card=new CardLayout();
		main.setLayout(card);
		main.setBorder(new LineBorder(SystemColor.menu,30));
		this.getContentPane().add(main);
		
		//First Card: Set the size of the puzzle
		JPanel sizePanel=new JPanel();
		sizePanel.setBorder(new LineBorder(SystemColor.menu,200));
		sizePanel.setLayout(new GridLayout(3,1,0,50));
		main.add(sizePanel);
		
		JLabel sizeLabel=new JLabel("Select the size of the puzzle");
		sizeLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
		sizePanel.add(sizeLabel);
		
		
		sizeSpin=new JSlider(JSlider.HORIZONTAL,2,6,2);
		sizeSpin.setMajorTickSpacing(1);
		sizeSpin.setMinorTickSpacing(1);
		sizeSpin.setFont(new Font("Times New Roman",Font.BOLD,30));
		sizeSpin.setPaintLabels(true);
		sizePanel.add(sizeSpin);
		
		sizeButton=new JButton("Submit");
		sizeButton.setFont(new Font("Times New Roman",Font.BOLD,30));
		sizePanel.add(sizeButton);
		sizeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.next(main);
			}
			
		});
		
		
		//Second Card: Main panel containing the grid and word list
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout(50,30));
		main.add(mainPanel);
		
		mainPanel.add(wordP,BorderLayout.EAST);
		mainPanel.add(gridP,BorderLayout.CENTER);
		
		JButton restart=new JButton("Restart");
		mainPanel.add(restart, BorderLayout.SOUTH);
		View.setFont(restart, 30);
		restart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.previous(main);
				gridP.getTitle().setVisible(true);
				gridP.getSubmitLetters().setVisible(true);
				gridP.getEditableGrid().removeAll();
				wordP.getList().setListData(new String[0]);
				wordP.setVisible(false);
			}
			
		});
		
		wordP.setVisible(false);
		
		
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void setFont(JComponent c,int size){
		c.setFont(new Font("Times New Roman",Font.BOLD,size));
	}
	
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public GridPanel getGridP() {
		return gridP;
	}
	public WordPanel getWordP() {
		return wordP;
	}
	public JButton getSizeButton() {
		return sizeButton;
	}
	
	public JSlider getSizeSpin() {
		return sizeSpin;
	}
		



}
