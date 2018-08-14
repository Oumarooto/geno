package jokers.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jokers.com.dao.ModuleRepository;
import jokers.com.entities.Module;
import jokers.com.error.ModuleNotFoundException;

@Service
@Transactional
public class IModuleImpl implements IModule{
	
	@Autowired
	public ModuleRepository moduleRepository;

	@Override
	public Module save(Module m) {
		return moduleRepository.save(m);
	}

	@Override
	public boolean update(Module m, String codeModule) {
		m.setCodeModule(codeModule);
		moduleRepository.save(m);
		return true;
	}

	@Override
	public boolean delete(String codeModule) {
		Module m = moduleRepository.findOne(codeModule);
		if(m==null) {
			throw new ModuleNotFoundException("CODE MODULE-" + codeModule);
		}
		moduleRepository.delete(m);
		return true;
	}

	@Override
	public Optional<Module> getOne(String codeModule) {
		Module m = moduleRepository.findOne(codeModule);
		if(m==null) {
			throw new ModuleNotFoundException("CODE MODULE-" + codeModule);
		}
		return Optional.ofNullable(m);
	}

	@Override
	public Page<Module> getAll(int p, int s) {
		List<Module> modules = new ArrayList<>();
		moduleRepository.findAll().forEach(modules::add);
		Page<Module> pageModule =  new PageImpl<>(modules, new PageRequest(p, s), modules.size());
		return pageModule;
	}

}
