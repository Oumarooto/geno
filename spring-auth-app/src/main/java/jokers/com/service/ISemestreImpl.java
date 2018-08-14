package jokers.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jokers.com.dao.SemestreRepository;
import jokers.com.entities.Semestre;
import jokers.com.error.SemestreNotFoundException;

@Service
@Transactional
public class ISemestreImpl implements ISemestre{
	
	@Autowired
	public SemestreRepository semestreRepository;

	@Override
	public Semestre save(Semestre s) {
		Semestre semestre =  semestreRepository.save(s);
		return semestre;
	}

	@Override
	public boolean update(Semestre g, Long idSemestre) {
		g.setIdSemestre(idSemestre);
		semestreRepository.saveAndFlush(g);
		return true;
	}

	@Override
	public boolean delete(Long idSemestre) {
		Semestre s = semestreRepository.getOne(idSemestre);
		if(s==null) {
			throw new SemestreNotFoundException("ID SEMESTRE-"+idSemestre);
		}
		semestreRepository.delete(s);
		return true;
	}

	@Override
	public Optional<Semestre> getOne(Long idSemestre) {
		Semestre s = semestreRepository.findOne(idSemestre);
		if(s==null) {
			throw new SemestreNotFoundException("ID SEMESTRE-"+idSemestre);
		}
		return Optional.ofNullable(s);
	}

	@Override
	public List<Semestre> getAll() {
		List<Semestre> s = semestreRepository.findAll();
		return s;
	}

}
