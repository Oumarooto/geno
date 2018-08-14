package jokers.com.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Semestre implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSemestre;
	private LocalDate dateDebutSemestre;
	private LocalDate dateFinSemestre;
	private String intituleSemestre;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ANNEESCOLAIRE")
	private AnneeScolaire anneeScolaire;
	
	public Semestre() {
		super();
	}

	

	public Semestre(LocalDate dateDebutSemestre, LocalDate dateFinSemestre, String intituleSemestre,
			AnneeScolaire anneeScolaire) {
		super();
		this.dateDebutSemestre = dateDebutSemestre;
		this.dateFinSemestre = dateFinSemestre;
		this.intituleSemestre = intituleSemestre;
		this.anneeScolaire = anneeScolaire;
	}



	public Long getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(Long idSemestre) {
		this.idSemestre = idSemestre;
	}

	public LocalDate getDateDebutSemestre() {
		return dateDebutSemestre;
	}

	public void setDateDebutSemestre(LocalDate dateDebutSemestre) {
		this.dateDebutSemestre = dateDebutSemestre;
	}

	public LocalDate getDateFinSemestre() {
		return dateFinSemestre;
	}

	public void setDateFinSemestre(LocalDate dateFinSemestre) {
		this.dateFinSemestre = dateFinSemestre;
	}

	public String getIntituleSemestre() {
		return intituleSemestre;
	}

	public void setIntituleSemestre(String intituleSemestre) {
		this.intituleSemestre = intituleSemestre;
	}
	

	public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}


	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}


	@Override
	public String toString() {
		return "Semestre [idSemestre=" + idSemestre + ", dateDebutSemestre=" + dateDebutSemestre + ", dateFinSemestre="
				+ dateFinSemestre + ", intituleSemestre=" + intituleSemestre + ", anneeScolaire=" + anneeScolaire + "]";
	}



	
	
}
