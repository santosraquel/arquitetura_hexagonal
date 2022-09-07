package com.dev.arquitetura_hexagonal.dominio.portas.repositories;

import java.util.List;

import com.dev.arquitetura_hexagonal.dominio.Produto;

public interface ProdutoRepositoryPort {
    List<Produto> buscarTodos();

    Produto buscarPeloSku(String sku);

    void salvar(Produto produto);
}
