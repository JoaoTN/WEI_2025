package siapro.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JlabelCategoria {
    public void lblCat(JPanel contentPane){
        JLabel lblCat = new JLabel("CATEGORIA");
		lblCat.setBounds(165, 12, 110, 14);
		contentPane.add(lblCat);
    }

    public void lblNewLabel(JPanel contentPane){
         JLabel lblNewLabel = new JLabel("Nome da Categoria:");
		lblNewLabel.setBounds(12, 38, 159, 14);
		contentPane.add(lblNewLabel);
    }


    public void lblNewLabel_1(JPanel contentPane){
        JLabel lblNewLabel_1 = new JLabel("Quantidade de Avaliadores:");
    lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
    lblNewLabel_1.setBounds(12, 86, 263, 14);
    contentPane.add(lblNewLabel_1);
    }
    

    public void lblNewLabel_2(JPanel contentPane){
         JLabel lblNewLabel_2 = new JLabel("Quantidade Mínima");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(12, 112, 159, 14);
		contentPane.add(lblNewLabel_2);
    }

   
    public void lblNotamxima(JPanel contentPane){
        JLabel lblNotamxima = new JLabel("Quantidade Máxima");
		lblNotamxima.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNotamxima.setBounds(235, 112, 159, 14);
		contentPane.add(lblNotamxima);
    }

    


}
