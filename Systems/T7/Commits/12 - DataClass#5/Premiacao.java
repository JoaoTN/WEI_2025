package controleatleta;

public class Premiacao {

    private final String titulo;
    private final int ano;

    public Premiacao(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return ano + " - " + titulo;
    }
}
