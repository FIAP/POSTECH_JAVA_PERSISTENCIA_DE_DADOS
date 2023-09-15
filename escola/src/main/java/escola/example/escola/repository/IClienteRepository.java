package escola.example.escola.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import escola.example.escola.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

      @Query("SELECT TO_CHAR(a.dataCriacao, 'MM') AS mes, COUNT(*) AS quantidade " +
           "FROM Cliente a " +
           "GROUP BY mes " +
           "ORDER BY mes")
    List<Object[]> buscarTotalNovosClientes();     
}
