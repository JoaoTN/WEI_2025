package control;

class DadosCliente {
   private String nome;
   private String fone;
   private String cpf;
   private String cidade;
   private String idade;
   private String sexo;
   private String fonec;
   private String email;
   private String cep;        
   private String estado;
   private String bairro;
   private String numero;
   private String rua;  

   public DadosCliente(String nome, String fone, String cpf, String cidade, String idade, String sexo, String fonec, String email, String cep, String estado, String bairro, String numero, String rua) {
        this.nome = nome;
        this.fone = fone;
        this.cpf = cpf;
        this.cidade = cidade;
        this.idade = idade;
        this.sexo = sexo;
        this.fonec = fonec;
        this.email = email;
        this.cep = cep;
        this.estado = estado;
        this.bairro = bairro;
        this.numero = numero;
        this.rua = rua;     
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFonec() {
        return fonec;
    }

    public void setFonec(String fonec) {
        this.fonec = fonec;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}

public class Cliente {    
    public static String v[] = new String[14]; 
    public static String id = "0";
    private DadosCliente dadosCliente;
    
    public Cliente(DadosCliente dadosCliente){
       this.dadosCliente = dadosCliente;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DadosCliente getDadosCliente() {
        return dadosCliente;
    }

    public void setDadosCliente(DadosCliente dadosCliente) {
        this.dadosCliente = dadosCliente;
    }
}