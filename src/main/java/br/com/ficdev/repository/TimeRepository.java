package br.com.ficdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.ficdev.model.Time;

@Repository
@EnableJpaRepositories
public interface TimeRepository extends JpaRepository<Time, Long>{

}
