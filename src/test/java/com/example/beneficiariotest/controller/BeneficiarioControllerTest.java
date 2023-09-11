package com.example.beneficiariotest.controller;

import com.example.beneficiariotest.dto.BeneficiarioInputDTO;
import com.example.beneficiariotest.dto.BeneficiarioOutputDTO;
import com.example.beneficiariotest.model.Beneficiario;
import com.example.beneficiariotest.service.BeneficiarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BeneficiarioControllerTest {
    @InjectMocks
    private BeneficiarioController beneficiarioController;

    @Mock
    private BeneficiarioService beneficiarioService;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void testGetAllBeneficiarios() {
        Beneficiario beneficiario1 = new Beneficiario("123456789-12", "John Doe",
                LocalDate.now().minusYears(20));

        Beneficiario beneficiario2 = new Beneficiario("111111111-12", "Jane doe",
                LocalDate.now().minusYears(18));

        List<Beneficiario> beneficiarios = Arrays.asList(beneficiario1, beneficiario2);

        when(beneficiarioService.listarTodos()).thenReturn(beneficiarios);

        ResponseEntity<List<BeneficiarioOutputDTO>> response = beneficiarioController.listar();

        verify(beneficiarioService, times(1)).listarTodos();

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<BeneficiarioOutputDTO> responseBody = response.getBody();

        assertEquals(2, responseBody.size());
    }

    @Test
    public void testBuscarBeneficiarioByCpf() {
        String expectedCpf = "123456789-12";
        String excpectedNome = "John Doe";
        LocalDate expectedDataNascimento = LocalDate.now().minusYears(20);

        Beneficiario beneficiario = new Beneficiario(expectedCpf, excpectedNome, expectedDataNascimento);
        BeneficiarioOutputDTO beneficiarioOutput = new BeneficiarioOutputDTO(expectedCpf, excpectedNome,
                expectedDataNascimento);

        when(beneficiarioService.buscarPorCpfOrThrow(expectedCpf)).thenReturn(beneficiario);

        when(modelMapper.map(any(Beneficiario.class), eq(BeneficiarioOutputDTO.class)))
                .thenReturn(beneficiarioOutput);

        ResponseEntity<BeneficiarioOutputDTO> response = beneficiarioController.buscar(expectedCpf);

        verify(beneficiarioService, times(1)).buscarPorCpfOrThrow(expectedCpf);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        BeneficiarioOutputDTO output = response.getBody();

        assertEquals(expectedCpf, output.getCpf());
        assertEquals(excpectedNome, output.getNomeBeneficiario());
        assertEquals(expectedDataNascimento, output.getDataNascimento());
    }

    @Test
    public void testAdicionarNovoBeneficiario() {
        BeneficiarioInputDTO beneficiarioInputDTO = new BeneficiarioInputDTO("123456789-12",
                "John Doe", LocalDate.now().minusYears(20));

        ResponseEntity<Void> response = beneficiarioController.adicionar(beneficiarioInputDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testReset() {
        ResponseEntity<Void> response = beneficiarioController.reset();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}