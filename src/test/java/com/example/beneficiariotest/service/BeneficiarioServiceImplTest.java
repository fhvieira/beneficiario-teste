package com.example.beneficiariotest.service;

import com.example.beneficiariotest.exception.BeneficiarioAlreadyExistsException;
import com.example.beneficiariotest.exception.BeneficiarioNotFoundException;
import com.example.beneficiariotest.model.Beneficiario;
import com.example.beneficiariotest.repository.BeneficiarioReposiroty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BeneficiarioServiceImplTest {
    @InjectMocks
    BeneficiarioServiceImpl service;

    @Mock
    private BeneficiarioReposiroty repository;

    @Test
    void givenAnNotFoundCpf_whenCallingBuscarPorCpfOrThrow_thenReturnNotFoundException() {
        when(repository.findById(anyString())).thenReturn(Optional.empty());

        assertThrows(BeneficiarioNotFoundException.class, () -> service.buscarPorCpfOrThrow(anyString()));
    }

    @Test
    void testBuscarPorCpfOrThrow() {
        String cpf = "12345678912";
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setCpf(cpf);

        when(repository.findById(cpf)).thenReturn(Optional.of(beneficiario));

        Beneficiario result = service.buscarPorCpfOrThrow("12345678912");

        assertEquals(cpf, result.getCpf());
    }

    @Test
    void testListarTodos() {
        List<Beneficiario> beneficiarios = List.of(new Beneficiario());

        when(repository.findAll()).thenReturn(beneficiarios);

        List<Beneficiario> result = service.listarTodos();

        assertEquals(1, result.size());
    }

    @Test
    void testReset() {
        service.reset();
    }

    @Test
    void givenAnExistingCpf_whenCallingSalvar_thenReturnBeneficiarioJaCadastradoException() {
        String cpf = "12345678912";
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setCpf("12345678912");

        when(repository.findById(cpf)).thenReturn(Optional.of(beneficiario));

        assertThrows(BeneficiarioAlreadyExistsException.class, () -> service.salvar(beneficiario));
    }

    @Test
    void testSalvar() {
        Beneficiario beneficiario = mock(Beneficiario.class);

        service.salvar(beneficiario);
    }

}