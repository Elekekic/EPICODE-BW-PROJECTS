package entity.rivenditori;

import entity.biglietto.Ticket;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "distributori")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Distributore {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "distributore")
    private List<Ticket> tickets;

    public Distributore(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Distributore() {
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Distributore{" +
                "id=" + id +
                ", tickets=" + tickets +
                '}';
    }
}
