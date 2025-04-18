package controleatleta;

import java.util.ArrayList;

public class Boxeador extends Atleta {
    
    public static final byte SEXO_MASCULINO_INDICE = 0;
    public static final byte SEXO_FEMININO_INDICE = 1;
    public static final char SEXO_MASCULINO_VALOR = 'M';
    public static final char SEXO_FEMININO_VALOR = 'F';
    public static final byte CATEGORIA_AMADOR_INDICE = 0;
    public static final byte CATEGORIA_PROFISSIONAL_INDICE = 1;
    public static final char CATEGORIA_AMADOR_VALOR = 'A';
    public static final char CATEGORIA_PROFISSIONAL_VALOR = 'P';
    public static final byte ESTILO_ORTODOXO_INDICE = 0;
    public static final byte ESTILO_SOUTHPAW_INDICE = 1;
    public static final char ESTILO_ORTODOXO_VALOR = 'O';
    public static final char ESTILO_SOUTHPAW_VALOR = 'S';
    
    private char categoria; // A=Amador P=Profissional
    private char estilo; // O=Ortodoxo(destro) S=Southpaw(canhoto)
    private ArrayList<Premiacao> premiacoes;
    private Double envergadura; // Em cm
    private EstatisticaBoxeador estatisticas;
    
    
    public Boxeador(String nome) {
        super(nome);
        estatisticas = new EstatisticaBoxeador();
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }
    
    public Double getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(Double envergadura) {
        this.envergadura = envergadura;
    }

    public char getEstilo() {
        return estilo;
    }

    public void setEstilo(char estilo) {
        this.estilo = estilo;
    }

    

    public ArrayList<Premiacao> getPremiacoes() {
        return premiacoes;
    }

    public void setPremiacoes(ArrayList<Premiacao> premiacoes) {
        this.premiacoes = premiacoes;
    }
    
    public EstatisticaBoxeador getEstatisticaBoxeador(){
        return estatisticas;
    }
    
public class EstatisticaBoxeador{
    
    private int totalLutas;
    private int totalVitorias;
    private int totalVitoriasNocaute;
    private int totalEmpates;
    private int totalDerrotas;
    private int totalDesistencias;
    
    public int getTotalLutas() {
        return totalLutas;
    }

    public void setTotalLutas(int numLutas) {
        this.totalLutas = numLutas;
    }
    
    public int getTotalVitorias() {
        return totalVitorias;
    }

    public void setTotalVitorias(int vitorias) {
        this.totalVitorias = vitorias;
    }
    
    public int getTotalVitoriasNocaute() {
        return totalVitoriasNocaute;
    }

    public void setTotalVitoriasNocaute(int vitoriasNocaute) {
        this.totalVitoriasNocaute = vitoriasNocaute;
    }
    
    public int getTotalEmpates() {
        return totalEmpates;
    }

    public void setTotalEmpates(int empates) {
        this.totalEmpates = empates;
    }
    public int getTotalDerrotas() {
        return totalDerrotas;
    }

    public void setTotalDerrotas(int derrotas) {
        this.totalDerrotas = derrotas;
    }
    
    public int getTotalDesistencias() {
        return totalDesistencias;
    }

    public void setTotalDesistencias(int desistencias) {
        this.totalDesistencias = desistencias;
    }
    
}

    public String obterCategoriaPesoNome() {
        return obterCategoriaPesoNome(this.getCategoria(), this.getInformacoesPessoais().getPeso());
    }

    public static String obterCategoriaPesoNome(char categoria, double peso) {
        if (categoria == 'A') {
            return obterCategoriaPesoNomeAmador(peso);
        } else if (categoria == 'P') {
            return obterCategoriaPesoNomeProfissional(peso);
        } else {
            return "";
        }
    }

    private static String obterCategoriaPesoNomeAmador(double peso) {
        if (peso <= 48) {
            return "Mosca Ligeiro";
        } else if (peso <= 51) {
            return "Mosca";
        } else if (peso <= 54) {
            return "Galo";
        } else if (peso <= 57) {
            return "Pena";
        } else if (peso <= 57) {
            return "Leve";
        } else if (peso <= 64) {
            return "M. M. Ligeiro";
        } else if (peso <= 69) {
            return "Meio Médio";
        } else if (peso <= 75) {
            return "Médio";
        } else if (peso <= 81) {
            return "Meio Pesado";
        } else if (peso <= 91) {
            return "Pesado";
        } else {
            return "Super Pesado";
        }
    }

    private static String obterCategoriaPesoNomeProfissional(double peso) {
        if (peso <= 47.627) {
            return "Palha";
        } else if (peso <= 48.988) {
            return "Mosca Ligeiro";
        } else if (peso <= 50.802) {
            return "Mosca";
        } else if (peso <= 52.163) {
            return "Super Mosca";
        } else if (peso <= 53.524) {
            return "Galo";
        } else if (peso <= 55.338) {
            return "Super Galo";
        } else if (peso <= 57.153) {
            return "Pena";
        } else if (peso <= 58.967) {
            return "Super Pena";
        } else if (peso <= 61.235) {
            return "Leve";
        } else if (peso <= 63.503) {
            return "M. M. Ligeiro";
        } else if (peso <= 66.678) {
            return "M. Médio";
        } else if (peso <= 69.853) {
            return "M. Ligeiro";
        } else if (peso <= 72.575) {
            return "Médio";
        } else if (peso <= 76.364) {
            return "Super Médio";
        } else if (peso <= 79.379) {
            return "Meio Pesado";
        } else if (peso <= 90.719) {
            return "Cruzador";
        } else {
            return "Pesado";
        }
    }
}