package entity.mezzi;

import entity.biglietto.Biglietto;
import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

@Entity
@Table(name = "viaggi")
public class Viaggio {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;

    private LocalDate data;

    @Column
    private LocalDateTime inizio;

    @Column
    private LocalDateTime arrivo;

    @Column(name = "tempo_effettivo_percorrenza")
    private Duration tempoEffettivoPercorrenza;

    //da rifare il costruttore

    public Viaggio(Mezzo mezzo, Tratta tratta, LocalDate data, LocalDateTime inizio) {
        this.mezzo = mezzo;
        this.tratta = tratta;
        this.data = data;
        this.inizio = inizio;
    }

    public LocalDateTime getInizio() {
        return inizio;
    }

    public void setInizio(LocalDateTime inizio) {
        this.inizio = inizio;
    }

    public LocalDateTime getArrivo() {
        return arrivo;
    }

    public void setArrivo(LocalDateTime arrivo) {
        this.arrivo = arrivo;
        this.tempoEffettivoPercorrenza = Duration.between(inizio, arrivo);
    }

    public Viaggio() {
    }

    public Integer getId() {
        return id;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTempoEffettivoPercorrenza() {
//        return "H "+tempoEffettivoPercorrenza.get(ChronoUnit.HOURS)+" M "
//                + tempoEffettivoPercorrenza.get(ChronoUnit.MINUTES)+" S "
//                + tempoEffettivoPercorrenza.get(ChronoUnit.SECONDS);
        return tempoEffettivoPercorrenza.toString();
    }

    public void setTempoEffettivoPercorrenza(Duration tempoEffettivoPercorrenza) {
        this.tempoEffettivoPercorrenza = tempoEffettivoPercorrenza;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }




    @Override
    public String toString() {
        return "Viaggio{" +
                "id=" + id +
                ", mezzo=" + mezzo +
                ", tratta=" + tratta +
                ", data=" + data +
                ", inizio=" + inizio +
                ", arrivo=" + arrivo +
                ", tempoEffettivoPercorrenza=" + tempoEffettivoPercorrenza +
                '}';
    }
}
