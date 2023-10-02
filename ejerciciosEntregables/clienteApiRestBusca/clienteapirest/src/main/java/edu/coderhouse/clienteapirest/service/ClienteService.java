package edu.coderhouse.clienteapirest.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.coderhouse.clienteapirest.entity.ClienteEntity;
import edu.coderhouse.clienteapirest.entity.ClienteResponse;
import edu.coderhouse.clienteapirest.repository.ClienteRepository;

// CAPA LOGICA
@Service
public class ClienteService {
    
    @Autowired // crea instancia sin necesidad de instanciarlo
    private ClienteRepository clienteRepository;

    // FUNCIONES PARA COMUNICARNOS CON LA BD USANDO EL REPOSITORIO
    public ClienteEntity save(ClienteEntity cliente){
        return clienteRepository.save(cliente);
    }

    public ClienteResponse findById(Long id) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            return null;
        } else {
            return new ClienteResponse(
            cliente.get().getNombre(),
            cliente.get().getApellido(),
            calcularAnios(cliente.get().getFechaNacimiento())
        );
        }
        
    } //Busca cliente por ID

    public Integer calcularAnios(LocalDate fechaNacimiento){
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }

}
