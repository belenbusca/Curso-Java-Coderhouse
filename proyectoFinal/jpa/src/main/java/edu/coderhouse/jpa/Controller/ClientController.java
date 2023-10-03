package edu.coderhouse.jpa.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.coderhouse.jpa.entity.Client;
import edu.coderhouse.jpa.service.ClientService;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(clientService.findAll());
    }
    
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable int id){
        Optional<Client> client = clientService.findClientById(id);
        if(client.isPresent()){
            return ResponseEntity.ok(client);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        try {
            Client clientSaved = clientService.save(client);
            return ResponseEntity.ok(clientSaved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
