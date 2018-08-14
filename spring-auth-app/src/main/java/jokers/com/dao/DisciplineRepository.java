package jokers.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jokers.com.entities.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long>{

}
