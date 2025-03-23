package br.sistema.crud.jdbc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import br.sistema.crud.jdbc.bo.LoginBO;
import br.sistema.crud.jdbc.dto.LoginDTO;
import br.sistema.crud.jdbc.util.MensagensUtil;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField passSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrame() {
		initializeUI();
		setupListeners();
	}

	private void initializeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLogar = new JButton("Logar");
		JButton btnSair = new JButton("Sair");
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLogar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair)
					.addGap(19))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelLogin, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnLogar))
					.addContainerGap())
		);
		
		JLabel lblLogin = new JLabel("Login");
		JLabel lblSenha = new JLabel("Senha");
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		passSenha = new JPasswordField();
		
		GroupLayout gl_panelLogin = new GroupLayout(panelLogin);
		gl_panelLogin.setHorizontalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(lblLogin)
							.addGap(10)
							.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelLogin.createSequentialGroup()
							.addComponent(lblSenha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passSenha)))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_panelLogin.setVerticalGroup(
			gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelLogin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(passSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panelLogin.setLayout(gl_panelLogin);
		contentPane.setLayout(gl_contentPane);
	}

	private void setupListeners() {
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				logar();
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
	}

	private void logar() {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setNome(txtLogin.getText());
		loginDTO.setSenha(new String(passSenha.getPassword()));

		LoginBO loginBO = new LoginBO();
		try {
			if (loginBO.logar(loginDTO)) {
				dispose();
				MainFrame m = new MainFrame();
				m.setLocationRelativeTo(null);
				m.setVisible(true);
			} else {
				MensagensUtil.addMsg(this, "Dados Inválidos");
			}
		} catch (Exception e) {
			e.printStackTrace();
			MensagensUtil.addMsg(this, e.getMessage());
		}
	}

	private void sair() {
		System.exit(0);
	}
}
