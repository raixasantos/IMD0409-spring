package com.jeanlima.springrestapi.rest.dto.Cliente;

import lombok.*;

import java.util.List;

import com.jeanlima.springrestapi.rest.dto.Pedido.PedidoPorClienteDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformacoesClienteDTO {
    private String nome;
    private String cpf;
    private List<PedidoPorClienteDTO> pedidos;
}
