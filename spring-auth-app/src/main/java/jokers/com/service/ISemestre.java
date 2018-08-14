package jokers.com.service;

import java.util.List;
import java.util.Optional;

import jokers.com.entities.Semestre;

public interface ISemestre {
	
	public Semestre save(Semestre s);
	public boolean update(Semestre g, Long idSemestre);
	public boolean delete(Long idSemestre);
	public Optional<Semestre> getOne(Long idSemestre);
	public List<Semestre> getAll();
	
}
