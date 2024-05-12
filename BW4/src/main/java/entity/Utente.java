package entity;

import entity.biglietto.Abbonamento;
import entity.biglietto.Biglietto;
import entity.biglietto.Ticket;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @OneToOne
    @JoinColumn(name = "tessera_numero_tessera")
    private Tessera tessera;

    @OneToMany(mappedBy = "utente")
    private List<Ticket> tickets;


    public Utente(String nome, String cognome, Tessera tessera, List<Ticket> tickets) {
        this.nome = nome;
        this.cognome = cognome;
        this.tessera = tessera;
        this.tickets = tickets;
    }

    public Utente() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}

