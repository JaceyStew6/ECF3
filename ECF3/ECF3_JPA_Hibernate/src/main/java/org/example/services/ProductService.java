package org.example.services;

import org.example.entities.Product;
import org.example.entities.ProductCategory;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ProductService extends BaseService implements Repository<Product> {

    public ProductService() {
        super();
    }


    @Override
    public boolean create(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Product findById(int id) {
        session = sessionFactory.openSession();
        Product product = session.get(Product.class,id);
        session.close();
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        session = sessionFactory.openSession();
        Query<Product> productQuery = session.createQuery("from Product ");
        productList = productQuery.list();
        for (Product p: productList){
            System.out.println(p);
        }
        session.close();
        return productList;
    }

    public void close(){
        sessionFactory.close();
    }




}
