package jokers.com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
/*@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING, length=3, name="TYPE_NOTES")*/
public class Note implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idNotes;
	private double NoteTp;
	private double NoteProjet;
	private double NoteClasse;
	private double NoteExamen;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_DISCIPLINE")
	private Discipline discipline;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ETUDIANT")
	private Etudiant etudiant;
	
	
	public Note() {
		super();
	}

	public Note(double noteTp, double noteProjet, double noteClasse, double noteExamen, Discipline discipline,
			Etudiant etudiant) {
		super();
		NoteTp = noteTp;
		NoteProjet = noteProjet;
		NoteClasse = noteClasse;
		NoteExamen = noteExamen;
		this.discipline = discipline;
		this.etudiant = etudiant;
	}





	public Long getIdNotes() {
		return idNotes;
	}


	public void setIdNotes(Long idNotes) {
		this.idNotes = idNotes;
	}


	public double getNoteTp() {
		return NoteTp;
	}


	public void setNoteTp(double noteTp) {
		NoteTp = noteTp;
	}


	public double getNoteProjet() {
		return NoteProjet;
	}


	public void setNoteProjet(double noteProjet) {
		NoteProjet = noteProjet;
	}


	public double getNoteClasse() {
		return NoteClasse;
	}


	public void setNoteClasse(double noteClasse) {
		NoteClasse = noteClasse;
	}


	public double getNoteExamen() {
		return NoteExamen;
	}


	public void setNoteExamen(double noteExamen) {
		NoteExamen = noteExamen;
	}


	public Discipline getDiscipline() {
		return discipline;
	}


	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	@Override
	public String toString() {
		return "Note [idNotes=" + idNotes + ", NoteTp=" + NoteTp + ", NoteProjet=" + NoteProjet + ", NoteClasse="
				+ NoteClasse + ", NoteExamen=" + NoteExamen + ", discipline=" + discipline + ", etudiant=" + etudiant
				+ "]";
	}
	
}
