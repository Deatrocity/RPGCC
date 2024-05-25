package ethan.rpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class StartNewTwo extends JFrame implements ActionListener{
	
	private JButton back_btn, next_btn, str_up, str_down, end_up, end_down, int_up, int_down, agi_up, agi_down;
	private JLabel main_label, name_label, race_class_label, str_label, end_label, int_label, agi_label, 
	str_value, end_value, int_value, agi_value, remaining_label, remaining_value;
	private String charName, charRace, charClass;
	private Integer remainingPoints, strength, endurance, intelligence, agility;
	
	StartNewTwo(String charName, String charRace, String charClass) {
		this.charName = charName;
        this.charRace = charRace;
        this.charClass = charClass;
        
        // setting remaining points and character stat values
        this.remainingPoints = 10;
        this.strength = 1;
        this.endurance = 1;
        this.intelligence = 1;
        this.agility = 1;
		
		setTitle("Ethan RPG - Start New Character");	
		setLayout(null);
		
		// Main label at top of screen
		main_label = new JLabel("Select starting stats");
		main_label.setBounds(170, 0, 500, 100);
		main_label.setFont(new Font("Chiller", Font.BOLD, 70));
		main_label.setForeground(Color.WHITE);
		add(main_label);
		// name label with character name
		name_label = new JLabel(this.charName);
		name_label.setBounds(340, 90, 500, 100);
		name_label.setFont(new Font("Serif", Font.BOLD, 30));
		name_label.setForeground(Color.WHITE);
		add(name_label);
		// label that shows both character race and class
		race_class_label = new JLabel(this.charRace + " " + this.charClass);
		race_class_label.setBounds(290, 135, 500, 100);
		race_class_label.setFont(new Font("Serif", Font.BOLD, 30));
		race_class_label.setForeground(Color.WHITE);
		add(race_class_label);
		
		
		// 'strength' label
		str_label = new JLabel("Strength");
		str_label.setBounds(120, 220, 500, 100);
		str_label.setFont(new Font("Serif", Font.BOLD, 25));
		str_label.setForeground(Color.WHITE);
		add(str_label);
		// endurance label
		end_label = new JLabel("Endurance");
		end_label.setBounds(120, 300, 500, 100);
		end_label.setFont(new Font("Serif", Font.BOLD, 25));
		end_label.setForeground(Color.WHITE);
		add(end_label);
		// intelligence label
		int_label = new JLabel("Intelligence");
		int_label.setBounds(120, 380, 500, 100);
		int_label.setFont(new Font("Serif", Font.BOLD, 25));
		int_label.setForeground(Color.WHITE);
		add(int_label);
		// agility label
		agi_label = new JLabel("Agility");
		agi_label.setBounds(120, 460, 500, 100);
		agi_label.setFont(new Font("Serif", Font.BOLD, 25));
		agi_label.setForeground(Color.WHITE);
		add(agi_label);
		// 'remaining points' label at bottom of screen
		remaining_label = new JLabel("Remaining Points:");
		remaining_label.setBounds(160, 560, 500, 100);
		remaining_label.setFont(new Font("Serif", Font.BOLD, 25));
		remaining_label.setForeground(Color.WHITE);
		add(remaining_label);
		
		
		// actual remaining points value label at bottom of screen
		remaining_value = new JLabel(String.valueOf(this.remainingPoints));
		remaining_value.setBounds(380, 560, 500, 100);
		remaining_value.setFont(new Font("Serif", Font.BOLD, 25));
		remaining_value.setForeground(Color.WHITE);
		add(remaining_value);
		// actual strength value label
		str_value = new JLabel(String.valueOf(this.strength));
		str_value.setBounds(380, 225, 500, 100);
		str_value.setFont(new Font("Serif", Font.BOLD, 25));
		str_value.setForeground(Color.WHITE);
		add(str_value);
		// actual endurance value label
		end_value = new JLabel(String.valueOf(this.endurance));
		end_value.setBounds(380, 305, 500, 100);
		end_value.setFont(new Font("Serif", Font.BOLD, 25));
		end_value.setForeground(Color.WHITE);
		add(end_value);
		// actual intelligence value label
		int_value = new JLabel(String.valueOf(this.intelligence));
		int_value.setBounds(380, 385, 500, 100);
		int_value.setFont(new Font("Serif", Font.BOLD, 25));
		int_value.setForeground(Color.WHITE);
		add(int_value);
		// actual agility value label
		agi_value = new JLabel(String.valueOf(this.agility));
		agi_value.setBounds(380, 465, 500, 100);
		agi_value.setFont(new Font("Serif", Font.BOLD, 25));
		agi_value.setForeground(Color.WHITE);
		add(agi_value);
		
		
		// + and - buttons to increase and decrease their associated character stat.
		// strength up
     	str_up = new JButton("+");
     	str_up.setBounds(440, 250, 60, 45);
     	str_up.setFocusPainted(false);
     	str_up.addActionListener(this);
     	str_up.setFont(new Font("Serif", Font.BOLD, 25));
     	add(str_up);
     	// strength down
     	str_down = new JButton("-");
     	str_down.setBounds(280, 250, 60, 45);
     	str_down.setFocusPainted(false);
     	str_down.addActionListener(this);
     	str_down.setEnabled(false);
     	str_down.setFont(new Font("Serif", Font.BOLD, 35));
     	add(str_down);
     	// endurance up
     	end_up = new JButton("+");
     	end_up.setBounds(440, 330, 60, 45);
     	end_up.setFocusPainted(false);
     	end_up.addActionListener(this);
     	end_up.setFont(new Font("Serif", Font.BOLD, 25));
     	add(end_up);
     	// endurance down
     	end_down = new JButton("-");
     	end_down.setBounds(280, 330, 60, 45);
     	end_down.setFocusPainted(false);
     	end_down.addActionListener(this);
     	end_down.setEnabled(false);
     	end_down.setFont(new Font("Serif", Font.BOLD, 35));
     	add(end_down);
     	// intelligence up
     	int_up = new JButton("+");
     	int_up.setBounds(440, 410, 60, 45);
     	int_up.setFocusPainted(false);
     	int_up.addActionListener(this);
     	int_up.setFont(new Font("Serif", Font.BOLD, 25));
     	add(int_up);
     	// intelligence down
     	int_down = new JButton("-");
     	int_down.setBounds(280, 410, 60, 45);
     	int_down.setFocusPainted(false);
     	int_down.addActionListener(this);
     	int_down.setEnabled(false);
     	int_down.setFont(new Font("Serif", Font.BOLD, 35));
     	add(int_down);
     	// agility up
     	agi_up = new JButton("+");
     	agi_up.setBounds(440, 500, 60, 45);
     	agi_up.setFocusPainted(false);
     	agi_up.addActionListener(this);
     	agi_up.setFont(new Font("Serif", Font.BOLD, 25));
     	add(agi_up);
     	// agility down
     	agi_down = new JButton("-");
     	agi_down.setBounds(280, 497, 60, 45);
     	agi_down.setFocusPainted(false);
     	agi_down.addActionListener(this);
     	agi_down.setEnabled(false);
     	agi_down.setFont(new Font("Serif", Font.BOLD, 35));
     	add(agi_down);
		
		
		// exit button
     	back_btn = new JButton("Back");
     	back_btn.setBounds(180, 700, 200, 35);
     	back_btn.addActionListener(this);
     	add(back_btn);
        // finalize button - disabled until all remaining points reach 0.
		next_btn = new JButton("Finalize");
		next_btn.setBounds(400, 700, 200, 35);
		next_btn.addActionListener(this);
		next_btn.setEnabled(false);
		add(next_btn);
		
		getContentPane().setBackground(Color.BLACK);
		setSize(800, 800);
		setVisible(true);	
		setLocation(500, 100);
		
	}

	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back_btn) {
			setVisible(false);
			new StartNewOne().setVisible(true);	
		} else if (ae.getSource() == str_up) {	// strength up and down buttons
			this.strength++;
			this.remainingPoints--;
			str_value.setText(String.valueOf(this.strength));
		} else if (ae.getSource() == str_down) {
			this.strength--;
			this.remainingPoints++;
			str_value.setText(String.valueOf(this.strength));
		} else if (ae.getSource() == end_up) {	// endurance up and down buttons
			this.endurance++;
			this.remainingPoints--;
			end_value.setText(String.valueOf(this.endurance));
		} else if (ae.getSource() == end_down) {
			this.endurance--;
			this.remainingPoints++;
			end_value.setText(String.valueOf(this.endurance));
		} else if (ae.getSource() == int_up) {	// endurance up and down buttons
			this.intelligence++;
			this.remainingPoints--;
			int_value.setText(String.valueOf(this.intelligence));
		} else if (ae.getSource() == int_down) {
			this.intelligence--;
			this.remainingPoints++;
			int_value.setText(String.valueOf(this.intelligence));
		} else if (ae.getSource() == agi_up) {	// endurance up and down buttons
			this.agility++;
			this.remainingPoints--;
			agi_value.setText(String.valueOf(this.agility));
		} else if (ae.getSource() == agi_down) {
			this.agility--;
			this.remainingPoints++;
			agi_value.setText(String.valueOf(this.agility));
		} else if (ae.getSource() == next_btn ) {
			setVisible(false);
			new CharacterSheet(this.charName, this.charRace, this.charClass, 1, 10, 10, this.strength, this.endurance, this.intelligence, this.agility).setVisible(true);
			
		}
		
		this.checkIfZero(strength, str_down);
		this.checkIfZero(endurance, end_down);
		this.checkIfZero(intelligence, int_down);
		this.checkIfZero(agility, agi_down);
		this.checkRemaining();
		remaining_value.setText(String.valueOf(this.remainingPoints));
		
		
	}
	
	
	public void checkRemaining() {
		if (this.remainingPoints <= 0) {
			str_up.setEnabled(false);
			end_up.setEnabled(false);
			int_up.setEnabled(false);
			agi_up.setEnabled(false);
			next_btn.setEnabled(true);
		} else {
			str_up.setEnabled(true);
			end_up.setEnabled(true);
			int_up.setEnabled(true);
			agi_up.setEnabled(true);
			next_btn.setEnabled(false);
		}
	}
	
	public void checkIfZero(Integer stat, JButton statBtn) {
		if (stat <= 1) {
			statBtn.setEnabled(false);
		} else {
			statBtn.setEnabled(true);
		}
	}
	
	public static void main(String args[]) {
		new StartNewTwo("Ethan", "Human", "Warrior");
	}

}
