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

import edu.coderhouse.jpa.entity.Invoice;
import edu.coderhouse.jpa.service.InvoiceService;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Invoice>> getInvoice() {
        return ResponseEntity.ok(invoiceService.findAll());
    }    

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<Invoice>> getInvoiceById(@PathVariable int id){
        Optional<Invoice> invoice = invoiceService.findInvoiceById(id);
        if(invoice.isPresent()){
            return ResponseEntity.ok(invoice);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice){
        try{
            Invoice invoiceSaved = invoiceService.save(invoice);
            return ResponseEntity.ok(invoiceSaved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
