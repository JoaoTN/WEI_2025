package siapro.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import siapro.controller.EventoController;
import siapro.model.Evento;
import siapro.model.EventoData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

public class Informacoes extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldLocal;
	private JTextField textFieldEstado;
	private JTextArea textAreaInformacoes;
	private Evento evento;
	private Path caminho;
	
	public Informacoes(Evento evento) {
		this.evento = evento;
		setBounds(100, 100, 745, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JlabelInformacoes jlabelInformacoes = new JlabelInformacoes();
		JbuttonInformacoes jbuttonInformacoes = new JbuttonInformacoes();

		jlabelInformacoes.lblInformaes(contentPane);
		

		jlabelInformacoes.lblNome(contentPane);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(78, 27, 334, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		textFieldNome.setText(evento.getNome());
		
		jlabelInformacoes.lblLocal(contentPane);
		
		textFieldLocal = new JTextField();
		textFieldLocal.setEditable(false);
		textFieldLocal.setBounds(78, 55, 334, 19);
		contentPane.add(textFieldLocal);
		textFieldLocal.setColumns(10);
		textFieldLocal.setText("IF Goiano - Campus Ceres");

		JButton btnLiberar = jbuttonInformacoes.btnLiberar(contentPane);
		
		JButton btnBloquear = jbuttonInformacoes.btnBloquear(contentPane);
		
		btnLiberar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evento.setLiberado(true);
				textFieldEstado.setText("Liberado");
				btnLiberar.setEnabled(false);
				btnBloquear.setEnabled(true);
			}
		});
		
		btnBloquear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evento.setLiberado(false);
				textFieldEstado.setText("Bloqueado");
				btnLiberar.setEnabled(true);
				btnBloquear.setEnabled(false);
			}
		});

		jlabelInformacoes.lblEstado(contentPane);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(78, 100, 207, 20);
		contentPane.add(textFieldEstado);
		textFieldEstado.setColumns(10);		
		if(evento.getLiberado() == true) {
			textFieldEstado.setText("Liberado");
			btnLiberar.setEnabled(false);
		}else {
			textFieldEstado.setText("Bloqueado");
			btnBloquear.setEnabled(false);
		}

		jlabelInformacoes.lblLogotipo(contentPane);

		JLabel lblLogo = jlabelInformacoes.lblLogo(contentPane);
		
		JButton btnEscolherArquivo = new JButton("Enviar Arquivo");
		btnEscolherArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(btnEscolherArquivo);
				File file = fc.getSelectedFile();
				try {
					caminho = Paths.get(file.getAbsolutePath());
					lblLogo.setIcon(new ImageIcon(caminho.toString()));
					getContentPane().add(lblLogo);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btnEscolherArquivo, "Arquivo não carregado");
				}
			}
		});
		
				
		btnEscolherArquivo.setBounds(145, 225, 133, 23);
		contentPane.add(btnEscolherArquivo);

		jlabelInformacoes.lblInformaesSobreO(contentPane);

	
		JTextArea textAreaInformacoes = new JTextArea();
		textAreaInformacoes.setBounds(22, 324, 390, 69);
		contentPane.add(textAreaInformacoes);
		textAreaInformacoes.setText(evento.getInformacoes());
		
		JButton btnSalvar = jbuttonInformacoes.btnSalvar(evento, textFieldNome, textAreaInformacoes, caminho);

					
		btnSalvar.setForeground(Color.BLUE);
		btnSalvar.setBounds(313, 404, 176, 25);
		contentPane.add(btnSalvar);
		
		setVisible(true);
		
	}
}
