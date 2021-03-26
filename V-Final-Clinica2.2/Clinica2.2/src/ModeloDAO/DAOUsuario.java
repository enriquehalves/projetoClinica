 
package ModeloDAO;

import Modelo.ModeloMedico;
import Modelo.ModeloUsuario;
import ModeloConexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

 
public class DAOUsuario {
    
     //instacia da classe conexaoBD do pacote modelo conexao
    ConexaoBD conex = new ConexaoBD();
    //instancia da classe modelo medico do pacote modelo
    ModeloUsuario mod = new ModeloUsuario();
    
    //metodo responsavel por salvar os dados do medico no banco
    public void Salvar( ModeloUsuario mod){
        //abre conexao com banco de dados
        conex.Conexao();
        try {
            //preparedStatement e a variavel responsavel por receber a conexao com banco de dados
              PreparedStatement pst = conex.con.prepareStatement("insert into usuarios(nome,tipo,senha) values (?,?,?)");
              //inserindo nome do medico no banco
              pst.setString(1, mod.getNome());
              //inserindo especialidade 
              pst.setString(2, mod.getTipo());
              //inserindo crm
              pst.setString(3, mod.getSenha());
              //responsavel por executar o preparedStatement
              pst.execute();
              //mostra uma mensagem se tudo ocorreu bem
            //  JOptionPane.showMessageDialog(null, "inserido com sucesso");
        } catch (Exception e) {
            //mostra uma mensagem de algo deu errado 
          //  JOptionPane.showMessageDialog(null, "erro ao inserir\n"+e );
        }
      
        //fecha conexao com banco
        conex.Desconecta();
    }
    //metodo que busca medico no banco
    public ModeloUsuario buscaUsuario( ModeloUsuario mod){
        //abre conexao
        conex.Conexao();
        //chama o metodo executaSql da classe conexao 
        conex.ExecutaSql("select *from usuarios where nome like'%"+mod.getPesquisa()+"%'");
        try {
            //filtra o primeiro resultado do banco de dados
            conex.rs.first();
            //seta na classe medico o valor do atributo codigo no banco de dados
            mod.setCodigo(conex.rs.getInt("codigo"));
            //seta na classe medico o valor do atributo nome no banco
            mod.setNome(conex.rs.getString("nome"));
            //seta a especialidade do atributo especialidade no banco
            mod.setTipo(conex.rs.getString("tipo"));
            //seta crm do atributo crm no banco
            mod.setSenha(conex.rs.getString("senha"));
            
        } catch (SQLException ex) {
            //mostra mensagem se tudo ocorreu bem
          // JOptionPane.showMessageDialog(null, "medico nao cadastrado");
        }
        //fecha conexao
        conex.Desconecta();
        //retorn mod medico conforme parametro do metodo
        return mod;
    }
    
    //metodo que edita informacoes 
    public void Editar( ModeloUsuario mod){
        //abre conexao
        conex.Conexao();
        try{
            //preparedstatement recebe a conexao 
        PreparedStatement pst = conex.con.prepareStatement("update usuarios set nome=?,tipo=?,senha=? where codigo=?" );
        //seta o nome do medico no banco de dados
        pst.setString(1, mod.getNome());
        //seta a especialidade no banco de dados
        pst.setString(2, mod.getTipo());
        //seta crm no banco de dados
        pst.setString(3, mod.getSenha());
        //seta codigo do medico no banco de dados
        pst.setInt(4, mod.getCodigo());
        //executa preparedstatement
        pst.execute();
        //mostra mensagem se tudo ocorreu bem
       // JOptionPane.showMessageDialog(null, "alterado com sucesso");
        }catch(Exception e){
            //mostra mensagem se algo deu errado
         //   JOptionPane.showMessageDialog(null, "erro ao altera medico");
        }
        //fecha conexao
        conex.Desconecta();
    }
    
    //metodo que exclui
    public void Excluir( ModeloUsuario mod){
        //abre conexao 
        conex.Conexao();
        try{
            //preparedstatement recebe conexao
        PreparedStatement pst = conex.con.prepareStatement("delete from usuarios where codigo=?");
        //seta no banco de dados codigo do medico a ser excluido
        pst.setInt(1, mod.getCodigo());
        //executa preparedstatement
        pst.execute();
        //mostra mensagem se tudo ocorreu bem
        //JOptionPane.showMessageDialog(null, "escluido com sucesso");
        }catch(Exception e){
            //mostra mensagem se algo deu errado
         //   JOptionPane.showMessageDialog(null, "erro ao excluir");
        }
        //fecha conexao com bancos
        conex.Desconecta();
    }
    
}
