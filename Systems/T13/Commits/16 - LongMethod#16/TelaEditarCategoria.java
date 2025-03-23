package siapro.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import siapro.controller.CategoriaController;
import siapro.model.Categoria;
import siapro.model.Criterio;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditarCategoria extends JFrame {

	private JPanel contentPaneCategoria;
	private JTextField textFieldCategoria;
	private JList listCriterios;
	private JLabel lblCriterios;
	private static CategoriaController cC = new CategoriaController();
	private JTextField textFieldMin;
	private JTextField textFieldMax;

	public TelaEditarCategoria(Categoria categoria) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 455);
		contentPaneCategoria = new JPanel();
		contentPaneCategoria.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneCategoria);
		contentPaneCategoria.setLayout(null);

		JlabelEditar jlabelEditar = new JlabelEditar();

		jlabelEditar.lblEditarCategoria(contentPaneCategoria, categoria);

		jlabelEditar.lblNomeCategoria(contentPaneCategoria);
		
		textFieldCategoria = new JTextField();
		textFieldCategoria.setBounds(39, 76, 237, 20);
		contentPaneCategoria.add(textFieldCategoria);
		textFieldCategoria.setColumns(10);
		textFieldCategoria.setText(categoria.getNome());
		
		listCriterios = new JList(cC.listarCriterio(categoria).toArray());
		listCriterios.setBounds(39, 187, 237, 171);
		contentPaneCategoria.add(listCriterios);
		
		lblCriterios = new JLabel("Criterios:");
		lblCriterios.setBounds(39, 162, 48, 14);
		contentPaneCategoria.add(lblCriterios);
		
		JButton btnEditarCriterio = new JButton("Editar criterio");
		btnEditarCriterio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAddCriterio((Criterio) listCriterios.getSelectedValue());
			}
		});
		btnEditarCriterio.setBounds(323, 226, 124, 23);
		contentPaneCategoria.add(btnEditarCriterio);
		
		JButton btnDeletarCriterio = new JButton("Deletar criterio");
		btnDeletarCriterio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaDeletarCriterio((Criterio) listCriterios.getSelectedValue());
			}
		});
		btnDeletarCriterio.setBounds(323, 271, 124, 23);
		contentPaneCategoria.add(btnDeletarCriterio);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				categoria.setNome(textFieldCategoria.getText());
				categoria.setQntMaxAvalProjeto(Integer.parseInt(textFieldMax.getText()));
				categoria.setQntMinAvalProjeto(Integer.parseInt(textFieldMin.getText()));
				categoria.setId(cC.salvarCategoria(categoria).getId());
			}
		});
		btnSalvar.setBounds(347, 381, 89, 23);
		contentPaneCategoria.add(btnSalvar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listCriterios.setListData(cC.listarCriterio(categoria).toArray());
			}
		});
		btnAtualizar.setBounds(226, 381, 89, 23);
		contentPaneCategoria.add(btnAtualizar);
		
		JButton btnAdicionarCriterio = new JButton("Adicionar criterio");
		btnAdicionarCriterio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(categoria.getId() != 0) {
					new TelaAddCriterio(categoria);					
				}
				else {
					categoria.setNome(textFieldCategoria.getText());
					categoria.setQntMaxAvalProjeto(Integer.parseInt(textFieldMax.getText()));
					categoria.setQntMinAvalProjeto(Integer.parseInt(textFieldMin.getText()));
					categoria.setId(cC.salvarCategoria(categoria).getId());
					new TelaAddCriterio(categoria);
				}
			}
		});
		btnAdicionarCriterio.setBounds(323, 184, 124, 23);
		contentPaneCategoria.add(btnAdicionarCriterio);

		jlabelEditar.lblQuantidadeDeAvaliadores(contentPaneCategoria);
		
		jlabelEditar.lblMin(contentPaneCategoria);
		
		textFieldMin = new JTextField();
		textFieldMin.setBounds(72, 131, 65, 20);
		contentPaneCategoria.add(textFieldMin);
		textFieldMin.setColumns(10);
		textFieldMin.setText(Integer.toString(categoria.getQntMinAvalProjeto()));

		jlabelEditar.lblMax(contentPaneCategoria);
		
		textFieldMax = new JTextField();
		textFieldMax.setBounds(219, 132, 65, 20);
		contentPaneCategoria.add(textFieldMax);
		textFieldMax.setColumns(10);
		textFieldMax.setText(Integer.toString(categoria.getQntMaxAvalProjeto()));
		
		JScrollPane scrollCriterios = new JScrollPane(listCriterios);
		scrollCriterios.setBounds(39, 187, 251, 182);
		contentPaneCategoria.add(scrollCriterios);
		setVisible(true);
	}
}
