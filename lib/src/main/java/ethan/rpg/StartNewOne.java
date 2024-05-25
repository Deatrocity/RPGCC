package ethan.rpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;


public class StartNewOne extends JFrame implements ActionListener{
	
	private JButton back_btn, next_btn;
	private JLabel main_label, name_label, race_label, class_label;
	private JComboBox<String> raceComboBox, classComboBox;
    private JTextArea raceTextArea, classTextArea;
    private JTextField nameTextField;
    private String charName, charRace, charClass;
	
	StartNewOne() {
		
		setTitle("Ethan RPG - Start New Character");	
		setLayout(null);	
		
		// Create main, name, race, and class labels
		main_label = new JLabel("Create New Character");
		main_label.setBounds(200, 0, 500, 100);
		main_label.setFont(new Font("Chiller", Font.BOLD, 50));
		main_label.setForeground(Color.WHITE);
		add(main_label);
		
		name_label = new JLabel("Name");
		name_label.setBounds(235, 100, 500, 100);
		name_label.setFont(new Font("Serif", Font.BOLD, 20));
		name_label.setForeground(Color.WHITE);
		add(name_label);
		
		race_label = new JLabel("Race");
		race_label.setBounds(275, 210, 500, 100);
		race_label.setFont(new Font("Serif", Font.BOLD, 20));
		race_label.setForeground(Color.WHITE);
		add(race_label);
		
		class_label = new JLabel("Class");
		class_label.setBounds(275, 415, 500, 100);
		class_label.setFont(new Font("Serif", Font.BOLD, 20));
		class_label.setForeground(Color.WHITE);
		add(class_label);
		
		// text field for user to enter their character name
		nameTextField = new JTextField(20);
		nameTextField.setBounds(300, 135, 200, 30);
		nameTextField.setFont(new Font("Serif", Font.BOLD, 20));
		add(nameTextField);
		
		// Drop down menu for character race selection
        String[] raceOptions = {"Human", "Elf", "Dwarf", "Orc", "Goblin"};
        raceComboBox = new JComboBox<>(raceOptions);
        raceComboBox.setBounds(340, 246, 200, 30);
        raceComboBox.setFont(new Font("Serif", Font.BOLD, 20));
        raceComboBox.addActionListener(this);
        add(raceComboBox);
        
        // Drop down menu for character class selection
        String[] classOptions = {"Warrior", "Rogue", "Mage", "Bard"};
        classComboBox = new JComboBox<>(classOptions);
        classComboBox.setBounds(340, 450, 200, 30);
        classComboBox.setFont(new Font("Serif", Font.BOLD, 20));
        classComboBox.addActionListener(this);
        add(classComboBox);
        
        // Text box that displays character race information based on menu selection
        raceTextArea = new JTextArea("Humans are versatile and ambitious, found worldwide from cities to villages. "
        		+ "Known for their diversity and innovation, their cultures are rich with tradition. "
        		+ "They are resilient adventurers and explorers.");
        JScrollPane raceScrollPane = new JScrollPane(raceTextArea);
        raceScrollPane.setBounds(240, 300, 300, 120);
        raceTextArea.setEditable(false);
        raceTextArea.setLineWrap(true);
        raceTextArea.setWrapStyleWord(true);
        raceTextArea.setFont(new Font("Serif", Font.PLAIN, 15));
        add(raceScrollPane);
        
        // Text box that displays character race information based on menu selection
        classTextArea = new JTextArea("Warriors are skilled in a large set of melee weapons and excel in"
        		+ " close combat. They have high hit points and armor compared to the other classes,"
        		+ " and make for great front line combatants.");
        JScrollPane classScrollPane = new JScrollPane(classTextArea);
        classScrollPane.setBounds(240, 500, 300, 120);
        classTextArea.setEditable(false);
        classTextArea.setLineWrap(true);
        classTextArea.setWrapStyleWord(true);
        classTextArea.setFont(new Font("Serif", Font.PLAIN, 15));
        add(classScrollPane);
		
        // create back button
     	back_btn = new JButton("Back");
     	back_btn.setBounds(180, 700, 200, 35);
     	back_btn.addActionListener(this);
     	add(back_btn);
		
        
        // create next button
		next_btn = new JButton("Next");
		next_btn.setBounds(400, 700, 200, 35);
		next_btn.addActionListener(this);
		add(next_btn);
		
		
		getContentPane().setBackground(Color.BLACK);
		setSize(800, 800);
		setVisible(true);	
		setLocation(500, 100);
	}
	

	public void actionPerformed(ActionEvent ae) {
		// back button
		if (ae.getSource() == back_btn) {
			setVisible(false);
			new MainMenu().setVisible(true);
		}
		// next button
		else if (ae.getSource() == next_btn ) {
			charName = (String) nameTextField.getText();
			charRace = (String) raceComboBox.getSelectedItem();
			charClass = (String) classComboBox.getSelectedItem();
			setVisible(false);
			new StartNewTwo(charName, charRace, charClass).setVisible(true);
		}
		// display text based on race combo box selection
		else if (ae.getSource() == raceComboBox) {
			String selectedItem = (String) raceComboBox.getSelectedItem();
		    raceTextArea.setText(getRaceDescription(selectedItem));
		}
		// display text based on class combo box selection
		else if (ae.getSource() == classComboBox) {
			String selectedItem = (String) classComboBox.getSelectedItem();
			classTextArea.setText(getClassDescription(selectedItem));
		}
	}
	
	
	// Race text descriptions
	private String getRaceDescription(String race) {
	    switch (race) {
	        case "Human":
	            return "Humans are versatile and ambitious, found worldwide from cities to villages. "
	            		+ "Known for their diversity and innovation, their cultures are rich with tradition. "
	            		+ "They are resilient adventurers and explorers.";
	        case "Elf":
	            return "Elves are ancient and graceful, harmonious with nature and magic. They live in "
	            		+ "enchanted forests and value art, wisdom, and magic. Skilled in archery and "
	            		+ "sorcery, elves are seen as elegant and aloof.";
	        case "Dwarf":
	            return "Dwarves live under mountains, known for their craftsmanship and mining. They value "
	            		+ "kinship and tradition, and are fierce warriors with a strong constitution. Loyal "
	            		+ "and hardy, dwarves excel in craftsmanship.";
	        case "Orc":
	            return "Orcs, strong and often misunderstood, live in tribal societies connected to nature and "
	            		+ "ancestors. Seen as warlike, they have a rich culture of honor. Orcs are formidable "
	            		+ "warriors and hunters.";
	        case "Goblin":
	            return "Goblins are resourceful survivors in tough environments. Adaptable and cunning, they "
	            		+ "thrive in diverse settings. Despite a mischievous reputation, goblins are innovative "
	            		+ "and form loose societies.";
	        
	        default:
	            return "Please select a character race.";
	    }
	}
	
	// character class text descriptions
	private String getClassDescription(String charClass) {
	    switch (charClass) {
	        case "Warrior":
	            return "Warriors are skilled in a large set of melee weapons and excel in"
	            		+ " close combat. They have high hit points and armor compared to the other classes,"
	            		+ " and make for great front line combatants.";
	        case "Mage":
	            return "Mages have mastered the art of magic through many years of arcane studies and an aptitude for "
	            		+ "experimentation. They have low hit points but make up for it with high magic points and an "
	            		+ "array of defensive and offensive magic.";
	        case "Rogue":
	            return "Rogues are as sly as they are cunning, and use the art of guile to get the advantage in any "
	            		+ "situation. In combat they lack hit points, so they must use their superior movement and "
	            		+ "agility to out maneuver their opponents.";
	        case "Bard":
	            return "Bards travel from tavern to tavern learning and spreading tales of the realm. They have a "
	            		+ "knack for archery, and as such excel at ranged combat. They have high damage and medium "
	            		+ "hit points.";     
	        default:
	            return "Please select a character class.";
	    }
	}
	
	
	
	public static void main(String args[]) {
		new StartNewOne();
	}
}
