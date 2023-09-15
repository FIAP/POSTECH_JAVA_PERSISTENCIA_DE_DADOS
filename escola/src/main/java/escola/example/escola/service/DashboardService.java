package escola.example.escola.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escola.example.escola.model.Professor;
import escola.example.escola.repository.IAlunoRepository;
import escola.example.escola.repository.IClienteRepository;
import escola.example.escola.repository.IProfessorRepository;
import escola.example.escola.repository.ITesteRepository;


@Service
public class DashboardService implements IDashService {

    private IAlunoRepository _alunoRepository;
    private IClienteRepository _clienteRepository;
    private ITesteRepository _testeRepository;
    private IProfessorRepository _professorRepository;

    @Autowired
    public DashboardService(
            IClienteRepository clienteRepository,
            IAlunoRepository alunoRepository,
            ITesteRepository testeRepository,
            IProfessorRepository professorRepository) {
        this._clienteRepository = clienteRepository;
        this._alunoRepository = alunoRepository;
        this._testeRepository = testeRepository;
        this._professorRepository = professorRepository;
    }

    @Override
    public List<Object[]> BuscarAlunosPorMes() {
        return _alunoRepository.BuscarAlunosPorMes();
    }

    public List<Object[]> buscarTotalNovosClientes() {
        return _clienteRepository.buscarTotalNovosClientes();
    }

    public List<Object[]> buscarTotalEnvioAcessosUltimoMes() {
        Date thirtyDaysAgo = java.sql.Date.valueOf(LocalDate.now().minusDays(30));

        return _alunoRepository.buscarTotalEnvioAcessos(thirtyDaysAgo);
    }

    public List<Object[]> buscarTotalTestesFinalizados() {
        return _testeRepository.buscarTotalTestesFinalizados();
    }

    public List<Professor> buscarProfessores() {
        return _professorRepository.findAll();
    }

}
