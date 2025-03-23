package siapro.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import siapro.model.Evento;

import java.awt.Font;

public class JlabelStyle{
    public void lblTrabalhos(JPanel contentPane){
        JLabel lblTrabalhos = new JLabel("TRABALHOS");
		lblTrabalhos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTrabalhos.setBounds(12, 8, 114, 15);
		contentPane.add(lblTrabalhos);
    }

    public void lblCategoria(JPanel contentPane){
        JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCategoria.setBounds(12, 132, 98, 15);
		contentPane.add(lblCategoria);
    }

    public void lblrea(JPanel contentPane){
        JLabel lblrea = new JLabel("Área:");
		lblrea.setFont(new Font("Dialog", Font.BOLD, 14));
		lblrea.setBounds(372, 127, 73, 25);
		contentPane.add(lblrea);
    }

    public void lblTrabalhosAdicionados(JPanel contentPane){
        JLabel lblTrabalhosAdicionados = new JLabel("Trabalhos Adicionados");
		lblTrabalhosAdicionados.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTrabalhosAdicionados.setBounds(12, 350, 194, 15);
		contentPane.add(lblTrabalhosAdicionados);
    }

    public void lblNomeEvento(JPanel contentPane, Evento evento){
        JLabel lblNomeEvento = new JLabel("EVENTO: " + evento.getNome());
		lblNomeEvento.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNomeEvento.setBounds(400, 85, 426, 15);
		contentPane.add(lblNomeEvento);
    }
}
