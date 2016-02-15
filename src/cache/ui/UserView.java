package cache.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;
import java.awt.Font;
/**
 * The UI view of the program
 * @author lenovo
 *
 */
public class UserView extends JFrame {
	private JTextField input;
	private JTextField check;
	private JLabel time;
	private JLabel count;
	private JButton submit;
	
	public UserView(){
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel main = new JPanel();
		main.setBorder(new LineBorder(SystemColor.menu, 40));
		getContentPane().add(main, BorderLayout.CENTER);
		main.setLayout(new GridLayout(5, 2, 20, 40));
		
		JLabel enter = new JLabel("Enter a Word");
		enter.setFont(new Font("Times New Roman", Font.BOLD, 30));
		main.add(enter);
		
		input = new JTextField();
		input.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		main.add(input);
		input.setColumns(10);
		
		JLabel a=new JLabel();
		main.add(a);
		
		submit=new JButton("Submit");
		main.add(submit);
		submit.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel Result = new JLabel("Result");
		Result.setFont(new Font("Times New Roman", Font.BOLD, 30));
		main.add(Result);
		
		check = new JTextField();
		check.setEditable(false);
		check.setColumns(15);
		check.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		main.add(check);
		this.setVisible(true);
		
		JLabel timeLabel=new JLabel("Processing Time");
		timeLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		main.add(timeLabel);
		
		time=new JLabel("");
		time.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		main.add(time);
			
		
		JLabel sizeLabel=new JLabel("Total Words");
		sizeLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		main.add(sizeLabel);
		
		count=new JLabel("");
		count.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		main.add(count);
		this.pack();
		
	}
	

	
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public JTextField getInput() {
		return input;
	}

	public JTextField getCheck() {
		return check;
	}

	public JButton getSubmit() {
		return submit;
	}

	public JLabel getTime() {
		return time;
	}

	public JLabel getCount() {
		return count;
	}
	
	
	
	
	
	
	

}
