package escola.example.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import escola.example.escola.model.Professor;
import escola.example.escola.service.IDashService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/dashboard")
public class DashboardController {

    @Autowired
    private IDashService _service;

    @GetMapping("/buscar-alunos-por-mes")
    public ResponseEntity<List<Object[]>> buscarAlunosPorMes() {
        return ResponseEntity.status(HttpStatus.OK).body(_service.BuscarAlunosPorMes());
    }

    @GetMapping("/buscar-total-novos-clientes")
    public ResponseEntity<List<Object[]>> buscarTotalNovosClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(_service.buscarTotalNovosClientes());
    }

    @GetMapping("/buscar-total-de-envio-acessos")
    public ResponseEntity<List<Object[]>> buscarTotalEnvioAcessos() {
        return ResponseEntity.status(HttpStatus.OK).body(_service.buscarTotalEnvioAcessosUltimoMes());
    }

    @GetMapping("/buscar-total-de-testes-finalizados")
    public ResponseEntity<List<Object[]>> buscarTotalTestesFinalizados() {
        return ResponseEntity.status(HttpStatus.OK).body(_service.buscarTotalTestesFinalizados());
    }

    @GetMapping("/buscar-professores")
    public ResponseEntity<List<Professor>> buscarProfessores() {
        return ResponseEntity.status(HttpStatus.OK).body(_service.buscarProfessores());
    }

}
