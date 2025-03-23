package br.sistema.crud.jdbc.dao;

import java.util.List;
import br.sistema.crud.jdbc.exception.PersistenciaException;

public interface GenericoDAO<T> {
	
	void salvar(T objeto) throws PersistenciaException;
	void deletar(Integer id) throws PersistenciaException;
	
	List<T> listarTodos() throws PersistenciaException;
	
	T buscarPorId(Integer id) throws PersistenciaException;
}
