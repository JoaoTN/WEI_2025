package siapro.controller;


import java.util.List;

import siapro.dao.ProjetoDAO;
import siapro.model.Area;
import siapro.model.Categoria;
import siapro.model.Evento;
import siapro.model.Projeto;
import siapro.model.ProjetoData;

public class AddProjetoController {
	

	public List<Categoria> listarCategoria(Evento evento) {
		evento.carregarCategorias();
		return evento.getCategorias();
	}
		
	public List<Area> listarAreas(Evento evento) {
	    evento.carregarAreas();
		return evento.getAreas();
	}
	
	public void salvarProjeto(ProjetoData projetoData) {		
    Projeto proj = new Projeto();
    proj.setTitulo(projetoData.getTitulo());
    proj.setAutores(projetoData.getAutores());
    proj.setEvento(projetoData.getEvento());
    proj.setCategoria(projetoData.getCategoria());
    proj.setArea(projetoData.getArea());
    proj.setId(projetoData.getIdProjeto());
    
    if (proj.getId() == 0) {
        new ProjetoDAO().salvar(proj);
    } else {
        new ProjetoDAO().editar(proj);
    }	
}

}