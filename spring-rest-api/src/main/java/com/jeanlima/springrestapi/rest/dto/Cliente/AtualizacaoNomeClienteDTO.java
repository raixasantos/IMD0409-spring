package com.jeanlima.springrestapi.rest.dto.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoNomeClienteDTO {
    private String nome;
}
