package com.example.projetoPresencial.repository;

import com.example.projetoPresencial.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ContaModel, Long> {
    Optional<ContaModel> findByEmail(String email);
    Optional<ContaModel> findByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
}
