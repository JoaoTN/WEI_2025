/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Multa;

/**
 *
 * @author paulojp
 */
public class BdMulta {
    
    /* ----CONEXÃO COM O BD-> */
    private Connection conexao;
    
    // Estabelece uma conexão
    public BdMulta() throws SQLException {       
        this.conexao = CriaConexao.getConexao();
    }
    /* <-CONEXÃO COM O BD---- */
    
    
    
    
    /* ----MULTA-> */
    
    // CREATE - Adiciona um registro
  public void adicionaMulta(Multa m) throws SQLException {
    // Prepara conexão p/ receber o comando SQL
    String sql = "INSERT INTO multa(id_cliente, descricao, valor) VALUES(?, ?, ?)";
    PreparedStatement stmt;
    // stmt recebe o comando SQL
    stmt = this.conexao.prepareStatement(sql);

    // Seta os valores p/ o stmt, substituindo os "?"
    stmt.setString(Parametro.ID_CLIENTE, String.valueOf(m.getId_cliente()));
    stmt.setString(Parametro.DESCRICAO, m.getDescricao());
    stmt.setString(Parametro.VALOR, String.valueOf(m.getValor()));

    // Resto do código...
}

// Defina uma classe ou enumeração para representar os parâmetros
public class Parametro {
    public static final int ID_CLIENTE = 1;
    public static final int DESCRICAO = 2;
    public static final int VALOR = 3;
}

        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta
    public List<Multa> getLista(String id) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM multa WHERE id_multa like ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, id);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Multa> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Multa m = new Multa();
            
            // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
            m.setId_multa(Integer.valueOf(rs.getString("id_multa")));
            m.setId_cliente(Integer.valueOf(rs.getString("id_cliente")));
            m.setDescricao(rs.getString("descricao"));
            m.setValor(Float.valueOf(rs.getString("valor")));
            
            // Adiciona o registro na lista
            lista.add(m);            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Retorna uma lista com as multas de um determinado cliente
    public List<Multa> getListaMultaPorCliente(String id_cliente) throws SQLException{  
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT multa.id_multa, multa.id_cliente, multa.descricao, multa.valor " +
                    "FROM multa " +
                    "INNER JOIN cliente " +
                    "ON multa.id_cliente = cliente.id_cliente " +
                    "WHERE multa.id_cliente = ?;";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1, id_cliente);
        
        // Recebe o resultado da consulta SQL
        ResultSet rs = stmt.executeQuery();
        
        List<Multa> lista = new ArrayList<>();
        
        // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
        while(rs.next()) {
            //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
            Multa m = new Multa();
            
            // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome" 
            m.setId_multa(Integer.valueOf(rs.getString("multa.id_multa")));
            m.setId_cliente(Integer.valueOf(rs.getString("multa.id_cliente")));
            m.setDescricao(rs.getString("multa.descricao"));
            m.setValor(Float.valueOf(rs.getString("multa.valor")));
            
            // Adiciona o registro na lista
            lista.add(m);            
        }
        
        // Fecha a conexão com o BD
        rs.close();
        stmt.close();
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Retorna o valor total das multas de um cliente
   public String totalMultaCliente(String id_cliente) throws SQLException {
    String sql = createTotalMultaQuery();
    PreparedStatement stmt = prepareStatementWithId(sql, id_cliente);
    float totalMulta = executeQueryAndRetrieveTotalMulta(stmt);
    stmt.close();

    return String.valueOf(totalMulta);
}

private String createTotalMultaQuery() {
    return "SELECT SUM(multa.valor) AS totalMulta FROM multa " +
           "INNER JOIN cliente ON multa.id_cliente = cliente.id_cliente " +
           "WHERE cliente.id_cliente = ? " +
           "GROUP BY cliente.id_cliente;";
}

private PreparedStatement prepareStatementWithId(String sql, String id_cliente) throws SQLException {
    PreparedStatement stmt = this.conexao.prepareStatement(sql);
    stmt.setString(1, id_cliente);
    return stmt;
}

private float executeQueryAndRetrieveTotalMulta(PreparedStatement stmt) throws SQLException {
    ResultSet rs = stmt.executeQuery();
    rs.next();
    float totalMulta = rs.getFloat("totalMulta");
    rs.close();
    return totalMulta;
}

    
    // DELETE - Apaga registros
    public void remove(int id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM multa WHERE id_multa=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        stmt.setInt(1, id);
        
        // Executa o codigo SQL, e fecha
        stmt.execute();
        stmt.close();        
    }
    
    // DELETE - Apaga todas as multas
    public void removeMultas(String id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM multa WHERE id_cliente=?";
        // stmt recebe o comando SQL
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        stmt.setString(1, id);
        
        // Executa o codigo SQL, e fecha
        stmt.execute();
        stmt.close();        
    }
    
    /* <-MULTA---- */
}
