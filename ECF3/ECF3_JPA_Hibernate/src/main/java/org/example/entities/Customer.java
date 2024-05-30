package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//TODO clear code non utilisé
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String name;
    private String emailAddress;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Vente> ventes =new ArrayList<>();

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

/*    public List<org.example.entities.Sale> getPurchases() {
        return sales;
    }

    public void setPurchases(List<org.example.entities.Sale> sales) {
        this.sales = sales;
    }*/

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", sales=" + ventes +
                '}';
    }
}
