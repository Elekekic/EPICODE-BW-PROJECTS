package Dao;


import entity.mezzi.Manutenzione;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ManutenzioneDao {
    private EntityManager em;

    public ManutenzioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Manutenzione manutenzione){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(manutenzione);
        et.commit();
    }

    public Manutenzione getById(Integer id){

        return em.find(Manutenzione.class,id);
    }

    public void update(Manutenzione manutenzione){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(manutenzione);
        et.commit();
    }

    public List<Manutenzione> findAll(){
        return em.createQuery("SELECT d FROM Manutenzione d",Manutenzione.class).getResultList();
    }

    public void delete(Manutenzione manutenzione){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(manutenzione);
        et.commit();
    }
}
