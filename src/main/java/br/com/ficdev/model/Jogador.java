package br.com.ficdev.model;

import java.util.List;

import br.com.ficdev.dto.JogadorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "time_id")
	@Null
	private Time time;
	
	private String nome;
	
	private String posicao;
	
	private char nivelHabilidade; 
	
	@OneToMany(mappedBy = "jogador")
	@JsonIgnore
	private List<Incidente> incidentes;

	public Jogador(Long id, String nome, String posicao, char nivelHabilidade) {
		this.id = id;
		this.nome = nome;
		this.posicao = posicao;
		this.nivelHabilidade = nivelHabilidade;
	}

	public static Jogador fromJogadorDTO (JogadorDTO jogadorDTO){
		return new Jogador(
				jogadorDTO.id(),
				jogadorDTO.nome(),
				jogadorDTO.posicao(),
				jogadorDTO.nivelHabilidade()
		);
	}
}
