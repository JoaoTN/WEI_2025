package siapro.model;

public class CriterioData {
    private Categoria categoria;
    private String nome;
    private String descricao;
    private String notaMin;
    private String notaMax;
    private long idCriterio;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNotaMin() {
        return notaMin;
    }

    public void setNotaMin(String notaMin) {
        this.notaMin = notaMin;
    }

    public String getNotaMax() {
        return notaMax;
    }

    public void setNotaMax(String notaMax) {
        this.notaMax = notaMax;
    }

    public long getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(long idCriterio) {
        this.idCriterio = idCriterio;
    }
    
}
