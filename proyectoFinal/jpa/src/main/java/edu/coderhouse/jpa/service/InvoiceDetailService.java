package edu.coderhouse.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.coderhouse.jpa.Repository.InvoiceDetailRepository;
import edu.coderhouse.jpa.entity.InvoiceDetail;

@Service
public class InvoiceDetailService {
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetail save(InvoiceDetail invoiceDetail){
        return invoiceDetailRepository.save(invoiceDetail);
    }

    public void delete(int id) {
        invoiceDetailRepository.deleteById(id);
    }

    public Optional<InvoiceDetail> findInvoiceDetailById(int id) {
        return invoiceDetailRepository.findById(id);
    }

    public List<InvoiceDetail> findAll(){
        return invoiceDetailRepository.findAll();
    }
    
}
