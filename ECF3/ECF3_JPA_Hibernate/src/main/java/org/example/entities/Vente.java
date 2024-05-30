package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//TODO clear code non utilisé

@Entity
@Table(name = "sale")
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saleId;
    private SaleStatus saleStatus;
    //TODO ajouter quantité vendue?


/*    @ManyToMany(mappedBy = "ventes", fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();*/

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "productSales", joinColumns = @JoinColumn(name = "saleId"), inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> products = new ArrayList<>();

/*    public void add (Product product){
        products.add(product);
    }*/

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
