package escola.example.escola.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import escola.example.escola.model.Aluno;

public interface IAlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT TO_CHAR(a.dataCriacao, 'MM') AS mes, COUNT(*) AS quantidade FROM Aluno a  GROUP BY mes ORDER BY mes")
    List<Object[]> BuscarAlunosPorMes();
    
    @Query("SELECT TO_CHAR(a.dataCriacao, 'MM') AS mes, COUNT(*) AS quantidade " +
           "FROM Aluno a " +
           "WHERE a.dataCriacao >= :thirtyDaysAgo " +
           "GROUP BY mes " +
           "ORDER BY mes")
    List<Object[]> buscarTotalEnvioAcessos(@Param("thirtyDaysAgo") Date thirtyDaysAgo);

    
}
