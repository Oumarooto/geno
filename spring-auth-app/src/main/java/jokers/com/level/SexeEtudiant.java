package jokers.com.level;

public enum SexeEtudiant {
	
	MALE("HOMME"), 
	FEMALE("FEMME");
	
	private String sexe;

	private SexeEtudiant(String sexe) {
		this.sexe = sexe;
	}

	public String getSexe() {
		return sexe;
	}
	
}
