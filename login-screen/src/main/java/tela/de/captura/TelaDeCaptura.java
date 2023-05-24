/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tela.de.captura;

import app.InserirMetrica;
import app.LogGenerator;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Rainha Katarine I
 */
public class TelaDeCaptura extends javax.swing.JFrame {

    /**
     * Creates new form TelaDeCaptura
     */
    public TelaDeCaptura() {
        initComponents();
        setLocation(950, 500);
        
        exibirDados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new javax.swing.JPanel();
        jPanelDataScreen = new javax.swing.JPanel();
        jLabelTextData = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelXbutton = new javax.swing.JLabel();
        jLabelMinimazingButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBackground.setBackground(new java.awt.Color(25, 118, 211));

        jPanelDataScreen.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTextData.setBackground(new java.awt.Color(0, 0, 0));
        jLabelTextData.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabelTextData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelDataScreenLayout = new javax.swing.GroupLayout(jPanelDataScreen);
        jPanelDataScreen.setLayout(jPanelDataScreenLayout);
        jPanelDataScreenLayout.setHorizontalGroup(
            jPanelDataScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTextData, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelDataScreenLayout.setVerticalGroup(
            jPanelDataScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTextData, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("Captura de Dados em Andamento");

        jLabelXbutton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabelXbutton.setForeground(new java.awt.Color(255, 255, 255));
        jLabelXbutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelXbutton.setText("X");
        jLabelXbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelXbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelXbuttonMouseClicked(evt);
            }
        });

        jLabelMinimazingButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelMinimazingButton.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinimazingButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinimazingButton.setText("-");
        jLabelMinimazingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimazingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimazingButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelBackgroundLayout = new javax.swing.GroupLayout(jPanelBackground);
        jPanelBackground.setLayout(jPanelBackgroundLayout);
        jPanelBackgroundLayout.setHorizontalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanelDataScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabelTitle)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelMinimazingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelXbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelBackgroundLayout.setVerticalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelXbutton)
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabelMinimazingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDataScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelXbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXbuttonMouseClicked
        try {
            LogGenerator.generateLog("Usuário deslogado.");
            LogGenerator.generateLog("Encerrando captura de dados.");
        } catch (IOException ex) {
            Logger.getLogger(TelaDeCaptura.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_jLabelXbuttonMouseClicked

    private void jLabelMinimazingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimazingButtonMouseClicked
        // TODO add your handling code here:
        Window window = SwingUtilities.getWindowAncestor((Component) evt.getSource());

        // Minimiza a janela
        if (window instanceof Frame) {
            Frame frame = (Frame) window;
            frame.setExtendedState(Frame.ICONIFIED);
        }
    }//GEN-LAST:event_jLabelMinimazingButtonMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaDeCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeCaptura().setVisible(true);
            }
        });
    }
    public void exibirDados(){
        try {
            LogGenerator.generateLog("Enviando dados...");
        } catch (IOException ex) {
            Logger.getLogger(TelaDeCaptura.class.getName()).log(Level.SEVERE, null, ex);
        }
        InserirMetrica im = new InserirMetrica();
        
       
        new Timer().scheduleAtFixedRate(new TimerTask() {

            public void run() {
                String insercao = im.inserirMetrica();;
                jLabelTextData.setText(insercao);
                
            }
        }, 0, 10000);
        
         new Timer().scheduleAtFixedRate(new TimerTask() {

            public void run() {
                jLabelTextData.setText("outro tempo");
                
            }
        }, 0, 120000);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelMinimazingButton;
    private javax.swing.JLabel jLabelTextData;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelXbutton;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelDataScreen;
    // End of variables declaration//GEN-END:variables
}
