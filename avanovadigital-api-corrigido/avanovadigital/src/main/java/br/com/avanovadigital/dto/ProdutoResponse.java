package br.com.avanovadigital.dto;

import java.math.BigDecimal;

import br.com.avanovadigital.model.Produto;

public record ProdutoResponse(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer quantidade) {

    public static ProdutoResponse de(Produto p) {
        return new ProdutoResponse(p.getId(), p.getNome(), p.getDescricao(), p.getPreco(), p.getQuantidade());
    }
}
