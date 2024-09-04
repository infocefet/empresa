package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    Funcionario save(@RequestBody Funcionario funcionario)
    {
        //faz um insert na tabela Funcionario
        return repository.save(funcionario);
    }
}
