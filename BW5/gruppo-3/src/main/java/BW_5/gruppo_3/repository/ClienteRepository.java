package BW_5.gruppo_3.repository;

import BW_5.gruppo_3.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    public Optional<Cliente> findByEmail(String email);

    @Query(value = "SELECT c FROM Cliente c JOIN c.indirizzi i WHERE i.tipoIndirizzo = LEGALE ORDER BY i.comune.provincia.provincia")
    public List<Cliente> clientiOrderByProvinciaSedeLegale();

    @Query(value = "SELECT c FROM Cliente c WHERE c.fatturatoAnnuale BETWEEN :fatturatoMin AND :fatturatoMax ORDER BY c.fatturatoAnnuale DESC")
    public List<Cliente> clientiFilteredByFatturatoAnnuale(@Param("fatturatoMin") double fatturatoMin, @Param("fatturatoMax") double fatturatoMax);

    public List<Cliente> findByDataInserimento (LocalDate dataInserimento);

    public List<Cliente> findByDataUltimoContatto (LocalDate dataUltimoContatto);


public List<Cliente> findByRagioneSocialeContaining(String like);


}
