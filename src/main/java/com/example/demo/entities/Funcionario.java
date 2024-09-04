package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity //Entidade, ou seja, vai criar tabela correspondente
public class Funcionario {

    //chave primária, auto_increment
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String cargo;

    //sempre crie o construtor padrão nas entidades
    //exigência do SpringBoot
    public Funcionario()
    {

    }
    public Funcionario(String nome, String cargo)
    {
        this.nome = nome;
        this.cargo = cargo;
    }
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public String getCargo()
    {
        return cargo;
    }
    public void setCargo(String cargo)
    {
        this.cargo = cargo;
    }
    
    @Override
    public String toString() {
     return "Funcionario{" + "id=" + this.id + ", name='" + this.nome + '\'' + ", role='" + this.cargo + '\'' + '}';
    }

}
