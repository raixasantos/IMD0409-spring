package com.jeanlima.springrestapi.rest.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.repository.ClienteRepository;
import com.jeanlima.springrestapi.rest.dto.Cliente.AtualizacaoNomeClienteDTO;
import com.jeanlima.springrestapi.rest.dto.Cliente.ClienteDTO;
import com.jeanlima.springrestapi.rest.dto.Cliente.InformacoesClienteDTO;
import com.jeanlima.springrestapi.service.ClienteService;

@RequestMapping("/api/clientes")
@RestController //anotação especializadas de controller - todos já anotados com response body!
public class ClienteController {

    @Autowired
    private ClienteRepository clientes;

    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    public Cliente getClienteById( @PathVariable Integer id ){
        return clientes
                .findById(id)
                .orElseThrow(() -> //se nao achar lança o erro!
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }

    @GetMapping("/{id}/pedidos")
    public InformacoesClienteDTO getClienteWithPedidosById( @PathVariable Integer id ){        
        return new InformacoesClienteDTO();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save( @RequestBody ClienteDTO dto ){
        Cliente cliente = service.salvar(dto);
        return cliente.getId();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        clientes.findById(id)
                .map( cliente -> {
                    clientes.delete(cliente );
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Cliente cliente ){
        clientes
                .findById(id)
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Cliente não encontrado") );
    }

    @PatchMapping("{id}/nome")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNome(@PathVariable Integer id ,
                             @RequestBody AtualizacaoNomeClienteDTO dto){
        String novoNome = dto.getNome();
        service.atualizaNome(id, novoNome);
    }

    @GetMapping
    public List<Cliente> find( Cliente filtro ){
        ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(
                                            ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return clientes.findAll(example);
    }

}
