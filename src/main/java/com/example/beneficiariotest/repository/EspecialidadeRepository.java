package com.example.beneficiariotest.repository;

import com.example.beneficiariotest.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, String> {

    Optional<Especialidade> findByNome(String nome);
}
