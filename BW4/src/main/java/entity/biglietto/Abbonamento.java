package entity.biglietto;

import entity.rivenditori.Distributore;
import entity.Utente;
import enums.TipoAbbonamento;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "abbonamenti")

 public class Abbonamento extends Ticket {

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_abbonamento")
    private TipoAbbonamento tipoAbbonamento;

    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;

    public Abbonamento(String codiceUnivoco, double prezzo, LocalDate dataEmissione, Utente utente, Distributore distributore, TipoAbbonamento tipoAbbonamento, LocalDate dataScadenza) {
        super(codiceUnivoco, prezzo, dataEmissione, utente, distributore);
        this.tipoAbbonamento = tipoAbbonamento;
        this.dataScadenza = dataScadenza;
    }

    public Abbonamento() {
        super();
    }

    public TipoAbbonamento getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(TipoAbbonamento tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "tipoAbbonamento=" + tipoAbbonamento +
                ", dataScadenza=" + dataScadenza +
                '}';
    }
}
