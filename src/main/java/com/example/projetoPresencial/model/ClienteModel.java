package com.example.projetoPresencial.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class ClienteModel {
    List<ContaModel> contas;

    @Id @GeneratedValue
    private Long Id;
    private String nome, cpf, email;
    private LocalDate nadaNascimento;
}
