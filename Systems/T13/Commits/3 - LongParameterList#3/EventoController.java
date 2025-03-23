package siapro.controller;

import siapro.dao.EventoDAO;
import siapro.model.Evento;
import siapro.model.EventoData;

public class EventoController {
	public void editarEvento(EventoData eventoData) {
		Evento evento = new Evento();
		evento.setNome(eventoData.getNome());
		evento.setInformacoes(eventoData.getInformacoes());
		evento.setLiberado(eventoData.getSituacao());
		evento.setLogotipo(eventoData.getLogotipo());
		evento.setId(eventoData.getIdEvento());
		new EventoDAO().editar(evento);
	}
	public Evento atualizar(Evento evento) {
		return (Evento) new EventoDAO().pesquisarId(evento.getId());
	}
}
