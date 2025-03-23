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
    
    private static final int LIMITE_PESO_AMADOR = 48;
    private static final int LIMITE_PESO_MOSCA = 51;
    private static final int LIMITE_PESO_GALO = 54;
    private static final int LIMITE_PESO_PENA = 57;
    private static final int LIMITE_PESO_LEVE = 60;
    private static final int LIMITE_PESO_MM_LIGEIRO = 64;
    private static final int LIMITE_PESO_MEIO_MEDIO = 69;
    private static final int LIMITE_PESO_MEDIO = 75;
    private static final int LIMITE_PESO_MEIO_PESADO = 81;
    private static final int LIMITE_PESO_PESADO = 91;

    private static final double LIMITE_PESO_PROFISSIONAL_PALHA = 47.627;
    private static final double LIMITE_PESO_PROFISSIONAL_MOSCA_LIGEIRO = 48.988;
    private static final double LIMITE_PESO_PROFISSIONAL_MOSCA = 50.802;
    private static final double LIMITE_PESO_PROFISSIONAL_SUPER_MOSCA = 52.163;
    private static final double LIMITE_PESO_PROFISSIONAL_GALO = 53.524;
    private static final double LIMITE_PESO_PROFISSIONAL_SUPER_GALO = 55.338;
    private static final double LIMITE_PESO_PROFISSIONAL_PENA = 57.153;
    private static final double LIMITE_PESO_PROFISSIONAL_SUPER_PENA = 58.967;
    private static final double LIMITE_PESO_PROFISSIONAL_LEVE = 61.235;
    private static final double LIMITE_PESO_PROFISSIONAL_MM_LIGEIRO = 63.503;
    private static final double LIMITE_PESO_PROFISSIONAL_MM_MEDIO = 66.678;
    private static final double LIMITE_PESO_PROFISSIONAL_M_LIGEIRO = 69.853;
    private static final double LIMITE_PESO_PROFISSIONAL_MEDIO = 72.575;
    private static final double LIMITE_PESO_PROFISSIONAL_SUPER_MEDIO = 76.364;
    private static final double LIMITE_PESO_PROFISSIONAL_MEIO_PESADO = 79.379;
    private static final double LIMITE_PESO_PROFISSIONAL_CRUZADOR = 90.719;

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
        if (peso <= LIMITE_PESO_AMADOR) {
            return "Mosca Ligeiro";
        } else if (peso <= LIMITE_PESO_MOSCA) {
            return "Mosca";
        } else if (peso <= LIMITE_PESO_GALO) {
            return "Galo";
        } else if (peso <= LIMITE_PESO_PENA) {
            return "Pena";
        } else if (peso <= LIMITE_PESO_LEVE) {
            return "Leve";
        } else if (peso <= LIMITE_PESO_MM_LIGEIRO) {
            return "M. M. Ligeiro";
        } else if (peso <= LIMITE_PESO_MEIO_MEDIO) {
            return "Meio Médio";
        } else if (peso <= LIMITE_PESO_MEDIO) {
            return "Médio";
        } else if (peso <= LIMITE_PESO_MEIO_PESADO) {
            return "Meio Pesado";
        } else if (peso <= LIMITE_PESO_PESADO) {
            return "Pesado";
        } else {
            return "Super Pesado";
        }
    }

    private static String obterCategoriaPesoNomeProfissional(double peso) {
        if (peso <= LIMITE_PESO_PROFISSIONAL_PALHA) {
            return "Palha";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_MOSCA_LIGEIRO) {
            return "Mosca Ligeiro";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_MOSCA) {
            return "Mosca";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_SUPER_MOSCA) {
            return "Super Mosca";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_GALO) {
            return "Galo";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_SUPER_GALO) {
            return "Super Galo";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_PENA) {
            return "Pena";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_SUPER_PENA) {
            return "Super Pena";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_LEVE) {
            return "Leve";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_MM_LIGEIRO) {
            return "M. M. Ligeiro";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_MM_MEDIO) {
            return "M. Médio";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_M_LIGEIRO) {
            return "M. Ligeiro";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_MEDIO) {
            return "Médio";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_SUPER_MEDIO) {
            return "Super Médio";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_MEIO_PESADO) {
            return "Meio Pesado";
        } else if (peso <= LIMITE_PESO_PROFISSIONAL_CRUZADOR) {
            return "Cruzador";
        } else {
            return "Pesado";
        }
    }
}

public class EstatisticaBoxeador{
    
    private int totalLutas;
    private int totalVitorias;
    private int totalVitoriasNocaute;
    private int totalEmpates;
    private int totalDerrotas;
    private int totalDesistencias;
    
     public EstatisticaBoxeador() {
        // Inicializa as estatísticas com valores padrão
        this.totalLutas = 0;
        this.totalVitorias = 0;
        this.totalVitoriasNocaute = 0;
        this.totalEmpates = 0;
        this.totalDerrotas = 0;
        this.totalDesistencias = 0;
    }
    
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
    public void adicionarVitoria() {
        totalLutas++;
        totalVitorias++;
    }

    public void adicionarVitoriaNocaute() {
        totalLutas++;
        totalVitorias++;
        totalVitoriasNocaute++;
    }
    public void adicionarEmpate() {
        totalLutas++;
        totalEmpates++;
    }

    public void adicionarDerrota() {
        totalLutas++;
        totalDerrotas++;
    }
    public void adicionarDesistencia() {
        totalLutas++;
        totalDesistencias++;
    }
}