package edu.coderhouse.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.coderhouse.jpa.Repository.InoviceRepository;
import edu.coderhouse.jpa.entity.Invoice;

@Service
public class InvoiceService {
    @Autowired
    private InoviceRepository inoviceRepository;

    public Invoice save(Invoice invoice) {
        return inoviceRepository.save(invoice);
    }

    public void delete(int id){
        inoviceRepository.deleteById(id);
    }

    public Optional<Invoice> findInvoiceById(int id){
        return inoviceRepository.findById(id);
    }

    public List<Invoice> findAll() {
        return inoviceRepository.findAll();
    }
    
}
