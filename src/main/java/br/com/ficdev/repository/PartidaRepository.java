package br.com.ficdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.ficdev.model.Partida;

@Repository
@EnableJpaRepositories
public interface PartidaRepository extends JpaRepository<Partida, Long>{

}
