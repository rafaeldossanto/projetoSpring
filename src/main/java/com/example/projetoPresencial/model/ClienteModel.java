package com.example.projetoPresencial.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

  @AllArgsConstructor
public class ClienteModel {
    List<ContaModel> contas;

    @Id @GeneratedValue
    private Long Id;
    private String nome, cpf, email;
    private LocalDate nadaNascimento;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNadaNascimento() {
        return nadaNascimento;
    }

    public void setNadaNascimento(LocalDate nadaNascimento) {
        this.nadaNascimento = nadaNascimento;
    }
}
