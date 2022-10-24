package com.jeanlima.springrestapi.service.impl;

import org.springframework.stereotype.Service;

import com.jeanlima.springrestapi.exception.RegraNegocioException;
import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.repository.ClienteRepository;
import com.jeanlima.springrestapi.rest.dto.Cliente.ClienteDTO;
import com.jeanlima.springrestapi.service.ClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Override
    public void atualizaNome(Integer id, String nome) {
        repository
                .findById(id)
                .map(cliente -> {
                    cliente.setNome(nome);
                    return repository.save(cliente);
                }).orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

    }

    @Override
    public Cliente salvar(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        repository.save(cliente);
        return cliente;
    }
}
