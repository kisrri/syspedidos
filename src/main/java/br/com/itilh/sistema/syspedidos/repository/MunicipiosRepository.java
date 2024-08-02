package br.com.itilh.sistema.syspedidos.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.itilh.sistema.syspedidos.model.Municipios;

@Repository
public interface MunicipiosRepository extends CrudRepository<Municipios , BigInteger > {

    List<Municipios> findByEstadosId(BigInteger id);
    List<Municipios> findByEstadosNomeIgnoreCase(String nome);


}