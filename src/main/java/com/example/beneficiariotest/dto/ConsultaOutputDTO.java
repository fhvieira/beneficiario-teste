package com.example.beneficiariotest.dto;

import java.time.LocalDateTime;

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
