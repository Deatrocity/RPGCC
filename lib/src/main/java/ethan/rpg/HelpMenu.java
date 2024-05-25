package ethan.rpg;

import java.awt.event.*;
import javax.swing.*;

public class HelpMenu extends JFrame implements ActionListener {
	
	JButton back_btn;
	
	HelpMenu(){
		
		setTitle("Ethan RPG - Help");	
		setLayout(null);
		
		// creates exit button
		back_btn = new JButton("Back");
		back_btn.setBounds(275, 700, 200, 35);
		back_btn.addActionListener(this);
		add(back_btn);
		
		// set size of frame, make it visible, and set location on screen it will open
		setSize(800, 800);
		setVisible(true);	
		setLocation(500, 100);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back_btn) {
			setVisible(false);
			new MainMenu().setVisible(true);
		}
	}
	
	public static void main(String args[]) {
		new HelpMenu();
	}

}
