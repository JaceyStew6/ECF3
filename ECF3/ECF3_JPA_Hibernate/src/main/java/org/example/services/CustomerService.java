package org.example.services;

import org.example.entities.Customer;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerService extends BaseService implements Repository<Customer> {
    public CustomerService() {
        super();
    }


    @Override
    public boolean create(Customer o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Customer o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Customer findById(int id) {
        session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList= null;
        session = sessionFactory.openSession();
        Query<Customer> customerQuery = session.createQuery("from Customer ");
        customerList = customerQuery.list();
        for (Customer c : customerList){
            System.out.println(c);
        }
        session.close();
        return customerList;
    }

    public void close(){
        sessionFactory.close();
    }
}
