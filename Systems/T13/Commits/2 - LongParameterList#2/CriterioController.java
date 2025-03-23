package siapro.controller;

import java.util.List;

import siapro.dao.CriterioDAO;
import siapro.dao.EventoDAO;
import siapro.model.Categoria;
import siapro.model.Criterio;
import siapro.model.CriterioData;
import siapro.model.Evento;

public class CriterioController {
	public boolean salvar(CriterioData criterioData) {
		double notaMaxima = Double.parseDouble(criterioData.getNotaMax());
		double notaMinima = Double.parseDouble(criterioData.getNotaMin());
		
		Criterio c = new Criterio();
		c.setNome(criterioData.getNome());
		c.setDescricao(criterioData.getDescricao());
		c.setNotaMaxima(notaMaxima);
		c.setNotaMinima(notaMinima);
		c.setCategoria(criterioData.getCategoria());
		c.setId(criterioData.getIdCriterio());
		if(c.getId() != 0) {
			c = (Criterio) new CriterioDAO().editar(c);
			if(c.getId() != 0) {
				return true;
			}else {
				return false;
			}
			
		}else {
			c = (Criterio) new CriterioDAO().salvar(c);
			if(c.getId() != 0) {
				return true;
			}else {
				return false;
			}
		}
		
		
	}
	
	public List<Categoria> listaCategorias(Evento e){
		List<Categoria> categorias =  new ListarCategoriaController().listarCategoria(e);
		return categorias;
	}
	
	public Evento listarCategorias(Categoria c) {
		c.setEvento((Evento) new EventoDAO().pesquisarPorCategoria(c));
		return c.getEvento();
	}
	
	public boolean deletarCriterio(Criterio c) {
		if(new CriterioDAO().deletar(c)) {
			return true;
		}else {
			return false;
		}
	}
}