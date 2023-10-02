package edu.coderhouse.clienteapirest.controller;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.coderhouse.clienteapirest.entity.ClienteEntity;
import edu.coderhouse.clienteapirest.entity.ClienteResponse;
import edu.coderhouse.clienteapirest.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}) // le devuelvo un id, formato json
    public ResponseEntity<ClienteResponse> findById(@PathVariable Long id) { // la variable llega por el path
        ClienteResponse cliente = clienteService.findById(id); //obtenemos el cliente

        if(cliente!= null) { // si esta el cleinte con todos sus datos que tiene que tener
            return ResponseEntity.ok(cliente); //devuelve 200
        } else {
            return ResponseEntity.notFound().build(); //devuelve un 404
        }
    }

    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE}) // produce y consume formato json
    public ResponseEntity<ClienteEntity> save(@RequestBody ClienteEntity cliente) { // el param llega desde el body
        try {
            ClienteEntity clienteSaved = clienteService.save(cliente);
            return ResponseEntity.ok(clienteSaved);
        } catch (Exception e) {
            e.printStackTrace(); //imprimimos
            return ResponseEntity.badRequest().build();
        }
        
    }
    
}