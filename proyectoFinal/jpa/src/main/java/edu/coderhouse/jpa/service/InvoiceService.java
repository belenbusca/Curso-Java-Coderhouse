package edu.coderhouse.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.coderhouse.jpa.Repository.ClientRepository;
import edu.coderhouse.jpa.Repository.InoviceRepository;
import edu.coderhouse.jpa.Repository.ProductRepository;
import edu.coderhouse.jpa.entity.Client;
import edu.coderhouse.jpa.entity.Invoice;
import edu.coderhouse.jpa.entity.InvoiceDetail;

@Service
public class InvoiceService {
    @Autowired
    private InoviceRepository inoviceRepository;
    // para validar existencia de cliente y producto:
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;

    public void delete(int id){
        inoviceRepository.deleteById(id);
    }

    public Optional<Invoice> findInvoiceById(int id){
        return inoviceRepository.findById(id);
    }

    public List<Invoice> findAll() {
        return inoviceRepository.findAll();
    }
    
    public Invoice save(Invoice invoice) {
        Boolean clientExists = clientExists(invoice.getClient());
        Boolean productExists = productExists(invoice.getInvoiceDetails());
        Boolean enoughStock = enoughStock(invoice.getInvoiceDetails());

        if(clientExists && productExists && enoughStock) {
            //crear invoice detail -> ver lo de date con el servicio externo
            // actualizar stock
            var invoiceToSave = buildInvoice(invoice);
            return inoviceRepository.save(invoice);
        }
        else throw new RuntimeException("Couldnt save the invoice");
            
    }
    // + validaciones
    private Boolean clientExists(Client client){
        var opCliente = this.clientRepository.findById(client.getId());
		return !opCliente.isEmpty();
    }

    private Boolean productExists(List<InvoiceDetail> details){
        for (InvoiceDetail detail : details) {
			var productoId = detail.getProduct().getId();
			var opProducto = this.productRepository.findById(productoId);
			if (opProducto.isEmpty()) {
				return false;
			}
		}
		return true;
    }

    private Boolean enoughStock(List<InvoiceDetail> details){
        for (InvoiceDetail detail : details) {
			var productoId = detail.getProduct().getId();
			var opProducto = this.productRepository.findById(productoId);
			if (opProducto.isEmpty()) {
				return false;
			}
            if(opProducto.get().getStock() < detail.getAmount())
                return false;
		}
		return true;
    }

    private Invoice buildInvoice(Invoice invoice){
        var invoiceToSave = new Invoice();
        invoiceToSave.setClient(clientRepository.findById(invoice.getClient().getId()).get()); // o uso service? TODO!

        RestTemplate restTemplate = new RestTemplate();
        return invoiceToSave;
    }



}
