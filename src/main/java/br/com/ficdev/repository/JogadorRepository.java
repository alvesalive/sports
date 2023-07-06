package br.com.ficdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.ficdev.model.Jogador;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface JogadorRepository extends JpaRepository<Jogador, Long>{

    List<Jogador> findByNomeContainingIgnoreCase(String nome);
}
