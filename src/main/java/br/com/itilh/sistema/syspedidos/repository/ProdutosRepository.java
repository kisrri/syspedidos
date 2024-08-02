package br.com.itilh.sistema.syspedidos.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.itilh.sistema.syspedidos.model.Produtos;

@Repository
public interface ProdutosRepository extends CrudRepository<Produtos, BigInteger> {
    
}

