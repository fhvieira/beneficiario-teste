package com.example.beneficiariotest.service;

import com.example.beneficiariotest.exception.BeneficiarioAlreadyExistsException;
import com.example.beneficiariotest.exception.BeneficiarioNotFoundException;
import com.example.beneficiariotest.model.Beneficiario;
import com.example.beneficiariotest.repository.BeneficiarioReposiroty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {
    private final BeneficiarioReposiroty repository;

    public BeneficiarioServiceImpl(BeneficiarioReposiroty repository) {
        this.repository = repository;
    }

    public List<Beneficiario> listarTodos() {
        return repository.findAll();
    }

    public Beneficiario buscarPorCpfOrThrow(String cpf) {
        return repository.findById(cpf)
                .orElseThrow(() -> new BeneficiarioNotFoundException(String.format(
                        "Beneficiário com cpf %s não foi encontrado", cpf)));
    }

    @Override
    public Beneficiario salvar(final Beneficiario beneficiario) {
        repository.findById(beneficiario.getCpf()).ifPresent(b -> {
            throw new BeneficiarioAlreadyExistsException(String.format("Beneficiário com cpf %s já cadastrado",
                    beneficiario.getCpf()));
        });

        return repository.save(beneficiario);
    }

    @Override
    public void reset() {
        repository.deleteAll();
    }
}
