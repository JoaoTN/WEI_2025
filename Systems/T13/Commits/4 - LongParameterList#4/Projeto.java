package siapro.model;

import java.util.List;

import siapro.dao.AvaliacaoDAO;

public class Projeto implements Entidade{
	private long id;
	private String titulo;
	private String autores;
	private List<Avaliacao> avaliacoes;
	private Area area;
	private Categoria categoria;
	private Evento evento;
	
	public Projeto(){
		
	}
	
	public Projeto(ProjetoData data) {
		super();
		data.setIdProjeto(this.id);
		data.setTitulo(this.titulo);
		data.setAutores(this.autores);
		data.setAvaliacoes(avaliacoes);
		data.setArea(this.area);
		data.setCategoria(this.categoria);
		data.setEvento(this.evento);
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public void carregarAvaliacoes(Projeto projeto) {
		List<Avaliacao> avaliacoes = new AvaliacaoDAO().pesquisarPorProjeto(projeto);
		this.setAvaliacoes(avaliacoes);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTitulo();
	}
}
