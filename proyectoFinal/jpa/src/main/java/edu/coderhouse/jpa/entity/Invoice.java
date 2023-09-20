package edu.coderhouse.jpa.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class Invoice {

    // CONSTRUCTORES
    public Invoice(){
        super();
    }

    public Invoice(int id, Client client, Date created_at, long total){
        super();
        this.id = id;
        this.client = client;
        this.created_at = created_at;
        this.total = total;
    }

    //RELACIONES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inv_id")
    private int id;

    @ManyToOne
	@JoinColumn(name="inv_client_id") //!!!! no se si esta bien, sera client_id en vez de inv_client_id?
	private Client client;

    @Column(name = "inv_created_at")
    private Date created_at;

    @Column(name = "inv_total")
    private long total;

    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }  
}
