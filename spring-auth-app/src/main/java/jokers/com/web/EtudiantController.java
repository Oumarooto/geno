package jokers.com.web;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jokers.com.entities.Etudiant;
import jokers.com.error.StudentNotFoundException;
import jokers.com.service.IEtudiantImpl;

@RestController
public class EtudiantController {
	
	@Autowired
	private IEtudiantImpl etudiantImpl;
	
	//Code to create Student
	@PostMapping(path="/students/")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Etudiant e){
		Etudiant saveStudent = etudiantImpl.save(e);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{matricule}")
				.buildAndExpand(saveStudent.getMatriculeEtudiant())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	//Code to update Student
	@PutMapping(path="/students/{matricule}")
	public ResponseEntity<Object> mettreAJourEtudiant(@RequestBody Etudiant e, @PathVariable String matricule){
	Optional<Etudiant>	updateStudent = etudiantImpl.getOne(matricule);
		if(!updateStudent.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		etudiantImpl.update(e, matricule);
		return ResponseEntity.noContent().build();
	}
	
	
	//Code to retrieve One Student
	@GetMapping(path="/students/{matricule}")
	public Etudiant retrieveStudent(@PathVariable String matricule) {
		
		Optional<Etudiant> student = etudiantImpl.getOne(matricule);
		if(!student.isPresent()) {
			throw new StudentNotFoundException("Matricule-"+matricule);
		}
		return student.get();
	}
	
	//Code to Delete One Student
	@DeleteMapping(path="/students/{matricule}")
	public boolean deleteStudent(@PathVariable String matricule) {
		return etudiantImpl.delete(matricule);
	}

	//Code to retrieve all Student
	@GetMapping(path="/students/")
	public Page<Etudiant> retrieveAllStudents(
			@RequestParam(name="page", defaultValue="0")int p, 
			@RequestParam(name="size", defaultValue="5")int s){
		return etudiantImpl.getAll(p, s);
	}
	
	
}
