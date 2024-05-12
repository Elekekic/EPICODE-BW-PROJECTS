package entity.biglietto;

import entity.rivenditori.Distributore;
import entity.Utente;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tickets")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Ticket {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "codice_univoco")
    private String codiceUnivoco;

    @Column
    private double prezzo;

    @Column(name = "data_emissione")
    private LocalDate dataEmissione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "distributore_id")
    private Distributore distributore;


    public Ticket(String codiceUnivoco, double prezzo, LocalDate dataEmissione, Utente utente, Distributore distributore) {
        this.codiceUnivoco = codiceUnivoco;
        this.prezzo = prezzo;
        this.dataEmissione = dataEmissione;
        this.utente = utente;
        this.distributore = distributore;
    }

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(String codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }



    public Distributore getDistributore() {
        return distributore;
    }

    public void setDistributore(Distributore distributore) {
        this.distributore = distributore;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", codiceUnivoco='" + codiceUnivoco + '\'' +
                ", prezzo=" + prezzo +
                ", dataEmissione=" + dataEmissione +
                ", utente=" + utente +
                ", distributore=" + distributore +
                '}';
    }
}