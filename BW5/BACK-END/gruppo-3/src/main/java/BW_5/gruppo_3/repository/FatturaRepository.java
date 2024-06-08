package BW_5.gruppo_3.repository;

import BW_5.gruppo_3.Enums.StatoFattura;
import BW_5.gruppo_3.entity.Cliente;
import BW_5.gruppo_3.entity.Fattura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FatturaRepository extends JpaRepository<Fattura, Integer> {

    public List<Fattura> findByCliente (Cliente cliente);

    public List<Fattura> findByStatoFattura (StatoFattura statoFattura);

    @Query("SELECT f FROM Fattura f WHERE f.data = :data")
    public List<Fattura> findByDataInserimento (@Param("data") LocalDate data);

//    @Query("SELECT f FROM Fattura f WHERE YEAR(f.dataInserimento) = :anno")
//    public List<Fattura> findByAnno(@Param("anno") int anno);

    //@Query("SELECT f FROM Fattura f WHERE f.dataInserimento BETWEEN :startDate AND :endDate")
    //@Query("SELECT f FROM Fattura f WHERE FUNCTION('YEAR', f.data) = :anno")
    @Query("SELECT f FROM Fattura f WHERE EXTRACT(YEAR FROM f.data) = :anno")
    public List<Fattura> findByAnno(@Param("anno") int anno);


    @Query("SELECT f FROM Fattura f WHERE f.importo BETWEEN :importoMin AND :importoMax ORDER BY f.importo DESC")
    public List<Fattura> fatturePerRangeDiImporti (@Param("importoMin") double importoMin, @Param("importoMax") double importoMax);
}
