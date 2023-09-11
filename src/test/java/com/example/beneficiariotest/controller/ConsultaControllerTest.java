package com.example.beneficiariotest.controller;

import com.example.beneficiariotest.dto.BeneficiarioOutputDTO;
import com.example.beneficiariotest.dto.ConsultaInputDTO;
import com.example.beneficiariotest.dto.ConsultaOutputDTO;
import com.example.beneficiariotest.model.Consulta;
import com.example.beneficiariotest.service.ConsultaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultaControllerTest {
    @InjectMocks
    private ConsultaController consultaController;

    @Mock
    private ConsultaService consultaService;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void testAdicionarConsulta() {
        ConsultaInputDTO consulta = new ConsultaInputDTO();

        ResponseEntity<Void> response = consultaController.adicionar(consulta);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void testListarConsultas() {
        Consulta consulta = new Consulta();
        consulta.setId(123);
        consulta.setDataConsulta(LocalDateTime.now());

        List<Consulta> consultas = List.of(consulta);

        when(consultaService.listarTodos()).thenReturn(consultas);

        ResponseEntity<List<ConsultaOutputDTO>> response = consultaController.listar();

        List<ConsultaOutputDTO> responseBody = response.getBody();

        assertEquals(1, responseBody.size());
    }

    @Test
    public void testReset() {
        ResponseEntity<Void> response = consultaController.reset();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}