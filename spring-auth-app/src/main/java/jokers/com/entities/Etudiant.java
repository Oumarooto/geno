package jokers.com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Etudiant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="matriculeEtudiant", nullable=false, unique=true)
	private String matriculeEtudiant;
	private String nomEtudiant;
	private String prenomEtudiant;
	@Past
	private Date dateNaissanceEtudiant;
	private String lieuNaissanceEtudiant;
	private String adresseEtudiant;
	private double numeroEtudiant;
	private String sexeEtudiant;
	@Email(message="Votre email est obligatoire")
	private String emailEtudiant;
	private int telephoneEtudiant;
	private String photoEtudiant;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CLASSE")
	private Classe classe;
	@OneToMany(mappedBy="etudiant", fetch=FetchType.LAZY)
	private Collection<Note> notes;
	
	public Etudiant() {
		super();
	}
	
	public Etudiant(String matriculeEtudiant, String nomEtudiant, String prenomEtudiant, Date dateNaissanceEtudiant,
			String lieuNaissanceEtudiant, String adresseEtudiant, double numeroEtudiant,String sexeEtudiant, String emailEtudiant, int telephoneEtudiant,
			String photoEtudiant, Classe classe) {
		super();
		this.matriculeEtudiant = matriculeEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
		this.lieuNaissanceEtudiant = lieuNaissanceEtudiant;
		this.adresseEtudiant = adresseEtudiant;
		this.numeroEtudiant = numeroEtudiant;
		this.sexeEtudiant = sexeEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.telephoneEtudiant = telephoneEtudiant;
		this.photoEtudiant = photoEtudiant;
		this.classe = classe;
	}

	public String getMatriculeEtudiant() {
		return matriculeEtudiant;
	}
	public void setMatriculeEtudiant(String matriculeEtudiant) {
		this.matriculeEtudiant = matriculeEtudiant;
	}
	public String getNomEtudiant() {
		return nomEtudiant;
	}
	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}
	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}
	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}
	public Date getDateNaissanceEtudiant() {
		return dateNaissanceEtudiant;
	}
	public void setDateNaissanceEtudiant(Date dateNaissanceEtudiant) {
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}
	public String getAdresseEtudiant() {
		return adresseEtudiant;
	}
	public void setAdresseEtudiant(String adresseEtudiant) {
		this.adresseEtudiant = adresseEtudiant;
	}
	public String getPhotoEtudiant() {
		return photoEtudiant;
	}
	public void setPhotoEtudiant(String photoEtudiant) {
		this.photoEtudiant = photoEtudiant;
	}

	public double getNumeroEtudiant() {
		return numeroEtudiant;
	}

	public void setNumeroEtudiant(double numeroEtudiant) {
		this.numeroEtudiant = numeroEtudiant;
	}

	public String getEmailEtudiant() {
		return emailEtudiant;
	}

	public void setEmailEtudiant(String emailEtudiant) {
		this.emailEtudiant = emailEtudiant;
	}
	

	public String getLieuNaissanceEtudiant() {
		return lieuNaissanceEtudiant;
	}


	public void setLieuNaissanceEtudiant(String lieuNaissance) {
		this.lieuNaissanceEtudiant = lieuNaissance;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@JsonIgnore
	public Collection<Note> getNotes() {
		return notes;
	}

	public void setNotes(Collection<Note> notes) {
		this.notes = notes;
	}
	
	public int getTelephoneEtudiant() {
		return telephoneEtudiant;
	}

	public void setTelephoneEtudiant(int telephoneEtudiant) {
		this.telephoneEtudiant = telephoneEtudiant;
	}
	
	public String getSexeEtudiant() {
		return sexeEtudiant;
	}

	public void setSexeEtudiant(String sexeEtudiant) {
		this.sexeEtudiant = sexeEtudiant;
	}

	@Override
	public String toString() {
		return "Etudiant [matriculeEtudiant=" + matriculeEtudiant + ", nomEtudiant=" + nomEtudiant + ", prenomEtudiant="
				+ prenomEtudiant + ", dateNaissanceEtudiant=" + dateNaissanceEtudiant + ", lieuNaissanceEtudiant="
				+ lieuNaissanceEtudiant + ", adresseEtudiant=" + adresseEtudiant + ", numeroEtudiant=" + numeroEtudiant
				+ ", sexeEtudiant=" + sexeEtudiant + ", emailEtudiant=" + emailEtudiant + ", telephoneEtudiant="
				+ telephoneEtudiant + ", photoEtudiant=" + photoEtudiant + ", classe=" + classe + ", notes=" + notes
				+ "]";
	}

}
