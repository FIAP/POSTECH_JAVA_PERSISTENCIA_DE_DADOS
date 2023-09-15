package escola.example.escola.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Data
@Entity
public class Testes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   
    
    private Date dataEnvio; 
    
    private Date dataFinalizacao;

    @OneToOne()
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

}