package com.example.projetoPresencial.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(nome = "Clientes")
@Getter @Setter
@AllArgsConstructor
public class ClienteModel {
    List<ContaModel> contas;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome, cpf, email;
    private LocalDate dataNascimento;
}
