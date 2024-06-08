package BW_5.gruppo_3.Exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Error {
    private String messaggio;
    private LocalDateTime dataErrore;
}
