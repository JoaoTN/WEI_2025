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
import sgab.model.dto.util.ExemplarStatus;
import sgab.model.dto.util.ExemplarTipo;
import sgab.model.exception.PersistenciaException;
import java.util.ArrayList;
import sgab.model.dto.Autor;
import sgab.model.dto.Biblioteca;

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
            if (exemplarDisponivelParaConsulta(exe, biblioteca))
                listExemplar.add(exe);
        }
        
        return listExemplar;
    }

    private boolean exemplarDisponivelParaConsulta(Exemplar exemplar, Biblioteca biblioteca) {
        boolean tipoConsulta = exemplar.getTipo() == ExemplarTipo.CONSULTA;
        boolean ativo = exemplar.getStatus() != ExemplarStatus.DESATIVADA;
        boolean pertenceBiblioteca = exemplar.getBibliotecaPosse() == biblioteca;

        return tipoConsulta && ativo && pertenceBiblioteca;
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
            if(exemplarDisponivelParaReserva(exemplar)){
                resultados.add(exemplar);
            }
        }
        return resultados;
    }
    
    public List<Exemplar> listarAcervoParaReserva(String titulo){
        List<Exemplar> resultados = new LinkedList<>();
        for(Exemplar exemplar : exemplares.values()){
            if(checaSemelhanca(exemplar.getObra().getTitulo(), titulo) && exemplarDisponivelParaReserva(exemplar)){
                resultados.add(exemplar);
            }
        }
        return resultados;
    }
    
    public List<Exemplar> listarAcervoParaReserva(Autor autor){
        List<Exemplar> resultados = new LinkedList<>();
        for(Exemplar exemplar : exemplares.values()){
            if(exemplar.getObra().getAutor().equals(autor) && exemplarDisponivelParaReserva(exemplar)) {
                resultados.add(exemplar);
            }
        }
        return resultados;
    }
    
    public List<Exemplar> listarAcervoParaReserva(Biblioteca biblioteca){
        List<Exemplar> resultados = new LinkedList<>();
        for(Exemplar exemplar : exemplares.values()){
            if(exemplar.getBibliotecaPosse().equals(biblioteca) && exemplarDisponivelParaReserva(exemplar)){
                resultados.add(exemplar);
            }
        }
        return resultados;
    }

    private boolean exemplarDisponivelParaReserva(Exemplar exemplar) {
        ExemplarStatus status = exemplar.getStatus();
        ExemplarTipo tipo = exemplar.getTipo();
        boolean ativo = status != ExemplarStatus.DESATIVADA;
        boolean reparo = status != ExemplarStatus.REPARO;
        boolean transferencia = status != ExemplarStatus.TRANSFERENCIA;
        boolean normal = tipo == ExemplarTipo.NORMAL;

       return ativo && reparo && transferencia && normal;
    }
     
    private boolean checaSemelhanca(String nomeObra, String nomeInput){
        String nomeA = nomeObra.toLowerCase();
        String nomeB = nomeInput.toLowerCase();
        float count = 0;
        
        //iguala o tamanho das Strings
        if(nomeA.length() > nomeB.length()){
            for(int i =0; i < (nomeObra.length() - nomeInput.length()); i++){
                nomeB = nomeB.concat(" ");
            }
        }
        if(nomeA.length() < nomeB.length()){
            for(int i =0; i < (nomeObra.length() - nomeInput.length()); i++){
                nomeA = nomeA.concat(" ");
            }
        }
        
        for(int i=0, j=0; i<nomeA.length(); i++, j++) { 
            if(nomeA.charAt(i) != nomeB.charAt(j)){
                count++;
                if(i+1 == nomeA.length())
                    continue;
                if(nomeA.charAt(i+1)==nomeB.charAt(j))
                    j--;
            }
        }
        float porcentagem = count / nomeA.length();
        
        if(porcentagem < 0.21)
            return true;
        
        return false;
    }
}
