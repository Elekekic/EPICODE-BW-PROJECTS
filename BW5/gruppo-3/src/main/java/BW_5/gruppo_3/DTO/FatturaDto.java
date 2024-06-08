package BW_5.gruppo_3.DTO;

import BW_5.gruppo_3.Enums.StatoFattura;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDate;


@Data
public class FatturaDto {

    private LocalDate data;

    @Min(value = 0)
    private double importo;

    private StatoFattura statoFattura;


    @Min(value = 1)
    private int clienteId;

}
