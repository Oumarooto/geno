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
public class Specialite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSpecialite;
	private String intituleSpecialite;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_DEPARTEMENT")
	private Departement departement;
	
	public Specialite() {
		super();
	}

	public Specialite(String intituleSpecialite, Departement departement) {
		super();
		this.intituleSpecialite = intituleSpecialite;
		this.departement = departement;
	}

	public Long getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(Long idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	public String getIntituleSpecialite() {
		return intituleSpecialite;
	}

	public void setIntituleSpecialite(String intituleSpecialite) {
		this.intituleSpecialite = intituleSpecialite;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	@Override
	public String toString() {
		return "Specialite [idSpecialite=" + idSpecialite + ", intituleSpecialite=" + intituleSpecialite
				+ ", departement=" + departement + "]";
	}
	
}
