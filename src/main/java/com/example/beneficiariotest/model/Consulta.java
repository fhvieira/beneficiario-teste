package com.example.beneficiariotest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbconsulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CONSULTA")
    private Integer id;

    @Column(name = "CPF_BENEFICIARIO")
    private String cpfBeneficiario;

    @Column(name = "COD_ESPECIALIDADE")
    private Integer codigoEspecialidade;

    @NotNull(message = "Data da consulta deve ser informado")
    @Column(name = "DATA_HORA_CONSULTA")
    private LocalDateTime dataConsulta;

    public Consulta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataHoraConsulta) {
        this.dataConsulta = dataHoraConsulta;
    }

    public String getCpfBeneficiario() {
        return cpfBeneficiario;
    }

    public void setCpfBeneficiario(String cpfBeneficiario) {
        this.cpfBeneficiario = cpfBeneficiario;
    }

    public Integer getCodigoEspecialidade() {
        return codigoEspecialidade;
    }

    public void setCodigoEspecialidade(Integer codigoEspecialidade) {
        this.codigoEspecialidade = codigoEspecialidade;
    }
}
