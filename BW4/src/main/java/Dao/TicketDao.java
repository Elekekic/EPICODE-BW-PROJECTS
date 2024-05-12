package Dao;

import entity.Utente;
import entity.biglietto.Abbonamento;
import entity.biglietto.Ticket;
import entity.rivenditori.Distributore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class TicketDao {

    private EntityManager em;

    public TicketDao(EntityManager em) {
        this.em = em;
    }

    public void save(Ticket ticket) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(ticket);
        et.commit();
    }

    public Ticket getById(Integer id) {

        return em.find(Ticket.class, id);
    }

    public void update(Ticket ticket) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(ticket);
        et.commit();
    }

    //    public List<Ticket> findAll(){
//        return em.createQuery("SELECT a FROM Ticket a",Ticket.class).getResultList();
//    }
    public List<Ticket> findAll() {
        return em.createQuery("SELECT t FROM Ticket t JOIN Abbonamento a ON t.id = a.id JOIN " +
                        "Biglietto b ON t.id = b.id", Ticket.class)
                .getResultList();
    }

    public void delete(Ticket ticket) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(ticket);
        et.commit();
    }


    public Long countTicketsByDistributor(LocalDate startDate, LocalDate endDate, Distributore distributore) {
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

    public boolean verificaValiditaAbbonamento(String numeroTessera) {

        // Assicurati che non ci siano transazioni attive prima di iniziare una nuova transazione
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback(); // Annulla la transazione attiva
        }
        em.getTransaction().begin(); // Inizia una nuova transazione
        try {
            // Esegui il codice della transazione

            // Esegui il test del metodo verificaValiditaAbbonamento
            Abbonamento abbonamento = em.createQuery("SELECT a FROM Abbonamento a ", Abbonamento.class)
                    .getResultStream().filter(abbonamento1 ->abbonamento1.getUtente().getTessera().getNumeroTessera().equals(numeroTessera) )
                    .findFirst().orElse(null);

            if (abbonamento==null) {
                // Utente non trovato o non ha un abbonamento, quindi non è valido
                em.getTransaction().commit(); // Concludi la transazione
                return false;
            }

            // Verifica la data di scadenza dell'abbonamento per determinare la sua validità

            LocalDate dataScadenza = abbonamento.getDataScadenza();
            LocalDate oggi = LocalDate.now();
            boolean abbonamentoValido = !oggi.isAfter(dataScadenza); // L'abbonamento è valido se la data attuale non supera la data di scadenza

            em.getTransaction().commit(); // Concludi la transazione
            return abbonamentoValido;
        } catch (Exception e) {
            em.getTransaction().rollback(); // Annulla la transazione in caso di errore
            throw e; // Rilancia l'eccezione per gestirla più in alto nel codice
        }
    }

}

