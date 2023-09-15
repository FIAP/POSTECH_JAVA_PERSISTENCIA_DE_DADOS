package escola.example.escola.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import escola.example.escola.model.Testes;

public interface ITesteRepository extends JpaRepository<Testes, Long> {

       @Query("SELECT TO_CHAR(a.dataFinalizacao, 'MM') AS mes, COUNT(*) AS quantidade " +
       "FROM Testes a " +
       "GROUP BY mes " +
       "ORDER BY mes")
    List<Object[]> buscarTotalTestesFinalizados(); 
    
}
