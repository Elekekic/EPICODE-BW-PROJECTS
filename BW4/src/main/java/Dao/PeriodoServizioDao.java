package Dao;

import entity.mezzi.Mezzo;
import entity.mezzi.PeriodoServizio;
import entity.mezzi.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PeriodoServizioDao {
    private EntityManager em;

    public PeriodoServizioDao(EntityManager em) {
        this.em = em;
    }

    public void save(PeriodoServizio periodoServizio){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(periodoServizio);
        et.commit();
    }

    public void update(PeriodoServizio periodoServizio){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(periodoServizio);
        et.commit();
    }

    public List<PeriodoServizio> findAll(){
        return em.createQuery("SELECT p FROM PeriodoServizio p",PeriodoServizio.class).getResultList();
    }

    public void delete(PeriodoServizio periodoServizio){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(periodoServizio);
        et.commit();
    }

    public List<PeriodoServizio> getPeriodiServizioByMezzo(Mezzo mezzo) {
        return em.createQuery("SELECT ps FROM PeriodoServizio ps WHERE ps.mezzo = :mezzo", PeriodoServizio.class)
                .setParameter("mezzo", mezzo)
                .getResultList();
    }
}
