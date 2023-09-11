package com.example.beneficiariotest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class BeneficiarioInputDTO {
    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "^[0-9]{11}$", message = "CPF deve ter 11 numeros")
    private String cpf;

    @JsonProperty("nome")
    @NotBlank(message = "Nome do Beneficiario is required")
    private String nomeBeneficiario;

    @JsonProperty("data-nascimento")
    @NotNull(message = "Data de Nascimento is required")
    private LocalDate dataNascimento;

    public BeneficiarioInputDTO(String cpf, String nomeBeneficiario, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.nomeBeneficiario = nomeBeneficiario;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeBeneficiario() {
        return nomeBeneficiario;
    }

    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
