package br.com.ficdev.controller;

import br.com.ficdev.dto.JogadorDTO;
import br.com.ficdev.model.Jogador;
import br.com.ficdev.service.JogadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jogador")
@Tag(name = "api-jogador")
public class JogadorController {

    final
    JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping("/listar")
    public String listarJogadores(Model model) {
        List<JogadorDTO> jogadores = jogadorService.listarJogadores();
        model.addAttribute("jogadores", jogadores);
        return "jogador";
    }

    @PostMapping("/criar")
    public String addJogador(Jogador jogador) {
        jogadorService.criarJogador(jogador);
        return "redirect:/jogador/listar";
    }

    @GetMapping("/atualizar/{id}")
    public String updateJogador(@PathVariable Long id, Model model) {
        JogadorDTO jogador = jogadorService.obterJogadorPorId(id);
        model.addAttribute("jogador", jogador);
        return "jogadorupdate";
    }

    @GetMapping("/apagar/{id}")
    public String deleteJogador(@PathVariable Long id) {
        jogadorService.excluirJogador(id);
        return "redirect:/jogador/listar";
    }

    @GetMapping("/pesquisar")
    public String pesquisarJogadores(@RequestParam("nome") String nome, Model model) {
        List<JogadorDTO> jogadores = jogadorService.pesquisarJogadoresPorNome(nome);
        model.addAttribute("jogadores", jogadores);
        return "jogadorpesquisa";
    }







    /**
     * **********************************
     * Methods above : Thymeleaf
     * Methods below : Entity and DTO
     * **********************************
     */

    @Operation(summary = "Lista todos os jogadores", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pesquisa bem sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar consulta"),
    })
    @GetMapping
    public ResponseEntity<List<JogadorDTO>> listarJogadores() {
        List<JogadorDTO> jogadores = jogadorService.listarJogadores();
        return ResponseEntity.ok(jogadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogadorDTO> obterJogadorPorId(@PathVariable Long id) {
        JogadorDTO jogador = jogadorService.obterJogadorPorId(id);
        return ResponseEntity.ok(jogador);
    }

    @PostMapping
    public Jogador criarJogador(@RequestBody Jogador jogador) {
        return jogadorService.criarJogador(jogador);
    }

    @PutMapping("/{id}")
    public Jogador atualizarJogador(@PathVariable Long id, @RequestBody Jogador jogadorAtualizado) {
        return jogadorService.atualizarJogador(id, jogadorAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluirJogador(@PathVariable Long id) {
        jogadorService.excluirJogador(id);
    }


}
