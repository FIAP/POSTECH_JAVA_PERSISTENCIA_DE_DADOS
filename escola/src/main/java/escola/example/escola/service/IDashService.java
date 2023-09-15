package escola.example.escola.service;

import java.util.List;

import escola.example.escola.model.Professor;

public interface IDashService {
     List<Object[]> BuscarAlunosPorMes();
     List<Object[]> buscarTotalNovosClientes();
     List<Object[]> buscarTotalEnvioAcessosUltimoMes();
     List<Object[]> buscarTotalTestesFinalizados();
     List<Professor> buscarProfessores();

}
