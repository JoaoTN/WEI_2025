package br.edu.devmedia.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.devmedia.jdbc.ConexaoUtil;
import br.edu.devmedia.jdbc.dto.PessoaDTO;
import br.edu.devmedia.jdbc.exception.PersistenciaExcpetion;

public class PessoaDAO implements GenericoDAO<PessoaDTO> {

    private static final String INSERT_SQL = "INSERT INTO TB_PESSOA(NOME, CPF, ENDERECO, SEXO, DT_NASC) VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE TB_PESSOA SET NOME = ?, CPF = ?, ENDERECO = ?, SEXO = ?, DT_NASC = ? WHERE ID_PESSOA = ?";
    private static final String DELETE_SQL = "DELETE FROM TB_PESSOA WHERE ID_PESSOA = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM TB_PESSOA";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM TB_PESSOA WHERE ID_PESSOA = ?";
    private static final String SELECT_BY_FILTER_SQL = "SELECT * FROM TB_PESSOA WHERE 1 = 1";

    @Override
    public void inserir(PessoaDTO pessoaDTO) throws PersistenciaExcpetion {
        try (Connection connection = ConexaoUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {
            setPessoaStatementValues(statement, pessoaDTO);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaExcpetion(e.getMessage(), e);
        }
    }

    @Override
    public void atualizar(PessoaDTO pessoaDTO) throws PersistenciaExcpetion {
        try (Connection connection = ConexaoUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            setPessoaStatementValues(statement, pessoaDTO);
            statement.setInt(6, pessoaDTO.getIdPessoa());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaExcpetion(e.getMessage(), e);
        }
    }

    @Override
    public void deletar(Integer idPessoa) throws PersistenciaExcpetion {
        try (Connection connection = ConexaoUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setInt(1, idPessoa);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaExcpetion(e.getMessage(), e);
        }
    }

    @Override
    public List<PessoaDTO> listarTodos() throws PersistenciaExcpetion {
        List<PessoaDTO> listaPessoas = new ArrayList<>();
        try (Connection connection = ConexaoUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                PessoaDTO pessoaDTO = getPessoaFromResultSet(resultSet);
                listaPessoas.add(pessoaDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaExcpetion(e.getMessage(), e);
        }
        return listaPessoas;
    }

    @Override
    public PessoaDTO buscarPorId(Integer id) throws PersistenciaExcpetion {
        PessoaDTO pessoaDTO = null;
        try (Connection connection = ConexaoUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_SQL)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    pessoaDTO = getPessoaFromResultSet(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaExcpetion(e.getMessage(), e);
        }
        return pessoaDTO;
    }

    public List<PessoaDTO> filtraPessoa(String nome, Long cpf, String sexo) throws PersistenciaExcpetion {
        List<PessoaDTO> lista = new ArrayList<>();
        StringBuilder sqlBuilder = new StringBuilder(SELECT_BY_FILTER_SQL);

        if (nome != null && !nome.equals("")) {
            sqlBuilder.append(" AND NOME = ?");
        }

        if (cpf != null) {
            sqlBuilder.append(" AND CPF = ?");
        }

        if (sexo != null && !sexo.equals("")) {
            sqlBuilder.append(" AND SEXO = ?");
        }

        try (Connection connection = ConexaoUtil.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlBuilder.toString())) {
            int paramIndex = 1;
            if (nome != null && !nome.equals("")) {
                statement.setString(paramIndex++, nome);
            }

            if (cpf != null) {
                statement.setLong(paramIndex++, cpf);
            }

            if (sexo != null && !sexo.equals("")) {
                statement.setString(paramIndex, sexo);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    PessoaDTO pessoaDTO = getPessoaFromResultSet(resultSet);
                    lista.add(pessoaDTO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaExcpetion(e.getMessage(), e);
        }
        return lista;
    }

    private void setPessoaStatementValues(PreparedStatement statement, PessoaDTO pessoaDTO) throws Exception {
        statement.setString(1, pessoaDTO.getNome());
        statement.setLong(2, pessoaDTO.getCpf());
        statement.setString(3, pessoaDTO.getEndereco());
        statement.setString(4, String.valueOf(pessoaDTO.getSexo()));
        statement.setDate(5, new Date(pessoaDTO.getDtNascimento().getTime()));
    }

    private PessoaDTO getPessoaFromResultSet(ResultSet resultSet) throws Exception {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
        pessoaDTO.setNome(resultSet.getString("nome"));
        pessoaDTO.setCpf(resultSet.getLong("cpf"));
        pessoaDTO.setDtNascimento(resultSet.getDate("dt_nasc"));
        pessoaDTO.setEndereco(resultSet.getString("endereco"));
        pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
        return pessoaDTO;
    }
}
