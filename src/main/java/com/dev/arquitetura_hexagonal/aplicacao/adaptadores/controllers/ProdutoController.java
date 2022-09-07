package com.dev.arquitetura_hexagonal.aplicacao.adaptadores.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;
import com.dev.arquitetura_hexagonal.dominio.dtos.EstoqueDTO;
import com.dev.arquitetura_hexagonal.dominio.dtos.ProdutoDTO;
import com.dev.arquitetura_hexagonal.dominio.portas.interfaces.ProdutoServicePort;

@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    void criarProdutos(@RequestBody ProdutoDTO produtoDTO) {
        produtoServicePort.criarProduto(produtoDTO);
    }

    @GetMapping
    List<ProdutoDTO> getProdutos() {
        return produtoServicePort.buscarProdutos();
    }

    @PutMapping(value = "/{sku}")
    void atualizarEstoque(@PathVariable String sku, @RequestBody EstoqueDTO estoqueDTO) throws NotFoundException {
        produtoServicePort.atualizarEstoque(sku, estoqueDTO);
    }

}
