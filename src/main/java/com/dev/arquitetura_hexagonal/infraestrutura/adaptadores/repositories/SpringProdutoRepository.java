package com.dev.arquitetura_hexagonal.infraestrutura.adaptadores.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.arquitetura_hexagonal.infraestrutura.adaptadores.entidades.ProdutoEntity;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {
    Optional<ProdutoEntity> findBySku(String sku);
}