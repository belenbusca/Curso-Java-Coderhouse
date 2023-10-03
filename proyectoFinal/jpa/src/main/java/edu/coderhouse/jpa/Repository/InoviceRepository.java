package edu.coderhouse.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.coderhouse.jpa.entity.Invoice;

@Repository
public interface InoviceRepository extends JpaRepository<Invoice, Integer>{
    
}
