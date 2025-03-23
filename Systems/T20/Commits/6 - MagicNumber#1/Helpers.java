package sgab.util;

public class Helpers {
    static private final float LIMITE_SIMILARIDADE = 0.21f;
    public static boolean checaSemelhanca(String nomeObra, String nomeInput){
        String nomeA = nomeObra.toLowerCase();
        String nomeB = nomeInput.toLowerCase();
        float count = 0;

        //iguala o tamanho das Strings
        if(nomeA.length() > nomeB.length()){
            for(int i =0; i < (nomeObra.length() - nomeInput.length()); i++){
                nomeB = nomeB.concat(" ");
            }
        }
        if(nomeA.length() < nomeB.length()){
            for(int i =0; i < (nomeObra.length() - nomeInput.length()); i++){
                nomeA = nomeA.concat(" ");
            }
        }

        for(int i=0, j=0; i<nomeA.length(); i++, j++) {
            if(nomeA.charAt(i) != nomeB.charAt(j)){
                count++;
                if(i+1 == nomeA.length())
                    continue;
                if(nomeA.charAt(i+1)==nomeB.charAt(j))
                    j--;
            }
        }
        float porcentagem = count / nomeA.length();

        if(porcentagem < LIMITE_SIMILARIDADE)
            return true;

        return false;
    }
}
