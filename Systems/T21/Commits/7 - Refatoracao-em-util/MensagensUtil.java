package br.sistema.crud.jdbc.util;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MensagensUtil {
    
    public static void exibirMensagem(Component component, String msg){
        JOptionPane.showMessageDialog(component, msg);
    }
}
