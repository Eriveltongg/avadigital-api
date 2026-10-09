package br.com.avanovadigital.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.avanovadigital.dto.ProdutoRequest;
import br.com.avanovadigital.dto.ProdutoResponse;
import br.com.avanovadigital.exception.RecursoNaoEncontradoException;
import br.com.avanovadigital.model.Produto;
import br.com.avanovadigital.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ProdutoResponse criar(ProdutoRequest dados) {
        Produto produto = new Produto();
        copiar(dados, produto);
        return ProdutoResponse.de(repository.save(produto));
    }

    @Transactional(readOnly = true)
    public List<ProdutoResponse> listar() {
        return repository.findAll().stream().map(ProdutoResponse::de).toList();
    }

    @Transactional(readOnly = true)
    public ProdutoResponse buscar(Long id) {
        return ProdutoResponse.de(obter(id));
    }

    @Transactional
    public ProdutoResponse atualizar(Long id, ProdutoRequest dados) {
        Produto produto = obter(id);
        copiar(dados, produto);
        return ProdutoResponse.de(repository.save(produto));
    }

    @Transactional
    public void excluir(Long id) {
        repository.delete(obter(id));
    }

    private Produto obter(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado: id " + id));
    }

    private void copiar(ProdutoRequest dados, Produto produto) {
        produto.setNome(dados.nome());
        produto.setDescricao(dados.descricao());
        produto.setPreco(dados.preco());
        produto.setQuantidade(dados.quantidade());
    }
}
