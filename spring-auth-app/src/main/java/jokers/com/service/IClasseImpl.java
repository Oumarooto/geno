package jokers.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jokers.com.dao.ClasseRepository;
import jokers.com.entities.Classe;
import jokers.com.error.ClasseNotFoundException;

@Service
@Transactional
public class IClasseImpl implements IGestionSco<Classe, Long, String>{
	
	@Autowired
	public ClasseRepository classeRepository;

	@Override
	public Classe save(Classe c) {
		Classe classe = classeRepository.save(c);
		return classe;
	}

	@Override
	public Optional<Classe> getOne(Long idClasse) {
		Classe classe = classeRepository.findOne(idClasse);
		if(classe==null) {
			throw new ClasseNotFoundException("ID CLASSE-" + idClasse);
		}
		return Optional.ofNullable(classe);
	}

	@Override
	public Page<Classe> getAll(String p, String s) {
		// None
		return null;
	}

	@Override
	public Classe updateObject(Classe g, Long idClasse) {
		// None
		return null;
	}
	
	@Override
	public Page<Classe> getAlls(Integer p, Integer s) {
		List<Classe> classes = new ArrayList<>();
		classeRepository.findAll().forEach(classes::add);
		Page<Classe> pageClasse =  new PageImpl<>(classes, new PageRequest(p, s), classes.size());
		return pageClasse;
	}


	@Override
	public boolean update(Classe c, Long idClasse) {
		c.setIdClasse(idClasse);
		classeRepository.saveAndFlush(c);
		return true;
	}

	@Override
	public boolean delete(Long idClasse) {
		Classe classe = classeRepository.getOne(idClasse);
		if(classe==null) {
			throw new ClasseNotFoundException("ID CLASSE-" + idClasse);
		}
		classeRepository.delete(classe);
		return true;
	}

}
