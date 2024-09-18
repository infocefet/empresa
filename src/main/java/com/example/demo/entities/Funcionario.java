package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity //Entidade, ou seja, vai criar tabela correspondente
public class Funcionario {

    //chave primária, auto_increment
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String cargo;

    @OneToMany(mappedBy="funcionarioTitular", cascade = CascadeType.PERSIST)
    private List<Dependente> listaDependentes;


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
    public List<Dependente> getListaDependentes()
    {
        return listaDependentes;
    }

    @Override
    public String toString() {
     return "Funcionario{" + "id=" + this.id + ", name='" + this.nome + '\'' + ", role='" + this.cargo + '\'' + '}';
    }

}
