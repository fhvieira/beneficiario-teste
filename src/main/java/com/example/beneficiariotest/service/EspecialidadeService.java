package com.example.beneficiariotest.service;

import com.example.beneficiariotest.model.Especialidade;

import java.util.List;

public interface EspecialidadeService {

    List<Especialidade> listarTodos();


    Especialidade buscarPorNome(String nome);

    Especialidade buscarPorNomeOrThrow(String nomeEspecialidade);
}
