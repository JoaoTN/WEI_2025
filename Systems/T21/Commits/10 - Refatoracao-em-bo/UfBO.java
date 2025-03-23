package br.sistema.crud.jdbc.bo;

import java.util.List;

import br.sistema.crud.jdbc.dao.UfDAO;
import br.sistema.crud.jdbc.exception.NegocioException;
import br.sistema.crud.jdbc.model.Uf;

public class UfBO {
	
	private UfDAO ufDAO;
	
	public UfBO() {
		this.ufDAO = new UfDAO();
	}
	
	public List<Uf> listarUfs() throws NegocioException {
		try {
			return ufDAO.listarUfs();
		} catch (Exception e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}
}
