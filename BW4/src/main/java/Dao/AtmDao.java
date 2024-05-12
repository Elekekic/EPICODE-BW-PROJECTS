package Dao;

import entity.biglietto.Biglietto;
import entity.rivenditori.Atm;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AtmDao {
    private EntityManager em;

    public AtmDao(EntityManager em) {
        this.em = em;
    }

    public void save(Atm atm){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(atm);
        et.commit();
    }

    public Atm getById(Integer id){

        return em.find(Atm.class,id);
    }

    public void update(Atm atm){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(atm);
        et.commit();
    }

    public List<Atm> findAll(){
        return em.createQuery("SELECT b FROM Atm b",Atm.class).getResultList();
    }

    public void delete(Atm atm){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(atm);
        et.commit();
    }
}
