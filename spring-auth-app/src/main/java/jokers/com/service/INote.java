package jokers.com.service;

import java.util.List;
import java.util.Optional;

import jokers.com.entities.Note;

public interface INote {
	
	public Note save(Note n);
	public boolean update(String codeEtudiant, String intituleDiscipline, Long idNote);
	public boolean delete(String codeEtudiant, String intituleDiscipline, Long idNote);
	public Optional<Note> getOne(String codeEtudiant, String intituleDiscipline, Long idNote);
	public List<Note> getAll();

}
