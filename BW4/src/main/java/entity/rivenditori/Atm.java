package entity.rivenditori;

import entity.biglietto.Ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "atm")
public class Atm extends Distributore {

    private boolean attivo;
    @Column(name = "fuori_servizio")
    private boolean fuoriServizio;

    public Atm(List<Ticket> tickets, boolean attivo, boolean fuoriServizio) {
        super(tickets);
        this.attivo = attivo;
        this.fuoriServizio = fuoriServizio;
    }

    public Atm(boolean attivo, boolean fuoriServizio) {
        this.attivo = attivo;
        this.fuoriServizio = fuoriServizio;
    }

    public Atm() {
        super();
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public boolean isFuoriServizio() {
        return fuoriServizio;
    }

    public void setFuoriServizio(boolean fuoriServizio) {
        this.fuoriServizio = fuoriServizio;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "attivo=" + attivo +
                ", fuoriServizio=" + fuoriServizio +
                '}';
    }
}
