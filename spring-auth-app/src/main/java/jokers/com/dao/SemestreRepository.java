package jokers.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jokers.com.entities.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {

}
