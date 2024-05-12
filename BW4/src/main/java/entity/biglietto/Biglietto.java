package entity.biglietto;

import entity.mezzi.Mezzo;
import entity.rivenditori.Distributore;
import entity.Utente;
import entity.mezzi.Viaggio;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "biglietti")
public class Biglietto extends Ticket {

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;


    private boolean vidimato = false;


    public Biglietto(String codiceUnivoco, double prezzo, LocalDate dataEmissione, Utente utente,
                     Distributore distributore, Mezzo mezzo, boolean vidimato) {
        super(codiceUnivoco, prezzo, dataEmissione, utente, distributore);
        this.mezzo = mezzo;
        this.vidimato = vidimato;
    }


    public Biglietto() {
        super();
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public boolean isVidimato() {
        return vidimato;
    }

    public void setVidimato(boolean vidimato) {
        this.vidimato = vidimato;
    }
    public void obliterazione(){
        if (!vidimato) {
            vidimato = true;
            System.out.println("Biglietto obliterato");
        } else {
            System.out.println("Il biglietto è stato già obliterato");
        }
    }
    @Override
    public String toString() {
        return "Biglietto{" +
                "mezzo=" + mezzo +
                ", vidimato=" + vidimato +
                '}';
    }


}
