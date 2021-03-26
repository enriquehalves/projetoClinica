
/*classe que monta a tabela*/ 
package Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

 //modelo tabela herda de abstracttablemodel
public class ModeloTabela extends AbstractTableModel{
    //arraylist linhas 
    private ArrayList linhas = null;
    //vetor de string colunas
    private String[] colunas = null;
    
    //construtor da classe com array list e vetor string com parametro
    public ModeloTabela(ArrayList lin, String[] col){
        //seta linha
        setLinhas(lin);
        //seta colunas
        setColunas(col);
    }

    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    //conta quantidade de colunas
    public int getColumnCount(){
        //retorna quantidade de colunas
        return colunas.length;
    }
    
    //conta quantidade de linhas
    public int getRowCount(){
        //retorna tamanho das linhas
        return linhas.size();
    }
    //metodo que armazena nome da coluna
    public String getColumnName(int numCol){
        //retorna nome da coluna
        return colunas[numCol];
    }
    
    //metodo que obtem um valor da coluna
    public Object getValueAt(int numLin, int numCol){
        //vetor object linha faz catch vetor de com  as linhas 
        Object[] linha = (Object[])getLinhas().get(numLin);
        //retorna numero de colunas em cada linha
        return linha[numCol];
    }
}
