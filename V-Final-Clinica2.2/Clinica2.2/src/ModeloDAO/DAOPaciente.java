 
package ModeloDAO;

import Modelo.ModeloPaciente;
import ModeloConexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

 
public class DAOPaciente {
    
    ModeloPaciente paciente = new ModeloPaciente();
    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexbairro = new ConexaoBD();
    int codigo ;
    String nomeBairro;
    
    
    public void Salvar(ModeloPaciente paciente){
      BuscaCodigoBairro(paciente.getBairro());
        conex.Conexao();
         
        try {
          PreparedStatement pst = conex.con.prepareStatement("insert into pacientes(nome,nascimento,rg,telefone,cpf,email,rua,cep,complemento,pacbairrocodigo)values(?,?,?,?,?,?,?,?,?,?)");
          pst.setString(1, paciente.getNome());
          pst.setString(2, paciente.getNascimento());
          pst.setString(3, paciente.getRg());
          pst.setString(4, paciente.getTelefone());
          pst.setString(5, paciente.getCpf() );
          pst.setString(6, paciente.getEmail());
          pst.setString(7, paciente.getRua());
          pst.setString(8, paciente.getCep());
          pst.setString(9, paciente.getComplemento());
          pst.setInt(10, codigo);
          pst.execute();
          JOptionPane.showMessageDialog(null, "inserido com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao inserir paciente " +e);
        }
        
        conex.Desconecta();
    }
    
    public void Editar(ModeloPaciente paciente){
      BuscaCodigoBairro(paciente.getBairro());
        conex.Conexao();
         
        try {
          PreparedStatement pst = conex.con.prepareStatement("update pacientes set nome=?,nascimento=?,rg=?,telefone=?,cpf=?,email=?,rua=?,cep=?,complemento=?,pacbairrocodigo=? where codigo=? ");
          pst.setString(1, paciente.getNome());
          pst.setString(2, paciente.getNascimento());
          pst.setString(3, paciente.getRg());
          pst.setString(4, paciente.getTelefone());
          pst.setString(5, paciente.getCpf() );
          pst.setString(6, paciente.getEmail());
          pst.setString(7, paciente.getRua());
          pst.setString(8, paciente.getCep());
          pst.setString(9, paciente.getComplemento());
          pst.setInt(10, codigo);
          pst.setInt(11, paciente.getCodigo());
          pst.execute();
          JOptionPane.showMessageDialog(null, "alterado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao inserir paciente " +e);
        }
        
        conex.Desconecta();
    }
    
    public void BuscaCodigoBairro(String nome){
        conex.Conexao();
        
        try {
            conex.ExecutaSql("select *from bairro where bairronome='"+nome+"'");
            conex.rs.first();
            codigo=conex.rs.getInt("bairrocodigo");
            System.out.println(codigo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao buscar bairro "+e);
        }
        
        conex.Desconecta();
    }
    
    public ModeloPaciente buscaPaciente(ModeloPaciente paciente){
        
        conex.Conexao();
        
        try {
            conex.ExecutaSql("select *from pacientes where nome like'%"+paciente.getPesquisa()+"%'");
            conex.rs.first();
            BuscaNomeBairro(conex.rs.getInt("pacbairrocodigo"));
            paciente.setNome(conex.rs.getString("nome"));
            paciente.setNascimento(conex.rs.getString("nascimento"));
            paciente.setRg(conex.rs.getString("rg"));
            paciente.setCpf(conex.rs.getString("cpf"));
            paciente.setTelefone(conex.rs.getString("telefone"));
            paciente.setRua(conex.rs.getString("rua"));
            paciente.setCep(conex.rs.getString("cep"));
            paciente.setComplemento(conex.rs.getString("complemento"));
            paciente.setEmail(conex.rs.getString("email"));
            paciente.setBairro(nomeBairro);
            paciente.setCodigo(conex.rs.getInt("codigo"));
            
            
        } catch (Exception e) {
        }
        
        conex.Desconecta();
        
        return paciente;
    }
    
    public void BuscaNomeBairro(int cod){
        conexbairro.Conexao();
        
        try {
            conexbairro.ExecutaSql("select *from bairro where bairrocodigo='"+cod+"'");
            conexbairro.rs.first();
            nomeBairro = conexbairro.rs.getString("bairronome");
        } catch (Exception e) {
        }
        
        conexbairro.Desconecta();
    }
    
    public void Excluir(ModeloPaciente paciente){
        conex.Conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from pacientes where codigo=?");
            pst.setInt(1, paciente.getCodigo());
            pst.execute();
        } catch (Exception e) {
        }
        
        
        conex.Desconecta();
    }
    
}
