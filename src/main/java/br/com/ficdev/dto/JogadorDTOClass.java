package br.com.ficdev.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class JogadorDTOClass {
    private Long id;
    private String nome;
    private String posicao;
    private char nivelHabilidade;

    public JogadorDTOClass(Long id, String nome, String posicao, char nivelHabilidade) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.nivelHabilidade = nivelHabilidade;
    }

}
