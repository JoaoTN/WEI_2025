package siapro.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import siapro.controller.EventoController;
import siapro.model.Evento;
import siapro.model.EventoData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class JbuttonInformacoes extends JFrame{
    public JButton btnLiberar(JPanel contentPane){
        JButton btnLiberar = new JButton("Liberar");
		btnLiberar.setBounds(78, 136, 89, 23);
		contentPane.add(btnLiberar);
        return btnLiberar;
        
    }

    public JButton btnBloquear(JPanel contentPane){
        JButton btnBloquear = new JButton("Bloquear");
		btnBloquear.setBounds(201, 136, 89, 23);
		contentPane.add(btnBloquear);
        return btnBloquear;
    }

    public JButton btnSalvar(Evento evento, JTextField textFieldNome, JTextArea textAreaInformacoes, Path caminho){
        JButton btnSalvar = new JButton("Salvar Alterações");
		btnSalvar.addActionListener(new ActionListener() {
			private long idEvento;
			public void actionPerformed(ActionEvent e) {
				this.idEvento = evento.getId();
				if(textFieldNome.getText().isEmpty() || textAreaInformacoes.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Não é possivel salvar com campos vazios");		
				}
				else {
					EventoData eventoData = new EventoData();
					eventoData.setNome(textFieldNome.getText());
					eventoData.setInformacoes(textAreaInformacoes.getText());
					eventoData.setSituacao(evento.getLiberado());
					eventoData.setLogotipo(caminho.toString());
					eventoData.setIdEvento(idEvento);
					new EventoController().editarEvento(eventoData);

					JOptionPane.showMessageDialog(null,"Alteração salva com sucesso");
				}					
			}
		});

        return btnSalvar;
    }
    
    
}
