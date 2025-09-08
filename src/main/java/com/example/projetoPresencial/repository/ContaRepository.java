package com.example.projetoPresencial.repository;

import com.example.projetoPresencial.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Long>{
    Optional<ContaModel> findByNumeroConta(String numeroConta);
    boolean existsByNumeroConta(String numeroConta);
}
