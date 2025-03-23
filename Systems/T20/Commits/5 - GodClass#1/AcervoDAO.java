package sgab.model.dao;

/**
 *
 * @author iulli e letícia
 */


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import sgab.model.dto.Exemplar;
import sgab.model.dto.util.AcervoHelper;
import sgab.model.dto.util.ExemplarStatus;
import sgab.model.dto.util.ExemplarTipo;
import sgab.model.exception.PersistenciaException;
import java.util.ArrayList;
import sgab.model.dto.Autor;
import sgab.model.dto.Biblioteca;
import sgab.util.Helpers;

public class AcervoDAO implements GenericDAO<Exemplar, Long>{
    private Map<Long, Exemplar> exemplares = new HashMap<>();
    
    private static AcervoDAO acervoDAO;
    static{
        AcervoDAO.acervoDAO = null;
    }
    
    private static Long ids;
    static{
        AcervoDAO.ids = 0L;
    }
    
    public static Long getNextId() {
        return AcervoDAO.ids++;
    }
    
    private AcervoDAO() {}
    
    public static AcervoDAO getInstance() {
        if (acervoDAO == null) {
            acervoDAO = new AcervoDAO();
        }
        return acervoDAO;
    }
    
    
    @Override
    public void inserir(Exemplar exemplar) {
        exemplar.setId(AcervoDAO.getNextId());
        exemplares.put(exemplar.getId(), exemplar);
    }
    
     @Override
    public void alterar(Exemplar exemplar) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    @Override
    public Exemplar pesquisar(Long key) {
        return exemplares.get(key);
    }
    
    public List<Exemplar> listarRestauracao(Biblioteca biblioteca) {
        List<Exemplar> listExemplares = new ArrayList<>();
        
        for (Exemplar exe: exemplares.values())
            if (exe.getStatus() == ExemplarStatus.REPARO && exe.getBibliotecaPosse() == biblioteca)
                listExemplares.add(exe);
        
        return listExemplares;
    }
    
    public List<Exemplar> listarConsulta(Biblioteca biblioteca) {
        List<Exemplar> listExemplar = new ArrayList<>();
        
        for (Exemplar exe: exemplares.values()) {
            if (AcervoHelper.exemplarDisponivelParaConsulta(exe, biblioteca))
                listExemplar.add(exe);
        }
        
        return listExemplar;
    }
    
    public List<Exemplar> listarTransferencia(Biblioteca biblioteca) {
        List<Exemplar> listExemplar = new ArrayList<>();
        
        for (Exemplar exe: exemplares.values())
            if (exe.getStatus() == ExemplarStatus.TRANSFERENCIA && exe.getBibliotecaPosse() == biblioteca)
                listExemplar.add(exe);
        
        return listExemplar;
    }
    
    public boolean mudaStatus(Long id, ExemplarStatus status){
        Exemplar exemplarAlvo = pesquisar(id);
        if(exemplarAlvo == null)
            throw new PersistenciaException("Nenhum exemplar");
        exemplarAlvo.setStatus(status);
        return true;
    }
    
    public boolean mudaTipo(Long id, ExemplarTipo tipo){
        Exemplar exemplarAlvo = pesquisar(id);
        if(exemplarAlvo == null || exemplarAlvo.getStatus() == ExemplarStatus.DESATIVADA)
            throw new PersistenciaException("Nenhum exemplar desse id encontrado");
        exemplarAlvo.setTipo(tipo);
        return true;
    }
    
    public List<Exemplar> listarAcervoBiblioteca(Biblioteca biblioteca){
        List<Exemplar> resultados = new LinkedList<>();
        for(Exemplar exemplar : exemplares.values()){
            if(exemplar.getBibliotecaPosse() == biblioteca && exemplar.getStatus() != ExemplarStatus.DESATIVADA){
                resultados.add(exemplar);
            }
        }
        return resultados;
    }

    public boolean disponibilizar(Long id){
        mudaStatus(id, ExemplarStatus.DISPONIVEL);
        return true;
    }
    
    public List<Exemplar> listarAcervoParaReserva(){
        List<Exemplar> resultados = new LinkedList<>();
        for(Exemplar exemplar : exemplares.values()){
            if(AcervoHelper.exemplarDisponivelParaReserva(exemplar)){
                resultados.add(exemplar);
            }
        }
        return resultados;
    }
    
    public List<Exemplar> listarAcervoParaReserva(String titulo){
        List<Exemplar> resultados = new LinkedList<>();
        for(Exemplar exemplar : exemplares.values()){
            if(Helpers.checaSemelhanca(exemplar.getObra().getTitulo(), titulo)
                    && AcervoHelper.exemplarDisponivelParaReserva(exemplar)){
                resultados.add(exemplar);
            }
        }
        return resultados;
    }
    
    public List<Exemplar> listarAcervoParaReserva(Autor autor){
        List<Exemplar> resultados = new LinkedList<>();
        for(Exemplar exemplar : exemplares.values()){
            if(exemplar.getObra().getAutor().equals(autor)
                    && AcervoHelper.exemplarDisponivelParaReserva(exemplar)) {
                resultados.add(exemplar);
            }
        }
        return resultados;
    }
    
    public List<Exemplar> listarAcervoParaReserva(Biblioteca biblioteca){
        List<Exemplar> resultados = new LinkedList<>();
        for(Exemplar exemplar : exemplares.values()){
            if(exemplar.getBibliotecaPosse().equals(biblioteca) && AcervoHelper.exemplarDisponivelParaReserva(exemplar)){
                resultados.add(exemplar);
            }
        }
        return resultados;
    }
}
