package jokers.com.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AnneeScolaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAnneSco;
	private LocalDate dateDebutAnneeSco;
	private LocalDate dateFinAnneeSco;
	@OneToMany(mappedBy="anneeScolaire", fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private Collection<Classe> classes;
	@OneToMany(mappedBy="anneeScolaire", fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private Collection<Semestre> semestres;
	
	
	public AnneeScolaire() {
		super();
	}
	
	public AnneeScolaire(LocalDate dateDebutAnneeSco, LocalDate dateFinAnneeSco) {
		super();
		this.dateDebutAnneeSco = dateDebutAnneeSco;
		this.dateFinAnneeSco = dateFinAnneeSco;
	}

	public Long getIdAnneSco() {
		return idAnneSco;
	}

	public void setIdAnneSco(Long idAnneSco) {
		this.idAnneSco = idAnneSco;
	}

	public LocalDate getDateDebutAnneeSco() {
		return dateDebutAnneeSco;
	}

	public void setDateDebutAnneeSco(LocalDate dateDebutAnneeSco) {
		this.dateDebutAnneeSco = dateDebutAnneeSco;
	}

	public LocalDate getDateFinAnneeSco() {
		return dateFinAnneeSco;
	}

	public void setDateFinAnneeSco(LocalDate dateFinAnneeSco) {
		this.dateFinAnneeSco = dateFinAnneeSco;
	}
	
	@JsonIgnore
	public Collection<Classe> getClasses() {
		return classes;
	}

	public void setClasses(Collection<Classe> classes) {
		this.classes = classes;
	}
	

	@JsonIgnore
	public Collection<Semestre> getSemestres() {
		return semestres;
	}

	public void setSemestres(Collection<Semestre> semestres) {
		this.semestres = semestres;
	}

	@Override
	public String toString() {
		return "AnneeScolaire [idAnneSco=" + idAnneSco + ", dateDebutAnneeSco=" + dateDebutAnneeSco
				+ ", dateFinAnneeSco=" + dateFinAnneeSco + ", classes=" + classes + "]";
	}

}
