package controleatleta;

import java.util.HashMap;
import java.util.Map;

public class Endereco {
    
    private Map<String, String> atributos;

    public Endereco() {
        atributos = new HashMap<String, String>();
    }
    
    public void setAtributo(String nome, String valor) {
        atributos.put(nome, valor);
    }

    public String getAtributo(String nome) {
        return atributos.get(nome);
    }
}
