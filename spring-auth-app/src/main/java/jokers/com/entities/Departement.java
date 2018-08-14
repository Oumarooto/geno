package jokers.com.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Departement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDepartement;
	private String nomDepartement;
	@OneToMany(mappedBy="departement", fetch=FetchType.LAZY)
	private Collection<Specialite> specialites;
	
	public Departement() {
		super();
	}

	public Departement(String nomDepartement) {
		super();
		this.nomDepartement = nomDepartement;
	}

	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
	
	@JsonIgnore
	public Collection<Specialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(Collection<Specialite> specialites) {
		this.specialites = specialites;
	}

	@Override
	public String toString() {
		return "Departement [idDepartement=" + idDepartement + ", nomDepartement=" + nomDepartement + "]";
	}
	
}
