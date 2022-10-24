package com.jeanlima.springrestapi.rest.dto.Pedido;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class PedidoPorClienteDTO {
    private Integer codigo;
    private List<InformacaoItemPedidoDTO> items;
    private BigDecimal total;
}
