package com.example.beneficiariotest.service;

import com.example.beneficiariotest.dto.ConsultaInputDTO;
import com.example.beneficiariotest.model.Consulta;
import com.example.beneficiariotest.model.Especialidade;
import com.example.beneficiariotest.repository.ConsultaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultaServiceImplTest {
    @InjectMocks
    ConsultaServiceImpl consultaService;

    @Mock
    private ConsultaRepository repository;

    @Mock
    private ModelMapper modelMapper;

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
        ConsultaInputDTO input = new ConsultaInputDTO();
        Consulta consultaToSave = mock(Consulta.class);
        Consulta savedConsulta = mock(Consulta.class);
        Especialidade especialidade = new Especialidade();

        input.setNomeEspecialidade("NomeEspecialidade");

        when(modelMapper.map(input, Consulta.class)).thenReturn(consultaToSave);
        when(especialidadeService.buscarPorNomeOrThrow(input.getNomeEspecialidade())).thenReturn(especialidade);
        when(repository.save(consultaToSave)).thenReturn(savedConsulta);

        Consulta result = consultaService.salvar(input);

        verify(repository, times(1)).save(consultaToSave);

        assertEquals(savedConsulta, result);
    }

    @Test
    void testReset() {
        doNothing().when(repository).deleteAll();

        consultaService.reset();

        verify(repository, times(1)).deleteAll();
    }
}