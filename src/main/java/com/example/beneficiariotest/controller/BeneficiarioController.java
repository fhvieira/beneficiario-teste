package com.example.beneficiariotest.controller;

import com.example.beneficiariotest.dto.BeneficiarioInputDTO;
import com.example.beneficiariotest.dto.BeneficiarioOutputDTO;
import com.example.beneficiariotest.model.Beneficiario;
import com.example.beneficiariotest.service.BeneficiarioService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {
    private final BeneficiarioService beneficiarioService;
    private final ModelMapper modelMapper;

    public BeneficiarioController(BeneficiarioService beneficiarioService, ModelMapper modelMapper) {
        this.beneficiarioService = beneficiarioService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<BeneficiarioOutputDTO>> listar() {
        List<Beneficiario> beneficiarios = beneficiarioService.listarTodos();

        List<BeneficiarioOutputDTO> dtoList = beneficiarios.stream()
                        .map(beneficiario -> modelMapper.map(beneficiario, BeneficiarioOutputDTO.class))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<BeneficiarioOutputDTO> buscar(@PathVariable String cpf) {
        Beneficiario beneficiario = beneficiarioService.buscarPorCpfOrThrow(cpf);

        BeneficiarioOutputDTO output = modelMapper.map(beneficiario, BeneficiarioOutputDTO.class);

        return ResponseEntity.ok(output);
    }

    @PostMapping
    public ResponseEntity<Void> adicionar(@Valid @RequestBody BeneficiarioInputDTO input) {
        Beneficiario beneficiario = modelMapper.map(input, Beneficiario.class);

        beneficiarioService.salvar(beneficiario);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/reset")
    public ResponseEntity<Void> reset() {
        beneficiarioService.reset();

        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
