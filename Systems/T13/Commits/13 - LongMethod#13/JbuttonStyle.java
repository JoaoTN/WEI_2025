package siapro.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import siapro.controller.ListarProjetoController;
import siapro.model.Evento;
import siapro.model.Projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JbuttonStyle extends JFrame{
    public void btnAddTrabalho(JPanel contentPane, Evento evento){
        JButton btnAddTrabalho = new JButton("Adicionar Trabalhos");
		btnAddTrabalho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaAddProjeto tap = new TelaAddProjeto(evento);
				tap.setVisible(true);
			}
		});
		btnAddTrabalho.setBounds(12, 30, 169, 25);
		contentPane.add(btnAddTrabalho);
    }

    public void btnDistribuirTrabalho(JPanel contentPane){
        JButton btnDistribuirTrabalho = new JButton("Distribuir Trabalhos");
		btnDistribuirTrabalho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDistribuirTrabalho.setBounds(214, 30, 183, 25);
		contentPane.add(btnDistribuirTrabalho);
    }

    public void btnEditarTrabalho(JPanel contentPane, JList listaTrabalho){
        JButton btnEditarTrabalho = new JButton("Editar Trabalho");
		btnEditarTrabalho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Projeto p = (Projeto) listaTrabalho.getSelectedValue();
				new TelaAddProjeto((Projeto) listaTrabalho.getSelectedValue());
				dispose();
			}
		});
		btnEditarTrabalho.setBounds(500, 374, 147, 25);
		contentPane.add(btnEditarTrabalho);
    }
    
    public void btnExcluirTrabalho(JPanel contentPane, Evento evento, JList listaTrabalho){
        		JButton btnExcluirTrabalho = new JButton("Excluir Trabalho");
        
		btnExcluirTrabalho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarProjeto listarProjeto = new ListarProjeto(evento);
                listarProjeto.desativar();
				listaTrabalho.setListData(new ListarProjetoController().listarProjeto(evento).toArray());
			}
		});
		btnExcluirTrabalho.setBounds(500, 425, 152, 25);
		contentPane.add(btnExcluirTrabalho);
    }


}
