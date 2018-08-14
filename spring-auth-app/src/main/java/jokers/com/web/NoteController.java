package jokers.com.web;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jokers.com.entities.Note;
import jokers.com.service.IDisciplineImpl;
import jokers.com.service.IEtudiantImpl;
import jokers.com.service.INoteImpl;

@RestController
public class NoteController {
	
	@Autowired
	public INoteImpl noteImpl;
	@Autowired
	public IEtudiantImpl etudiantImpl;
	@Autowired
	public IDisciplineImpl disciplineImpl;
	
	//Code to create Note
		@PostMapping(path="/notes/")
		public ResponseEntity<Object> createNote(@Valid @RequestBody Note n){
			Note saveNote = noteImpl.save(n);
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{idNote}")
					.buildAndExpand(saveNote.getIdNotes())
					.toUri();
			return ResponseEntity.created(location).build();
		}

}
