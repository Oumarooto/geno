package jokers.com.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Classe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idClasse;
	private String intituleClasse;
	private String niveauClasse;
	@OneToMany(mappedBy="classe", fetch=FetchType.LAZY)
	private Collection<Etudiant> etudiants;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ANNEE_SCOLAIRE")
	private AnneeScolaire anneeScolaire;

	
	public Classe() {
		super();
	}


	public Classe(String intituleClasse, String niveauClasse, AnneeScolaire anneeScolaire) {
		super();
		this.intituleClasse = intituleClasse;
		this.niveauClasse = niveauClasse;
		this.anneeScolaire = anneeScolaire;
	}

	public Long getIdClasse() {
		return idClasse;
	}


	public void setIdClasse(Long idClasse) {
		this.idClasse = idClasse;
	}


	public String getIntituleClasse() {
		return intituleClasse;
	}


	public void setIntituleClasse(String intituleClasse) {
		this.intituleClasse = intituleClasse;
	}


	public String getNiveau() {
		return niveauClasse;
	}


	public void setNiveau(String niveauClasse) {
		this.niveauClasse = niveauClasse;
	}


	@JsonIgnore
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}


	
	public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}


	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}


	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}


	@Override
	public String toString() {
		return "Classe [idClasse=" + idClasse + ", intituleClasse=" + intituleClasse + ", niveauClasse=" + niveauClasse
				+ ", etudiants=" + etudiants + "]";
	}
	
}
