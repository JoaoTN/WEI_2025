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
public class Emprestimo {
    
    private int id_emprestimo;
    private Cliente cliente;
    private Livro livro;
    private String data_emprestimo;
    private String data_devolucao;

    public Emprestimo() {
    }

    public Emprestimo(int id_emprestimo, Cliente cliente, Livro livro, String data_emprestimo, String data_devolucao) {
        this.id_emprestimo = id_emprestimo;
        this.cliente = cliente;
        this.livro = livro;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}

public class Cliente {
    
    private int id;
    private String nome;
    private String dataNasc;
    private String sexo;
    private String cpf;
    private String endereco;
    private String fone;

    public Cliente() {
    }   

    public Cliente(String nome, String dataNasc, String sexo, String cpf, String endereco, String fone) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.cpf = cpf;
        this.endereco = endereco;
        this.fone = fone;
    }

    // Getters e Setters omitidos para brevidade
    
    public boolean possuiDadosIncompletos() {
        return nome.isEmpty() || dataNasc.isEmpty() || sexo.isEmpty() || cpf.isEmpty() || endereco.isEmpty();
    }
}

public class Livro {
    
    private int id;
    private String exemplar;
    private String autor;
    private int edicao;
    private int ano;
    private String disponibilidade;

    public Livro() {
    }   

    public Livro(String exemplar, String autor, int edicao, int ano, String disponibilidade) {
        this.exemplar = exemplar;
        this.autor = autor;
        this.edicao = edicao;
        this.ano = ano;
        this.disponibilidade = disponibilidade;
    }

    // Getters e Setters omitidos para bre
