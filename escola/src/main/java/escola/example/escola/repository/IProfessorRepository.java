package escola.example.escola.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import escola.example.escola.model.Professor;

public interface IProfessorRepository extends JpaRepository<Professor, Long> {  
  
}
