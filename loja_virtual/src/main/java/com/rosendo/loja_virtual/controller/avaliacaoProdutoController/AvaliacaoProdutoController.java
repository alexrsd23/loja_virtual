package com.rosendo.loja_virtual.controller.avaliacaoProdutoController;

import com.rosendo.loja_virtual.domain.avaliacaoProduto.AtualizarCadastroAvaliacaoDTO;
import com.rosendo.loja_virtual.domain.avaliacaoProduto.AvaliacaoProduto;
import com.rosendo.loja_virtual.domain.avaliacaoProduto.CadastroAvaliacaoProdutoDTO;
import com.rosendo.loja_virtual.services.avaliacaoProdutoService.AvaliacaoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/avaliacoesProduto")
public class AvaliacaoProdutoController {

    @Autowired
    private AvaliacaoProdutoService avaliacaoProdutoService;

    @PostMapping(value = "/avaliarProduto")
    public ResponseEntity<AvaliacaoProduto> salvarAvaliacao(@RequestBody CadastroAvaliacaoProdutoDTO cadastroAvaliacaoProdutoDTO) {
        AvaliacaoProduto avaliacaoProduto = avaliacaoProdutoService.salvarAvaliacao(cadastroAvaliacaoProdutoDTO);
        return new ResponseEntity<>(avaliacaoProduto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<AvaliacaoProduto>> listarAvaliacoes(Pageable pageable) {
        Page<AvaliacaoProduto> avaliacoes = avaliacaoProdutoService.listarAvaliacoes(pageable);
        return new ResponseEntity<>(avaliacoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoProduto> buscarAvaliacaoPorId(@PathVariable Long id) {
        AvaliacaoProduto avaliacaoProduto = avaliacaoProdutoService.buscarAvaliacaoPorId(id);
        return new ResponseEntity<>(avaliacaoProduto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoProduto> atualizarAvaliacaoProduto(@PathVariable Long id,
                                                                      @RequestBody AtualizarCadastroAvaliacaoDTO atualizarCadastroAvaliacaoDTO) {
        AvaliacaoProduto avaliacaoProduto = avaliacaoProdutoService.atualizarAvaliacaoProduto(id, atualizarCadastroAvaliacaoDTO);
        return new ResponseEntity<>(avaliacaoProduto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        avaliacaoProdutoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
