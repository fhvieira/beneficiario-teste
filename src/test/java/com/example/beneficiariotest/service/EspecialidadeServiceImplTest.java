package com.example.beneficiariotest.service;

import com.example.beneficiariotest.model.Especialidade;
import com.example.beneficiariotest.repository.EspecialidadeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EspecialidadeServiceImplTest {
    @InjectMocks
    EspecialidadeServiceImpl especialidadeService;

    @Mock
    private EspecialidadeRepository repository;

    @Test
    void listarTodos() {
        List<Especialidade> especialidades = List.of(new Especialidade());

        when(repository.findAll()).thenReturn(especialidades);

        List<Especialidade> result = especialidadeService.listarTodos();

        assertEquals(1, result.size());
    }

    @Test
    void buscarPorNome() {
    }

    @Test
    void buscarPorNomeOrThrow() {
    }
}