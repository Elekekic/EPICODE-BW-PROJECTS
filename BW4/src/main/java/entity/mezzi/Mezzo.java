package entity.mezzi;

import entity.biglietto.Biglietto;
import enums.TipoMezzo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mezzi")
public class Mezzo {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "mezzo")
    private List<Viaggio> viaggi;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_mezzo")
    private TipoMezzo tipoMezzo;

    @Column(name = "inizio_servizio")
    private LocalDate inizioServizio;

    @Column(name = "fine_servizio")
    private LocalDate fineServizio;

    @OneToMany(mappedBy = "mezzo")
    @Column(name = "periodi_servizio")
    private List<PeriodoServizio> periodiServizio;

    private int capienza;

    @OneToMany(mappedBy = "mezzo")
    private List<Biglietto> bigliettiVidimati;

    @OneToMany(mappedBy = "mezzo")
    private List<Manutenzione> manutenzioni;


    public Mezzo() {
        // Inizializza la lista dei periodi di servizio
        this.periodiServizio = new ArrayList<>();
        this.bigliettiVidimati = new ArrayList<>();
        this.manutenzioni = new ArrayList<>();
        this.viaggi = new ArrayList<>();

    }

    public Mezzo(TipoMezzo tipoMezzo, LocalDate inizioServizio, LocalDate fineServizio,
                 int capienza) {
        this.tipoMezzo = tipoMezzo;
        this.inizioServizio = inizioServizio;
        this.fineServizio = fineServizio;
        this.capienza = capienza;
        this.periodiServizio = new ArrayList<>();
        this.bigliettiVidimati = new ArrayList<>();
        this.manutenzioni = new ArrayList<>();
        this.viaggi = new ArrayList<>();
    }

    public void aggiungiPeriodoServizio(LocalDate inizioServizio, LocalDate fineServizio) {
        // Creazione di un nuovo oggetto PeriodoServizio con le date fornite
        PeriodoServizio periodo = new PeriodoServizio(inizioServizio, fineServizio);

        if (periodiServizio == null) {
            periodiServizio = new ArrayList<>();
        }
        periodiServizio.add(periodo);
    }

    public List<PeriodoServizio> getPeriodiServizio() {
        return periodiServizio;
    }

    public Integer getId() {
        return id;
    }


    public TipoMezzo getTipoMezzo() {
        return tipoMezzo;
    }

    public void setTipoMezzo(TipoMezzo tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }

    public LocalDate getInizioServizio() {
        return inizioServizio;
    }

    public void setInizioServizio(LocalDate inizioServizio) {
        this.inizioServizio = inizioServizio;
    }

    public LocalDate getFineServizio() {
        return fineServizio;
    }

    public void setFineServizio(LocalDate fineServizio) {
        this.fineServizio = fineServizio;
    }


    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public List<Biglietto> getBigliettiVidimati() {
        return bigliettiVidimati;
    }

    public void setBigliettiVidimati(List<Biglietto> bigliettiVidimati) {
        this.bigliettiVidimati = bigliettiVidimati;
    }

    public List<Manutenzione> getManutenzioni() {
        return manutenzioni;
    }

    public void setManutenzioni(List<Manutenzione> manutenzioni) {
        this.manutenzioni = manutenzioni;
    }


    public List<Viaggio> getViaggi() {
        return viaggi;
    }

    public void setViaggi(List<Viaggio> viaggi) {
        this.viaggi = viaggi;
    }

    public void setPeriodiServizio(List<PeriodoServizio> periodiServizio) {
        this.periodiServizio = periodiServizio;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "id=" + id +
//                ", viaggi=" + viaggi +
                ", tipoMezzo=" + tipoMezzo +
                ", inizioServizio=" + inizioServizio +
                ", fineServizio=" + fineServizio +
//                ", periodiServizio=" + periodiServizio +
                ", capienza=" + capienza +
//                ", bigliettiVidimati=" + bigliettiVidimati +
//                ", manutenzioni=" + manutenzioni +
                '}';
    }
}
