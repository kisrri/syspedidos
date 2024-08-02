package br.com.itilh.sistema.syspedidos.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.itilh.sistema.syspedidos.model.Municipios;
import br.com.itilh.sistema.syspedidos.repository.MunicipiosRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class MunicipiosController {

    private final MunicipiosRepository repositorio;

    public MunicipiosController (MunicipiosRepository repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/municipios")
    public List<Municipios> getMunicipios() {
        return (List<Municipios>) repositorio.findAll();
    }

    @GetMapping("/municipios/{id}")
    public Municipios getMunicipioPorId(@PathVariable BigInteger id) throws Exception {
        return repositorio.findById(id)
        .orElseThrow(()-> new Exception("Id não encontrado."));
    }

    @PostMapping("/municipios")
    public Municipios postMunicipio(@RequestBody Municipios entity) throws Exception {    
        try{ 
            return repositorio.save(entity);
        }catch (Exception ex){
            throw new Exception("Não foi possível criar o município." + ex.getMessage());
        }
    }

    @PutMapping("/municipios/{id}")
    public Municipios putMunicipio(@PathVariable BigInteger id, @RequestBody Municipios entity) throws Exception {
        try{ 
            return repositorio.save(entity);
        }catch (Exception ex){
            throw new Exception("Não foi possível alterar o município." + ex.getMessage());
        }
    }

    @DeleteMapping("/municipios/{id}")
    public String deleteMunicipio(@PathVariable BigInteger id) throws Exception{
        try{ 
             repositorio.deleteById(id);
             return "Excluído";
        }catch (Exception ex){
            throw new Exception("Não foi possível excluir o id informado." + ex.getMessage());
        }
    }
    
}
