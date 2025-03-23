package ValidaDados;

public class ValidaDados {

    public static void validarNome(String nome) throws Exception {

        String validos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZãõñáéíóú";

        if (nome == null) {
            throw new Exception("Nome inválido!");
        } else if (nome.isEmpty()) {
            throw new Exception("Nome inválido!");
        } else {
            for (int i = 0; i < nome.length(); i++) {
                if (validos.indexOf(nome.charAt(i)) == -1) {
                    throw new Exception("Caracter inválido!");
                }
            }
        }
    }
    
    public static void validarPeso(String peso) throws Exception{
    final float PESO_MINIMO = 2.5f;
    final float PESO_MAXIMO = 400.0f;
    
    String validos = "0123456789.,";
    
    if(peso.isEmpty()){
        throw new Exception("Peso inválido!");
    }
    for(int i = 0; i < peso.length(); i++){
        if (validos.indexOf(peso.charAt(i)) == -1) {
            throw new Exception("Caracter inválido!");
        }
    }
    
    peso = peso.replace(',', '.');
    
    Float pe;
    try{
        pe = Float.parseFloat(peso);
    }catch(Exception e){
        throw new Exception("Peso inválido!");
    } if (pe < PESO_MINIMO || pe > PESO_MAXIMO){
        throw new Exception("Peso inválido!");
    }
}

public static void validarAno(String ano) throws Exception{
    final int ANO_MINIMO = 1900;
    final int ANO_MAXIMO = 2013;
    
    String validos = "0123456789";
    
    if(ano.isEmpty()){
        throw new Exception("Ano inválido!");
    }
    for(int i = 0; i < ano.length(); i++){
        if (validos.indexOf(ano.charAt(i)) == -1) {
            throw new Exception("Caracter inválido!");
        }
    }
           
    Integer anoTitulo;
    try{
        anoTitulo = Integer.parseInt(ano);
    }catch(Exception e){
        throw new Exception("Ano inválido!");
    } if (anoTitulo < ANO_MINIMO || anoTitulo > ANO_MAXIMO){
        throw new Exception("Ano inválido!");
    }
}

public static void validarQuantidade(String qntd) throws Exception{
    final int QNTD_MINIMA = 0;
    final int QNTD_MAXIMA = 1000;
    
    String validos = "0123456789";
    
    if(qntd.isEmpty()){
        throw new Exception("Quantidade inválida!");
    }
    for(int i = 0; i < qntd.length(); i++){
        if (validos.indexOf(qntd.charAt(i)) == -1) {
            throw new Exception("Caracter inválido!");
        }
    }
           
    Integer qntdTitulo;
    try{
        qntdTitulo = Integer.parseInt(qntd);
    }catch(Exception e){
        throw new Exception("Quantidade inválida!");
    } if (qntdTitulo < QNTD_MINIMA || qntdTitulo > QNTD_MAXIMA){
        throw new Exception("Quantidade inválida!");
    }
}

public static void validarRank(String rank) throws Exception{
    final int RANK_MINIMO = 0;
    final int RANK_MAXIMO = 500;
    
    String validos = "0123456789";
    
    if(rank.isEmpty()){
        throw new Exception("Rank inválido!");
    }
    for(int i = 0; i < rank.length(); i++){
        if (validos.indexOf(rank.charAt(i)) == -1) {
            throw new Exception("Caracter inválido!");
        }
    }
           
    Integer rankMundial;
    try{
        rankMundial = Integer.parseInt(rank);
    }catch(Exception e){
        throw new Exception("Rank inválido!");
    } if (rankMundial < RANK_MINIMO || rankMundial > RANK_MAXIMO){
        throw new Exception("Rank inválido!");
    }
}

public static void validarFortuna(String fortuna) throws Exception{
    final double FORTUNA_MINIMA = 0.0;
    final double FORTUNA_MAXIMA = 1000000000000000.00;
    
    String validos = "0123456789.,";
    
    if(fortuna.isEmpty()){
        throw new Exception("Fortuna inválido!");
    }
    for(int i = 0; i < fortuna.length(); i++){
        if (validos.indexOf(fortuna.charAt(i)) == -1) {
            throw new Exception("Caracter inválido!");
        }
    }
    
    fortuna = fortuna.replace(',', '.');
    
    double fort;
    try{
        fort = Double.parseDouble(fortuna);
    }catch(Exception e){
        throw new Exception("Fortuna inválida!");
    } if (fort > FORTUNA_MAXIMA || fort < FORTUNA_MINIMA){
        throw new Exception("Fortuna inválida!");
    }
}

}
