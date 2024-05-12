package Dao;

import entity.mezzi.Tratta;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TrattaDao {
    private EntityManager em;

    public TrattaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(tratta);
        et.commit();
    }

    public Tratta getById(Integer id){

        return em.find(Tratta.class,id);
    }

    public void update(Tratta tratta){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(tratta);
        et.commit();
    }

    public List<Tratta> findAll(){
        return em.createQuery("SELECT t FROM Tratta t",Tratta.class).getResultList();
    }

    public void delete(Tratta tratta){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(tratta);
        et.commit();
    }
}
