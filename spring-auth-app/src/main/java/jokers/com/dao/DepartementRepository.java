package jokers.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jokers.com.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long>{

}
