package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dependente {
    
    //chave primária, auto_increment
    @Id @GeneratedValue
    private Long idDependente;
    private String nomeDependente;

    //Funcionario titular
    @ManyToOne
    @JoinColumn(name="func_id", nullable = false)
    private Funcionario funcionarioTitular;

    public Dependente()
    {

    }

    public Long getIdDependente()
    {
        return idDependente;
    }
    public void setIdDependente(Long idDependente)
    {
        this.idDependente = idDependente;
    }
    public String getNomeDependente()
    {
        return nomeDependente;
    }
    public void setNomeDependente(String nomeDependente)
    {
        this.nomeDependente = nomeDependente;
    }

    public Funcionario getFuncionarioTitular()
    {
        return funcionarioTitular;
    }
    public void setFuncionarioTitular(Funcionario funcionarioTitular)
    {
        this.funcionarioTitular = funcionarioTitular;
    }
}
