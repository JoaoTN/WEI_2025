/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author FERNANDO ROGI
 */

class DadosFuncionario {
    private String nome;
    private String cpf;
    private String email;
    private String fone;
    private String idade;
    private String salario;
    private String fonec;
    private String numero;
    private String data;
    private String departamento;
    private String funcao;
    private String observacao;
    private String sexo;


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getIdade() {
        return this.idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSalario() {
        return this.salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getFonec() {
        return this.fonec;
    }

    public void setFonec(String fonec) {
        this.fonec = fonec;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public DadosFuncionario(String nome, String cpf, String email, String fone,  String idade, String salario, String fonec, String numero, String data, String departamento, String funcao, String observacao, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.fone = fone;
        this.idade = idade;
        this.salario = salario;
        this.fonec = fonec;
        this.numero = numero;
        this.data = data;
        this.departamento = departamento;
        this.funcao = funcao;
        this.observacao = observacao;
        this.sexo = sexo;
    }   
    
}

public class Funcionario {
    public static String v[] = new String[14];
     public static String id = "0";
     private DadosFuncionario dadosFuncionario;
    
    public Funcionario(DadosFuncionario dadosFuncionario) {
        this.dadosFuncionario = dadosFuncionario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DadosFuncionario getDadosFuncionario() {
        return dadosFuncionario;
    }

    public void setDadosFuncionario(DadosFuncionario dadosFuncionario) {
        this.dadosFuncionario = dadosFuncionario;
    }
    

}
