
/*classe responsavel pela conexao com banco de dados*/
package ModeloConexao;

import java.sql.*;
 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

 
public class ConexaoBD {
   // atributos para realizar a conexao 
   public Statement stm; //variavel que recebe a conexao com banco de dados
   public ResultSet rs; // variavel que armazena os dados recebidos pelo preparedstatement
   private String driver = "com.mysql.jdbc.Driver";//driver do mysql
   private String caminho = "jdbc:mysql://localhost:3306/clinica";//caminho da tabela no localhost
   private String usuario = "root";//usuario padrao do mysql
   private String senha = "";//senha e vazia por padrao no mysql
   public Connection con;//variavel que estabelece conexao com banco
   
   //metodo que abre conexao 
   public void Conexao(){
       try {
           //seta a propriedade do driver do mysql
           Class.forName(driver);
           //con recebe conexao 
           con=DriverManager.getConnection(caminho,usuario,senha);
         //  JOptionPane.showMessageDialog(null, "conectado");
       }catch(Exception e){
           //mostra mensagem se conectou com banco
           JOptionPane.showMessageDialog(null, "erro ao conectar");
       }
   }
   //metodo responsavel por fazer insert update, exclusao e select no banco
   public void ExecutaSql(String Sql){
       try {
           //preparedstatement cria statement e permite pesquisar dados de cima para baixo quanto de baixo para cima
             stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
             //executa variavel esql
             rs = stm.executeQuery(Sql);
       } catch (Exception e) {
           //mostra mensagem se tudo ocorreu bem
           JOptionPane.showMessageDialog(null, "erro ao executar sql");
       }
    
   
   }
   //desconecta o banco
   public void Desconecta(){
       try {
           //fecha conexao
           con.close();
         //  JOptionPane.showMessageDialog(null, "desconectado");
       } catch (Exception e) {
           //mostra mensagem se a conexao no foi fechada
           JOptionPane.showMessageDialog(null, "erro ao conecatar");
       }
   }
    
   
}
