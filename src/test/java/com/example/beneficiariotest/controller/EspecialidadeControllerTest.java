package com.example.beneficiariotest.controller;

import com.example.beneficiariotest.dto.EspecialidadeOutputDTO;
import com.example.beneficiariotest.model.Especialidade;
import com.example.beneficiariotest.service.EspecialidadeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EspecialidadeControllerTest {
    @InjectMocks
    private EspecialidadeController especialidadeController;

    @Mock
    private EspecialidadeService especialidadeService;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void listar() {
        Especialidade especialidade1 = new Especialidade();
        Especialidade especialidade2 = new Especialidade();

        List<Especialidade> especialidades = Arrays.asList(especialidade1, especialidade2);

        when(especialidadeService.listarTodos()).thenReturn(especialidades);

        ResponseEntity<List<EspecialidadeOutputDTO>> response = especialidadeController.listar();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}