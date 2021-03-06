/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.ModeloMedico;
import Modelo.ModeloTabela;
import Modelo.ModeloUsuario;
import ModeloConexao.ConexaoBD;
import ModeloDAO.DAOUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Henrique
 */
public class FormularioUsuario extends javax.swing.JFrame {

    ConexaoBD conex = new ConexaoBD();
    ModeloUsuario mod = new ModeloUsuario();
    DAOUsuario control = new DAOUsuario();
    int flag =1;
    /**
     * Creates new form FormularioUsuario
     */
    public FormularioUsuario() {
        initComponents();
        btn_excluiruser.setEnabled(false);
        btn_salvaruser.setEnabled(false);
        alteraruser.setEnabled(false);
       
         preencherTabela("select *from usuarios order by nome");//atualiza tabela
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nomeusuario = new javax.swing.JTextField();
        usuariosenha = new javax.swing.JPasswordField();
        senhaconfirmar = new javax.swing.JPasswordField();
        usuariotipo = new javax.swing.JComboBox<>();
        btn_novouser = new javax.swing.JButton();
        btn_salvaruser = new javax.swing.JButton();
        alteraruser = new javax.swing.JButton();
        btn_excluiruser = new javax.swing.JButton();
        pesquisauser = new javax.swing.JTextField();
        btn_pesquisauser = new javax.swing.JButton();
        btn_cancelaruser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelausuario = new javax.swing.JTable();
        btn_voltarusuario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        iduser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel3.setText("Usuario");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 50, 70, 14);

        jLabel4.setText("Senha");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(140, 90, 60, 14);

        jLabel5.setText("Confirmar Senha");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(360, 90, 110, 14);

        jLabel6.setText("Tipo");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(470, 40, 40, 14);

        nomeusuario.setEnabled(false);
        jPanel1.add(nomeusuario);
        nomeusuario.setBounds(180, 50, 270, 30);

        usuariosenha.setEnabled(false);
        jPanel1.add(usuariosenha);
        usuariosenha.setBounds(180, 90, 160, 30);

        senhaconfirmar.setEnabled(false);
        jPanel1.add(senhaconfirmar);
        senhaconfirmar.setBounds(460, 90, 160, 30);

        usuariotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "m??dico", "recepcionista" }));
        usuariotipo.setEnabled(false);
        jPanel1.add(usuariotipo);
        usuariotipo.setBounds(500, 40, 120, 20);

        btn_novouser.setText("Novo");
        btn_novouser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novouserActionPerformed(evt);
            }
        });
        jPanel1.add(btn_novouser);
        btn_novouser.setBounds(20, 40, 90, 23);

        btn_salvaruser.setText("Salvar");
        btn_salvaruser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvaruserActionPerformed(evt);
            }
        });
        jPanel1.add(btn_salvaruser);
        btn_salvaruser.setBounds(20, 70, 90, 23);

        alteraruser.setText("Alterar");
        alteraruser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alteraruserActionPerformed(evt);
            }
        });
        jPanel1.add(alteraruser);
        alteraruser.setBounds(20, 100, 90, 23);

        btn_excluiruser.setText("Excluir");
        btn_excluiruser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluiruserActionPerformed(evt);
            }
        });
        jPanel1.add(btn_excluiruser);
        btn_excluiruser.setBounds(20, 130, 90, 23);
        jPanel1.add(pesquisauser);
        pesquisauser.setBounds(160, 160, 320, 30);

        btn_pesquisauser.setText("Pesquisar");
        btn_pesquisauser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisauserActionPerformed(evt);
            }
        });
        jPanel1.add(btn_pesquisauser);
        btn_pesquisauser.setBounds(490, 160, 120, 30);

        btn_cancelaruser.setText("Cancelar");
        btn_cancelaruser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelaruserActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelaruser);
        btn_cancelaruser.setBounds(20, 160, 90, 23);

        tabelausuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelausuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelausuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelausuario);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(160, 200, 452, 160);

        btn_voltarusuario.setText("Voltar");
        btn_voltarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarusuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btn_voltarusuario);
        btn_voltarusuario.setBounds(20, 230, 90, 23);

        jLabel2.setText("ID");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 10, 50, 14);

        iduser.setEnabled(false);
        jPanel1.add(iduser);
        iduser.setBounds(180, 10, 80, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 30, 690, 380);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Usu??rio");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 10, 170, 14);

        setSize(new java.awt.Dimension(729, 461));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarusuarioActionPerformed
       
       dispose();
    }//GEN-LAST:event_btn_voltarusuarioActionPerformed

    private void btn_novouserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novouserActionPerformed
       
        nomeusuario.setEnabled(true);
        senhaconfirmar.setEnabled(true);
        usuariosenha.setEnabled(true);
        usuariotipo.setEnabled(true);
        btn_salvaruser.setEnabled(true);
        nomeusuario.setText("");
        senhaconfirmar.setText("");
        usuariosenha.setText("");
        iduser.setText("");
        btn_excluiruser.setEnabled(false);
       
        
        
    }//GEN-LAST:event_btn_novouserActionPerformed

    private void btn_salvaruserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvaruserActionPerformed
       
               //se campo nome estiver vazio
        if(nomeusuario.getText().isEmpty()){
            //pede pra inserir nome
            JOptionPane.showMessageDialog(null, "preencher o nome para continuar");
            //deixa o cursor piscando no campo nome
            nomeusuario.requestFocus();
          //se crm vazio
        }else if(usuariosenha.getText().isEmpty()){
            //preencher crm
            JOptionPane.showMessageDialog(null, "preencher o CRM para continuar");
            //deixa cursor piscando
            usuariosenha.requestFocus();
        }else
        //se flag == 1
        if(flag == 1){
            //seta na classe medico o que estiver escrito no campo nome do medico no frame
        mod.setNome(nomeusuario.getText());
        //seta na classe medico o que esta selecionado na caixa de compinacao
        mod.setTipo(String.valueOf(usuariotipo.getSelectedItem()));
        //seta na classe medico o que esta escrito no crm 
        mod.setSenha(usuariosenha.getText());
        //metodo salvar 
        control.Salvar(mod);
        nomeusuario.setText("");//limpa o campo
        usuariosenha.setText("");  //limpa o campo
        senhaconfirmar.setText(""); // limpa o campo
        nomeusuario.setEnabled(false);//desabilita o campo nome do medico 
        senhaconfirmar.setEnabled(false);//desbilita crm
        usuariosenha.setEnabled(false);
        
        usuariotipo.setEnabled(false);//desabilita especialidade
        btn_salvaruser.setEnabled(false);
         preencherTabela("select *from usuarios order by nome");//atualiza tabela
        }else{
        mod.setCodigo(Integer.parseInt(iduser.getText()));
        mod.setNome(nomeusuario.getText());
        //seta na classe medico o que esta selecionado na caixa de compinacao
        mod.setTipo(String.valueOf(usuariotipo.getSelectedItem()));
        //seta na classe medico o que esta escrito no crm 
        mod.setSenha(usuariosenha.getText());
        //metodo salvar 
        control.Editar(mod);
           nomeusuario.setText("");//limpa o campo
        usuariosenha.setText("");  //limpa o campo
        senhaconfirmar.setText(""); // limpa o campo
        nomeusuario.setEnabled(false);//desabilita o campo nome do medico 
        senhaconfirmar.setEnabled(false);//desbilita crm
        usuariosenha.setEnabled(false);
        
        usuariotipo.setEnabled(false);//desabilita especialidade
        btn_salvaruser.setEnabled(false);
         preencherTabela("select *from usuarios order by nome");//atualiza tabela
        }
    }//GEN-LAST:event_btn_salvaruserActionPerformed

    private void alteraruserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alteraruserActionPerformed
       flag=2;
       
        nomeusuario.setEnabled(true);
        senhaconfirmar.setEnabled(true);
        usuariosenha.setEnabled(true);
        usuariotipo.setEnabled(true);
        btn_salvaruser.setEnabled(true);
        usuariosenha.setText("");
    }//GEN-LAST:event_alteraruserActionPerformed

    private void btn_pesquisauserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisauserActionPerformed
        mod.setPesquisa(pesquisauser.getText());//seta na classe medico o que eta escrito no campo pesquisa 
        ModeloUsuario model = control.buscaUsuario(mod);//modelo medico recebe metodo busca medico
        nomeusuario.setText(model.getNome());//campo nome seta o que esta na variavel nome da classe modelo
        usuariosenha.setText(String.valueOf(model.getSenha()));//seta crm tranformando em string o inteiro que esta no crm da classe modelo
        iduser.setText(String.valueOf(model.getCodigo()));//seta codigo que esta na classe codigo
        usuariotipo.setSelectedItem(model.getTipo());//seta especialidade que esta na classe modelo
        alteraruser.setEnabled(true);//desabilita botao editar
        btn_excluiruser.setEnabled(true);//desabilita bota excluir
    }//GEN-LAST:event_btn_pesquisauserActionPerformed

    private void btn_excluiruserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluiruserActionPerformed
           int resposta = 0;//resposta
        resposta = JOptionPane.showConfirmDialog(null, "deseja realmente excluir?");//se resposta for sim
        if(resposta == JOptionPane.YES_OPTION ){
            mod.setCodigo(Integer.parseInt(iduser.getText()));//seta codigo na classe modelomedico
            control.Excluir(mod);//metodo excluir medico
            
            senhaconfirmar.setText("");//limpa 
            nomeusuario.setText("");//limpa
            usuariotipo.setEnabled(false);//desbilita
            iduser.setText("");//limpa
            usuariosenha.setText("");//limpa
            pesquisauser.setText("");//limpa
             preencherTabela("select *from usuarios order by nome");//atualiza tabela
        }
    }//GEN-LAST:event_btn_excluiruserActionPerformed

    private void tabelausuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelausuarioMouseClicked
        
        //quando clica em um nome da tabela 
        String nome_usuario = ""+tabelausuario.getValueAt(tabelausuario.getSelectedRow(),1);//
      
        //abre conexao
      conex.Conexao();
      //executa select com o nome selecionado na tabela
      conex.ExecutaSql("select *from usuarios where nome='"+nome_usuario+"'");
      try{
          //filtra o primeiro resultado
      conex.rs.first();
      //seta no campo idmedico o valor do atributo codigo no banco de dados
      iduser.setText(String.valueOf(conex.rs.getInt("codigo")));
      //seta no campo nome valor do atributo nome no banco de dados
      nomeusuario.setText(conex.rs.getString("nome"));
      //seta especialidade do atributo especialidade do banco de dados
      usuariotipo.setSelectedItem(conex.rs.getString("tipo"));
      //seta crm transformando em string o inteiro do atributo crm no banco de dados
      usuariosenha.setText(String.valueOf(conex.rs.getInt("senha")));
      }catch(Exception e){
          //mostra mensafem se algo nao funcionou
          JOptionPane.showMessageDialog(null, "erro no evento mouseclicked");
      }
      //desconecta
      conex.Desconecta();
      alteraruser.setEnabled(true);//habilita bota
      btn_excluiruser.setEnabled(true);//habilita botao
    }//GEN-LAST:event_tabelausuarioMouseClicked

    private void btn_cancelaruserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelaruserActionPerformed
       btn_excluiruser.setEnabled(false);
       btn_novouser.setEnabled(true);
       btn_salvaruser.setEnabled(false);
       alteraruser.setEnabled(false);
       nomeusuario.setText("");
       senhaconfirmar.setText("");
       usuariosenha.setText("");
       nomeusuario.setEnabled(false);
       usuariosenha.setEnabled(false);
       usuariotipo.setEnabled(false);
       senhaconfirmar.setEnabled(false);
       iduser.setText("");
    }//GEN-LAST:event_btn_cancelaruserActionPerformed

    
     public void preencherTabela(String Sql){
        
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID","Nome","Tipo"};//titulos das coluna da tabela
        //abre conexao
        conex.Conexao();
        //executa busca no banco
        conex.ExecutaSql(Sql);
        
        try{
            //filtra primeiro resultado
            conex.rs.first();
            do{
                //insere no arraylist o que esta no atributo codigo nome ... no banco de dados
                dados.add(new Object[]{conex.rs.getInt("codigo"),conex.rs.getString("nome"),conex.rs.getString("tipo")});
               //enquanto tiver registro na tabela do banco
            }while(conex.rs.next());
        }catch(Exception e){
            //se algo deu errdo
            JOptionPane.showMessageDialog(null, "busque novamente");
        }
        //instancia tablea com os dados e coluna como parametro
        ModeloTabela modelotabela = new ModeloTabela(dados, colunas);
        //seta o modelo tabela
        tabelausuario.setModel(modelotabela);
        
        //dimensiona tamanho da coluna 0
        tabelausuario.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabelausuario.getColumnModel().getColumn(0).setResizable(false);//nao permite redimensionamento
        
        tabelausuario.getColumnModel().getColumn(1).setPreferredWidth(230);  //dimensiona tamanho da coluna 1
        tabelausuario.getColumnModel().getColumn(1).setResizable(false);//nao permite redimensionamento
        
        tabelausuario.getColumnModel().getColumn(2).setPreferredWidth(140);  //dimensiona tamanho da coluna 2
        tabelausuario.getColumnModel().getColumn(2).setResizable(false);//nao permite redimensionamento
        
        //tabelausuario.getColumnModel().getColumn(3).setPreferredWidth(80);  //dimensiona tamanho da coluna 3
        //tabelausuario.getColumnModel().getColumn(3).setResizable(false);//nao permite redimensionamento
       
        tabelausuario.getTableHeader().setReorderingAllowed(false);//nao permite reordenar a tabela
        tabelausuario.setAutoResizeMode(tabelausuario.AUTO_RESIZE_OFF);//nao permite redimensionar a tabela
        
        tabelausuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//so permite que um nome seja selecionado 
             //fecha conexao   
        conex.Desconecta();
    
    
    
    
    }
    
    
    
    
    public static void main(String[] args){
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
            java.util.logging.Logger.getLogger(FormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alteraruser;
    private javax.swing.JButton btn_cancelaruser;
    private javax.swing.JButton btn_excluiruser;
    private javax.swing.JButton btn_novouser;
    private javax.swing.JButton btn_pesquisauser;
    private javax.swing.JButton btn_salvaruser;
    private javax.swing.JButton btn_voltarusuario;
    private javax.swing.JTextField iduser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeusuario;
    private javax.swing.JTextField pesquisauser;
    private javax.swing.JPasswordField senhaconfirmar;
    private javax.swing.JTable tabelausuario;
    private javax.swing.JPasswordField usuariosenha;
    private javax.swing.JComboBox<String> usuariotipo;
    // End of variables declaration//GEN-END:variables
}
