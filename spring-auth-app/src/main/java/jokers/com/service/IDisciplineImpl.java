package jokers.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jokers.com.dao.DisciplineRepository;
import jokers.com.entities.Discipline;
import jokers.com.error.DisciplineNotFoundException;

@Service
@Transactional
public class IDisciplineImpl implements IDiscipline{
	
	@Autowired
	public DisciplineRepository disciplineRepository;

	@Override
	public Discipline save(Discipline d) {
		return disciplineRepository.save(d);
	}

	@Override
	public boolean update(Discipline g, Long idDiscipline) {
		g.setIdDisciplince(idDiscipline);
		disciplineRepository.saveAndFlush(g);
		return true;
	}

	@Override
	public boolean delete(Long idDiscipline) {
		Discipline d = disciplineRepository.findOne(idDiscipline);
		if(d==null) {
			throw new DisciplineNotFoundException("CODE DISCIPLINE-"+idDiscipline);
		}
		disciplineRepository.delete(d);
		return true;
	}

	@Override
	public Optional<Discipline> getOne(Long idDiscipline) {
		Discipline d = disciplineRepository.findOne(idDiscipline);
		if(d==null) {
			throw new DisciplineNotFoundException("CODE DISCIPLINE-"+idDiscipline);
		}
		return Optional.ofNullable(d);
	}

	@Override
	public Page<Discipline> getAll(int p, int s) {
		List<Discipline> discipline = new ArrayList<>();
		disciplineRepository.findAll().forEach(discipline::add);
		Page<Discipline> pageDiscipline =  new PageImpl<>(discipline, new PageRequest(p, s), discipline.size());
		return pageDiscipline;
	}

}
