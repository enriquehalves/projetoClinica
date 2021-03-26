 
package ModeloDAO;

import Modelo.ModeloConcluir;
import ModeloConexao.ConexaoBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

 
public class DAOConcluir {
    
    ConexaoBD conexao = new ConexaoBD();
    ModeloConcluir mc = new ModeloConcluir();
    
    
    public void Salvar(ModeloConcluir mc){
        
        try {
            conexao.Conexao();
             PreparedStatement pst = conexao.con.prepareStatement("insert into concluir(nomePac,nomeMed,nascPac,diagnostico,receita) values(?,?,?,?,?)");
             pst.setString(1, mc.getNomePaciente());
             pst.setString(2, mc.getNomeMedico());
             pst.setString(3, mc.getNascPac());
             pst.setString(4, mc.getDiagnostico());
             pst.setString(5, mc.getReceita());
             pst.execute();
             JOptionPane.showMessageDialog(null,"finalizado");
        } catch (Exception e) {
             
             JOptionPane.showMessageDialog(null,"erro ao finalizar "+e);
        }
        
        conexao.Desconecta();
    }
}
