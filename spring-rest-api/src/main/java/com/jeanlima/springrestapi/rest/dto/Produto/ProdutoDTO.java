package com.jeanlima.springrestapi.rest.dto.Produto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private String descricao;
    private BigDecimal preco;
}
