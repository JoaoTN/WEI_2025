package siapro.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import siapro.controller.ListarAreaController;
import siapro.controller.ListarCategoriaController;
import siapro.controller.ListarProjetoController;
import siapro.model.Evento;
import siapro.model.Projeto;

public class ListarProjeto extends JFrame {

	private JPanel contentPane;
	private JTextField txtfPesquisarProjeto;
	private JList listaTrabalho;

	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Evento evento = (Evento) new EventoDAO().pesquisarId(1);
					ListarProjeto frame = new ListarProjeto(evento);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	
	public void desativar() {
		Projeto projeto = (Projeto) listaTrabalho.getSelectedValue();
		new ListarProjetoController().desativarProjeto(projeto);
	}
	
	public ListarProjeto(Evento evento) {
		setTitle("Lista de Projetos");
		setBounds(100, 100, 826, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JlabelStyle jlabelStyle = new JlabelStyle();
		JbuttonStyle jbuttonStyle = new JbuttonStyle();

		jlabelStyle.lblTrabalhos(contentPane);
		
		jbuttonStyle.btnAddTrabalho(contentPane, evento);
		

		jbuttonStyle.btnDistribuirTrabalho(contentPane);
		
		
		txtfPesquisarProjeto = new JTextField();
		txtfPesquisarProjeto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtfPesquisarProjeto.setText("");
			}
		});
		txtfPesquisarProjeto.setText("Digite sua pesquisa");
		txtfPesquisarProjeto.setBounds(12, 80, 235, 25);
		contentPane.add(txtfPesquisarProjeto);
		txtfPesquisarProjeto.setColumns(10);

		jlabelStyle.lblCategoria(contentPane);

		jlabelStyle.lblrea(contentPane);
		
		
		JList listaCategoria = new JList(new ListarCategoriaController().listarCategoria(evento).toArray());
		listaCategoria.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaCategoria.setBackground(UIManager.getColor("CheckBox.background"));
		listaCategoria.setBounds(12, 157, 330, 175);
		contentPane.add(listaCategoria);
		
		JList listaArea = new JList(new ListarAreaController().listarAreas(evento).toArray());
		listaArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaArea.setBackground(UIManager.getColor("CheckBox.background"));
		listaArea.setBounds(372, 157, 330, 175);
		contentPane.add(listaArea);

		jlabelStyle.lblTrabalhosAdicionados(contentPane);
		
		listaTrabalho = new JList(new ListarProjetoController().listarProjeto(evento).toArray());
		listaTrabalho.setBorder(new LineBorder(new Color(60, 179, 113)));
		listaTrabalho.setBackground(UIManager.getColor("CheckBox.background"));
		listaTrabalho.setBounds(12, 377, 463, 219);
		contentPane.add(listaTrabalho);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String texto = txtfPesquisarProjeto.getText();
					listaTrabalho.setListData(new ListarProjetoController().pesquisarTitulo(evento, texto).toArray());
			}
		});
		btnPesquisar.setBounds(255, 78, 114, 25);
		contentPane.add(btnPesquisar);

		jbuttonStyle.btnEditarTrabalho(contentPane, listaTrabalho);
		
		
		jbuttonStyle.btnExcluirTrabalho(contentPane, evento, listaTrabalho);
		
		JScrollPane scrollLCategoria = new JScrollPane(listaCategoria);
		scrollLCategoria.setBounds(12, 157, 342, 175);
		contentPane.add(scrollLCategoria);
		
		JScrollPane scrollLArea = new JScrollPane(listaArea);
		scrollLArea.setBounds(372, 157, 330, 175);
		contentPane.add(scrollLArea);
		
		JScrollPane scrollLTrabalho = new JScrollPane(listaTrabalho);
		scrollLTrabalho.setBounds(12, 377, 463, 219);
		contentPane.add(scrollLTrabalho);

		jlabelStyle.lblNomeEvento(contentPane, evento);
	
 		
		setVisible(true);
	}
}
