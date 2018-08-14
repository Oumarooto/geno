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

import jokers.com.entities.Classe;
import jokers.com.error.ClasseNotFoundException;
import jokers.com.service.IClasseImpl;

@RestController
public class ClasseController {
	
	@Autowired
	public IClasseImpl classeImpl;
	
	//Code to create Classe
		@PostMapping(path="/classes/")
		public ResponseEntity<Object> createClasse(@Valid @RequestBody Classe c){
			Classe saveClasse = classeImpl.save(c);
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{idClasse}")
					.buildAndExpand(saveClasse.getIdClasse())
					.toUri();
			return ResponseEntity.created(location).build();
		}
		
		//Code to update Classe
		@PutMapping(path="/classes/{matricule}")
		public ResponseEntity<Object> updateClasse(@RequestBody Classe c, @PathVariable Long idClasse){
		Optional<Classe>	updateClasse = classeImpl.getOne(idClasse);
			if(!updateClasse.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			classeImpl.update(c, idClasse);
			return ResponseEntity.noContent().build();
		}
		
		//Code to retrieve One Classe
		@GetMapping(path="/classes/{idClasse}")
		public Classe retrieveClasse(@PathVariable Long idClasse) {
			
			Optional<Classe> classe = classeImpl.getOne(idClasse);
			if(!classe.isPresent()) {
				throw new ClasseNotFoundException("ID CLASSE-"+idClasse);
			}
			return classe.get();
		}
		
		
		//Code to Delete One Classe
		@DeleteMapping(path="/classes/{idClasse}")
		public boolean deleteClasse(@PathVariable Long idClasse) {
			return classeImpl.delete(idClasse);
		}

		//Code to retrieve all Classe
		@GetMapping(path="/classes/")
		public Page<Classe> retrieveAllClasse(
				@RequestParam(name="page", defaultValue="0")int p, 
				@RequestParam(name="size", defaultValue="5")int s){
			return classeImpl.getAlls(p, s);
		}

}
