package com.example.beneficiariotest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbespecialidade")
public class Especialidade {

    @Id
    @Column(name = "COD_ESPECIALIDADE")
    private Integer id;

    @Column(name = "NM_ESPECIALIDADE")
    private String nome;

    public Especialidade() {

    }

    public Especialidade(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeEspecialidade) {
        this.nome = nomeEspecialidade;
    }
}
