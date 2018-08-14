package jokers.com.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import jokers.com.entities.Module;

public interface IModule {
	

	public Module save(Module m);
	public boolean update(Module m, String codeDiscipline);
	public boolean delete(String codeModule);
	public Optional<Module> getOne(String codeModule);
	public Page<Module> getAll(int p, int s);


}
