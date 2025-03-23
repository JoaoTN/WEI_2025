package siapro.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import siapro.model.Categoria;

import java.awt.Font;

public class JlabelEditar {
    public void lblEditarCategoria(JPanel contentPaneCategoria, Categoria categoria){
        JLabel lblEditarCategoria = new JLabel(categoria.getId()!=0?"Editar Categoria":"Salvar Categoria");
        lblEditarCategoria.setFont(new Font("Segoe UI Historic", Font.PLAIN, 17));
        lblEditarCategoria.setBounds(181, 11, 134, 24);
        contentPaneCategoria.add(lblEditarCategoria);
    }

    public void lblNomeCategoria(JPanel contentPaneCategoria){
        JLabel lblNomeCategoria = new JLabel("Nome categoria: ");
        lblNomeCategoria.setBounds(39, 51, 84, 14);
        contentPaneCategoria.add(lblNomeCategoria);
    }
    

    public void lblQuantidadeDeAvaliadores(JPanel contentPaneCategoria){
        JLabel lblQuantidadeDeAvaliadores = new JLabel("Quantidade de avaliadores:");
        lblQuantidadeDeAvaliadores.setBounds(39, 110, 147, 14);
        contentPaneCategoria.add(lblQuantidadeDeAvaliadores);
    }
    

    public void lblMin(JPanel contentPaneCategoria){
        JLabel lblMin = new JLabel("Min.:");
        lblMin.setBounds(39, 135, 48, 14);
        contentPaneCategoria.add(lblMin);
    }
    
    
    public void lblMax(JPanel contentPaneCategoria){
         JLabel lblMax = new JLabel("Max.:");
        lblMax.setBounds(188, 135, 48, 14);
        contentPaneCategoria.add(lblMax);
    }
    
   
}
