package com.example.beneficiariotest.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ConsultaOutputDTO {

    private Integer id;
    private LocalDateTime dataConsulta;
    public ConsultaOutputDTO() {

    }

    public ConsultaOutputDTO(Integer id, LocalDateTime dataConsulta) {
        this.id = id;
        this.dataConsulta = dataConsulta;
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

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}
