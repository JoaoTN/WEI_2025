
package control;

import java.util.ArrayList;

class DadosProduto {
    private String nome;
    private String codigo_produto;
    private String valor_da_compra;
    private String marca;
    private String data_da_compra;
    private String valor_da_venda;
    private String categoria;
    private String descricao;  
    private String fornecedor;
    private String prateleira;
    private String quant;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo_produto() {
        return this.codigo_produto;
    }

    public void setCodigo_produto(String codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public String getValor_da_compra() {
        return this.valor_da_compra;
    }

    public void setValor_da_compra(String valor_da_compra) {
        this.valor_da_compra = valor_da_compra;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getData_da_compra() {
        return this.data_da_compra;
    }

    public void setData_da_compra(String data_da_compra) {
        this.data_da_compra = data_da_compra;
    }

    public String getValor_da_venda() {
        return this.valor_da_venda;
    }

    public void setValor_da_venda(String valor_da_venda) {
        this.valor_da_venda = valor_da_venda;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getPrateleira() {
        return this.prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String getQuant() {
        return this.quant;
    }

    public void setQuant(String quant) {
        this.quant = quant;
    }

    public DadosProduto(String nome, String codigo_produto, String valor_da_compra, String marca, String data_da_compra, String valor_da_venda, String categoria, String descricao, String fornecedor, String prateleira, String quant) {
        this.nome = nome;
        this.codigo_produto = codigo_produto;
        this.valor_da_compra = valor_da_compra;
        this.marca = marca;
        this.data_da_compra = data_da_compra;
        this.valor_da_venda = valor_da_venda;
        this.categoria = categoria;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.prateleira = prateleira;
        this.quant = quant;
    }
}

public class Produto {
    public static String v[] = new String[12];
    public static String id = "0";
    public static String pesquisa;
    private DadosProduto dadosProduto;
    
    public Produto(DadosProduto dadosProduto){
        this.dadosProduto = dadosProduto;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DadosProduto geDadosProduto() {
        return dadosProduto;
    }

    public void setDadosProduto(DadosProduto dadosProduto) {
        this.dadosProduto = dadosProduto;
    }
}

