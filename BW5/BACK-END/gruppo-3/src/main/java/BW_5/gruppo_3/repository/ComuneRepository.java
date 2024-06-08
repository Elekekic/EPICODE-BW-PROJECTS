package BW_5.gruppo_3.repository;

import BW_5.gruppo_3.entity.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ComuneRepository extends JpaRepository<Comune,Integer> {

    public Optional<Comune> findByDenominazione(String denominazione);
}
