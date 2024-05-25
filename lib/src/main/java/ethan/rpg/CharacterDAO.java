package ethan.rpg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacterDAO {
	
	// Save character to SQLite database file located in resources folder
    public void saveCharacter(String name, String charClass, String race, int level, int health, int mana, int strength, int endurance, int intelligence, int agility) {
        String sql = "INSERT INTO users(name, class, race, level, health, mana, strength, endurance, intelligence, agility) VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        try (Connection conn = DatabaseUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, charClass);
            pstmt.setString(3, race);
            pstmt.setInt(4, level);
            pstmt.setInt(5, health);
            pstmt.setInt(6, mana);
            pstmt.setInt(7, strength);
            pstmt.setInt(8, endurance);
            pstmt.setInt(9, intelligence);
            pstmt.setInt(10, agility);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Load all characters from SQLite database into List to display on screen
    
    public List<Character> getAllCharacters() {
        List<Character> characterList = new ArrayList<>();
        String sql = "SELECT name, class, race, level, health, mana, strength, endurance, intelligence, agility FROM users";

        try (Connection conn = DatabaseUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Character character = new Character(
                    rs.getString("name"),
                    rs.getString("class"),
                    rs.getString("race"),
                    rs.getInt("level"),
                    rs.getInt("health"),
                    rs.getInt("mana"),
                    rs.getInt("strength"),
                    rs.getInt("endurance"),
                    rs.getInt("intelligence"),
                    rs.getInt("agility")
                );
                characterList.add(character);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return characterList;
    }
    
    
    // Delete character from database
    public void deleteCharacter(String name) {
        String sql = "DELETE FROM users WHERE name = ?";

        try (Connection conn = DatabaseUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
