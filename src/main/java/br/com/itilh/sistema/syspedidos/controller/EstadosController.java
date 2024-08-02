package br.com.itilh.sistema.syspedidos.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.itilh.sistema.syspedidos.model.Estados;
import br.com.itilh.sistema.syspedidos.repository.EstadosRepository;
import br.com.itilh.sistema.syspedidos.util.ModoBusca;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class EstadosController {

    private final EstadosRepository repositorio;

    public EstadosController(EstadosRepository repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/estados")
    public List<Estados> getTodos() {
        return  (List<Estados>) repositorio.findAll();
    }

    @GetMapping("/estados/nome/{nome}")
    public List<Estados> getEstadosPorNome(@PathVariable String nome, @RequestParam(required = true) ModoBusca modoBusca) {
        if(modoBusca.equals(ModoBusca.EXATO)){
            return repositorio.findByNome(nome);
        }else if (modoBusca.equals(ModoBusca.INICIADO)){
            return repositorio.findByNomeStartingWithIgnoreCase(nome);
        }else if (modoBusca.equals(ModoBusca.FINALIZADO)){
            return repositorio.findByNomeEndingWithIgnoreCase(nome);
        }else{
            return repositorio.findByNomeContainingIgnoreCase(nome);
        }
    }
    
    @GetMapping("/estados/{id}")
    public Optional<Estados> getPorId(@PathVariable BigInteger id) {
        return repositorio.findById(id);
    }
    
    @PostMapping("/estados")
    public Estados postEstados(@RequestBody Estados entity) {
        return repositorio.save(entity);
    }
    
    @PutMapping("/estados/{id}")
    public Estados alterarEstados(@PathVariable BigInteger id, @RequestBody Estados novosDados) {
        Optional<Estados> estadosArmazenado = repositorio.findById(id);
        if(estadosArmazenado.isPresent()){
            estadosArmazenado.get().setNome(novosDados.getNome());
            return repositorio.save(estadosArmazenado.get());
        }
        return null;
    }
    
    @DeleteMapping("/estados/{id}")
    public String deletePorId(@PathVariable BigInteger id) {
        Optional<Estados> estadosArmazenado = repositorio.findById(id);
        if(estadosArmazenado.isPresent()){
            repositorio.delete(estadosArmazenado.get());
            return "Excluido";
        }
        return "Não excluido";
    }
}
