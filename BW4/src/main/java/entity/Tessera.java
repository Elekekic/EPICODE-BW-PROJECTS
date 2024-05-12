package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tessere")

public class Tessera {
    @Id
    @Column(name = "numero_tessera")
    private String numeroTessera;

    @Column(name = "data_emissione")
    private LocalDate dataEmissione;

    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;



    public Tessera() {
    }

    public Tessera(String numeroTessera, LocalDate dataEmissione, LocalDate dataScadenza) {
        this.numeroTessera = numeroTessera;
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataScadenza;

    }



    public String getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }



    @Override
    public String toString() {
        return "Tessera{" +
                "numeroTessera='" + numeroTessera + '\'' +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                '}';
    }
}
