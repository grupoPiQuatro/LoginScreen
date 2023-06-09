package app;
import sql.Conection;
import models.UserLogin;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author MonitotMind
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public Login() {
        initComponents();
        iptLogin.setBackground(new java.awt.Color(0,0,0,1));
        iptSenha.setBackground(new java.awt.Color(0,0,0,1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelImg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        iptLogin = new javax.swing.JTextField();
        iptSenha = new javax.swing.JPasswordField();
        jLabelXButton = new javax.swing.JLabel();
        jLabelLoginTitle = new javax.swing.JLabel();
        jLabelSubtitle = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelUserIcon = new javax.swing.JLabel();
        jLabelPasswordIconHide = new javax.swing.JLabel();
        jLabelPasswordIconShow = new javax.swing.JLabel();
        jLabelUserLine = new javax.swing.JLabel();
        jLabelPasswordLine = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textAlert = new javax.swing.JTextField();
        iptSenha1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/login.png"))); // NOI18N
        jPanel1.add(jLabelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 500, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 440));

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iptLogin.setBackground(new java.awt.Color(25, 118, 211));
        iptLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        iptLogin.setForeground(new java.awt.Color(255, 255, 255));
        iptLogin.setBorder(null);
        iptLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iptLoginActionPerformed(evt);
            }
        });
        jPanel2.add(iptLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 260, -1));

        iptSenha.setBackground(new java.awt.Color(25, 118, 211));
        iptSenha.setForeground(new java.awt.Color(255, 255, 255));
        iptSenha.setBorder(null);
        iptSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });
        jPanel2.add(iptSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 260, 20));

        jLabelXButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelXButton.setForeground(new java.awt.Color(255, 255, 255));
        jLabelXButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelXButton.setText("X");
        jLabelXButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelXButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelXButtonMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelXButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 4, 34, -1));

        jLabelLoginTitle.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabelLoginTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoginTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoginTitle.setText("Login");
        jPanel2.add(jLabelLoginTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 39, 423, 56));

        jLabelSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSubtitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSubtitle.setText("Olá, vamos iniciar!");
        jPanel2.add(jLabelSubtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 101, 423, -1));

        jLabelUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUser.setText("Usuário");
        jPanel2.add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabelPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setText("Senha");
        jPanel2.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabelUserIcon.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUserIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_user_20px_1.png"))); // NOI18N
        jPanel2.add(jLabelUserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 40, 35));

        jLabelPasswordIconHide.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPasswordIconHide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPasswordIconHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_invisible_20px_1.png"))); // NOI18N
        jLabelPasswordIconHide.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelPasswordIconHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPasswordIconHideMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelPasswordIconHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 40, 35));

        jLabelPasswordIconShow.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPasswordIconShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPasswordIconShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_eye_20px_1.png"))); // NOI18N
        jLabelPasswordIconShow.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelPasswordIconShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPasswordIconShowMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelPasswordIconShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 40, 35));

        jLabelUserLine.setBackground(new java.awt.Color(25, 118, 211));
        jLabelUserLine.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUserLine.setText("__________________________________");
        jPanel2.add(jLabelUserLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 260, -1));

        jLabelPasswordLine.setBackground(new java.awt.Color(25, 118, 211));
        jLabelPasswordLine.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPasswordLine.setText("__________________________________");
        jPanel2.add(jLabelPasswordLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 260, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 118, 211));
        jButton1.setText("LOGIN");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 118, 211), 2, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 220, 40));

        textAlert.setBackground(new java.awt.Color(25, 118, 211));
        textAlert.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textAlert.setForeground(new java.awt.Color(255, 255, 255));
        textAlert.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textAlert.setBorder(null);
        textAlert.setCaretColor(new java.awt.Color(25, 118, 211));
        textAlert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAlertActionPerformed(evt);
            }
        });
        jPanel2.add(textAlert, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 200, 30));

        iptSenha1.setBackground(new java.awt.Color(25, 118, 211));
        iptSenha1.setForeground(new java.awt.Color(255, 255, 255));
        iptSenha1.setBorder(null);
        iptSenha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iptSenha1ActionPerformed(evt);
            }
        });
        jPanel2.add(iptSenha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 260, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 420, 440));

        setSize(new java.awt.Dimension(916, 438));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelXButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelXButtonMouseClicked

    private void jLabelPasswordIconHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPasswordIconHideMouseClicked
        iptSenha.setEchoChar((char)0);
        jLabelPasswordIconHide.setVisible(false);
        jLabelPasswordIconHide.setEnabled(false);
        jLabelPasswordIconShow.setEnabled(true);
        jLabelPasswordIconShow.setEnabled(true);
    }//GEN-LAST:event_jLabelPasswordIconHideMouseClicked

    private void jLabelPasswordIconShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPasswordIconShowMouseClicked
        iptSenha.setEchoChar((char)8226);
        jLabelPasswordIconHide.setVisible(true);
        jLabelPasswordIconHide.setEnabled(true);
        jLabelPasswordIconShow.setEnabled(false);
        jLabelPasswordIconShow.setEnabled(false);
    }//GEN-LAST:event_jLabelPasswordIconShowMouseClicked

    private void iptLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iptLoginActionPerformed

        
    }//GEN-LAST:event_iptLoginActionPerformed

    private void textAlertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAlertActionPerformed

    }//GEN-LAST:event_textAlertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Boolean verify = verificaCampos();
        
        if (verify){
            try {
                consultaBanco();
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Email ou senha vazios");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private Boolean verificaCampos(){
        String login = iptLogin.getText();
        String senha = iptSenha.getText();
        
        if ("".equals(login) || "".equals(senha)){
            JOptionPane.showMessageDialog(this, "Você tem campos a serem preenchidos");
            return false;
        }
        return true;
    }
    
    
    
    private void consultaBanco() throws IOException{
        String login = iptLogin.getText();
        String senha = iptSenha.getText();
        
        Conection conect = new Conection();
        
        JdbcTemplate con = conect.getConnection();
        
        List<UserLogin> user = new ArrayList();
        
        user = con.query(String.format("select * from Usuario where email = '%s' and senha = '%s'", login, senha ), 
                new BeanPropertyRowMapper(UserLogin.class));
        Integer sizeUser = user.size();
        
        if (sizeUser > 0) {
            LogGenerator.generateLog("Usuario logado");
            LogGenerator.generateLog("Entrando com o login " + login);
//            textAlert.setText("Usuário encontrado");
            Looca looca = new Looca(user);
           
            this.setVisible(false);
            looca.setVisible(true);
           
        }else{
//            textAlert.setText("Usuario não encontrado");
            JOptionPane.showMessageDialog(this, "Email ou senha incorreto!");
        }
    }
    
    
    
    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void iptSenha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iptSenha1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iptSenha1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField iptLogin;
    private javax.swing.JPasswordField iptSenha;
    private javax.swing.JPasswordField iptSenha1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelLoginTitle;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPasswordIconHide;
    private javax.swing.JLabel jLabelPasswordIconShow;
    private javax.swing.JLabel jLabelPasswordLine;
    private javax.swing.JLabel jLabelSubtitle;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLabel jLabelUserIcon;
    private javax.swing.JLabel jLabelUserLine;
    private javax.swing.JLabel jLabelXButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField textAlert;
    // End of variables declaration//GEN-END:variables
}
