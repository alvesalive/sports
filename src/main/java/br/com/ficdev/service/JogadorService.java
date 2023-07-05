package br.com.ficdev.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.ficdev.dto.JogadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ficdev.model.Jogador;
import br.com.ficdev.repository.JogadorRepository;

@Service
public class JogadorService {
	
    final
    JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

//    public List<Jogador> listarJogadores() {
//        return jogadorRepository.findAll();
//    }

    public List<JogadorDTO> listarJogadores() {
        List<Jogador> jogadores = jogadorRepository.findAll();
        return jogadores.stream()
                .map(jogador -> new JogadorDTO(
                        jogador.getId(),
                        jogador.getNome(),
                        jogador.getPosicao(),
                        jogador.getNivelHabilidade()
                ))
                .collect(Collectors.toList());
    }
//    public Jogador obterJogadorPorId(Long id) {
//        return jogadorRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Jogador não encontrado com o ID: " + id));
//    }

    public JogadorDTO obterJogadorPorId(Long id) {
        Optional<Jogador> jogador = Optional.ofNullable(jogadorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Jogador não encontrado com o ID: " + id)));
        JogadorDTO jogadorDTO = new JogadorDTO(
                jogador.get().getId(),
                jogador.get().getNome(),
                jogador.get().getPosicao(),
                jogador.get().getNivelHabilidade()
        );
        return jogadorDTO;
    }

    public Jogador criarJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public Jogador atualizarJogador(Long id, Jogador jogadorAtualizado) {

        Jogador jogador = Jogador.fromJogadorDTO(obterJogadorPorId(id));

        jogador.setNome(jogadorAtualizado.getNome());
        jogador.setPosicao(jogadorAtualizado.getPosicao());
        jogador.setNivelHabilidade(jogadorAtualizado.getNivelHabilidade());
        jogador.setTime(jogadorAtualizado.getTime());
        return jogadorRepository.save(jogador);
    }

    public void excluirJogador(Long id) {
        Jogador jogador = Jogador.fromJogadorDTO(obterJogadorPorId(id));
        jogadorRepository.delete(jogador);
    }
}
