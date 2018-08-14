package jokers.com.level;

public enum SessionSemestre {
	
	SESSION_UN("SESSION 1"), SESSION_DEUX("SESSION 2");
	
	private String session;

	private SessionSemestre(String session) {
		this.session = session;
	}

	public String getSession() {
		return session;
	}
	
}
