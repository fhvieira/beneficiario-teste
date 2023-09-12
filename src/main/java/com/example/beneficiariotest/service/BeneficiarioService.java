package com.example.beneficiariotest.service;

import com.example.beneficiariotest.model.Beneficiario;

import java.util.List;

public interface BeneficiarioService {
    List<Beneficiario> listarTodos();

    Beneficiario buscarPorCpfOrThrow(String cpf);

    Beneficiario salvar(Beneficiario beneficiario);

    void reset();
}
