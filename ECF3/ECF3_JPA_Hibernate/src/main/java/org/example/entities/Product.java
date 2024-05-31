package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//TODO clear code non utilisé
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private int productId;
    private String description;
    private ProductCategory productCategory;
    private String size;
    private double price;
    private int stock;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private List<Vente> ventes = new ArrayList<>();

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Vente> getSales() {
        return ventes;
    }

    public void setSales(List<Vente> ventes) {
        this.ventes = ventes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", description='" + description + '\'' +
                ", productCategory=" + productCategory +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales=" + ventes +
                '}';
    }
}
