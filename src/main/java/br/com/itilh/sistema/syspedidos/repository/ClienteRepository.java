package br.com.itilh.sistema.syspedidos.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.itilh.sistema.syspedidos.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, BigInteger> {

}