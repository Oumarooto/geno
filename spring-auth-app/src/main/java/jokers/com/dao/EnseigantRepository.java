package jokers.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jokers.com.entities.Enseignant;


public interface EnseigantRepository extends JpaRepository<Enseignant, Long> {

}
