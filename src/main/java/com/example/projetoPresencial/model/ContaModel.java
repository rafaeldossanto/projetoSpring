package com.example.projetoPresencial.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor
public class ContaModel {

    private ClienteModel clienteModel;
    public ContaModel (ClienteModel clienteModel){
        this.clienteModel = clienteModel;
    }

    @Id @GeneratedValue
    private Long id;
    private String numeroConta;
    private BigDecimal saldo;
}
