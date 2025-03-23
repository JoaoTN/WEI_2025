package controleatleta;

import java.util.ArrayList;
import java.util.HashMap;

public class Tenista extends Atleta{

    private EstatisticasTenista estatisticas;
    private CarreiraTenista carreira;
      
    public Tenista(String nome) {
        super(nome);
        this.estatisticas = new EstatisticasTenista();
    }
    
    public EstatisticasTenista getEstatisticas() {
        return estatisticas;
    }

    public CarreiraTenista getCarreira() {
        return carreira;
    }
    
    public class EstatisticasTenista {
        private int posicaoRankMundial;
        private HashMap<Integer, Integer> vitoriasPorAno;
        private HashMap<Integer, Integer> derrotasPorAno;

        public EstatisticasTenista() {
            this.vitoriasPorAno = new HashMap<Integer, Integer>();
            this.derrotasPorAno = new HashMap<Integer, Integer>();
        }

        public int getPosicaoRankMundial() {
            return posicaoRankMundial;
        }

        public void setPosicaoRankMundial(int posicaoRankMundial) {
            this.posicaoRankMundial = posicaoRankMundial;
        }

        public HashMap<Integer, Integer> getVitoriasPorAno() {
            return vitoriasPorAno;
        }

        public void setVitoriasPorAno(HashMap<Integer, Integer> vitoriasPorAno) {
            this.vitoriasPorAno = vitoriasPorAno;
        }
        
        public HashMap<Integer, Integer> getDerrotasPorAno() {
            return derrotasPorAno;
        }
        
        public void setDerrotasPorAno(HashMap<Integer, Integer> derrotasPorAno) {
            this.derrotasPorAno = derrotasPorAno;
        }
    }

    public class CarreiraTenista {
        private double fortunaAcumuladaJogos;
        private double fortunaAcumuladaPropagandas;
        private TipoQuadra quadraPreferida;
        private ArrayList<Patrocinador> patrocinadores;
        private HashMap<String, Integer> nomeQuantidadeTitulosGanhos;

        public CarreiraTenista() {
            this.patrocinadores = new ArrayList<Patrocinador>();
            this.nomeQuantidadeTitulosGanhos = new HashMap<String, Integer>();
        }

        public double getFortunaAcumuladaJogos() {
            return fortunaAcumuladaJogos;
        }

        public void setFortunaAcumuladaJogos(double fortunaAcumuladaJogos) {
            this.fortunaAcumuladaJogos = fortunaAcumuladaJogos;
        }
        
        public double getFortunaAcumuladaPropagandas() {
            return fortunaAcumuladaPropagandas;
        }

        public void setFortunaAcumuladaPropagandas(double fortunaAcumuladaPropagandas) {
            this.fortunaAcumuladaPropagandas = fortunaAcumuladaPropagandas;
        }

        public TipoQuadra getQuadraPreferida() {
            return quadraPreferida;
        }

        public void setQuadraPreferida(TipoQuadra quadraPreferida) {
            this.quadraPreferida = quadraPreferida;
        }
        
        public ArrayList<Patrocinador> getPatrocinadores() {
            return patrocinadores;
        }

        public void setPatrocinadores(ArrayList<Patrocinador> patrocinadores) {
            this.patrocinadores = patrocinadores;
        }
        
        public HashMap<String, Integer> getNomeQuantidadeTitulosGanhos() {
            return nomeQuantidadeTitulosGanhos;
        }

        public void setNomeQuantidadeTitulosGanhos(HashMap<String, Integer> nomeQuantidadeTitulosGanhos) {
            this.nomeQuantidadeTitulosGanhos = nomeQuantidadeTitulosGanhos;
        }     
    
     }    
        
}