/*classe que insere altera e exclui dados do medico do banco*/ 
package ModeloDAO;

import ModeloConexao.ConexaoBD;
import Modelo.ModeloMedico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

 
public class DAOMedico {
    
    //instacia da classe conexaoBD do pacote modelo conexao
    ConexaoBD conex = new ConexaoBD();
    //instancia da classe modelo medico do pacote modelo
    ModeloMedico mod = new ModeloMedico();
    
    //metodo responsavel por salvar os dados do medico no banco
    public void Salvar(ModeloMedico mod){
        //abre conexao com banco de dados
        conex.Conexao();
        try {
            //preparedStatement e a variavel responsavel por receber a conexao com banco de dados
              PreparedStatement pst = conex.con.prepareStatement("insert into medicos(nomemed,especialidade,crm) values (?,?,?)");
              //inserindo nome do medico no banco
              pst.setString(1, mod.getNome());
              //inserindo especialidade 
              pst.setString(2, mod.getEspecialidade());
              //inserindo crm
              pst.setInt(3, mod.getCrm());
              //responsavel por executar o preparedStatement
              pst.execute();
              //mostra uma mensagem se tudo ocorreu bem
              JOptionPane.showMessageDialog(null, "inserido com sucesso");
        } catch (Exception e) {
            //mostra uma mensagem de algo deu errado 
            JOptionPane.showMessageDialog(null, "erro ao inserir\n"+e );
        }
      
        //fecha conexao com banco
        conex.Desconecta();
    }
    //metodo que busca medico no banco
    public ModeloMedico buscaMedico(ModeloMedico mod){
        //abre conexao
        conex.Conexao();
        //chama o metodo executaSql da classe conexao 
        conex.ExecutaSql("select *from medicos where nomemed like'%"+mod.getPesquisa()+"%'");
        try {
            //filtra o primeiro resultado do banco de dados
            conex.rs.first();
            //seta na classe medico o valor do atributo codigo no banco de dados
            mod.setCodigo(conex.rs.getInt("codigo"));
            //seta na classe medico o valor do atributo nome no banco
            mod.setNome(conex.rs.getString("nomemed"));
            //seta a especialidade do atributo especialidade no banco
            mod.setEspecialidade(conex.rs.getString("especialidade"));
            //seta crm do atributo crm no banco
            mod.setCrm(conex.rs.getInt("crm"));
            
        } catch (SQLException ex) {
            //mostra mensagem se tudo ocorreu bem
           JOptionPane.showMessageDialog(null, "medico nao cadastrado");
        }
        //fecha conexao
        conex.Desconecta();
        //retorn mod medico conforme parametro do metodo
        return mod;
    }
    
    //metodo que edita informacoes 
    public void Editar(ModeloMedico mod){
        //abre conexao
        conex.Conexao();
        try{
            //preparedstatement recebe a conexao 
        PreparedStatement pst = conex.con.prepareStatement("update medicos set nomemed=?,especialidade=?,crm=? where codigo=?" );
        //seta o nome do medico no banco de dados
        pst.setString(1, mod.getNome());
        //seta a especialidade no banco de dados
        pst.setString(2, mod.getEspecialidade());
        //seta crm no banco de dados
        pst.setInt(3, mod.getCrm());
        //seta codigo do medico no banco de dados
        pst.setInt(4, mod.getCodigo());
        //executa preparedstatement
        pst.execute();
        //mostra mensagem se tudo ocorreu bem
        JOptionPane.showMessageDialog(null, "alterado com sucesso");
        }catch(Exception e){
            //mostra mensagem se algo deu errado
            JOptionPane.showMessageDialog(null, "erro ao altera medico");
        }
        //fecha conexao
        conex.Desconecta();
    }
    
    //metodo que exclui
    public void Excluir(ModeloMedico mod){
        //abre conexao 
        conex.Conexao();
        try{
            //preparedstatement recebe conexao
        PreparedStatement pst = conex.con.prepareStatement("delete from medicos where codigo=?");
        //seta no banco de dados codigo do medico a ser excluido
        pst.setInt(1, mod.getCodigo());
        //executa preparedstatement
        pst.execute();
        //mostra mensagem se tudo ocorreu bem
        JOptionPane.showMessageDialog(null, "excluido com sucesso");
        }catch(Exception e){
            //mostra mensagem se algo deu errado
            JOptionPane.showMessageDialog(null, "erro ao excluir");
        }
        //fecha conexao com bancos
        conex.Desconecta();
    }
    
}
