package br.com.ficdev.mapper;

import br.com.ficdev.dto.JogadorDTO;
import br.com.ficdev.model.Jogador;
import org.modelmapper.ModelMapper;

public class JogadorMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static JogadorDTO toDTO(Jogador jogador) {
        return modelMapper.map(jogador, JogadorDTO.class);
    }

    public static Jogador toEntity(JogadorDTO jogadorDTO) {
        return modelMapper.map(jogadorDTO, Jogador.class);
    }
}