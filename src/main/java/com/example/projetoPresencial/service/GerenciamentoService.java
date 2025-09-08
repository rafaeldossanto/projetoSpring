package com.example.projetoPresencial.service;

import com.example.projetoPresencial.model.ClienteModel;
import com.example.projetoPresencial.model.ContaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GerenciamentoService {

    private ContaModel contaModel;
    List<ClienteModel> clientes;

    public GerenciamentoService(ContaModel contaModel){
        this.contaModel = contaModel;
    }

    public void addCliente(ClienteModel clienteModel){
        for (ClienteModel cliente : clientes) {
            if (cliente.getCpf().equals(clienteModel.getCpf())){
                throw new IllegalArgumentException("Invalido.");
            } else {
                clientes.add(clienteModel);
            }
        }
    }
}
