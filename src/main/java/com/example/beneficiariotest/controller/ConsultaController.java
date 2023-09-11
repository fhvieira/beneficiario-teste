package com.example.beneficiariotest.controller;

import com.example.beneficiariotest.dto.ConsultaInputDTO;
import com.example.beneficiariotest.dto.ConsultaOutputDTO;
import com.example.beneficiariotest.model.Consulta;
import com.example.beneficiariotest.service.ConsultaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    private final ConsultaService consultaService;

    private final ModelMapper modelMapper;

    public ConsultaController(ConsultaService consultaService, ModelMapper modelMapper) {
        this.consultaService = consultaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<ConsultaOutputDTO>> listar() {
        List<Consulta> consultas = consultaService.listarTodos();

        List<ConsultaOutputDTO> output = consultas.stream()
                .map(consulta -> modelMapper.map(consulta, ConsultaOutputDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> adicionar(@Valid @RequestBody ConsultaInputDTO input) {
        consultaService.salvar(input);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/reset")
    public ResponseEntity<Void> reset() {
        consultaService.reset();

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
