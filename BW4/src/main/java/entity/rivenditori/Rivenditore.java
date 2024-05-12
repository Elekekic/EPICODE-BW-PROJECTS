package entity.rivenditori;

import entity.biglietto.Ticket;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rivendentori")
public class Rivenditore extends Distributore {


    private String nome;

    public Rivenditore(List<Ticket> tickets, String nome) {
        super(tickets);
        this.nome = nome;
    }

    public Rivenditore() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Rivenditore{}";
    }
}

