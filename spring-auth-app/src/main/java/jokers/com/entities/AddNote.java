package jokers.com.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADD")
public class AddNote extends Note{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddNote(double noteTp, double noteProjet, double noteClasse, double noteExamen, Discipline discipline,
			Etudiant etudiant) {
		super(noteTp, noteProjet, noteClasse, noteExamen, discipline, etudiant);
		// TODO Auto-generated constructor stub
	}
	
}
