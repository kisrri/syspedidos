package br.com.itilh.sistema.syspedidos.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.itilh.sistema.syspedidos.model.Estados;

@Repository
public interface EstadosRepository extends CrudRepository<Estados, BigInteger> {

    List<Estados> findByNome(String nome);

    List<Estados> findByNomeStartingWithIgnoreCase(String nome);

    List<Estados> findByNomeEndingWithIgnoreCase(String nome);

    List<Estados> findByNomeContainingIgnoreCase(String nome);

    @Query("FROM Estados e WHERE e.nome like %?1")
    List<Estados> findByMinhaQuery(String nome);
}
