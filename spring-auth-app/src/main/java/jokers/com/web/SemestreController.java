package jokers.com.web;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jokers.com.entities.Semestre;
import jokers.com.error.SemestreNotFoundException;
import jokers.com.service.ISemestreImpl;

@RestController
public class SemestreController {
	
	@Autowired
	public ISemestreImpl semestreImpl;
	
	//Code to create Semestre
		@PostMapping(path="/semestres/")
		public ResponseEntity<Object> createSemestre(@Valid @RequestBody Semestre s){
			Semestre saveSemestre = semestreImpl.save(s);
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{idSemestre}")
					.buildAndExpand(saveSemestre.getIdSemestre())
					.toUri();
			return ResponseEntity.created(location).build();
		}
		
		//Code to update Semestres
		@PutMapping(path="/semestres/{idSemestre}")
		public ResponseEntity<Object> mettreAJourSemestre(@RequestBody Semestre s, @PathVariable Long idSemestre){
		Optional<Semestre>	updateSemestre = semestreImpl.getOne(idSemestre);
			if(!updateSemestre.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			semestreImpl.update(s, idSemestre);
			return ResponseEntity.noContent().build();
		}
		

		//Code to retrieve One Semestre
		@GetMapping(path="/semestres/{idSemestre}")
		public Semestre retrieveSemestre(@PathVariable Long idSemestre) {
			Optional<Semestre> semestre = semestreImpl.getOne(idSemestre);
			if(!semestre.isPresent()) {
				throw new SemestreNotFoundException("Matricule-"+idSemestre);
			}
			return semestre.get();
		}
		
		//Code to Delete One Semestre
		@DeleteMapping(path="/semestres/{idSemestre}")
		public boolean deleteSemestre(@PathVariable Long idSemestre) {
			return semestreImpl.delete(idSemestre);
		}
		
		//Code to retrieve all Semestre
		@GetMapping(path="/semestres/")
		public List<Semestre> retrieveAllSemestres(){
			return semestreImpl.getAll();
		}

}
