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

import jokers.com.dao.EtudiantRepository;
import jokers.com.entities.Etudiant;
import jokers.com.error.StudentNotFoundException;

@Service
@Transactional
public class IEtudiantImpl implements IGestionSco<Etudiant, String, Integer> {

	@Autowired
	public EtudiantRepository etudiantRepository;

	@Override
	public Etudiant save(Etudiant g) {
		Etudiant student = etudiantRepository.save(g);
		return student;
	}
	
	@Override
	public Optional<Etudiant> getOne(String mtricle) {
		Etudiant etd = etudiantRepository.findOne(mtricle);
		if(etd==null) {
			throw new StudentNotFoundException("matricule-" + mtricle);
		}
		return Optional.ofNullable(etd);
	}

	@Override
	public Page<Etudiant> getAll(Integer p, Integer s) {
		List<Etudiant> students = new ArrayList<>();
		etudiantRepository.findAll().forEach(students::add);
		Page<Etudiant> pageStudent =  new PageImpl<>(students, new PageRequest(p, s), students.size());
		return pageStudent;
	}

	

	@Override
	public boolean delete(String mtricle) {
		Etudiant etd = etudiantRepository.getOne(mtricle);
		if(etd==null) {
			throw new StudentNotFoundException("matricule-" + mtricle);
		}
		etudiantRepository.delete(etd);
		return true;
	}

	@Override
	public boolean update(Etudiant g, String mtricle) {
		g.setMatriculeEtudiant(mtricle);
		etudiantRepository.saveAndFlush(g);
		return true;
	}

	@Override
	public Etudiant updateObject(Etudiant g, String mtricle) {
		g.setMatriculeEtudiant(mtricle);
		return etudiantRepository.saveAndFlush(g);
	}

	@Override
	public Page<Etudiant> getAlls(Integer p, Integer s) {
		return null;
	}

	

}
