package jokers.com.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Module implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String codeModule;
	private String intituleModule;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CLASSE")
	private Classe classe;
	@OneToMany(mappedBy="module", fetch=FetchType.LAZY)
	private Collection<Discipline> disciplines;
	
	public Module() {
		super();
	}

	public Module(String codeModule, String intituleModule, Classe classe) {
		super();
		this.codeModule = codeModule;
		this.intituleModule = intituleModule;
		this.classe = classe;
	}

	/*public Long getIdModule() {
		return idModule;
	}

	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}*/

	public String getCodeModule() {
		return codeModule;
	}

	public void setCodeModule(String codeModule) {
		this.codeModule = codeModule;
	}

	public String getIntituleModule() {
		return intituleModule;
	}

	public void setIntituleModule(String intituleModule) {
		this.intituleModule = intituleModule;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@JsonIgnore
	public Collection<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(Collection<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	@Override
	public String toString() {
		return "Module [codeModule=" + codeModule + ", intituleModule=" + intituleModule
				+ ", classe=" + classe + ", disciplines=" + disciplines + "]";
	}
	
}
