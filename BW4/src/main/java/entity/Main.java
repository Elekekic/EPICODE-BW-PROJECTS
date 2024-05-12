package entity;

import Dao.*;
import entity.biglietto.Abbonamento;
import entity.biglietto.Biglietto;
import entity.mezzi.*;
import entity.rivenditori.Atm;
import entity.rivenditori.Rivenditore;
import enums.TipoAbbonamento;
import enums.TipoMezzo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("build_week_jpa3");
        EntityManager em = emf.createEntityManager();

        BigliettoDao bigliettoDao = new BigliettoDao(em);
        UtenteDao utenteDao = new UtenteDao(em);
        TesseraDao tesseraDao = new TesseraDao(em);
        ViaggioDao viaggioDao = new ViaggioDao(em);
        AbbonamentoDao abbonamentoDao = new AbbonamentoDao(em);
        TrattaDao trattaDao = new TrattaDao(em);
        RivenditoreDao rivenditoreDao = new RivenditoreDao(em);
        ManutenzioneDao manutenzioneDao = new ManutenzioneDao(em);
        DistributoreDao distributoreDao = new DistributoreDao(em);
        MezzoDao mezzoDao = new MezzoDao(em);
        TicketDao ticketDao = new TicketDao(em);
        AtmDao atmDao = new AtmDao(em);
        PeriodoServizioDao periodoServizioDao = new PeriodoServizioDao(em);

//        //MEZZI
//        //AUTOBUS
//        Mezzo mezzoAutobus = new Mezzo();
//        mezzoAutobus.setTipoMezzo(TipoMezzo.AUTOBUS);
//        mezzoAutobus.setCapienza(30);
//        mezzoAutobus.setInizioServizio(LocalDate.of(2024, 1, 1));
//        mezzoAutobus.setFineServizio(LocalDate.of(2024, 1, 31));
//        mezzoAutobus.aggiungiPeriodoServizio(mezzoAutobus.getInizioServizio(), mezzoAutobus.getFineServizio());
//        mezzoAutobus.aggiungiPeriodoServizio(LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 29));
//        try {
//            mezzoDao.save(mezzoAutobus);
//            System.out.println("Il mezzo AUTOBUS è stato aggiunto con successo");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Errore nel salvataggio del mezzo AUTOBUS");
//        }
//
//
//        //TRAM
//        Mezzo mezzoTram = new Mezzo();
//        mezzoTram.setTipoMezzo(TipoMezzo.TRAM);
//        mezzoTram.setCapienza(300);
//        mezzoTram.setInizioServizio(LocalDate.of(2024, 1, 1));
//        mezzoTram.setFineServizio(LocalDate.of(2024, 1, 31));
//        mezzoTram.aggiungiPeriodoServizio(mezzoTram.getInizioServizio(), mezzoTram.getFineServizio());
//        mezzoTram.aggiungiPeriodoServizio(LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 29));
//        try {
//            mezzoDao.save(mezzoTram);
//            System.out.println("Il mezzo TRAM è stato aggiunto con successo");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Errore nel salvataggio del mezzo TRAM");
//        }
//
//        //MANUTENZIONE
//        List<Manutenzione> manutenzioni = new ArrayList<>();
//        manutenzioni.add(manutenzioneDao.getById(1));
//        Manutenzione manutenzione1 = new Manutenzione();
//        manutenzione1.setDataInizio(LocalDate.of(2024, 2, 4));
//        manutenzione1.setDataFine(LocalDate.of(2024, 5, 12));
//        manutenzione1.setMezzo(mezzoTram);
//        try {
//            manutenzioneDao.save(manutenzione1);
//            System.out.println("La manutenzione è stata aggiunta con successo");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Errore nel salvataggio della manutenzione");
//        }
//
//
//
//        mezzoAutobus.setManutenzioni(manutenzioni);
//        try {
//            mezzoDao.update(mezzoAutobus);
//            System.out.println("Il mezzo è stato aggiunto alla manutenzione con successo");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Errore nel salvataggio la manutenzione");
//        }
//
//
//        manutenzione1.setMezzo(mezzoTram);
//        try {
//            manutenzioneDao.update(manutenzione1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        //VIAGGIO
//        Viaggio viaggio1 = new Viaggio();
//        List<Viaggio> viaggi = new ArrayList<>();
//        viaggi.add(viaggioDao.getById(1));
//        viaggio1.setInizio(LocalDateTime.of(2024,5,7,9,24));
//        viaggio1.setArrivo(LocalDateTime.of(2024,5,7,11,50));
//        viaggio1.setData(LocalDate.of(2024, 5, 7));
//        viaggio1.setTratta(trattaDao.getById(16));
//        viaggio1.setMezzo(mezzoAutobus);
//        try {
//            viaggioDao.save(viaggio1);
//            System.out.println("Viaggio aggiunto con successo");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Errore nel salvataggio del viaggio");
//        }
//
//
//        //TRATTA
//        Tratta tratta1 = new Tratta();
//        tratta1.setTempoMedio(20);
//        tratta1.setCapolinea("Stazione centrale");
//        tratta1.setZonaPartenza("Stazione Notarbartolo");
//        tratta1.setTicket(abbonamentoDao.getById(11));
//        try {
//            trattaDao.save(tratta1);
//            System.out.println("La Tratta è stata aggiunta con successo");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Errore nel salvataggio della Tratta");
//        }
//
//        viaggio1.setTratta(trattaDao.getById(5));
//        try {
//            viaggioDao.update(viaggio1);
//            System.out.println("La Tratta è stata associata con il viaggio con successo");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Errore nel salvataggio della Tratta2");
//        }
//
//        //BIGLIETTO 1
//        Biglietto biglietto1 = new Biglietto();
//        List<Biglietto> biglietti = new ArrayList<>();
//        biglietti.add(bigliettoDao.getById(1));
//        biglietto1.setCodiceUnivoco("rv");
//        biglietto1.setPrezzo(2.2);
//        biglietto1.setDataEmissione(LocalDate.of(2024, 5, 7));
//        biglietto1.setVidimato(true);
//        biglietto1.setMezzo(mezzoAutobus);
//
//        try {
//            ticketDao.save(biglietto1);
//            System.out.println("Biglietto 1 è stato salvato correttamente");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("Biglietto 1  già esistente ");
//        }
//
//
//        //BIGLIETTO 2
//        Biglietto biglietto2 = new Biglietto();
//        biglietti.add(biglietto2);
//        biglietto2.setCodiceUnivoco("atm");
//        biglietto2.setPrezzo(2.5);
//        biglietto2.setDataEmissione(LocalDate.of(2024, 5, 7));
//        biglietto2.setVidimato(true);
//        biglietto2.setMezzo(mezzoTram);
//
//        try {
//            ticketDao.save(biglietto2);
//            System.out.println("Biglietto 2 è stato salvato correttamente");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("Biglietto 2 già esistente ");
//        }
//
//
//        //TESSERRA
//        Tessera tessera1 = new Tessera();
//        tessera1.setNumeroTessera("A123456");
//        tessera1.setDataEmissione(LocalDate.of(2024, 5, 7));
//        tessera1.setDataScadenza(LocalDate.of(2025, 5, 7));
//        try {
//            tesseraDao.save(tessera1);
//            System.out.println("Tessera salvato correttamente");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("Tessera già esistente ");
//        }
//
        //        //TESSERRA2
//        Tessera tessera2 = new Tessera();
//        tessera2.setNumeroTessera("B123456");
//        tessera2.setDataEmissione(LocalDate.of(2023, 5, 7));
//        tessera2.setDataScadenza(LocalDate.of(2024, 5, 7));
//        try {
//            tesseraDao.save(tessera2);
//            System.out.println("Tessera salvato correttamente");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("Tessera già esistente ");
//        }

//        //UTENTE
//        Utente utente1 = new Utente();
//        List<Utente> utenti = new ArrayList<>();
//        utenti.add(utenteDao.getById(8));
//        utente1.setNome("Elena");
//        utente1.setCognome("Kekic");
//
//        try {
//            utenteDao.save(utente1);
//            System.out.println("Utente " + utente1.getNome() + " " + utente1.getCognome() + " è stato/a aggiunto/a con successo");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Errore nel salvataggio di Utente");
//        }
//
//        biglietto1.setUtente(utenteDao.getById(8));
//        try {
//            ticketDao.update(biglietto1);
//            System.out.println("Biglietto 1 è stato aggiornato correttamente");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        biglietto2.setUtente(utenteDao.getById(8));
//        try {
//            ticketDao.update(biglietto2);
//            System.out.println("Biglietto 2 è stato aggiornato correttamente");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //DISTRIBUTORE
//        //ATM
//        Atm atm1 = new Atm();
//        atm1.setAttivo(true);
//        atm1.setFuoriServizio(false);
//        try {
//            distributoreDao.save(atm1);
//            System.out.println("Atm è salvato correttamente");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("Atm già esistente ");
//        }
//
//
//        //RIVENDITORE
//        Rivenditore rivenditore1 = new Rivenditore();
//        rivenditore1.setNome("Rivenditore Piazza Garibaldi");
//        try {
//            distributoreDao.save(rivenditore1);
//            System.out.println("Rivenditore è stato salvato correttamente");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("Rivenditore già esistente ");
//        }
//
//        biglietto1.setDistributore(distributoreDao.getById(9));
//        try {
//            bigliettoDao.update(biglietto1);
//            System.out.println("Il biglietto è stato associato correttamente al distributore");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("Il biglietto è stato associato correttamente al distributore");
//        }
//
//
//        biglietto2.setDistributore(distributoreDao.getById(10));
//        try {
//            bigliettoDao.update(biglietto2);
//            System.out.println("Il biglietto è stato associato correttamente al distributore");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("Il biglietto NON è stato associato correttamente al distributore");
//        }
//
//        utente1.setTessera(tesseraDao.getById("A123456"));
//        try {
//            utenteDao.update(utente1);
//            System.out.println("La tessera è stata associata correttamente all'utente");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("La tessera NON è stata associata correttamente all'utente");
//        }
//
//
//        //ABBONAMENTO
//        Abbonamento abbonamento1 = new Abbonamento();
//        ;
//        abbonamento1.setTipoAbbonamento(TipoAbbonamento.MENSILE);
//        abbonamento1.setCodiceUnivoco("A1523");
//        abbonamento1.setPrezzo(70);
//        abbonamento1.setDistributore(distributoreDao.getById(9));
//        abbonamento1.setDataEmissione(LocalDate.of(2024, 5, 7));
//        abbonamento1.setDataScadenza(LocalDate.of(2024, 6, 7));
//        abbonamento1.setUtente(utenteDao.getById(8));
//        try {
//            ticketDao.save(abbonamento1);
//            System.out.println("Abbonamento salvato correttamente");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("Abbonamento già esistente ");
//        }
//
//        tratta1.setTicket(abbonamentoDao.getById(11));
//        try {
//            trattaDao.update(tratta1);
//            System.out.println("La Tratta è stata aggiornata con successo");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Errore nel salvataggio della Tratta");
//        }
//
//        //PERIODO DI SERVIZIO
//        PeriodoServizio periodoServizio = new PeriodoServizio();
//        periodoServizio.setInizio(LocalDate.of(2024, 3, 1));
//        periodoServizio.setFine(LocalDate.of(2024, 7, 2));
//        periodoServizio.setMezzo(mezzoDao.getById(1));
//        try {
//            periodoServizioDao.save(periodoServizio);
//            System.out.println("Periodo servizio è stato salvato correttamente");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("Periodo servizio già esistente");
//        }


        System.out.println("--------------------------------------------------------------------");

        List<Tessera> rinnovoScadenzaTessera=tesseraDao.getRinnovoScadenzaTessera();;
        System.out.println("Tessere da rinnovare:");
        for (Tessera tessera : rinnovoScadenzaTessera) {
            System.out.println(tessera);
            // Rinnova la tessera
            tessera.setDataScadenza(tessera.getDataScadenza().plusYears(1));
            tesseraDao.update(tessera);
            System.out.println("Tessera rinnovata per un altro anno.");
        }

        System.out.println("--------------------------------------------------------------------");
        System.out.println();
        System.out.println("Conta il numero totale di biglietti emessi nel periodo specificato");
        System.out.println();
        Long totalTickets = bigliettoDao.countTotalTickets(LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 12, 31));
        System.out.println("Numero totale di biglietti emessi: " + totalTickets);

        // Conta il numero totale di abbonamenti emessi nel periodo specificato
        Long totalSubscriptions = abbonamentoDao.countTotalSubscriptions(LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 12, 31));
        System.out.println("Numero totale di abbonamenti emessi: " + totalSubscriptions);


        System.out.println("--------------------------------------------------------------------");


        // Conta il numero di biglietti emessi dal distributore specificato nel periodo specificato
        Long ticketsByDistributor = ticketDao.countTicketsByDistributor(LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 12, 31), distributoreDao.getById(9));
        System.out.println("Numero di biglietti emessi dal ATM: " + ticketsByDistributor);


        // Conta il numero di abbonamenti emessi dal distributore specificato nel periodo specificato
        Long subscriptionsByDistributor = abbonamentoDao.countSubscriptionsByDistributor(LocalDate.of(2024,
                        1, 1),
                LocalDate.of(2024, 12, 31), distributoreDao.getById(10));
        System.out.println("Numero di abbonamenti emessi dal rivenditore: " + subscriptionsByDistributor);


        System.out.println("--------------------------------------------------------------------");


        //controllo valido di un abbonamento
        try {
            boolean abbonamentoValido = ticketDao.verificaValiditaAbbonamento("A123456");
            System.out.println("L'abbonamento A123456 è valido? " + abbonamentoValido);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Errore: " + e.getMessage());
        }


        System.out.println("--------------------------------------------------------------------");


        // Ottieni le manutenzioni del mezzo
        List<Manutenzione> manutenzioni1 = mezzoDao.getManutenzioniByMezzo(mezzoDao.getById(2));
        System.out.println("Manutenzioni del mezzo " + mezzoDao.getById(2) + " SONO: " + manutenzioni1);

        List<PeriodoServizio> periodiServizio = periodoServizioDao.getPeriodiServizioByMezzo(mezzoDao.getById(1));
        System.out.println("Periodi di servizio del mezzo " + mezzoDao.getById(1) + " SONO:");
        for (PeriodoServizio periodo : periodiServizio) {
            System.out.println(periodo);
        }


        System.out.println("--------------------------------------------------------------------");


        // Conta il numero di biglietti vidimati sul MEZZOAUTOBUS
        try {
            long numBigliettiVidimati = bigliettoDao.countVidimatiByMezzo(mezzoDao.getById(1));
            System.out.println("Numero di biglietti vidimati sul mezzo autobus: " + numBigliettiVidimati);
        } catch (Exception e) {e.printStackTrace();
            System.err.println("Si è verificato un errore durante il conteggio dei biglietti vidimati: " + e.getMessage());
        }

        // Conta il numero di biglietti vidimati sul MEZZOTRAM
        try {
            long numBigliettiVidimati = bigliettoDao.countVidimatiByMezzo(mezzoDao.getById(2));
            System.out.println("Numero di biglietti vidimati sul mezzo tram: " + numBigliettiVidimati);
        } catch (Exception e) {e.printStackTrace();
            System.err.println("Si è verificato un errore durante il conteggio dei biglietti vidimati: " + e.getMessage());
        }

        // Conta il numero di biglietti vidimati nel periodo specificato
        try {
            long vidimatiByPeriod = bigliettoDao.countVidimatiByPeriod(LocalDate.of(2024, 1, 1),
                    LocalDate.of(2024, 12, 31));
            System.out.println("Numero di biglietti vidimati nel periodo 01-01-2024 - 31-12-2024: " + vidimatiByPeriod);
        } catch (Exception e) {e.printStackTrace();
            System.err.println("Errore durante l'esecuzione delle query: " + e.getMessage());
        }


        System.out.println("--------------------------------------------------------------------");

        Integer ricerca = mezzoDao.countViaggiByMezzoAndTratta(mezzoDao.getById(1),trattaDao.getById(5));
        System.out.println("Totale tratte per questo mezzo: "+ ricerca);

        System.out.println("Tempo effettivo di percorrenza del viaggio scelto: " + viaggioDao.getById(4).getTempoEffettivoPercorrenza());

    }
}


