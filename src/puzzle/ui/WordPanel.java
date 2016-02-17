package puzzle.ui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WordPanel extends JPanel {
	private JButton submit; //The button that will submit the length of target words to the controller
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
		
	}
	
	
	public JButton getSubmit() {
		return submit;
	}
	
	
	
}