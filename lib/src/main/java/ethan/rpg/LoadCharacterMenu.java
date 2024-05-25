package ethan.rpg;

import java.awt.event.*;
import java.util.List;

import javax.swing.*;

public class LoadCharacterMenu extends JFrame implements ActionListener{
	
	private JButton back_btn, delete_btn;
	private JList<String> characterList;
	
	LoadCharacterMenu() {
		
		setTitle("Ethan RPG - Load Character");	
		setLayout(null);
		
		
		CharacterDAO dao = new CharacterDAO();
        List<Character> characters = dao.getAllCharacters();
        String[] characterNames = characters.stream().map(Character::getName).toArray(String[]::new);

        characterList = new JList<>(characterNames);
        JScrollPane scrollPane = new JScrollPane(characterList);
        scrollPane.setBounds(75, 100, 250, 400);
        add(scrollPane);
		
        
        // creates delete button
     	back_btn = new JButton("Back");
     	back_btn.setBounds(75, 700, 200, 35);
     	back_btn.addActionListener(this);
     	add(back_btn);
		
		// creates exit button
		delete_btn = new JButton("Delete");
		delete_btn.setBounds(400, 700, 200, 35);
		delete_btn.addActionListener(this);
		add(delete_btn);
		
		
		// set size of frame, make it visible, and set location on screen it will open
		setSize(800, 800);
		setVisible(true);	
		setLocation(500, 100);
		
	}
	

	public void actionPerformed(ActionEvent ae) {
		// back button takes user to main menu
		if (ae.getSource() == back_btn) {
			setVisible(false);
			new MainMenu().setVisible(true);	
		} 
		// delete button removes selected character from database, then refreshes list
		else if (ae.getSource() == delete_btn) {
	        String selectedName = characterList.getSelectedValue();
	        if (selectedName != null) {
	            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + selectedName + "?", "Delete Character", JOptionPane.YES_NO_OPTION);
	            if (confirm == JOptionPane.YES_OPTION) {
	                CharacterDAO dao = new CharacterDAO();
	                dao.deleteCharacter(selectedName);

	                // Refresh the list after deletion
	                refreshCharacterList();
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "Please select a character to delete.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
		
	}
	
	
	// refresh the list after deleting character
	private void refreshCharacterList() {
	    CharacterDAO dao = new CharacterDAO();
	    List<Character> characters = dao.getAllCharacters();
	    DefaultListModel<String> model = new DefaultListModel<>();
	    for (Character character : characters) {
	        model.addElement(character.getName());
	    }
	    characterList.setModel(model);
	}
	
	public static void main(String args[]) {
		new LoadCharacterMenu();
	}

}
