package ethan.rpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class CharacterSheet extends JFrame implements ActionListener{

	private JLabel main_label, name_label, race_class_level_label, level_label, health_label, mana_label,
	str_label, end_label, int_label, agi_label, label1;
	private String charName, charRace, charClass;
	private Integer level, health, mana, strength, endurance, intelligence, agility;
	private Image image, resizedImage;
	private ImageIcon resizedIcon, originalIcon;
	private JButton back_btn, next_btn, save_btn;
	
	CharacterSheet(String charName, String charRace, String charClass, Integer level, Integer health, Integer mana, Integer strength, Integer endurance, Integer intelligence, Integer agility){
		
		this.charName = charName;
		this.charRace = charRace;
		this.charClass = charClass;
		this.level = level;
		this.health = health;
		this.mana = mana;
		this.strength = strength;
		this.endurance = endurance;
		this.intelligence = intelligence;
		this.agility = agility;
		
		this.setTitle("Ethan RPG - Character Sheet");	
		this.setLayout(null);
		
		// Main label at top of screen
		main_label = new JLabel("Character Sheet");
		main_label.setBounds(275, 0, 500, 100);
		main_label.setFont(new Font("Chiller", Font.BOLD, 50));
		add(main_label);
		// name label with character name
		name_label = new JLabel("Name: " + this.charName);
		name_label.setBounds(50, 50, 500, 100);
		name_label.setFont(new Font("Serif", Font.BOLD, 25));
		add(name_label);
		// label that shows both character race and class
		race_class_level_label = new JLabel("Level " + this.level + " " + this.charRace + " " + this.charClass);
		race_class_level_label.setBounds(50, 90, 500, 100);
		race_class_level_label.setFont(new Font("Serif", Font.BOLD, 25));
		add(race_class_level_label);
		
		// health and mana labels
		health_label = new JLabel("Health:   " + this.health);
		health_label.setBounds(50, 190, 500, 100);
		health_label.setFont(new Font("Serif", Font.BOLD, 25));
		health_label.setForeground(Color.RED);
		add(health_label);
		mana_label = new JLabel("Mana:     " + this.mana);
		mana_label.setBounds(50, 230, 500, 100);
		mana_label.setFont(new Font("Serif", Font.BOLD, 25));
		mana_label.setForeground(Color.BLUE);
		add(mana_label);
		
		// labels that display character strength, endurance, intelligence, and agility.
		str_label = new JLabel("Strength:        " + this.strength);
		str_label.setBounds(50, 350, 500, 100);
		str_label.setFont(new Font("Serif", Font.BOLD, 25));
		add(str_label);
		end_label = new JLabel("Endurance:   " + this.endurance);
		end_label.setBounds(50, 400, 500, 100);
		end_label.setFont(new Font("Serif", Font.BOLD, 25));
		add(end_label);
		int_label = new JLabel("Intelligence:   " + this.intelligence);
		int_label.setBounds(50, 450, 500, 100);
		int_label.setFont(new Font("Serif", Font.BOLD, 25));
		add(int_label);
		agi_label = new JLabel("Agility:           " + this.agility);
		agi_label.setBounds(50, 500, 500, 100);
		agi_label.setFont(new Font("Serif", Font.BOLD, 25));
		add(agi_label);
		
		// creates exit button
     	back_btn = new JButton("Main Menu");
     	back_btn.setBounds(180, 700, 200, 35);
     	back_btn.addActionListener(this);
     	back_btn.setFocusPainted(false);
     	add(back_btn);
        // creates finalize button
		next_btn = new JButton("OK");
		next_btn.setBounds(400, 700, 200, 35);
		next_btn.addActionListener(this);
		next_btn.setFocusPainted(false);
		next_btn.setEnabled(false);
		add(next_btn);
		// creates finalize button
		save_btn = new JButton("Save");
		save_btn.setBounds(295, 650, 200, 35);
		save_btn.addActionListener(this);
		save_btn.setFocusPainted(false);
		save_btn.setEnabled(true);
		add(save_btn);
		
		
		// Determine image for character based on chosen race and class
		if ("Human".equals(this.charRace) && "Warrior".equals(this.charClass)) {
		    originalIcon = new ImageIcon(getClass().getResource("/images/human_warrior.png"));
		} else if (this.charRace == "Human" && this.charClass =="Rogue") {
			originalIcon = new ImageIcon(getClass().getResource("/images/human_rogue.png"));
		} else if (this.charRace == "Human" && this.charClass =="Mage") {
			originalIcon = new ImageIcon(getClass().getResource("/images/human_mage.png"));
		} else if (this.charRace == "Human" && this.charClass =="Bard") {
			originalIcon = new ImageIcon(getClass().getResource("/images/human_bard.png"));
		} else if (this.charRace == "Orc" && this.charClass =="Warrior") {
			originalIcon = new ImageIcon(getClass().getResource("/images/orc_warrior.png"));
		} else if (this.charRace == "Orc" && this.charClass =="Rogue") {
			originalIcon = new ImageIcon(getClass().getResource("/images/orc_rogue.png"));
		} else if (this.charRace == "Orc" && this.charClass =="Mage") {
			originalIcon = new ImageIcon(getClass().getResource("/images/orc_mage.png"));
		} else if (this.charRace == "Orc" && this.charClass =="Bard") {
			originalIcon = new ImageIcon(getClass().getResource("/images/orc_bard.png"));
		} else if (this.charRace == "Elf" && this.charClass =="Warrior") {
			originalIcon = new ImageIcon(getClass().getResource("/images/elf_warrior.png"));
		} else if (this.charRace == "Elf" && this.charClass =="Rogue") {
			originalIcon = new ImageIcon(getClass().getResource("/images/elf_rogue.png"));
		} else if (this.charRace == "Elf" && this.charClass =="Mage") {
			originalIcon = new ImageIcon(getClass().getResource("/images/elf_mage.png"));
		} else if (this.charRace == "Elf" && this.charClass =="Bard") {
			originalIcon = new ImageIcon(getClass().getResource("/images/elf_bard.png"));
		} else if (this.charRace == "Goblin" && this.charClass =="Warrior") {
			originalIcon = new ImageIcon(getClass().getResource("/images/goblin_warrior.png"));
		} else if (this.charRace == "Goblin" && this.charClass =="Rogue") {
			originalIcon = new ImageIcon(getClass().getResource("/images/goblin_rogue.png"));
		} else if (this.charRace == "Goblin" && this.charClass =="Mage") {
			originalIcon = new ImageIcon(getClass().getResource("/images/goblin_mage.png"));
		} else if (this.charRace == "Goblin" && this.charClass =="Bard") {
			originalIcon = new ImageIcon(getClass().getResource("/images/goblin_bard.png"));
		} else if (this.charRace == "Dwarf" && this.charClass =="Warrior") {
			originalIcon = new ImageIcon(getClass().getResource("/images/dwarf_warrior.png"));
		} else if (this.charRace == "Dwarf" && this.charClass =="Rogue") {
			originalIcon = new ImageIcon(getClass().getResource("/images/dwarf_rogue.png"));
		} else if (this.charRace == "Dwarf" && this.charClass =="Mage") {
			originalIcon = new ImageIcon(getClass().getResource("/images/dwarf_mage.png"));
		} else if (this.charRace == "Dwarf" && this.charClass =="Bard") {
			originalIcon = new ImageIcon(getClass().getResource("/images/dwarf_bard.png"));
		}
		
		// Get the image from the icon and resize it
		image = originalIcon.getImage();
	    int newWidth = 275; // New width in pixels
	    int newHeight = 275; // New height in pixels
	    Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	    ImageIcon resizedIcon = new ImageIcon(resizedImage);
	    JLabel label1 = new JLabel(resizedIcon);
	    label1.setSize(newWidth, newHeight);
	    label1.setLocation(400, 130); // Adjust location
	    add(label1);
		
		
		setSize(800, 800);
		setVisible(true);
		setLocation(500, 100);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == back_btn) {
			setVisible(false);
			new MainMenu().setVisible(true);
		} else if (ae.getSource() == save_btn) {
			saveCharacter();
			save_btn.setEnabled(false);
		}
		
	}
	
	// save character to database
	private void saveCharacter() {
	    CharacterDAO characterDAO = new CharacterDAO();
	    characterDAO.saveCharacter(this.charName, this.charClass, this.charRace, this.level, this.health, this.mana, this.strength, this.endurance, this.intelligence, this.agility);
	    JOptionPane.showMessageDialog(this, "Character saved successfully!");
	}
	
	
	public static void main(String[] args) {
		
		new CharacterSheet("Ethan", "Dwarf", "Mage", 1, 100, 10, 5, 4, 3, 2);

	}

}
