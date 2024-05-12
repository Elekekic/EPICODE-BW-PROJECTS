package Dao;

import entity.Tessera;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;

public class TesseraDao {
    private EntityManager em;

    public TesseraDao(EntityManager em) {
        this.em = em;
    }

    public void save(Tessera tessera){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(tessera);
        et.commit();
    }

    public Tessera getById(String id){

        return em.find(Tessera.class,id);
    }

    public void update(Tessera tessera){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(tessera);
        et.commit();
    }

    public List<Tessera> findAll(){
        return em.createQuery("SELECT t FROM Tessera t",Tessera.class).getResultList();
    }

    public void delete(Tessera tessera){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(tessera);
        et.commit();
    }


    public List<Tessera> getRinnovoScadenzaTessera() {
        LocalDate oggi = LocalDate.now();
        return em.createQuery(
                        "SELECT t FROM Tessera t " +
                                "WHERE t.dataEmissione IS NOT NULL " +  // Assicurati che la data di emissione non sia nulla
                                "AND (t.dataScadenza < :oggi OR t.dataScadenza = :oggi)",  // Se è scaduta o scade oggi
                        Tessera.class)
                .setParameter("oggi", oggi)
                .getResultList();
    }
}
