package jokers.com.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import jokers.com.entities.Discipline;


public interface IDiscipline {
	
	public Discipline save(Discipline d);
	public boolean update(Discipline g, Long idDiscipline);
	public boolean delete(Long idDiscipline);
	public Optional<Discipline> getOne(Long idDiscipline);
	public Page<Discipline> getAll(int p, int s);

}
