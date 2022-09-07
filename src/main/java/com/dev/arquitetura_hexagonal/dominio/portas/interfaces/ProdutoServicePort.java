package com.dev.arquitetura_hexagonal.dominio.portas.interfaces;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.dev.arquitetura_hexagonal.dominio.dtos.EstoqueDTO;
import com.dev.arquitetura_hexagonal.dominio.dtos.ProdutoDTO;

public interface ProdutoServicePort {
    List<ProdutoDTO> buscarProdutos();

    void criarProduto(ProdutoDTO produtoDTO);

    void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws NotFoundException;
}
