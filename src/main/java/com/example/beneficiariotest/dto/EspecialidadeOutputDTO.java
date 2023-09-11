package com.example.beneficiariotest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EspecialidadeOutputDTO {
    @JsonProperty("codigo-especialidade")
    private Integer id;

    @JsonProperty("nome-especialidade")
    private String nomeEspecialidade;

    public EspecialidadeOutputDTO(Integer id, String nomeEspecialidade) {
        this.id = id;
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public EspecialidadeOutputDTO() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }
}
