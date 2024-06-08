package BW_5.gruppo_3.DTO;

import jakarta.validation.constraints.NotBlank;

public class ComuneDTO {
@NotBlank(message = "Inserire codice provincia")
    private String codiceProvincia;
    @NotBlank(message = "Inserire progressivo comune")
    private String progressivoComune;
    @NotBlank(message = "Inserire denominazione comune")
    private String denominazione;
}
