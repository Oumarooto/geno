package jokers.com.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jokers.com.dao.AnneeScolaireRepository;
import jokers.com.entities.AnneeScolaire;
import jokers.com.error.AnneeScolaireNotFoundException;

@Service
@Transactional
public class IAnneeScolaireImpl implements IGestionSco<AnneeScolaire, Long, LocalDateTime>{
	
	@Autowired
	public AnneeScolaireRepository anneeScolaireRepository;

	@Override
	public AnneeScolaire save(AnneeScolaire a) {
		return anneeScolaireRepository.save(a);
	}

	@Override
	public Optional<AnneeScolaire> getOne(Long idAnneeScolaire) {
		AnneeScolaire anneeScolaire = anneeScolaireRepository.findOne(idAnneeScolaire);
		if(anneeScolaire==null) {
			throw new AnneeScolaireNotFoundException("ID ANNEE SCOLAIRE-" + idAnneeScolaire);
		}
		return Optional.ofNullable(anneeScolaire);
	}

	@Override
	public Page<AnneeScolaire> getAll(LocalDateTime p, LocalDateTime s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnneeScolaire updateObject(AnneeScolaire g, Long mtricle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(AnneeScolaire a, Long id) {
		a.setIdAnneSco(id);
		anneeScolaireRepository.saveAndFlush(a);
		return true;
	}

	@Override
	public boolean delete(Long id) {
		anneeScolaireRepository.delete(id);
		return true;
	}

	@Override
	public Page<AnneeScolaire> getAlls(Integer p, Integer s) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
