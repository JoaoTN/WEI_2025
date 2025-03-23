package br.sistema.crud.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.sistema.crud.jdbc.ConexaoUtil;
import br.sistema.crud.jdbc.dto.UfDTO;
import br.sistema.crud.jdbc.exception.PersistenciaException;

public class UfDAO {

    public List<UfDTO> listaEstado() throws PersistenciaException {
        List<UfDTO> lista = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultado = null;

        try {
            connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM tb_uf";
            preparedStatement = connection.prepareStatement(sql);
            resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                UfDTO ufDTO = criarUfDTO(resultado);
                lista.add(ufDTO);
            }
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage(), e);
        } finally {
            closeResources(connection, preparedStatement, resultado);
        }

        return lista;
    }

    private UfDTO criarUfDTO(ResultSet resultado) throws SQLException {
        UfDTO ufDTO = new UfDTO();
        ufDTO.setIdUF(resultado.getInt("idUF"));
        ufDTO.setSiglaUF(resultado.getString("siglaUF"));
        ufDTO.setDescricao(resultado.getString("descricao"));
        return ufDTO;
    }

    private void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultado) {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // Lidar com a exceção ou registrar o erro
            e.printStackTrace();
        }
    }
}
