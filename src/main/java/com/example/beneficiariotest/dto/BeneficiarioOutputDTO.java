package com.example.beneficiariotest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class BeneficiarioOutputDTO {
    private String cpf;

    @JsonProperty("nome")
    private String nomeBeneficiario;

    @JsonProperty("data-nascimento")
    private LocalDate dataNascimento;

    public BeneficiarioOutputDTO() {
    }

    public BeneficiarioOutputDTO(String cpf, String nomeBeneficiario, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.nomeBeneficiario = nomeBeneficiario;
        this.dataNascimento = dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeBeneficiario() {
        return nomeBeneficiario;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
