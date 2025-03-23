/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author paulojp
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String dataNasc;
    private String sexo;
    private String cpf;
    private String endereco;
    private String fone;

    public Cliente(ClienteData clienteData) {
        this.nome = clienteData.getNome();
        this.dataNasc = clienteData.getDataNasc();
        this.sexo = clienteData.getSexo();
        this.cpf = clienteData.getCpf();
        this.endereco = clienteData.getEndereco();
        this.fone = clienteData.getFone();
    }
    
    public Cliente() {
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }  
    
}

