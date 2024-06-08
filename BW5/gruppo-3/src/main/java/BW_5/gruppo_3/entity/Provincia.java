package BW_5.gruppo_3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Provincia {
    @Id
    @GeneratedValue
    private int id;

    private String sigla;
    private String provincia;
    private String regione;

    @JsonIgnore
    @OneToMany(mappedBy = "provincia", fetch = FetchType.EAGER)
    private List<Comune> comuni;


}
