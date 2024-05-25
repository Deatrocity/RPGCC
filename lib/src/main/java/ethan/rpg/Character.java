package ethan.rpg;

public class Character {
	
	private String name, charClass, race;
	private Integer level, health, mana, strength, endurance, intelligence, agility;
	
	
	Character(String name, String charClass, String race, Integer level, Integer health, Integer mana, Integer strength, Integer endurance, Integer intelligence, Integer agility) {
		
		this.setName(name);
		this.setCharClass(charClass);
		this.setRace(race);
		this.setLevel(level);
		this.setHealth(health);
		this.setMana(mana);
		this.setStrength(strength);
		this.setEndurance(endurance);
		this.setIntelligence(intelligence);
		this.setAgility(agility);
		
	}
	
	// Getters
	public String getName() {
		return name;
	}
	public String getCharClass() {
		return charClass;
	}
	public String getRace() {
		return race;
	}
	public Integer getLevel() {
		return level;
	}
	public Integer getHealth() {
		return health;
	}
	public Integer getMana() {
		return mana;
	}
	public Integer getStrength() {
		return strength;
	}
	public Integer getEndurance() {
		return endurance;
	}
	public Integer getIntelligence() {
		return intelligence;
	}
	public Integer getAgility() {
		return agility;
	}

	
	// Setters
	
	public void setName(String name) {
		this.name = name;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public void setHealth(Integer health) {
		this.health = health;
	}
	public void setMana(Integer mana) {
		this.mana = mana;
	}
	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	public void setEndurance(Integer endurance) {
		this.endurance = endurance;
	}
	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}
	public void setAgility(Integer agility) {
		this.agility = agility;
	}
}
