package app.condominio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import app.condominio.domain.enums.TipoCategoria;

@SuppressWarnings("serial")
@Entity
@Table(name = "categorias")
public class Categoria implements Serializable, Comparable<Categoria> {

	private static final int MAX_NIVEL = 4;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategoria")
	private Long idCategoria;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoCategoria tipo;

	@Size(min = 1, max = 50)
	@NotBlank
	private String descricao;

	@Max(MAX_NIVEL)
	private Integer nivel;

	@Size(min = 1, max = 255)
	@NotBlank
	private String ordem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoriapai")
	private Categoria categoriaPai;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcondominio")
	private Condominio condominio;

	@OneToMany(mappedBy = "categoriaPai", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Categoria> categoriasFilhas = new ArrayList<>();

	@OneToMany(mappedBy = "categoriaPai", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@OrderBy("descricao")
	private List<Subcategoria> subcategorias = new ArrayList<>();

	public static final int getMaxNivel() {
		return MAX_NIVEL;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public TipoCategoria getTipo() {
		return tipo;
	}

	public void setTipo(TipoCategoria tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getOrdem() {
		return ordem;
	}

	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}

	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public List<Categoria> getCategoriasFilhas() {
		return Collections.unmodifiableList(categoriasFilhas);
	}

	public void setCategoriasFilhas(List<Categoria> categoriasFilhas) {
		this.categoriasFilhas = new ArrayList<>(categoriasFilhas);
	}

	public void removeCategoriaFilha(Categoria categoriaFilha) {
		this.categoriasFilhas.remove(categoriaFilha);
	}

	public List<Subcategoria> getSubcategorias() {
		return Collections.unmodifiableList(subcategorias);
	}

	public void setSubcategorias(List<Subcategoria> subcategorias) {
		this.subcategorias = new ArrayList<>(subcategorias);
	}

	public void removeSubcategoria(Subcategoria subcategoria) {
		this.subcategorias.remove(subcategoria);
	}

	@Override
	public String toString() {
		return ordem + " - " + descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Categoria other = (Categoria) obj;
		return Objects.equals(idCategoria, other.idCategoria);
	}

	@Override
	public int compareTo(Categoria o) {
		return this.ordem.compareTo(o.getOrdem());
	}

}
