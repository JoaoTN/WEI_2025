package controleatleta;

import ValidaDados.ValidaDados;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.HashMap;

public class CadastroTenista extends javax.swing.JDialog {

    private Tenista umTenista;
    private TipoQuadra quadra;
    private ArrayList<Patrocinador> patrocinadores;
    private HashMap<String, Integer> nomeQuantidadeTitulosGanhos;
    private HashMap<Integer, Integer> vitoriasAno;
    private HashMap<Integer, Integer> derrotasAno;
    private Patrocinador patrocinador;
    private ControleTenista controleTenista;
    
    public CadastroTenista(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPosRankMundial = new javax.swing.JLabel();
        jLabelFortunaJogos = new javax.swing.JLabel();
        jLabelFortunaPropagandas = new javax.swing.JLabel();
        jLabelTipoQuadra = new javax.swing.JLabel();
        jTextFieldPosRankMundial = new javax.swing.JTextField();
        jTextFieldFortunaJogos = new javax.swing.JTextField();
        jTextFieldFortunaPropagandas = new javax.swing.JTextField();
        jComboBoxTipoQuadra = new javax.swing.JComboBox();
        jButtonSalvarTenista = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAdicionarPatrocinadores = new javax.swing.JButton();
        jButtonTitulosGanhos = new javax.swing.JButton();
        jButtonVitoriasDerrotasAno = new javax.swing.JButton();
        jButtonPesquisarTenista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelPosRankMundial.setText("Posição no Rank Mundial:");

        jLabelFortunaJogos.setText("Fortuna Acumulada em Jogos:");

        jLabelFortunaPropagandas.setText("Fortuna Acumulada em Propagandas:");

        jLabelTipoQuadra.setText("Quadra Preferida: ");

        jComboBoxTipoQuadra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hard Court(Piso Duro)", "Clay(Saibro)", "Grass(Grama)" }));

        jButtonSalvarTenista.setText("Salvar");
        jButtonSalvarTenista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarTenistaActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAdicionarPatrocinadores.setText("Patrocinadores");
        jButtonAdicionarPatrocinadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarPatrocinadoresActionPerformed(evt);
            }
        });

        jButtonTitulosGanhos.setText("Títulos Ganhos");
        jButtonTitulosGanhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTitulosGanhosActionPerformed(evt);
            }
        });

        jButtonVitoriasDerrotasAno.setText("Vitórias e Derrotas por Ano");
        jButtonVitoriasDerrotasAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVitoriasDerrotasAnoActionPerformed(evt);
            }
        });

        jButtonPesquisarTenista.setText("Pesquisar");
        jButtonPesquisarTenista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarTenistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPesquisarTenista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(173, 173, 173)
                                .addComponent(jButtonSalvarTenista, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPosRankMundial)
                                    .addComponent(jLabelFortunaJogos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldFortunaJogos, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                    .addComponent(jTextFieldPosRankMundial)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelFortunaPropagandas)
                                    .addComponent(jLabelTipoQuadra))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldFortunaPropagandas)
                                    .addComponent(jComboBoxTipoQuadra, 0, 290, Short.MAX_VALUE))))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonTitulosGanhos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAdicionarPatrocinadores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonVitoriasDerrotasAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPosRankMundial)
                    .addComponent(jTextFieldPosRankMundial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFortunaJogos)
                    .addComponent(jTextFieldFortunaJogos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFortunaPropagandas)
                    .addComponent(jTextFieldFortunaPropagandas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoQuadra)
                    .addComponent(jComboBoxTipoQuadra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonVitoriasDerrotasAno)
                .addGap(18, 18, 18)
                .addComponent(jButtonTitulosGanhos)
                .addGap(18, 18, 18)
                .addComponent(jButtonAdicionarPatrocinadores)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalvarTenista)
                            .addComponent(jButtonCancelar))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesquisarTenista)
                        .addContainerGap(40, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarTenistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarTenistaActionPerformed
     
        ValidaDados dados = null;
        
        CadastroPatrocinadores cadastroPat = new CadastroPatrocinadores(null, true);
        String nomePatrocinadorAux = cadastroPat.getNomePatrocinador();
        patrocinadores = new ArrayList<Patrocinador>();
        patrocinador = new Patrocinador(nomePatrocinadorAux);
        patrocinadores.add(patrocinador);
        
        CadastroTitulosGanhos cadastroTitulosGanhos = new CadastroTitulosGanhos(null, true);
        String nomeTituloAux = cadastroTitulosGanhos.getNomeTitulo();
        int qntdTituloAux = cadastroTitulosGanhos.getQuantidadeTitulo();
        nomeQuantidadeTitulosGanhos = new HashMap<String, Integer>();
        nomeQuantidadeTitulosGanhos.put(nomeTituloAux, qntdTituloAux);
        
        CadastroVitoriasDerrotasAno cadastroVitoriasDerrotasAno = new CadastroVitoriasDerrotasAno(null, true);
        int ano = cadastroVitoriasDerrotasAno.getAno();
        int vitorias = cadastroVitoriasDerrotasAno.getVitoriasAno();
        int derrotas = cadastroVitoriasDerrotasAno.getDerrotasAno();
        vitoriasAno = new HashMap<Integer, Integer> ();
        derrotasAno = new HashMap<Integer, Integer> ();
        vitoriasAno.put(ano, vitorias);
        derrotasAno.put(ano, derrotas);
        
        
        try {
            
            ValidaDados.validarRank(jTextFieldPosRankMundial.getText());
            ValidaDados.validarFortuna(jTextFieldFortunaJogos.getText());       
            ValidaDados.validarFortuna(jTextFieldFortunaPropagandas.getText());       
   
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO!", JOptionPane.INFORMATION_MESSAGE);
        }
        

        umTenista.getEstatisticas().setPosicaoRankMundial(Integer.parseInt(jTextFieldPosRankMundial.getText()));
        umTenista.getCarreira().setFortunaAcumuladaJogos(Double.parseDouble(jTextFieldFortunaJogos.getText()));
        umTenista.getCarreira().setFortunaAcumuladaPropagandas(Double.parseDouble(jTextFieldFortunaPropagandas.getText()));
        umTenista.getCarreira().setPatrocinadores(patrocinadores);
        umTenista.getCarreira().setNomeQuantidadeTitulosGanhos(nomeQuantidadeTitulosGanhos);
        umTenista.getEstatisticas().setVitoriasPorAno(vitoriasAno);
        umTenista.getEstatisticas().setDerrotasPorAno(derrotasAno);
        
        switch (jComboBoxTipoQuadra.getSelectedIndex()) {
            case TipoQuadra.HARD_COURT_INDICE:
                quadra = new TipoQuadra(TipoQuadra.HARD_COURT_VALOR);
                umTenista.getCarreira().setQuadraPreferida(quadra);
                break;
            case TipoQuadra.CLAY_INDICE:
                quadra = new TipoQuadra(TipoQuadra.CLAY_VALOR);
                umTenista.getCarreira().setQuadraPreferida(quadra);
                break;
            case TipoQuadra.GRASS_INDICE:
                quadra = new TipoQuadra(TipoQuadra.GRASS_VALOR);
                umTenista.getCarreira().setQuadraPreferida(quadra);
                break;
        }
        
        JOptionPane.showMessageDialog(null, "Tenista Adicionado com Sucesso!!","ATENÇÃO!!", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_jButtonSalvarTenistaActionPerformed

    private void jButtonAdicionarPatrocinadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarPatrocinadoresActionPerformed
        CadastroPatrocinadores cadastroPat = new CadastroPatrocinadores(null, true);
        cadastroPat.setVisible(true);
        
    }//GEN-LAST:event_jButtonAdicionarPatrocinadoresActionPerformed

    private void jButtonTitulosGanhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTitulosGanhosActionPerformed
        CadastroTitulosGanhos cadastroTitulosGanhos = new CadastroTitulosGanhos(null, true);
        cadastroTitulosGanhos.setVisible(true);
    }//GEN-LAST:event_jButtonTitulosGanhosActionPerformed

    private void jButtonVitoriasDerrotasAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVitoriasDerrotasAnoActionPerformed
        CadastroVitoriasDerrotasAno cadastro = new CadastroVitoriasDerrotasAno(null, true);
        cadastro.setVisible(true);
    }//GEN-LAST:event_jButtonVitoriasDerrotasAnoActionPerformed

    private void jButtonPesquisarTenistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarTenistaActionPerformed
        String pesquisa = JOptionPane.showInputDialog("Informe o nome do Tenista.");
        if (pesquisa != null) {
            this.pesquisarTenista(pesquisa);
        }
    }//GEN-LAST:event_jButtonPesquisarTenistaActionPerformed

    private void pesquisarTenista(String nome) {
        Tenista tenistaPesquisado = controleTenista.pesquisar(nome);

        if (tenistaPesquisado == null) {
            JOptionPane.showMessageDialog(this, "Tenista não encontrado.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Tenista encontrado com sucesso!.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            //this.umTenista = tenistaPesquisado;
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroTenista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTenista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTenista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTenista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroTenista dialog = new CadastroTenista(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarPatrocinadores;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonPesquisarTenista;
    private javax.swing.JButton jButtonSalvarTenista;
    private javax.swing.JButton jButtonTitulosGanhos;
    private javax.swing.JButton jButtonVitoriasDerrotasAno;
    private javax.swing.JComboBox jComboBoxTipoQuadra;
    private javax.swing.JLabel jLabelFortunaJogos;
    private javax.swing.JLabel jLabelFortunaPropagandas;
    private javax.swing.JLabel jLabelPosRankMundial;
    private javax.swing.JLabel jLabelTipoQuadra;
    private javax.swing.JTextField jTextFieldFortunaJogos;
    private javax.swing.JTextField jTextFieldFortunaPropagandas;
    private javax.swing.JTextField jTextFieldPosRankMundial;
    // End of variables declaration//GEN-END:variables
}
