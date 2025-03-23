package siapro.model;

public class EventoData {
    private String nome; 
    private String informacoes;
    private Boolean situacao;
    private String logotipo;
    private long idEvento;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getInformacoes() {
        return informacoes;
    }
    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }
    public Boolean getSituacao() {
        return situacao;
    }
    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }
    public String getLogotipo() {
        return logotipo;
    }
    public void setLogotipo(String logotipo) {
        this.logotipo = logotipo;
    }
    public long getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }
}
