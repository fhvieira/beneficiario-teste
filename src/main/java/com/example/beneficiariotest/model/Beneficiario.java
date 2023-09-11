package com.example.beneficiariotest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
@Table(name = "tbbeneficiario")
public class Beneficiario {

    @Id
    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "^[0-9]{11}$", message = "CPF deve ter 11 numeros")
    private String cpf;

    @NotBlank(message = "Nome do Beneficiario é obrigatório")
    @Column(name = "NM_BENEFICIARIO", length = 55)
    private String nomeBeneficiario;

    @NotNull(message = "Data de Nascimento é obrigatório")
    @Column(name = "DT_NASCIMENTO")
    private LocalDate dataNascimento;

    public Beneficiario() {

    }

    public Beneficiario(String cpf, String nomeBeneficiario, LocalDate dataNascimento) {
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
