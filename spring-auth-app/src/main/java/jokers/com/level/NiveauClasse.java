package jokers.com.level;

public enum NiveauClasse {
	
	L1("Licence 1"),
	L2("Licence 2"),
	L3("Licence 3"),
	M1("Master 1"),
	M2("Master 2");
	
	private String level;

	private NiveauClasse(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}
	
}
