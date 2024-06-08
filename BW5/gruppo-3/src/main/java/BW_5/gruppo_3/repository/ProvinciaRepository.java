package BW_5.gruppo_3.repository;

import BW_5.gruppo_3.entity.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia,Integer> {

    public Optional<Provincia> findByProvincia(String provincia);

}
