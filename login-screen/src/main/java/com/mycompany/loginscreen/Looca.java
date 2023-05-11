/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.loginscreen;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Nathan David
 */
public class Looca extends javax.swing.JFrame {

    private List<UserLogin> user;

    public Looca(List<UserLogin> user) throws IOException {

        this.user = user;

        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);

        localidade.setVisible(false);
        localidade2.setVisible(false);
        localidade3.setVisible(false);
        localidadeInput.setVisible(false);
        localidadeInput2.setVisible(false);
        btnConfirmar.setVisible(false);

        verificarPc();
    }

    private Looca() {
        throw new UnsupportedOperationException("Necessita de lista."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void verificarPc() throws IOException {
        Conection conexao = new Conection();
        ConectionMySql conexao2 = new ConectionMySql();
        
        JdbcTemplate con = conexao.getConnection();
        JdbcTemplate con2 = conexao2.getConnection();
          
        InfoPc infoPc = new InfoPc();

//        String numeroSerial = null;
        String so = infoPc.sistemaOperacional();
//         if (so.equalsIgnoreCase("Windows")) {
//             numeroSerial = infoPc.numeroSerial();
//         } else {
//             numeroSerial = infoPc.numeroSerialLinux();
//         }
        
//        String hostName = infoPc.hostName();
        String hostName = "TESTE SO";

        List<Computador> listaComputador = con.query("select hostname,"
                + " sistemaOperacional, status from Computador where hostname = ?;",
                new BeanPropertyRowMapper(Computador.class), hostName);
        
        List<Computador> listaComputador2 = con2.query("select hostname,"
                + " sistemaOperacional, status from Computador where hostname = ?;",
                new BeanPropertyRowMapper(Computador.class), hostName);

            Integer computadorEncontrado = listaComputador.size();
            Integer computadorEncontrado2 = listaComputador2.size();
            
        if (computadorEncontrado > 0 && computadorEncontrado2 > 0) {
            mensagemPc.setText("Computador já cadastrado");
        } else {
            mensagemPc.setText("Computador não cadastrado");
            localidade.setVisible(true);
            localidade2.setVisible(true);
            localidade3.setVisible(true);
            localidadeInput.setVisible(true);
            localidadeInput2.setVisible(true);
            btnConfirmar.setVisible(true);
        }
    }

    public void cadastrarPc(String setor, String discoTipo) throws IOException {
        Conection conexao = new Conection();
        ConectionMySql conexao2 = new ConectionMySql();
        
        JdbcTemplate con = conexao.getConnection();
        JdbcTemplate con2 = conexao2.getConnection();
        
        InfoPc infoPc = new InfoPc();
       
//        String hostName = infoPc.hostName();
        String hostName = "TESTE SO";
        String mac = infoPc.mac();

        // DESCOMENTE ESSE CÓDIGO PARA TESTAR O CÓDIGO MAIS DE UMA VEZ NA MESMA MÁQUINA, POIS ELE GERA IDS DIFERENTES
        // SE AS DUAS LINHAS ABAIXO ESTIVEREM COMENTADAS A LINHA SEGUINTE DEVE ESTAR DESCOMENTADA
//        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 10001);
//        numeroSerial = String.valueOf(numeroAleatorio);

        String so = infoPc.sistemaOperacional();
//         if (so.equalsIgnoreCase("Windows")) {
//             numeroSerial = infoPc.numeroSerial();
//         } else {
//             numeroSerial = infoPc.numeroSerialLinux();
//         }
        Double freqCpu = infoPc.frequenciaCpu();
        Double qtdRam = infoPc.qtdRam();
        Double qtdArmazenamento = infoPc.qtdArmazenamento();
        Integer tipoDisco = null;
        
        if (discoTipo.equalsIgnoreCase("ssd")) {
            tipoDisco = 4;
        } else {
            tipoDisco = 5;
        }
        
        String status = "Operando";
        String fkEmpresa = null;;

        for (UserLogin usuario : user) {
            fkEmpresa = usuario.getFkEmpresa();
        }

        List<Componente> componentes = con.query("select * from Componente;",
                new BeanPropertyRowMapper(Componente.class));
        
        List<Componente> componentes2 = con2.query("select * from Componente;",
                new BeanPropertyRowMapper(Componente.class));
        
        System.out.println(componentes);

        Boolean validarRam = false;
        Boolean validarDiscoSSD = false;
        Boolean validarDiscoHD = false;
        Boolean validarCpu = false;

        for (Componente comp : componentes) {
            if (comp.getFkTipo() == 3) {
                if (comp.getNumeroChave().equals(freqCpu)) {
                    validarCpu = true;
                }
            }

            if (comp.getFkTipo() == 2) {
                if (comp.getNumeroChave().equals(qtdRam)) {
                    validarRam = true;
                }
            }

            if (discoTipo.equalsIgnoreCase("ssd")) {
                if (comp.getFkTipo() == 4) {
                    if (comp.getNumeroChave().equals(qtdArmazenamento)) {
                        validarDiscoSSD = true;
                    }
                }
            } else {
                if (comp.getFkTipo() == 5) {
                    if (comp.getNumeroChave().equals(qtdArmazenamento)) {
                        validarDiscoHD = true;
                    }
                }
            }
            
        }

        if (validarCpu == false) {
            int linhaComponenteCpu = con.update("insert into Componente (numeroChave, unidadeMedida, fkTipo) values (?, ?, ?)",
                    freqCpu,
                    "hz",
                    3
            );
            
            int linhaComponenteCpu2 = con2.update("insert into Componente (numeroChave, unidadeMedida, fkTipo) values (?, ?, ?)",
                    freqCpu,
                    "hz",
                    3
            );
        }

        if (validarRam == false) {
            int linhaComponenteRam = con.update("insert into Componente (numeroChave, unidadeMedida, fkTipo) values (?, ?, ?)",
                    qtdRam,
                    "gb",
                    2
            );
            
            int linhaComponenteRam2 = con2.update("insert into Componente (numeroChave, unidadeMedida, fkTipo) values (?, ?, ?)",
                    qtdRam,
                    "gb",
                    2
            );
        }

        if (discoTipo.equalsIgnoreCase("ssd")) {
            if (validarDiscoSSD == false) {
                int linhaComponenteDisco = con.update("insert into Componente (numeroChave, unidadeMedida, fkTipo) values (?, ?, ?)",
                        qtdArmazenamento,
                        "gb",
                        tipoDisco
                );
                
                int linhaComponenteDisco2 = con2.update("insert into Componente (numeroChave, unidadeMedida, fkTipo) values (?, ?, ?)",
                        qtdArmazenamento,
                        "gb",
                        tipoDisco
                );
            }
        } else {
            if (validarDiscoHD == false) {
                int linhaComponenteDisco = con.update("insert into Componente (numeroChave, unidadeMedida, fkTipo) values (?, ?, ?)",
                        qtdArmazenamento,
                        "gb",
                        tipoDisco
                );
                
                int linhaComponenteDisco2 = con2.update("insert into Componente (numeroChave, unidadeMedida, fkTipo) values (?, ?, ?)",
                        qtdArmazenamento,
                        "gb",
                        tipoDisco
                );
            }
        }

        int linhaLocalizacao = con.update("insert into Localizacao (setor) values (?)",
                setor
        );
        
        int linhaLocalizacao2 = con2.update("insert into Localizacao (setor) values (?)",
                setor
        );

        List<Localizacao> loc = con.query("select idLocalizacao from Localizacao order by idLocalizacao desc",
                new BeanPropertyRowMapper(Localizacao.class));
        
        List<Localizacao> loc2 = con2.query("select idLocalizacao from Localizacao order by idLocalizacao desc",
                new BeanPropertyRowMapper(Localizacao.class));

        Integer fkLocalizacao = null;
        Integer fkLocalizacao2 = null;

        for (Localizacao localidade : loc) {
            fkLocalizacao = localidade.getIdLocalizacao();
        }
        
        for (Localizacao localidade : loc2) {
            fkLocalizacao2 = localidade.getIdLocalizacao();
        }

        int linhasInseridas = con.update("insert into Computador values (?, ?, ?, ?, ?, ?)",
                hostName,
                status,
                so,
                mac,
                fkLocalizacao,
                fkEmpresa
        );
        
        int linhasInseridas2 = con2.update("insert into Computador values (?, ?, ?, ?, ?, ?)",
                hostName,
                status,
                so,
                mac,
                fkLocalizacao2,
                fkEmpresa
        );

        localidade.setVisible(false);
        localidade2.setVisible(false);
        localidade3.setVisible(false);
        localidadeInput.setVisible(false);
        localidadeInput2.setVisible(false);
        btnConfirmar.setVisible(false);
        mensagemPc.setText("Computador cadastrado!");
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        mensagemPc = new javax.swing.JLabel();
        localidade = new javax.swing.JLabel();
        localidade3 = new javax.swing.JLabel();
        localidade2 = new javax.swing.JLabel();
        localidadeInput = new javax.swing.JTextField();
        localidadeInput2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(25, 118, 211));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Monitor Mind");

        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        mensagemPc.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        mensagemPc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensagemPc.setText("Identificando Máquina");

        localidade.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        localidade.setText("Informe sobre sua máquina:");

        localidade3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        localidade3.setText("Tipo disco:");

        localidade2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        localidade2.setText("Setor:");

        localidadeInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        localidadeInput2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mensagemPc, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(localidadeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(localidadeInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(localidade2)
                        .addGap(164, 164, 164)
                        .addComponent(localidade3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnConfirmar)
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(localidade)
                        .addGap(168, 168, 168))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(mensagemPc)
                .addGap(87, 87, 87)
                .addComponent(localidade)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(localidade2)
                    .addComponent(localidade3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(localidadeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(localidadeInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(btnConfirmar)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 582, 522));

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 522));

        jPanel4.setBackground(new java.awt.Color(25, 118, 211));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 84, 522));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        String setor = localidadeInput.getText();
        String tipoDisco = localidadeInput2.getText();

        if (setor.equals("") || !tipoDisco.equals("ssd") && !tipoDisco.equals("hd")) {
            JOptionPane.showMessageDialog(this, "Você tem campos a serem preenchidos");
        } else {
            try {
                cadastrarPc(setor, tipoDisco);
            } catch (IOException ex) {
                Logger.getLogger(Looca.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Looca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel localidade;
    private javax.swing.JLabel localidade2;
    private javax.swing.JLabel localidade3;
    private javax.swing.JTextField localidadeInput;
    private javax.swing.JTextField localidadeInput2;
    private javax.swing.JLabel mensagemPc;
    // End of variables declaration//GEN-END:variables

}
