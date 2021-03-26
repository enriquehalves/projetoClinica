/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import ModeloConexao.ConexaoBD;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class TelaLogin extends javax.swing.JFrame {

    ConexaoBD conexao = new ConexaoBD();
    /**
     * Creates new form TelaPrincipal
     */
    public TelaLogin() {
        initComponents();
        conexao.Conexao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_entrar = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        loginusuarionome = new javax.swing.JTextField();
        loginusuariosenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clinica");
        setResizable(false);
        getContentPane().setLayout(null);

        btn_entrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_entrar.setForeground(new java.awt.Color(102, 102, 102));
        btn_entrar.setText("Entrar");
        btn_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_entrar);
        btn_entrar.setBounds(230, 200, 90, 23);

        btn_sair.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sair);
        btn_sair.setBounds(440, 290, 80, 30);
        getContentPane().add(loginusuarionome);
        loginusuarionome.setBounds(190, 120, 180, 30);
        getContentPane().add(loginusuariosenha);
        loginusuariosenha.setBounds(190, 160, 180, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuário");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 120, 60, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 160, 50, 17);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagensclin/fundo4.jpg"))); // NOI18N
        jLabel3.setEnabled(false);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 560, 330);

        setSize(new java.awt.Dimension(550, 363));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrarActionPerformed
      /*
        //pega texto do campo nome e compara com a string admin o mesmo ocorre com a senha se for igual deixa entrar 
        if(loginusuarionome.getText().equalsIgnoreCase("admin")&& loginusuariosenha.getText().equalsIgnoreCase("admin")){
            //instancia a tela principal
            TelaPrincipal tela = new TelaPrincipal();
            //torna tela principa visivel
        tela.setVisible(true);
        //fecha a tela atual
        dispose();
       }else{
            //mostra mensagem se tudo ocorreu bem
           JOptionPane.showMessageDialog(null, "usuario ou senha inválidos");
       }*/
      
      
        try {
            conexao.ExecutaSql("select *from usuarios where nome='"+loginusuarionome.getText()+"'");
            conexao.rs.first();
            if(conexao.rs.getString("senha").equals(loginusuariosenha.getText())){
                TelaPrincipal tela = new TelaPrincipal(loginusuarionome.getText());
                tela.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "usuario ou senha invalidos");
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "usuario ou senha invalidos "+e);
        }
      
      
    }//GEN-LAST:event_btn_entrarActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        //fecha a aplicacao
        System.exit(0);
    }//GEN-LAST:event_btn_sairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField loginusuarionome;
    private javax.swing.JPasswordField loginusuariosenha;
    // End of variables declaration//GEN-END:variables
}