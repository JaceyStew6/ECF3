package org.example.services;

import org.example.entities.Product;
import org.example.entities.Vente;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class SaleService extends BaseService implements Repository<Vente> {

    @Override
    public boolean create(Vente o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Vente o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Vente o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Vente findById(int id) {
        session = sessionFactory.openSession();
        Vente vente = session.get(Vente.class,id);
        session.close();
        return vente;
    }

    @Override
    public List<Vente> findAll() {
        //TODO modifier méthode car ne renvoie que l'emplacement mémoire
        List<Vente> venteList = null;
        session = sessionFactory.openSession();
        Query<Vente> venteQuery = session.createQuery("from Vente ");
        venteList = venteQuery.list();
        for (Vente v: venteList){
            System.out.println(v);
        }
        session.close();
        return venteList;
    }

    public void close(){
        sessionFactory.close();
    }
}
