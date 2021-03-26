 
package ModeloDAO;

import Modelo.ModeloAgendaConsulta;
import Modelo.ModeloMedico;
import Modelo.ModeloPaciente;
import ModeloConexao.ConexaoBD;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

 
public class DAOAgenda {
    
    ConexaoBD conexao = new ConexaoBD();
    ConexaoBD conexaomedico = new ConexaoBD();
    ConexaoBD conexaopaciente = new ConexaoBD(); 
    ModeloAgendaConsulta modconsulta = new ModeloAgendaConsulta();
    
     
  
    int codmedico;
    int codpaciente;
    public void salvar(ModeloAgendaConsulta modconsulta){
      
        BuscaCodigoPaciente(modconsulta.getNomepaciente());
        BuscaCodigoMedico(modconsulta.getNomemedico());
        conexao.Conexao();
        
        
        try {
            
            
            PreparedStatement pst = conexao.con.prepareStatement("insert into agenda(codigo_pacienteagenda,codigo_medicoagenda,agenda_data,agenda_motivo,agenda_status)values(?,?,?,?,?)");
            pst.setInt(1, codpaciente);
            pst.setInt(2,  codmedico);
            pst.setDate(3, new java.sql.Date(modconsulta.getData().getTime()));
            pst.setString(4, modconsulta.getMotivo());
            pst.setString(5, modconsulta.getStatus());
            pst.execute();
            JOptionPane.showMessageDialog(null, "consulta agendada!");
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "erro no agendamento "+e);   
        }
        
        
        conexao.Desconecta();
        
    }
    
    public void BuscaCodigoPaciente(String nomepaciente){
        
        try {
            conexaopaciente.Conexao();
            conexaopaciente.ExecutaSql("select *from pacientes where nome='"+nomepaciente+"'");
            conexaopaciente.rs.first();
            codpaciente=conexaopaciente.rs.getInt("codigo");
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "erro buscar codigo paciente "+e);
        }
       conexaopaciente.Desconecta();
        
    }
    public void BuscaCodigoMedico(String nomemedico){
           try {
            conexaomedico.Conexao();
            conexaomedico.ExecutaSql("select *from medicos where nomemed='"+nomemedico+"'");
            conexaomedico.rs.first();
            codmedico=conexaomedico.rs.getInt("codigo");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro buscar codigo medico "+e);
        }
       conexaomedico.Desconecta();
        
    }
    
     public int CodigoMedico(String nomemedico){
           try {
            conexaomedico.Conexao();
            conexaomedico.ExecutaSql("select *from medicos where nomemed='"+nomemedico+"'");
            conexaomedico.rs.first();
            codmedico=conexaomedico.rs.getInt("codigo");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro buscar codigo medico "+e);
        }
           
           
       conexaomedico.Desconecta();
       return codmedico;
        
    }
    
    
    public void Alterar(ModeloAgendaConsulta modconsulta){
        
        
        conexao.Conexao();
        
         try {
          PreparedStatement pst = conexao.con.prepareStatement("update agenda set agenda_status=? where codigo_agenda=? ");
          pst.setString(1, modconsulta.getStatus());
          pst.setInt(2, modconsulta.getCodigoconsulta());
 
          pst.execute();
          JOptionPane.showMessageDialog(null, "agendamento em atendimento");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao atender agendamento " +e);
        }
        
        
        
        
        
        conexao.Desconecta();
        
        
    }
  
    
    public void BuscaAgendamento(ModeloAgendaConsulta agenda){
        conexaomedico.Conexao();
        conexaomedico.ExecutaSql("select *from agenda where agenda_data'"+agenda.getData()+"'");
        try {
            conexaomedico.rs.first();
            codmedico=conexaomedico.rs.getInt("codigo_medicoagenda");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"agendamento nao encontrado");
        }
    }
    
      public ModeloAgendaConsulta BuscaAgendamentoPorCodigo(int cod){
        ModeloAgendaConsulta agen = new ModeloAgendaConsulta();
          conexao.Conexao();
        conexao.ExecutaSql("select *from agenda inner join pacientes on agenda.codigo_pacienteagenda=pacientes.codigo inner join medicos on agenda.codigo_medicoagenda=medicos.codigo where codigo_agenda='"+cod+"'");
        try {
            conexao.rs.first();
            agen.setNomepaciente(conexao.rs.getString("nome"));
            agen.setNomemedico(conexao.rs.getString("nomemed"));
            agen.setMotivo(conexao.rs.getString("agenda_motivo"));
            agen.setPacienteNasc(conexao.rs.getString("nascimento"));
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"agendamento nao encontrado por codigo "+e);
        }
        return agen;
    }
    
    
}
