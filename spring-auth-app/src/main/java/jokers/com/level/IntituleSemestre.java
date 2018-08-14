package jokers.com.level;

public enum IntituleSemestre {
	
	SEMESTRE_UN("SEMESTRE 1"),
	SEMESTRE_DEUX("SEMESTRE 2"), 
	SEMESTRE_TROIS("SEMESTRE 3"),
	SEMESTRE_QUATRE("SEMESTRE 4"),
	SEMESTRE_CINQ("SEMESTRE 5"),
	SEMESTRE_SIX("SEMESTRE 6"),
	SEMESTRE_SEPT("SEMESTRE 7"),
	SEMESTRE_HUIT("SEMESTRE 8"),
	SEMESTRE_NEUF("SEMESTRE 9"),
	SEMESTRE_DIX("SEMESTRE 10");
	
	private String semestre;

	private  IntituleSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getSemestre() {
		return semestre;
	}

}