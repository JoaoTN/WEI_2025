package sgab.model.dto.util;

import java.util.LinkedList;
import java.util.List;

import sgab.model.dto.Biblioteca;
import sgab.model.dto.Exemplar;

public class AcervoHelper {
    public static List<String> validarExemplar(Exemplar exemplar){
        List<String> erros = new LinkedList<>();
        if(exemplar == null){
            erros.add("Exemplar não pode ser null.");
        }
        else{
            if(exemplar.getObra() == null){
                erros.add("Obra não pode ser null.");
            }
            if(exemplar.getBibliotecaPosse() == null){
                erros.add("A biblioteca não pode ser null.");
            }
        }
        
        return erros;
    }

    public static boolean exemplarDisponivelParaReserva(Exemplar exemplar) {
        ExemplarStatus status = exemplar.getStatus();
        ExemplarTipo tipo = exemplar.getTipo();
        boolean ativo = status != ExemplarStatus.DESATIVADA;
        boolean reparo = status != ExemplarStatus.REPARO;
        boolean transferencia = status != ExemplarStatus.TRANSFERENCIA;
        boolean normal = tipo == ExemplarTipo.NORMAL;

        return ativo && reparo && transferencia && normal;
    }

    public static boolean exemplarDisponivelParaConsulta(Exemplar exemplar, Biblioteca biblioteca) {
        boolean tipoConsulta = exemplar.getTipo() == ExemplarTipo.CONSULTA;
        boolean ativo = exemplar.getStatus() != ExemplarStatus.DESATIVADA;
        boolean pertenceBiblioteca = exemplar.getBibliotecaPosse() == biblioteca;

        return tipoConsulta && ativo && pertenceBiblioteca;
    }
}
