package Dao;

import entity.mezzi.Manutenzione;
import entity.mezzi.Mezzo;
import entity.mezzi.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;

public class MezzoDao {
    private EntityManager em;

    public MezzoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Mezzo mezzo){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(mezzo);
        et.commit();
    }

    public Mezzo getById(Integer id){

        return em.find(Mezzo.class,id);
    }

    public void update(Mezzo mezzo){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(mezzo);
        et.commit();
    }

    public List<Mezzo> findAll(){
        return em.createQuery("SELECT m FROM Mezzo m",Mezzo.class).getResultList();
    }

    public void delete(Mezzo mezzo){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(mezzo);
        et.commit();
    }

    public List<Manutenzione> getManutenzioniByMezzo(Mezzo mezzo) {
        return em.createQuery("SELECT m FROM Manutenzione m WHERE m.mezzo = :mezzo", Manutenzione.class)
                .setParameter("mezzo", mezzo)
                .getResultList();
    }


    public Integer countViaggiByMezzoAndTratta(Mezzo mezzo, Tratta tratta) {
        return mezzo.getViaggi().stream().filter(v -> v.getTratta().equals(tratta)).toList().size();
    }

    
}
