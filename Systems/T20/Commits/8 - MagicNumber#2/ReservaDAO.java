/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgab.model.dao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import sgab.model.dto.Reserva;
import sgab.model.exception.PersistenciaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import sgab.model.dto.Biblioteca;
import sgab.model.dto.Exemplar;
import sgab.model.dto.Obra;
import sgab.model.dto.Pessoa;
/**
 *
 * @author T-Gamer
 */
public class ReservaDAO implements GenericDAO<Reserva, Long> {
    private Map<Long, Reserva> table = new HashMap<>();
    private static final int MAX_HORAS_DIFERENCA = 2;
    
    private static ReservaDAO reservaDAO;
    static {
        ReservaDAO.reservaDAO = null;
    }
    
    private static Long idSequence;
    static {
        ReservaDAO.idSequence = 0L;
    }
    
    public static Long getNextId() {
        return ReservaDAO.idSequence++;
    } 
    
    private ReservaDAO() { }
    
    public static ReservaDAO getInstance() {
        if(reservaDAO == null) {
            reservaDAO = new ReservaDAO();
        }
        return reservaDAO;
    }
    
    @Override
    public void inserir(Reserva entidade) {
        Long reservaId = ReservaDAO.getNextId();
        entidade.setId(reservaId);
        table.put(reservaId, entidade);
    }

    @Override
    public void alterar(Reserva entidade) {
        Reserva reserva = table.remove(entidade.getId());
        if (reserva == null)
            throw new PersistenciaException("Nenhuma reserva com " + "o id '" + entidade.getId() + "'.");
        
        inserir(entidade);
    }

    @Override
    public Reserva pesquisar(Long id) {
         return table.get(id);
    }
    
    public List<Reserva> listarTodos() {
        List<Reserva> listReservas = new ArrayList<>();
        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");

        for(Reserva reserva : table.values()){
            if(reserva.getEraDisponivel()){
                try {
                    String horarioReserva = reserva.getHorario();
                    Date horarioReservaDate = dateFormat.parse(horarioReserva);

                    long diffInMillis = dataAtual.getTime() - horarioReservaDate.getTime();
                    long diffInHours = TimeUnit.MILLISECONDS.toHours(diffInMillis);

                    if (diffInHours <= MAX_HORAS_DIFERENCA) {
                        delete(reserva.getId());
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            listReservas.add(reserva);
        }
        
        return listReservas;
    }
    
    public List<Reserva> listarTodos(Pessoa leitor) {
        List<Reserva> listReservas = new ArrayList<>();
        
        for(Reserva reserva : table.values()){
            if(reserva.getPessoa().equals(leitor)){
                listReservas.add(reserva);
            }
        }
        
        return listReservas;
    }
    
    public List<Reserva> listarTodos(Exemplar exemplar) {
        List<Reserva> listReservas = new ArrayList<>();
        
        for(Reserva reserva : table.values()){
            if(reserva.getExemplar().equals(exemplar)){
                listReservas.add(reserva);
            }
        }
        
        return listReservas;
    }
    
    public List<Reserva> listarTodos(String titulo) {
        List<Reserva> listReservas = new ArrayList<>();
        
        for(Reserva reserva : table.values()){
            if(checaSemelhanca(reserva.getExemplar().getObra().getTitulo(), titulo)){
                listReservas.add(reserva);
            }
        }
        
        return listReservas;
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
    
    public List<Reserva> listarPorObraBiblioteca(Obra obra, Biblioteca biblioteca) {
        List<Reserva> listReservas = new ArrayList<>();
        
        for(Reserva reserva : table.values()) {
            if(reserva.getExemplar().getObra() == obra && reserva.getExemplar().getBibliotecaPosse() == biblioteca)
                listReservas.add(reserva);
        }
        
        return listReservas;
    }
    
    public void delete(Long id){
        table.remove(id);
    }
}
