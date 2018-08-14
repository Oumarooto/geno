package jokers.com.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Discipline implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDiscipline;
	private String intituleDiscipline;
	private Integer coefDiscipline;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_MODULE")
	private Module module;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SEMESTRE")
	private Semestre semestre;
	@OneToMany(mappedBy="discipline", fetch=FetchType.LAZY)
	private Collection<Note> notes;
	@ManyToMany
	@JoinTable(name="ENSEIG_DISCIPLI")
	private Collection<Enseignant> enseignants;
	
	
	public Discipline() {
		super();
	}

	public Discipline( String intituleDiscipline, Integer coefDisciplince, Module module,
			Semestre semestre) {
		super();
		this.intituleDiscipline = intituleDiscipline;
		this.coefDiscipline = coefDisciplince;
		this.module = module;
		this.semestre = semestre;
	}


	public Long getIdDisciplince() {
		return idDiscipline;
	}


	public void setIdDisciplince(Long idDisciplince) {
		this.idDiscipline = idDisciplince;
	}


	public String getIntituleDiscipline() {
		return intituleDiscipline;
	}


	public void setIntituleDiscipline(String intituleDiscipline) {
		this.intituleDiscipline = intituleDiscipline;
	}


	public Integer getCoefDisciplince() {
		return coefDiscipline;
	}


	public void setCoefDisciplince(Integer coefDisciplince) {
		this.coefDiscipline = coefDisciplince;
	}


	@JsonIgnore
	public Collection<Note> getNotes() {
		return notes;
	}


	public void setNotes(Collection<Note> notes) {
		this.notes = notes;
	}


	public Module getModule() {
		return module;
	}


	public void setModule(Module module) {
		this.module = module;
	}


	public Semestre getSemestre() {
		return semestre;
	}


	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	
	


	public Long getIdDiscipline() {
		return idDiscipline;
	}

	public void setIdDiscipline(Long idDiscipline) {
		this.idDiscipline = idDiscipline;
	}

	public Integer getCoefDiscipline() {
		return coefDiscipline;
	}

	public void setCoefDiscipline(Integer coefDiscipline) {
		this.coefDiscipline = coefDiscipline;
	}

	public Collection<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Collection<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	@Override
	public String toString() {
		return "Discipline [idDisciplince=" + idDiscipline + ", intituleDiscipline=" + intituleDiscipline + ", coefDisciplince=" + coefDiscipline + ", notes="
				+ notes + ", module=" + module + ", semestre=" + semestre + "]";
	}
	
}
