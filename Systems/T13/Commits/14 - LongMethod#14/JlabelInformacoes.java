package siapro.gui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JlabelInformacoes {
    public void lblInformaes(JPanel contentPane){
        JLabel lblInformaes = new JLabel("Informações");
		lblInformaes.setBackground(Color.MAGENTA);
		lblInformaes.setForeground(Color.RED);
		lblInformaes.setBounds(22, 0, 131, 15);
		contentPane.add(lblInformaes);
    }

    public void lblNome(JPanel contentPane){
        JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 30, 66, 15);
		contentPane.add(lblNome);
    }

    public void lblLocal(JPanel contentPane){
        JLabel lblLocal = new JLabel("Local:");
		lblLocal.setBounds(22, 57, 73, 15);
		contentPane.add(lblLocal);
    }

    public void lblLogotipo(JPanel contentPane){
        JLabel lblLogotipo = new JLabel("Logotipo do Evento:");
		lblLogotipo.setBounds(22, 229, 131, 14);
		contentPane.add(lblLogotipo);
    }

    public JLabel lblLogo(JPanel contentPane){
        JLabel lblLogo = new JLabel();
		lblLogo.setBounds(300, 88, 401, 217);
		contentPane.add(lblLogo);

        return lblLogo;
    }

    public void lblInformaesSobreO(JPanel contentPane){
        JLabel lblInformaesSobreO = new JLabel("Informações sobre o Evento");
		lblInformaesSobreO.setForeground(Color.BLUE);
		lblInformaesSobreO.setBounds(22, 297, 224, 15);
		contentPane.add(lblInformaesSobreO);
    }

    public void lblEstado(JPanel contentPane){
        JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(22, 103, 66, 15);
		contentPane.add(lblEstado);
    }


}
