package ethan.rpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener {
	
	// instance variables
	JButton start_character, load_character, help_menu, exit_btn;
	JLabel main_label;
	
	// default constructor
	MainMenu() {
		
		setTitle("Ethan RPG");	
		setLayout(null);
		
		// Create main, name, race, and class labels
		main_label = new JLabel("Ethan's RPG");
		main_label.setBounds(170, 100, 500, 100);
		main_label.setFont(new Font("Chiller", Font.BOLD, 100));
		main_label.setForeground(Color.WHITE);
		add(main_label);
		
		
		// start new character button
		start_character = new JButton("Start New Character");
		start_character.setBounds(275, 350, 200, 35);
		start_character.setFocusPainted(false);
		start_character.addActionListener(this);
		add(start_character);
		
		// load character button
		load_character = new JButton("Load Character");
		load_character.setBounds(275, 400, 200, 35);
		load_character.setFocusPainted(false);
		load_character.addActionListener(this);
		add(load_character);
		
		// help menu button
		help_menu = new JButton("Help");
		help_menu.setBounds(275, 450, 200, 35);
		help_menu.setFocusPainted(false);
		help_menu.addActionListener(this);
		add(help_menu);
		
		// exit button
		exit_btn = new JButton("Exit");
		exit_btn.setBounds(275, 500, 200, 35);
		exit_btn.addActionListener(this);
		add(exit_btn);
		
		// torch images on both sides of button menu
		ImageIcon image = new ImageIcon(getClass().getResource("/images/torch.png"));
		JLabel label1 = new JLabel (image);
		label1.setSize(label1.getPreferredSize());
		label1.setLocation(-250, 100);
		add(label1);
		JLabel label2 = new JLabel (image);
		label2.setSize(label2.getPreferredSize());
		label2.setLocation(330, 100);
		add(label2);
		
		// set size of frame, make it visible, and set location on screen it will open
		setSize(800, 800);
		setVisible(true);	
		setLocation(500, 100);
		getContentPane().setBackground(Color.BLACK);
	}
	
	
	// makes current frame invisible and create new frame and make it visible based on which button is pressed.
	public void actionPerformed(ActionEvent ae) {	
		if (ae.getSource() == start_character) {
			setVisible(false);
			new StartNewOne().setVisible(true);		
		} else if (ae.getSource() == load_character) {
			setVisible(false);
			new LoadCharacterMenu().setVisible(true);
		} else if (ae.getSource() == help_menu) {
			setVisible(false);
			new HelpMenu().setVisible(true);
		} else if (ae.getSource() == exit_btn) {
			System.exit(0);
		}
	}
	
	public static void main(String args[]) {
		
		new MainMenu();
	}

}
