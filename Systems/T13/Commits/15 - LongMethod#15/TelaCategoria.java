package siapro.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import siapro.controller.CategoriaController;
import siapro.model.Categoria;

public class TelaCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeCategoria;
	private JTextField tfQuantidadeMinima;
	private JTextField tfQuantidadeMaxima;

	public void botaoSalvar() {
//		Categoria cat = new Categoria();
//		cat.setNome(tfNomeCategoria.getText());
//		cat.setQntMaxAvalProjeto(Integer.parseInt(tfQuantidadeMaxima.getText()));
//		cat.setQntMinAvalProjeto(Integer.parseInt(tfQuantidadeMinima.getText()));
     Categoria categoriaSalvar =new Categoria();
	 categoriaSalvar.setNome(tfNomeCategoria.getText());
	 categoriaSalvar.setQntMaxAvalProjeto(Integer.parseInt(tfQuantidadeMaxima.getText()));
	 categoriaSalvar.setQntMinAvalProjeto(Integer.parseInt(tfQuantidadeMinima.getText()));
		new CategoriaController().salvarCategoria(categoriaSalvar);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCategoria frame = new TelaCategoria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCategoria() {
		setBounds(100, 100, 416, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JlabelCategoria jlabelCategoria = new JlabelCategoria();

		jlabelCategoria.lblCat(contentPane);
		
		jlabelCategoria.lblNewLabel(contentPane);

		
		tfNomeCategoria = new JTextField();
		tfNomeCategoria.setBounds(12, 54, 159, 20);
		contentPane.add(tfNomeCategoria);
		tfNomeCategoria.setColumns(10);

		jlabelCategoria.lblNewLabel_1(contentPane);
		
		jlabelCategoria.lblNewLabel_2(contentPane);
		
		tfQuantidadeMinima = new JTextField();
		tfQuantidadeMinima.setColumns(10);
		tfQuantidadeMinima.setBounds(12, 134, 68, 20);
		contentPane.add(tfQuantidadeMinima);

		jlabelCategoria.lblNotamxima(contentPane);
		
		JButton salvaCategoria = new JButton("Salvar Categoria");
		salvaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				botaoSalvar();
			}
		});
		
		salvaCategoria.setFont(new Font("Dialog", Font.PLAIN, 12));
		salvaCategoria.setBounds(131, 179, 159, 20);
		contentPane.add(salvaCategoria);
		
		tfQuantidadeMaxima = new JTextField();
		tfQuantidadeMaxima.setColumns(10);
		tfQuantidadeMaxima.setBounds(235, 134, 68, 20);
		contentPane.add(tfQuantidadeMaxima);
	}
}
