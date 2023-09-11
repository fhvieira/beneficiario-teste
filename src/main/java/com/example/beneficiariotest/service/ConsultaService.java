package com.example.beneficiariotest.service;

import com.example.beneficiariotest.dto.ConsultaInputDTO;
import com.example.beneficiariotest.model.Consulta;

import java.util.List;

public interface ConsultaService {

    void salvar(ConsultaInputDTO consulta);

    void reset();

    List<Consulta> listarTodos();
}
