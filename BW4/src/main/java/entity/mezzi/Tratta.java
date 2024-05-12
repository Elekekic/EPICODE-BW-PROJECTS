package entity.mezzi;

import entity.biglietto.Abbonamento;
import entity.biglietto.Biglietto;
import entity.biglietto.Ticket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tratte")
public class Tratta {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "zona_partenza")
    private String zonaPartenza;
    @Column(name = "tempo_medio")
    private Integer tempoMedio;

    private String capolinea;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @OneToMany(mappedBy = "tratta")
    private List<Viaggio> viaggi;

    public Tratta(String zonaPartenza, Integer tempoMedio, String capolinea, Ticket ticket, List<Viaggio> viaggi) {
        this.zonaPartenza = zonaPartenza;
        this.tempoMedio = tempoMedio;
        this.capolinea = capolinea;
        this.ticket = ticket;
        this.viaggi = viaggi;
    }

    public Tratta() {
    }

    public Integer getId() {
        return id;
    }

    public String getZonaPartenza() {
        return zonaPartenza;
    }

    public void setZonaPartenza(String zonaPartenza) {
        this.zonaPartenza = zonaPartenza;
    }

    public Integer getTempoMedio() {
        return tempoMedio;
    }

    public void setTempoMedio(Integer tempoMedio) {
        this.tempoMedio = tempoMedio;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<Viaggio> getViaggi() {

        if (viaggi != null) {
            return this.viaggi;
        } else {
            System.err.println("Lista viaggi vuota");
            return  new ArrayList<>();
        }

    }

    public void setViaggi(List<Viaggio> viaggi) {


 this.viaggi = viaggi;

    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", zonaPartenza='" + zonaPartenza + '\'' +
                ", tempoMedio=" + tempoMedio +
                ", capolinea='" + capolinea + '\'' +
                ", ticket=" + ticket +
                ", viaggi=" + viaggi +
                '}';
    }
}
