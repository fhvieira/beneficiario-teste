package com.example.beneficiariotest.repository;

import com.example.beneficiariotest.model.Beneficiario;
import com.example.beneficiariotest.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

}
