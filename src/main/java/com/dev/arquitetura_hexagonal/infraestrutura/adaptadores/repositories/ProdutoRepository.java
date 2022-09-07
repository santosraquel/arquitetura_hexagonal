package com.dev.arquitetura_hexagonal.infraestrutura.adaptadores.repositories;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.dev.arquitetura_hexagonal.dominio.Produto;
import com.dev.arquitetura_hexagonal.dominio.portas.repositories.ProdutoRepositoryPort;
import com.dev.arquitetura_hexagonal.infraestrutura.adaptadores.entidades.ProdutoEntity;

public class ProdutoRepository implements ProdutoRepositoryPort {
    private final SpringProdutoRepository springProdutoRepository;

    public ProdutoRepository(SpringProdutoRepository springProdutoRepository) {
        this.springProdutoRepository = springProdutoRepository;
    }

    @Override
    public List<Produto> buscarTodos() {
        List<ProdutoEntity> produtoEntities = this.springProdutoRepository.findAll();
        return produtoEntities.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
    }

    @Override
    public Produto buscarPeloSku(String sku) {
        Optional<ProdutoEntity> produtoEntity = this.springProdutoRepository.findBySku(sku);

        if (produtoEntity.isPresent())
            return produtoEntity.get().toProduto();

        throw new RuntimeException("Produto não existe");
    }

    @Override
    public void salvar(Produto produto) {
        ProdutoEntity produtoEntity;
        if (Objects.isNull(produto.getCodigo()))
            produtoEntity = new ProdutoEntity(produto);
        else {
            produtoEntity = this.springProdutoRepository.findById(produto.getCodigo()).get();
            produtoEntity.atualizar(produto);
        }

        this.springProdutoRepository.save(produtoEntity);
    }
}
