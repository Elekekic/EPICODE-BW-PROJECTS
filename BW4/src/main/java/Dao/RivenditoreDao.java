package Dao;

import entity.rivenditori.Rivenditore;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class RivenditoreDao {
    private EntityManager em;

    public RivenditoreDao(EntityManager em) {
        this.em = em;
    }

    public void save(Rivenditore rivenditore){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(rivenditore);
        et.commit();
    }

    public Rivenditore getById(String id){

        return em.find(Rivenditore.class,id);
    }

    public Rivenditore getByName(String name){

        return em.find(Rivenditore.class,name);
    }

    public void update(Rivenditore rivenditore){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(rivenditore);
        et.commit();
    }

    public List<Rivenditore> findAll(){
        return em.createQuery("SELECT r FROM Rivenditore r",Rivenditore.class).getResultList();
    }

    public void delete(Rivenditore rivenditore){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(rivenditore);
        et.commit();
    }
}
