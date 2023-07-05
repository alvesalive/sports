package br.com.ficdev.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clube")
public class Time {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "capitao_id")
	private Jogador capitao;
	
	private String nome;
	
	private String cidade;
	
	private String tecnico;
	
	@OneToMany(mappedBy = "time", fetch = FetchType.EAGER)
	private List<Jogador> jogadores;
	
	@OneToMany(mappedBy = "timeVisitante")
	@JsonIgnore
	private List<Partida> partidasVisitante;
	
	@OneToMany(mappedBy = "timeCasa")
	private List<Partida> partidasCasa;
	

}
