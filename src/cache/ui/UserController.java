package cache.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import cache.domain.DictCache;

/**
 * Controls the whole program. Connect view and model.
 * @author lenovo
 *
 */
public class UserController {
	private DictCache m;
	private UserView v;
	
	/**
	 * Initiation
	 */
	public UserController(){
		m=new DictCache();
		v=new UserView();
		v.getSubmit().addActionListener(new WordListener());
		v.getCount().setText(m.getCount()+"");
	}
	
	/**
	 * An actionListener which will test whether the input word is in the cache
	 *
	 */
	private class WordListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String word=v.getInput().getText();
			long t1=System.nanoTime();
			if(m.wordExists(word)){
				v.getCheck().setText(word+" exists.");
			}else{
				v.getCheck().setText(word + " does not exist.");
			}
			long t2=System.nanoTime();
			long dt=t2-t1;
			v.getTime().setText(dt+" NanoSec");
			v.getInput().setText("");
			
		}
		
	}
	
	public static void main(String[] args){
		UserController c=new UserController();
	}

	
	
	

}
