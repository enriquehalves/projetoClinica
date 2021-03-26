 
package Modelo;

import java.util.Date;

 
public class ModeloAgendaConsulta {
  
 private int codigoconsulta;
 private String nomepaciente;
 private String nomemedico;
 private Date data;
 private String motivo;
 private String status;
 private String pacienteNasc;
 

    /**
     * @return the codigoconsulta
     */
    public int getCodigoconsulta() {
        return codigoconsulta;
    }

    /**
     * @param codigoconsulta the codigoconsulta to set
     */
    public void setCodigoconsulta(int codigoconsulta) {
        this.codigoconsulta = codigoconsulta;
    }

    /**
     * @return the nomepaciente
     */
    public String getNomepaciente() {
        return nomepaciente;
    }

    /**
     * @param nomepaciente the nomepaciente to set
     */
    public void setNomepaciente(String nomepaciente) {
        this.nomepaciente = nomepaciente;
    }

    /**
     * @return the nomemedico
     */
    public String getNomemedico() {
        return nomemedico;
    }

    /**
     * @param nomemedico the nomemedico to set
     */
    public void setNomemedico(String nomemedico) {
        this.nomemedico = nomemedico;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the pacienteNasc
     */
    public String getPacienteNasc() {
        return pacienteNasc;
    }

    /**
     * @param pacienteNasc the pacienteNasc to set
     */
    public void setPacienteNasc(String pacienteNasc) {
        this.pacienteNasc = pacienteNasc;
    }

 
}