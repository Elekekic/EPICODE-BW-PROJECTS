package Dao;

import entity.biglietto.Abbonamento;
import entity.rivenditori.Distributore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class AbbonamentoDao {
    private EntityManager em;

    public AbbonamentoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Abbonamento abbonamento){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(abbonamento);
        et.commit();
    }

    public Abbonamento getById(Integer id){

        return em.find(Abbonamento.class,id);
    }

    public void update(Abbonamento abbonamento){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(abbonamento);
        et.commit();
    }

    public List<Abbonamento> findAll(){
        return em.createQuery("SELECT a FROM Abbonamento a",Abbonamento.class).getResultList();
    }

    public void delete(Abbonamento abbonamento){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(abbonamento);
        et.commit();
    }
    public Long countTotalSubscriptions(LocalDate startDate, LocalDate endDate) {
        Query query = em.createQuery(
                "SELECT COUNT(a) FROM Abbonamento a " +
                        "WHERE a.dataEmissione BETWEEN :startDate AND :endDate"
        );
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return (Long) query.getSingleResult();
    }
    public Long countSubscriptionsByDistributor(LocalDate startDate, LocalDate endDate, Distributore distributore) {
        Query query = em.createQuery(
                "SELECT COUNT(t) FROM Ticket t " +
                        "WHERE t.distributore = :distributore " +
                        "AND t.dataEmissione BETWEEN :startDate AND :endDate"
        );
        query.setParameter("distributore", distributore);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return (Long) query.getSingleResult();
    }


}
