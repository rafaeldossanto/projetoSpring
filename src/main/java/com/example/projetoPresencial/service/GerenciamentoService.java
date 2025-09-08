package com.example.projetoPresencial.service;

import com.example.projetoPresencial.model.ClienteModel;
import com.example.projetoPresencial.model.ContaModel;
import com.example.projetoPresencial.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class GerenciamentoService {
    List<ClienteModel> clientes;

    @Autowired
    private ClienteRepository clienteRepository;


    public List<ClienteModel> findAll(){
        return clienteRepository.findAll();
    }


    public ClienteModel findById(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalido"));
    }

    public ClienteModel save(ClienteModel clienteModel){
        if (Period.between(clienteModel.getDataNascimento(), LocalDate.now()).getYears() < 18){
            throw new IllegalArgumentException("Cliente deve ser maior que 18.");
        }

        if (clienteRepository.existsByEmail(clienteModel.getEmail())) {
            throw new IllegalArgumentException("Email ja cadastrado");
        }

        if (clienteRepository.existsByCpf(clienteModel.getCpf())) {
            throw new IllegalArgumentException("CPF ja registrado");
        }

        return clienteRepository.save(clienteModel);
    }

    public ClienteModel update(Long id, ClienteModel clienteModeldetalhes) {
        ClienteModel clienteModel = findById(id);

        if (Period.between(clienteModel.getDataNascimento(), LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Cliente deve ser maior que 18.");
        }

        if (clienteRepository.existsByEmail(clienteModel.getEmail())) {
            throw new IllegalArgumentException("Email ja cadastrado");
        }

        if (clienteRepository.existsByCpf(clienteModel.getCpf())) {
            throw new IllegalArgumentException("CPF ja registrado");
        }

        clienteModel.setNome(clienteModeldetalhes.getNome());
        clienteModel.setEmail(clienteModeldetalhes.getEmail());
        clienteModel.setCpf(clienteModeldetalhes.getCpf());
        clienteModel.setDataNascimento(clienteModeldetalhes.getDataNascimento());

        return clienteRepository.save(clienteModel);
    }

    public void delete(Long id){
        ClienteModel clienteModel = findById(id);

        if (!clienteModel.getContas().isEmpty()) {
            throw new IllegalArgumentException("Nao e possivel excluir clientes com constas ativas.");
        }

        clienteRepository.delete(clienteModel);
    }

    private String generateAccountNumber() {
        Random random = new Random();
        String numeroConta;

        do {
            numeroConta = String.format("%06", random.nextInt(100000));
        } while (clienteRepository.existsByNumeroConta(numeroConta));

        return numeroConta;
    }
}
