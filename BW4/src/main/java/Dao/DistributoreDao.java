package Dao;

import entity.rivenditori.Distributore;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DistributoreDao {
    private EntityManager em;

    public DistributoreDao(EntityManager em) {
        this.em = em;
    }

    public void save(Distributore distributore){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(distributore);
        et.commit();
    }

    public Distributore getById(Integer id){

        return em.find(Distributore.class,id);
    }

    public void update(Distributore distributore){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(distributore);
        et.commit();
    }

    public List<Distributore> findAll(){
        return em.createQuery("SELECT d FROM Distributore d",Distributore.class).getResultList();
    }

    public void delete(Distributore distributore){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(distributore);
        et.commit();
    }
}
