package com.dev.arquitetura_hexagonal.infraestrutura.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dev.arquitetura_hexagonal.dominio.adaptadores.services.PedidoServiceImp;
import com.dev.arquitetura_hexagonal.dominio.portas.interfaces.ProdutoServicePort;
import com.dev.arquitetura_hexagonal.dominio.portas.repositories.ProdutoRepositoryPort;

@Configuration
public class BeanConfiguracao {
    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new PedidoServiceImp(produtoRepositoryPort);
    }
}
