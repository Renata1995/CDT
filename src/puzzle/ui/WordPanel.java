package puzzle.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class WordPanel extends JPanel {
	private JButton submitButton; //The button that will submit the length of target words to the controller
	private JSpinner lengthSpinner;
	private JList<String> wordList;
	private JScrollPane wordPane;
	private JLabel permutationLabel;
	private JLabel timeLabel;
	
	/*...*/
	public WordPanel(){
		super();
		/*
		 * If you want to use JList, init the JList with an empty arrayList
		 * 
		 * It's better not to use AbstractModel class or any other Model class for this JList.(We used AbstractModel in 120) 
		 * Instead, use jlist.setListData in the actionListener every time the content changes.
		 * 
		 * Because AbstractModel class requires a persistent list variable. However, the valid word list generated by the 
		 * model section of the program will not be a class variable. In other word, every time the findValidWords 
		 * method get called, a completely new arraylist will be generated. 
		 * 
		 * 
		 */
		this.setLayout(new BorderLayout(20,20));
		JPanel north=new JPanel();
		north.setLayout(new GridLayout(1,2,20,20));
		lengthSpinner = new JSpinner(new SpinnerNumberModel(2, 2, 2, 1));
		lengthSpinner.setSize(new Dimension(200,20));
		lengthSpinner.setMinimumSize(new Dimension(50,20));
		lengthSpinner.setPreferredSize(new Dimension(50,20));
		lengthSpinner.setEditor(new JSpinner.DefaultEditor(lengthSpinner)); //sets the spinner to be uneditable
		((DefaultEditor) lengthSpinner.getEditor()).getTextField().setHorizontalAlignment(JTextField.CENTER); //centers the spinner value
		north.add(lengthSpinner);
		View.setFont(lengthSpinner,30);
		
		submitButton = new JButton("SUBMIT");
		north.add(submitButton);
		View.setFont(submitButton,30);
		
		wordPane = new JScrollPane();
		wordList = new JList<String>();
		View.setFont(wordList,30);
		
		wordPane.setViewportView(wordList);
		wordPane.setPreferredSize(new Dimension(480,400));
		
		permutationLabel = new JLabel();
		permutationLabel.setHorizontalAlignment(JLabel.CENTER);
		View.setFont(permutationLabel, 15);
		setPermutationLabel(0,0);
		
		timeLabel = new JLabel();
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		View.setFont(timeLabel, 15);
		setTimeLabel("0");
		
		JPanel south = new JPanel();
		south.add(permutationLabel);
		south.add(Box.createRigidArea(new Dimension(10,0)));
		south.add(timeLabel);
		
		add(north,BorderLayout.NORTH);
		add(wordPane,BorderLayout.CENTER);
		add(south,BorderLayout.SOUTH);
		
	}
	
	public void setPermutationLabel(int valid, int permutations){
		permutationLabel.setText("VALID PERMUTATIONS: " +valid+ "/" +permutations);
	}
	
	public void setTimeLabel(String time){
		timeLabel.setText("TIME ELAPSED: " +time);
	}
	
	public JScrollPane getScrollPane(){
		return wordPane;
	}
	
	public JSpinner getSpinner(){
		return lengthSpinner;
	}
	
	public JList<String> getList(){
		return wordList;
	}
	
	public JButton getSubmit() {
		return submitButton;
	}
	
	
	
}
