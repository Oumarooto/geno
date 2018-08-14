package jokers.com.web;

import java.net.URI;
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

import jokers.com.entities.AnneeScolaire;
import jokers.com.error.AnneeScolaireNotFoundException;
import jokers.com.service.IAnneeScolaireImpl;

@RestController
public class AnneeScolaireController {

	@Autowired
	private IAnneeScolaireImpl anneeScolaireImpl;
	

	// Code to create School years
	@PostMapping(path = "/school-years/")
	public ResponseEntity<Object> schoolYears(@Valid @RequestBody AnneeScolaire a) {
		AnneeScolaire saveschoolYears = anneeScolaireImpl.save(a);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveschoolYears.getIdAnneSco()).toUri();
		return ResponseEntity.created(location).build();
	}

	// Code to update School years
	@PutMapping(path = "/school-years/{idSchoolYears}")
	public ResponseEntity<Object> updateSchoolYears(@RequestBody AnneeScolaire a, @PathVariable Long idSchoolYears) {
		Optional<AnneeScolaire> schoolYears = anneeScolaireImpl.getOne(idSchoolYears);
		if (!schoolYears.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		anneeScolaireImpl.update(a, idSchoolYears);
		return ResponseEntity.noContent().build();
	}

	// Code to get one School years by id
	@GetMapping(path = "/school-years/{idSchoolYears}")
	public AnneeScolaire retrieveschoolYears(@PathVariable Long idSchoolYears) {

		Optional<AnneeScolaire> anneeScolaire = anneeScolaireImpl.getOne(idSchoolYears);
		if(!anneeScolaire.isPresent()) {
			throw new AnneeScolaireNotFoundException("ID SCHOOL YEARS-"+idSchoolYears);
		}
		return anneeScolaire.get();
	}

	// Code to delete School years
	@DeleteMapping(path = "/school-years/{id}")
	public boolean deleteschoolYears(@PathVariable long idSchoolYears) {
		return anneeScolaireImpl.delete(idSchoolYears);
	}

}
