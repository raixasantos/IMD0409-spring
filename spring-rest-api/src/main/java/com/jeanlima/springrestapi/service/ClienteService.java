package com.jeanlima.springrestapi.service;

import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.rest.dto.Cliente.ClienteDTO;
import com.jeanlima.springrestapi.rest.dto.Pedido.PedidoPorClienteDTO;

public interface ClienteService {
    Cliente salvar(ClienteDTO dto);
    void atualizaNome(Integer id, String nome);
}
