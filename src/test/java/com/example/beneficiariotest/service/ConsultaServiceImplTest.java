package com.example.beneficiariotest.service;

import com.example.beneficiariotest.model.Beneficiario;
import com.example.beneficiariotest.model.Consulta;
import com.example.beneficiariotest.repository.ConsultaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultaServiceImplTest {
    @InjectMocks
    ConsultaServiceImpl consultaService;

    @Mock
    private ConsultaRepository repository;

    @Mock
    private BeneficiarioService beneficiarioService;

    @Mock
    private EspecialidadeService especialidadeService;

    @Test
    void testListarTodos() {
        List<Consulta> consultas = List.of(new Consulta());

        when(repository.findAll()).thenReturn(consultas);

        List<Consulta> result = consultaService.listarTodos();

        assertEquals(1, result.size());
    }

    @Test
    void testSalvar() {
    }

    @Test
    void testReset() {
        consultaService.reset();
    }
}