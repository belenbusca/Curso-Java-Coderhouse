package edu.coderhouse.clienteapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.coderhouse.clienteapirest.entity.ClienteEntity;

@Repository //las anotaciones les dan la identidad a las capas
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> { // LONG es el tipo de dato del id cliente
    
}
