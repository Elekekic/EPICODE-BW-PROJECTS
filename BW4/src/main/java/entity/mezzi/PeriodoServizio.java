package entity.mezzi;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "periodo_serivizio")
public class PeriodoServizio {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate inizio;
    private LocalDate fine;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;


    public PeriodoServizio(LocalDate inizio, LocalDate fine) {
        this.inizio = inizio;
        this.fine = fine;
    }

    public PeriodoServizio() {
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public LocalDate getInizio() {
        return inizio;
    }

    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }

    public LocalDate getFine() {
        return fine;
    }

    public void setFine(LocalDate fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "PeriodoServizio{" +
                "id=" + id +
                ", inizio=" + inizio +
                ", fine=" + fine +
                ", mezzo=" + mezzo +
                '}';
    }
}
