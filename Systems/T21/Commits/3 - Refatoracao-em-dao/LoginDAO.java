package br.sistema.crud.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.sistema.crud.jdbc.ConexaoUtil;
import br.sistema.crud.jdbc.dto.LoginDTO;
import br.sistema.crud.jdbc.dto.PessoaDTO;
import br.sistema.crud.jdbc.exception.PersistenciaExcpetion;

public class LoginDAO {

	public boolean logar(LoginDTO loginDTO) throws PersistenciaExcpetion {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "SELECT * FROM tb_login WHERE nome = ? AND senha = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, loginDTO.getNome());
			statement.setString(2, loginDTO.getSenha());

			ResultSet resultSet = statement.executeQuery();
			boolean resultado = resultSet.next();

			connection.close();

			return resultado;
		} catch (Exception e) {
			throw new PersistenciaExcpetion(e.getMessage(), e);
		}
	}
	
	// Outros métodos de CRUD...

}
