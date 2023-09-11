package com.example.beneficiariotest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public class ConsultaInputDTO {
    @Pattern(regexp = "^[0-9]{11}$", message = "CPF deve ter 11 numeros")
    @NotBlank(message = "Cpf do beneficiário deve ser informado")
    private String cpfBeneficiario;

    @NotBlank(message = "Nome da especialidade deve ser informado")
    private String nomeEspecialidade;

    @NotNull(message = "Data e hora da consulta devem ser informados")
    private LocalDateTime dataConsulta;

    public ConsultaInputDTO() {

    }

    public ConsultaInputDTO(String cpfBeneficiario, String nomeEspecialidade, LocalDateTime dataConsulta) {
        this.cpfBeneficiario = cpfBeneficiario;
        this.nomeEspecialidade = nomeEspecialidade;
        this.dataConsulta = dataConsulta;
    }

    public String getCpfBeneficiario() {
        return cpfBeneficiario;
    }

    public void setCpfBeneficiario(String cpfBeneficiario) {
        this.cpfBeneficiario = cpfBeneficiario;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}
