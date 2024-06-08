package BW_5.gruppo_3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import BW_5.gruppo_3.Enums.TipoIndirizzo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Indirizzo {

    @Id
    @GeneratedValue
    private int id;

    private String via;

    private int civico;

    private String localita;

    private String cap;

    @ManyToOne
    @JoinColumn(name = "comune_id")
    private Comune comune;

    @Enumerated(EnumType.STRING)
    private TipoIndirizzo tipoIndirizzo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;


}
