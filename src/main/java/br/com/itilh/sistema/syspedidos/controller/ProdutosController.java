package br.com.itilh.sistema.syspedidos.controller;

import br.com.itilh.sistema.syspedidos.model.Produtos;
import br.com.itilh.sistema.syspedidos.repository.ProdutosRepository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class ProdutosController {

    private final ProdutosRepository repositorio;

    public ProdutosController (ProdutosRepository repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/produtos")
    public List<Produtos> getProdutos() {
        return (List<Produtos>) repositorio.findAll();
    }

    @GetMapping("/produtos/{id}")
    public Produtos getPordutosPorId(@PathVariable BigInteger id) throws Exception {
        return repositorio.findById(id)
        .orElseThrow(()-> new Exception("Id não encontrado."));
    }

    @PostMapping("/produtos")
    public Produtos postProdutos(@RequestBody Produtos entity) throws Exception {    
        try{ 
            return repositorio.save(entity);
        }catch (Exception ex){
            throw new Exception("Não foi possível criar o produto." + ex.getMessage());
        }
    }

    @PutMapping("/produtos/{id}")
    public Produtos putProdutos(@PathVariable BigInteger id, @RequestBody Produtos entity) throws Exception {
        try{ 
            return repositorio.save(entity);
        }catch (Exception ex){
            throw new Exception("Não foi possível alterar o produto." + ex.getMessage());
        }
    }

    @DeleteMapping("/produtos/{id}")
    public String deleteProdutos(@PathVariable BigInteger id) throws Exception{
        try{ 
             repositorio.deleteById(id);
             return "Excluído";
        }catch (Exception ex){
            throw new Exception("Não foi possível excluir o id informado." + ex.getMessage());
        }
    }

    
}