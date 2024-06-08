package BW_5.gruppo_3.Service;

import BW_5.gruppo_3.Exception.NotFoundException;
import BW_5.gruppo_3.entity.Provincia;
import BW_5.gruppo_3.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinciaService {
    @Autowired
    private ProvinciaRepository provinciaRepository;


    public Provincia findByProvincia(String provincia ){
        Optional<Provincia> provinciaOptional = provinciaRepository.findByProvincia(provincia);
                if(provinciaOptional.isPresent()) {
                    return provinciaOptional.get();

                }
                else {
                    throw new NotFoundException("Provincia non trovata");
                }
    }
}
