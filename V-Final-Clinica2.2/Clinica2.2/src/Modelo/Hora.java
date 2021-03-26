 
package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

 
public class Hora {
    
   public String hora;
    SimpleDateFormat horaformatada = new SimpleDateFormat("HH:mm:ss");


    public void LerHora(){
        Date horaatual = new Date();
        hora=horaformatada.format(horaatual);
        
    }


}
