package com.example.beneficiariotest.controller;

import com.example.beneficiariotest.dto.EspecialidadeOutputDTO;
import com.example.beneficiariotest.model.Especialidade;
import com.example.beneficiariotest.service.EspecialidadeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {
    private final EspecialidadeService especialidadeService;
    private final ModelMapper modelMapper;

    public EspecialidadeController(EspecialidadeService especialidadeService, ModelMapper modelMapper) {
        this.especialidadeService = especialidadeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<EspecialidadeOutputDTO>> listar() {
        List<Especialidade> especialidades = especialidadeService.listarTodos();

        List<EspecialidadeOutputDTO> outpub = especialidades.stream()
                        .map(especialidade -> modelMapper.map(especialidade, EspecialidadeOutputDTO.class))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(outpub, HttpStatus.OK);
    }

}
