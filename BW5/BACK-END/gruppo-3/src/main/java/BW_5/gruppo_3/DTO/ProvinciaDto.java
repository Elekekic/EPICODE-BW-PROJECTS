package BW_5.gruppo_3.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProvinciaDto {

    @NotBlank(message = "La sigla non può essere vuota, mancante o composta da soli spazi")
    private String sigla;

    @NotBlank(message = "La provincia non può essere vuota, mancante o composta da soli spazi")
    private String provincia;

    @NotBlank(message = "La regione non può essere vuota, mancante o composta da soli spazi")
    private String regione;

}
