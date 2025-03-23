package sgab.model.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import sgab.model.dto.Obra;
import sgab.model.dto.util.ObraStatus;
import sgab.model.exception.PersistenciaException;
import sgab.model.dto.Autor;
import sgab.util.Helpers;

public class ObraDAO implements GenericDAO<Obra, Long>{
    private Map<Long, Obra> obras = new HashMap<>();

    private static ObraDAO obraDAO;
    static{
        ObraDAO.obraDAO = null;
    }
    
    private static Long ids;
    static{
        ObraDAO.ids = 0L;
    }
    
    public static Long getNextId() {
        return ObraDAO.ids++;
    }

    
    private ObraDAO() { };
    
    public static ObraDAO getInstance() {
        if (obraDAO == null) {
            obraDAO = new ObraDAO();
        }
        return obraDAO;
    }
    
    @Override
    public void inserir(Obra entidade) {
        entidade.setId(ObraDAO.getNextId());
        obras.put(entidade.getId(), entidade);
    }
    
    @Override
    public void alterar(Obra entidade) {
        Obra obraAlvo = obras.remove(entidade.getId());
        if(obraAlvo == null){
            throw new PersistenciaException("Nenhum usuário com "
                                        + "o id '" + entidade.getId() + "'.");
        }
        inserir(entidade);
    }

    @Override
    public Obra pesquisar(Long key) {
        return obras.get(key);
    }
    
    public List<Obra> listarObras(){
        List<Obra> obrasAtivas = new LinkedList<>();
        
        for(Obra obra : obras.values()){
            if(obra.getStatus() == ObraStatus.ATIVA){
                obrasAtivas.add(obra);
            }
        }
        return obrasAtivas;
    }
    
    public List<Obra> pesquisarNome(String titulo){
        List<Obra> resultados = new LinkedList<>();
        for (Obra obra : listarObras()){
            if(obra.getTitulo().equals(titulo)){
                resultados.add(obra);
            }
        }
        return resultados;
    }
    
    public List<Obra> pesquisarAutor(String autor){
        //throw new UnsupportedOperationException("Not supported yet.");LinkedList<Obra> resultados = new LinkedList();
        List<Obra> resultados = new LinkedList<>();
        for (Obra obra : listarObras()){
            for (Autor autores : obra.getAutor()){
                if(autores.getNome().equals(autor)){
                    resultados.add(obra);
                }   
            }
        }
        return resultados;
    }

    public List<Obra> pesquisaTituloAproximado(String titulo){
        List<Obra> resultado = new LinkedList<>();
        for (Obra obra : listarObras()){
            if(Helpers.checaSemelhanca(obra.getTitulo(), titulo)){
                resultado.add(obra);
            }
        }
        return resultado;
    }
}
