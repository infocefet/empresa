package com.example.demo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.Funcionario;
import com.example.demo.repositories.FuncionarioRepository;

@RestController
public class FuncionarioController {
    
    @Autowired
    private final FuncionarioRepository repository;

    public FuncionarioController(FuncionarioRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/funcionario")
    List<Funcionario> all() {
        //faz um select * from funcionario;
        return repository.findAll();
    }

    @PostMapping("/funcionario")
    ResponseEntity<Funcionario> save(@RequestBody Funcionario funcionario)
    {
        //faz um insert na tabela Funcionario
        repository.save(funcionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
          .path("/funcionario/{id}")
          .buildAndExpand(funcionario.getId())
          .toUri();

        return ResponseEntity.created(uri) //status 201 CREATED
          .body(funcionario);
        
    }

    @DeleteMapping("/funcionario/{id}")
    ResponseEntity<Funcionario> deleteFuncionario(@PathVariable Long id)
    {
        //Procuro um funcionario com esse id
        Optional<Funcionario> foundedFunc = repository.findById(id);
        if(foundedFunc.isPresent()) //verifica se a consulta retornou algum func diferente de null
        {
             //se ele existir, eu deleto
             repository.deleteById(id);
             //e retorno status = OK 200 
             return ResponseEntity.ok(foundedFunc.get()); 
        }
        //se não há nenhum funcionario com este id, retorno HTTP CODE 404= NOT FOUND
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable(value = "id") Long funcId, 
                                                   @RequestBody Funcionario updatedFunc)
    {
        Optional<Funcionario> foundedFunc = repository.findById(funcId);
        if(foundedFunc.isPresent()) //verifica se a consulta retornou algum func diferente de null
        {
            //atualizo os dados do func em memória com o os dados novos que recebi no JSON
            foundedFunc.get().setNome(updatedFunc.getNome());
            foundedFunc.get().setCargo(updatedFunc.getCargo());

            //salva as alterações deste func no BD
            repository.save(foundedFunc.get());

            //retorna ok (HTTP CODE 200 e retorno os dados atualizados)
            return ResponseEntity.ok(foundedFunc.get());
        }

        //se não há nenhum funcionario com este id, retorno HTTP CODE 404= NOT FOUND
        return ResponseEntity.notFound().build();
        
    }
}
