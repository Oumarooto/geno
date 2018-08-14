package jokers.com.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jokers.com.dao.DisciplineRepository;
import jokers.com.dao.EtudiantRepository;
import jokers.com.dao.NoteRepository;
import jokers.com.entities.Note;

@Service
@Transactional
public class INoteImpl implements INote{
	
	@Autowired
	public EtudiantRepository etudiantRepository;
	@Autowired
	public DisciplineRepository disciplineRepository;
	@Autowired
	public NoteRepository noteRepository;

	@Override
	public Note save(Note n) {
		Note note = noteRepository.save(n);
		return note;
	}


	@Override
	public boolean update(String codeEtudiant, String intituleDiscipline, Long idNote) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String codeEtudiant, String intituleDiscipline, Long idNote) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Note> getOne(String codeEtudiant, String intituleDiscipline, Long idNote) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
