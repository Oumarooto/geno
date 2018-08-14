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

import jokers.com.entities.Module;
import jokers.com.error.ModuleNotFoundException;
import jokers.com.service.IModuleImpl;

@RestController
public class ModuleController {
	
	@Autowired
	public IModuleImpl moduleImpl;
	
	//Code to create Module
		@PostMapping(path="/modules/")
		public ResponseEntity<Object> createModule(@Valid @RequestBody Module m){
			Module saveModule = moduleImpl.save(m);
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{codeModule}")
					.buildAndExpand(saveModule.getCodeModule())
					.toUri();
			return ResponseEntity.created(location).build();
		}
		
		//Code to update Module
		@PutMapping(path="/modules/{codeModule}")
		public ResponseEntity<Object> mettreAJourModule(@RequestBody Module m, @PathVariable String codeModule){
		Optional<Module>	updateModule = moduleImpl.getOne(codeModule);
			if(!updateModule.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			moduleImpl.update(m, codeModule);
			return ResponseEntity.noContent().build();
		}
		
		
		//Code to retrieve One Module
		@GetMapping(path="/modules/{codeModule}")
		public Module retrieveModule(@PathVariable String codeModule) {
			
			Optional<Module> modules = moduleImpl.getOne(codeModule);
			if(!modules.isPresent()) {
				throw new ModuleNotFoundException("CODE MODULE-"+codeModule);
			}
			return modules.get();
		}
		
		

		//Code to Delete One Module
		@DeleteMapping(path="/modules/{codeModule}")
		public boolean deleteModule(@PathVariable String matricule) {
			return moduleImpl.delete(matricule);
		}

		//Code to retrieve all Module
		@GetMapping(path="/modules/")
		public Page<Module> retrieveAllModules(
				@RequestParam(name="page", defaultValue="0")int p, 
				@RequestParam(name="size", defaultValue="5")int s){
			return moduleImpl.getAll(p, s);
		}
		

}
