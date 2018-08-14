package jokers.com.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Enseignant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEnseignant;
	private String codeEnseignant;
	private String nomEnseigant;
	private String prenomEnseignant;
	private String photoEnseignant;
	private String emailEnseingnant;
	private String email;
	@ManyToMany(mappedBy="enseignants") 
	private Collection<Discipline> disciplines; 
	
	public Enseignant() {
		super();
	}

	public Enseignant(String codeEnseignant, String nomEnseigant, String prenomEnseignant, String photoEnseignant,
			String emailEnseingnant, String email) {
		super();
		this.codeEnseignant = codeEnseignant;
		this.nomEnseigant = nomEnseigant;
		this.prenomEnseignant = prenomEnseignant;
		this.photoEnseignant = photoEnseignant;
		this.emailEnseingnant = emailEnseingnant;
		this.email = email;
	}

	public Long getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(Long idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public String getCodeEnseignant() {
		return codeEnseignant;
	}

	public void setCodeEnseignant(String codeEnseignant) {
		this.codeEnseignant = codeEnseignant;
	}

	public String getNomEnseigant() {
		return nomEnseigant;
	}

	public void setNomEnseigant(String nomEnseigant) {
		this.nomEnseigant = nomEnseigant;
	}

	public String getPrenomEnseignant() {
		return prenomEnseignant;
	}

	public void setPrenomEnseignant(String prenomEnseignant) {
		this.prenomEnseignant = prenomEnseignant;
	}

	public String getPhotoEnseignant() {
		return photoEnseignant;
	}

	public void setPhotoEnseignant(String photoEnseignant) {
		this.photoEnseignant = photoEnseignant;
	}

	public String getEmailEnseingnant() {
		return emailEnseingnant;
	}

	public void setEmailEnseingnant(String emailEnseingnant) {
		this.emailEnseingnant = emailEnseingnant;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Collection<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(Collection<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + ", codeEnseignant=" + codeEnseignant + ", nomEnseigant="
				+ nomEnseigant + ", prenomEnseignant=" + prenomEnseignant + ", photoEnseignant=" + photoEnseignant
				+ ", emailEnseingnant=" + emailEnseingnant + ", email=" + email + "]";
	}
	
}
