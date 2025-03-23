package control;

class DadosFornecedor {
    private String nome;
    private String cnpj;
    private String email;
    private String fone;
    private String numero;
    private String descricao;
    private String fonec;
    private String cep;
    private String bairro;
    private String estado;
    private String cidade;
    private String rua;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return this.fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFonec() {
        return this.fonec;
    }

    public void setFonec(String fonec) {
        this.fonec = fonec;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public DadosFornecedor(String nome, String cnpj, String email, String fone, String numero, String descricao, String fonec, String cep, String bairro, String estado, String cidade, String rua) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.fone = fone;
        this.numero = numero;
        this.descricao = descricao;
        this.fonec = fonec;
        this.cep = cep;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
    }
}


public class Fornecedor {
    public static String v[] = new String[13];
    public static String id = "0";
    private DadosFornecedor dadosFornecedor;
    
    public Fornecedor(DadosFornecedor dadosFornecedor){
        this.dadosFornecedor = dadosFornecedor;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DadosFornecedor getDadosFornecedor() {
        return dadosFornecedor;
    }

    public void setDadosFornecedor(DadosFornecedor dadosFornecedor) {
        this.dadosFornecedor = dadosFornecedor;
    }
}
