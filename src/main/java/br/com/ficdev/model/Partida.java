package br.com.ficdev.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Partida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "time_visitante_id")
	private Time timeVisitante;
	
	@ManyToOne
	@JoinColumn(name = "time_casa_id")
	private Time timeCasa;
	
	private Integer pontosTimeVisitante;
	
	private Integer pontosTimaCasa;
	
	private Date dataPartida;
	

}
