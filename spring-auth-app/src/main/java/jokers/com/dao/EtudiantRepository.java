package jokers.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jokers.com.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, String>{

}
