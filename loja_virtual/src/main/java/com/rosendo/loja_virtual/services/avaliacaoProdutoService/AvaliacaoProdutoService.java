package com.rosendo.loja_virtual.services.avaliacaoProdutoService;

import com.rosendo.loja_virtual.domain.avaliacaoProduto.AtualizarCadastroAvaliacaoDTO;
import com.rosendo.loja_virtual.domain.avaliacaoProduto.AvaliacaoProduto;
import com.rosendo.loja_virtual.domain.avaliacaoProduto.CadastroAvaliacaoProdutoDTO;
import com.rosendo.loja_virtual.repository.avaliacaoProdutoRepository.AvaliacaoProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoProdutoService {
    @Autowired
    private AvaliacaoProdutoRepository avaliacaoProdutoRepository;

    public AvaliacaoProduto salvarAvaliacao(CadastroAvaliacaoProdutoDTO cadastroAvaliacaoProdutoDTO) {
        AvaliacaoProduto avaliacaoProduto = new AvaliacaoProduto(cadastroAvaliacaoProdutoDTO);
        return avaliacaoProdutoRepository.save(avaliacaoProduto);
    }

    public Page<AvaliacaoProduto> listarAvaliacoes(Pageable pageable) {
        return avaliacaoProdutoRepository.findAll(pageable);
    }

    public AvaliacaoProduto buscarAvaliacaoPorId(Long id) {
        return avaliacaoProdutoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Avaliação não encontrada!"));
    }

    public AvaliacaoProduto atualizarAvaliacaoProduto(Long id,
                                                      AtualizarCadastroAvaliacaoDTO atualizarCadastroAvaliacaoDTO) {
        AvaliacaoProduto avaliacaoProduto = this.buscarAvaliacaoPorId(id);
        avaliacaoProduto.atualizarAvaliacaoProduto(atualizarCadastroAvaliacaoDTO);
        return avaliacaoProdutoRepository.save(avaliacaoProduto);
    }

    @Transactional
    public void deletar(Long id) {
        this.buscarAvaliacaoPorId(id);
        avaliacaoProdutoRepository.deleteById(id);
    }
}

