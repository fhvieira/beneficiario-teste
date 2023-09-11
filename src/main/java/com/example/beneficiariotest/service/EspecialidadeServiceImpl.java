package com.example.beneficiariotest.service;

import com.example.beneficiariotest.exception.EspecialidadeNotFoundException;
import com.example.beneficiariotest.model.Especialidade;
import com.example.beneficiariotest.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {
    private final EspecialidadeRepository reposiroty;

    public EspecialidadeServiceImpl(EspecialidadeRepository reposiroty) {
        this.reposiroty = reposiroty;
    }

    @Override
    public List<Especialidade> listarTodos() {
        return reposiroty.findAll();
    }

    @Override
    public Especialidade buscarPorNome(String nome) {
        return null;
    }

    @Override
    public Especialidade buscarPorNomeOrThrow(String nome) {
        return reposiroty.findByNome(nome).orElseThrow(() -> new EspecialidadeNotFoundException(""));
    }
}
