package BW_5.gruppo_3.Service;

import BW_5.gruppo_3.DTO.IndirizzoDto;
import BW_5.gruppo_3.entity.Indirizzo;
import BW_5.gruppo_3.repository.ClienteRepository;
import BW_5.gruppo_3.repository.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndirizzoService {

    @Autowired
    private IndirizzoRepository indirizzoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public String saveIndirizzo(IndirizzoDto indirizzoDto) {

        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setVia(indirizzoDto.getVia());
        indirizzo.setCap(indirizzoDto.getCap());
        indirizzo.setLocalita(indirizzoDto.getLocalita());
        indirizzo.setCivico(indirizzoDto.getCivico());
        indirizzo.setTipoIndirizzo(indirizzoDto.getTipoIndirizzo());

        indirizzoRepository.save(indirizzo);

        return "Indirizzo con ID: " + indirizzo.getId() + " creata correttamente.";
    }

}
