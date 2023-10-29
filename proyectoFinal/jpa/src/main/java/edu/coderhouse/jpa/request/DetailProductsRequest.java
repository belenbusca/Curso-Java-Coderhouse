package edu.coderhouse.jpa.request;

import java.util.List;

import edu.coderhouse.jpa.entity.Client;

public class DetailProductsRequest {
    private Client client;
    private List<DetailProductsRequest> details;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<DetailProductsRequest> getDetails() {
        return details;
    }

    public void setProduct_list(List<DetailProductsRequest> details) {
        this.details = details;
    }
}
