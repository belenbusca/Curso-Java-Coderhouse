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

import edu.coderhouse.jpa.entity.InvoiceDetail;
import edu.coderhouse.jpa.service.InvoiceDetailService;

@RestController
@RequestMapping("api/invoiceDetail")
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<InvoiceDetail>> getInvoiceDetail() {
        return ResponseEntity.ok(invoiceDetailService.findAll());
    }    

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<InvoiceDetail>> getInvoiceDetailById(@PathVariable int id){
        Optional<InvoiceDetail> invoiceDetail = invoiceDetailService.findInvoiceDetailById(id);
        if(invoiceDetail.isPresent()){
            return ResponseEntity.ok(invoiceDetail);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    //tal vez no lo use si creo los invoice detail desde el post de invoice como comento un compañero en la ultima clase :P
    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<InvoiceDetail> saveInvoiceDetail(@RequestBody InvoiceDetail invoiceDetail){
        try{
            InvoiceDetail invoiceDetailSaved = invoiceDetailService.save(invoiceDetail);
            return ResponseEntity.ok(invoiceDetailSaved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
