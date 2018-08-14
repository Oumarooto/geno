package jokers.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jokers.com.entities.Module;

public interface ModuleRepository extends JpaRepository<Module, String>{

}
