package puzzle.ui;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * This class creates an editable label. The class extends JPanel and uses cardLayout. The first card contains a JLabel.
 * The second card contains either a JTextField, a JSpinner, a JSlider, or a JComboBox.
 * @author Zixian Chai
 * The method is from community.oracle.com
 *
 */
@SuppressWarnings("serial")
public class JEditableLabel extends JPanel{
	private JLabel lb;
	private JComboBox<String> box;//JComboBox is used to prevent invalid input
	private CardLayout card;
	private String text;

	/**
	 * This method creates a new JEditableLabel object.
	 * @param str
	 * @param choice
	 */
	public JEditableLabel(String str) {
		super();
		text=str;
		card=new CardLayout();
		setLayout(card);

		String[] letters="A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",");
		DefaultComboBoxModel<String> m=new DefaultComboBoxModel<String>(letters);
		box=new JComboBox<String>(m);
		box.setSelectedItem(letters[0]);
		box.setVisible(true);
		add(box);
		View.setFont(box, 30);
		
		lb=new JLabel(text);
		add(lb);
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		View.setFont(lb, 35);
		
		this.setBorder(new LineBorder(Color.GRAY,2));


	}



	/**
	 * This method turns the panel into the second card.
	 */
	public void edit(){
		card.first(this);
	}


	/**
	 * This method will get contents after users' editing and save them into the label.
	 */
	public void save(){
		lb.setText(box.getSelectedItem().toString());
		text=lb.getText();
		card.last(this);
	}


	/**
	 * This method will ignore what the user have changed.
	 */
	public void cancel(){        
		card.last(this);
		setText(lb.getText());
	}


	/**
	 * This method will set a specific text to the component.
	 * @param str
	 */
	public void setText(String str){
		text=str;
		lb.setText(str);

		for(int i=0;i<box.getModel().getSize();i++){
			String st=(String)box.getModel().getElementAt(i);
			if(st.equalsIgnoreCase(text)){
				box.setSelectedItem(box.getModel().getElementAt(i));
			}
		}

	}

	
	/**
	 * Getters and Setters
	 * @return
	 */
	public String getText(){
		return text;
	}

	public JLabel getLb() {
		return lb;
	}

	public void setLb(JLabel lb) {
		this.lb = lb;
	}

	public JComboBox<String> getBox() {
		return box;
	}

	public void setBox(JComboBox<String> box) {
		this.box = box;
	}

	public CardLayout getCard() {
		return card;
	}

	public void setCard(CardLayout card) {
		this.card = card;
	}


}
