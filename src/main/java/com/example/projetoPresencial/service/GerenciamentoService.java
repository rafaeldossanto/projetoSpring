package com.example.projetoPresencial.service;

import com.example.projetoPresencial.model.ClienteModel;
import com.example.projetoPresencial.model.ContaModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GerenciamentoService {
    List<ClienteModel> clientes;


    private ContaModel contaModel;
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

    public void listarClientes(){
        for (ClienteModel cliente : clientes) {
            System.out.println(cliente.getNome());
        }
    }

    public ClienteModel buscarPorId(Long id){
        for (ClienteModel cliente : clientes) {
            if (cliente.getId().equals(id)){
                return cliente;
            }
        }
        return null;
    }

    public void deleteCliente(Long id) {
        try {
            clientes.remove(buscarPorId(id));
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }

    public void addConta(ContaModel contaModel, Long id){
        buscarPorId(id).getContas().add(contaModel);
    }

}
