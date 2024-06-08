package BW_5.gruppo_3.entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import BW_5.gruppo_3.Enums.StatoFattura;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Fattura {

    @Id
    @GeneratedValue
    private int numeroFattura;

    private LocalDate data;
    private double importo;

    @Enumerated(EnumType.STRING)
    private StatoFattura statoFattura;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIncludeProperties(value = {"id","ragioneSociale","email"})
    private Cliente cliente;

}
