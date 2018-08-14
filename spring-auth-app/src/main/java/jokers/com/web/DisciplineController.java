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

import jokers.com.entities.Discipline;
import jokers.com.error.StudentNotFoundException;
import jokers.com.service.IDisciplineImpl;

@RestController
public class DisciplineController {
	
	@Autowired
	public IDisciplineImpl disciplineImpl;
	
	//Code to create Discipline
		@PostMapping(path="/disciplines")
		public ResponseEntity<Object> createDiscipline(@Valid @RequestBody Discipline d){
			Discipline saveDiscipline = disciplineImpl.save(d);
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{codeDiscipline}")
					.buildAndExpand(saveDiscipline.getIdDisciplince())
					.toUri();
			return ResponseEntity.created(location).build();
		}
		
		//Code to update Discipline
		@PutMapping(path="/disciplines/{codeDiscipline}")
		public ResponseEntity<Object> mettreAJourDiscipline(@RequestBody Discipline d, @PathVariable Long idDiscipline){
		Optional<Discipline>	updateDiscipline = disciplineImpl.getOne(idDiscipline);
			if(!updateDiscipline.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			disciplineImpl.update(d, idDiscipline);
			return ResponseEntity.noContent().build();
		}
		
		//Code to retrieve One Discipline
		@GetMapping(path="/disciplines/{codeDiscipline}")
		public Discipline retrieveDiscipline(@PathVariable long idDiscipline) {
			
			Optional<Discipline> discipline = disciplineImpl.getOne(idDiscipline);
			if(!discipline.isPresent()) {
				throw new StudentNotFoundException("CODE DISCIPLINE-"+idDiscipline);
			}
			return discipline.get();
		}
		
		

		//Code to Delete One Disciplines
		@DeleteMapping(path="/disciplines/{codeDiscipline}")
		public boolean deleteDisciplines(@PathVariable Long idDiscipline) {
			return disciplineImpl.delete(idDiscipline);
		}

		//Code to retrieve all Disciplines
		@GetMapping(path="/disciplines")
		public Page<Discipline> retrieveAllDisciplines(
				@RequestParam(name="page", defaultValue="0")int p, 
				@RequestParam(name="size", defaultValue="5")int s){
			return disciplineImpl.getAll(p, s);
		}

}
