package com.dev.arquitetura_hexagonal.dominio.adaptadores.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.dev.arquitetura_hexagonal.dominio.Produto;
import com.dev.arquitetura_hexagonal.dominio.dtos.EstoqueDTO;
import com.dev.arquitetura_hexagonal.dominio.dtos.ProdutoDTO;
import com.dev.arquitetura_hexagonal.dominio.portas.interfaces.ProdutoServicePort;
import com.dev.arquitetura_hexagonal.dominio.portas.repositories.ProdutoRepositoryPort;

public class PedidoServiceImp implements ProdutoServicePort {
    private final ProdutoRepositoryPort produtoRepository;

    public PedidoServiceImp(ProdutoRepositoryPort produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepository.salvar(produto);
    }

    @Override
    public List<ProdutoDTO> buscarProdutos() {
        List<Produto> produtos = this.produtoRepository.buscarTodos();
        List<ProdutoDTO> produtoDTOS = produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
        return produtoDTOS;
    }

    @Override
    public void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws NotFoundException {
        Produto produto = this.produtoRepository.buscarPeloSku(sku);

        if (Objects.isNull(produto))
            throw new NotFoundException("Produto não encontrado");

        produto.atualizarEstoque(estoqueDTO.getQuantidade());

        this.produtoRepository.salvar(produto);
    }
}
