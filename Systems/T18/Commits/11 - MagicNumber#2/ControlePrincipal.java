/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import View.LimiteRelatorios;
import View.LimiteConImovel;
import Model.Comprador;
import Model.Corretor;
import Model.Imovel;
import Model.Proposta;
import Model.Util;
import View.LimiteConCatalogo;
import Model.Vendedor;
import Model.Visita;
import View.LimiteCadComprador;
import View.LimiteCadCorretor;
import View.LimiteCadImovel;
import View.LimiteCadVendedor;
import View.LimiteConPropostas;
import View.LimitePrincipal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class ControlePrincipal {
    
    //controladores
    private ControleComprador ctrComprador;
    private ControleVendedor ctrVendedor;
    private ControleImovel ctrImovel;
    private ControleCorretor ctrCorretor;

    final int MessageType = 0;
    
    public ControlePrincipal(){
        new LimitePrincipal(this);
        
        ctrComprador = new ControleComprador();
        ctrVendedor = new ControleVendedor();
        ctrImovel = new ControleImovel();
        ctrCorretor = new ControleCorretor();
        desserializaDados();
        //carregaDados();
    }
    
    public void carregaDados(){
        final int PercentagemCorretagem1 = 50;
        final int PercentagemCorretagem2 = 40;

        final int Ano = 2019;
        final int Mes = 12;
        final int Dia = 05;

        final int Codigo1 = 101;
        final int Codigo2 = 102;
        final int Codigo3 = 103;
        final int Codigo4 = 104;

        final int Preco1 = 700000;
        final int Preco2 = 1200000;
        final int Preco3 = 400000;
        final int Preco4 = 300000;

        final int Comissao1 = 5;
        final int Comissao2 = 4;
        final int Comissao3 = 5;
        final int Comissao4 = 4;

        //Adiciona Corretores
        ctrCorretor.cadastraCorretor("1001", "Joao Santos", "joao@gmail.com", "999990001", "10001", PercentagemCorretagem1);
        ctrCorretor.cadastraCorretor("1002", "Luiz Souza", "luiz@gmail.com", "999990002", "10002", PercentagemCorretagem2);
        
        //Adiciona Vendedores 
        ctrVendedor.cadastraVendedor("2001", "Marina Cintra", "marina@gmail.com", "888880001", Util.FONE);
        ctrVendedor.cadastraVendedor("2002", "Andre Cruz", "andre@gmail.com", "888880002", Util.FONE);
        ctrVendedor.cadastraVendedor("2003", "Felipe Antunes", "felipe@gmail.com", "888880003", Util.EMAIL);
        
        //Adiciona Compradores
        ctrComprador.cadastraComprador("3001", "Ana Carvalho", "ana@gmail.com", "777770001", Util.FONE);
        ctrComprador.cadastraComprador("3002", "Caio Oliveira", "caio@gmail.com", "777770002", Util.EMAIL);
        ctrComprador.cadastraComprador("3003", "Pedro Silva", "pedro@gmail.com", "777770003", Util.FONE);
        ctrComprador.cadastraComprador("3004", "Clara Maia", "clara@gmail.com", "777770004", Util.EMAIL);
        
        Calendar data = GregorianCalendar.getInstance();
        
        //Adiciona Imovel
        data.set(GregorianCalendar.YEAR, Ano);
        data.set(GregorianCalendar.MONTH, Mes);
        data.set(GregorianCalendar.DAY_OF_MONTH, Dia);
        
        Vendedor vend = retornaVendedorPorCpf("2001");
        ctrImovel.cadastraImovel(Codigo1, Util.CASA, "Casa 3 quartos", "Endereco","..\\images\\casa-101.jpg", Preco1, Comissao1, data, vend);
        
        vend = retornaVendedorPorCpf("2002");
        ctrImovel.cadastraImovel(Codigo2, Util.CASA, "Casa alto padrao", "Endereco2","..\\images\\casa-102.jpg", Preco2, Comissao2, data, vend);
        
        vend = retornaVendedorPorCpf("2003");
        ctrImovel.cadastraImovel(Codigo3, Util.APTO, "Apto 3 quartos", "Endereco3","..\\images\\apto-103.jpg", Preco3, Comissao3, data, vend);
        
        vend = retornaVendedorPorCpf("2001");
        ctrImovel.cadastraImovel(Codigo4, Util.APTO, "Apto 2 quartos", "Endereco4","..\\images\\apto-104.jpg", Preco4, Comissao4, data, vend);
    }
    
    //Interfaces cadastro
    public void interfaceCadCorretor(){
        new LimiteCadCorretor(this);
    }
    
    public void interfaceCadVendedor(){
        new LimiteCadVendedor(this);
    }
            
    public void interfaceCadImovel(){
        new LimiteCadImovel(this);
    }
    
    public void interfaceCadComprador(){
        new LimiteCadComprador(this);
    }
    
    //Interfaces consulta
    public void interfaceConCatalogo(){
        new LimiteConCatalogo(this);
    }
    
    public void interfaceConPropostas(){
        new LimiteConPropostas(this);
    }
    
    public void interfaceConImovel(){
        new LimiteConImovel(this);
    }
    
    //interface relatórios
    public void interfaceRelatorios(){
        new LimiteRelatorios(this);
    }
   
    //Cadastros
    public void cadCorretor(String cpf, String nome, String email, String fone, String creci, double comissao){
        ctrCorretor.cadastraCorretor(cpf, nome, email, fone, creci, comissao);
    }

    public void cadVendedor(String cpf, String nome, String email, String fone, String contato){
        ctrVendedor.cadastraVendedor(cpf, nome, email, fone, contato);
    }
    
    public void cadImovel(int codigo, String tipo, String descricao, String endereco, String foto, double preco, double comissao, String cpfVendedor){
        if(ctrVendedor.existeVendedor(cpfVendedor)){
            Vendedor vendedorImovel = ctrVendedor.retornaVendedorPorCpf(cpfVendedor);
            ctrImovel.cadastraImovel(codigo, tipo, descricao, endereco, foto, preco, comissao, vendedorImovel);
        }else{
            JOptionPane.showMessageDialog(null, "Não existe o vendedor com o CPF especificado!", "Erro", MessageType);
            System.out.println("Não existe o vendedor com o CPF especificado.");
        }
    }
    
    public void cadComprador(String cpf, String nome, String email, String fone, String contato){
        ctrComprador.cadastraComprador(cpf, nome, email, fone, contato);
    }
    
    //catálogo
    public ArrayList<Imovel> retornoArrayListImovel(String tipo){
        return ctrImovel.getListaImovel(tipo);
    }
    
    public List<String> retornoArrayListTipos(){
        return ctrImovel.getTiposImovel();
    }
    
    public String retornaStringDadosImovel(Imovel im){
        return ctrImovel.retornaDadosImovel(im);
    }
    
    //Proposta e visita
    public Comprador retornaCompradorPorCpf(String cpf){
        return ctrComprador.retornaCompradorPorCpf(cpf);
    }
    
    public Corretor retornaCorretorPorCpf(String cpf){
        return ctrCorretor.retornaCorretorPorCpf(cpf);
    }
    
    public Vendedor retornaVendedorPorCpf(String cpf){
        return ctrVendedor.retornaVendedorPorCpf(cpf);
    }
    
    public boolean registraPropostaPorCodigo(int codigo, Proposta proposta){
        return ctrImovel.procuraPropostaERegistra(codigo, proposta);
    }
    
    public boolean registraVisitaPorCodigo(int codigo, Visita visita){
        return ctrImovel.procuraVisitaERegistra(codigo, visita);
    }
    
    public void procuraAlteraEstadoPropostaMain(Imovel imo, Proposta pro, String novoEstado){
        ctrImovel.procuraAlteraEstadoProposta(imo, pro, novoEstado);
    }

    public Imovel retornoImovelPorCodigo(int codigo){
        return ctrImovel.retornoImovelPorCodigo(codigo);
    }
    
    public void desativarImovel(int codigo){
        ctrImovel.desativaImovel(codigo);
    }
    
    //relatórios
    public double retornoDinheiroImobiliaria(Calendar inicio, Calendar fim, boolean comCorretor){
        return ctrImovel.retornoDinheiroImobiliaria(inicio, fim, comCorretor);
    }
    
    public double retornoDinheiroCorretor(Calendar inicio,Calendar fim, String cpfCorretor){
        return ctrImovel.retornoDinheiroCorretor(inicio,fim,cpfCorretor);
    }
    
    public String retornoImoveisVendidosPorTempo(Calendar inicio, Calendar fim){
        return ctrImovel.retornoImoveisVendidosString(inicio, fim);
    }
    
    public String retornoImoveisPorVendedor(String cpfVendedor){
        return ctrImovel.retornoImoveisPorVendedor(cpfVendedor);
    }
    
    public String retornoEventosImovelPorPeriodo(Calendar inicio, Calendar fim, int codigo){
        return ctrImovel.retornoEventosImovelPorPeriodo(inicio, fim, codigo);
    }
    
    public String retornaVisitasCorretorString(Calendar inicio,Calendar fim, String cpfCorretor){
        return ctrImovel.retornaVisitasCorretorString(inicio, fim, cpfCorretor);
    } 
    
    public void desserializaDados(){
        ctrCorretor.desserializaCorretor();
        ctrVendedor.desserializaVendedor();
        ctrComprador.desserializaComprador();
        ctrImovel.desserializaImovel();
    }
    
    public void serializaDados(){
        ctrCorretor.serializaCorretor();
        ctrVendedor.serializaVendedor();
        ctrComprador.serializaComprador();
        ctrImovel.serializaImovel();
    }
}
