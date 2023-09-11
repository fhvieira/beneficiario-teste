package com.example.beneficiariotest.repository;

import com.example.beneficiariotest.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioReposiroty extends JpaRepository<Beneficiario, String> {

}
