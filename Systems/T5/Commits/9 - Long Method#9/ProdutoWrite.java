package model;

import control.Produto;
import control.Produto;
import view.ProdutosView;
import java.util.ArrayList;
import static view.ProdutosView.Modelo;

public class ProdutoWrite {

    public static ArrayList<Produto> produtos = new ArrayList<>();
    public static Produto itens = new Produto(null);

    public static void salvar() {
        atualizarDadosProduto();
        atualizarModelo();
    }    

    public static void atualizarDadosProduto() {
        Produto produto = ProdutoWrite.produtos.get(ProdutosView.index);
        String[] dadosProduto = Produto.v;

        produto.getDadosProduto().setNome(dadosProduto[0]);
        produto.getDadosProduto().setCodigo_produto(dadosProduto[1]);
        produto.getDadosProduto().setValor_da_compra(dadosProduto[2]);
        produto.getDadosProduto().setMarca(dadosProduto[3]);
        produto.getDadosProduto().setData_da_compra(dadosProduto[4]);
        produto.getDadosProduto().setValor_da_venda(dadosProduto[5]);
        produto.getDadosProduto().setCategoria(dadosProduto[6]);
        produto.getDadosProduto().setDescricao(dadosProduto[7]);
        produto.getDadosProduto().setFornecedor(dadosProduto[8]);
        produto.getDadosProduto().setPrateleira(dadosProduto[9]);
        produto.getDadosProduto().setQuant(dadosProduto[10]);

        Produto.id = produto.getDadosProduto().getCodigo_produto();

    }

    private static void atualizarModelo() {
        Produto produto = ProdutoWrite.produtos.get(ProdutosView.index);
        Modelo.setValueAt(produto, ProdutosView.index);
    }
}
