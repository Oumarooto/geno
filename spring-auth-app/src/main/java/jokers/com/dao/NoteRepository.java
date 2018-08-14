package jokers.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jokers.com.entities.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{

}
