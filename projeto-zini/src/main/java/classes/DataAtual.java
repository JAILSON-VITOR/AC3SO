package classes;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DataAtual {
    Date d;
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat formatoDH = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    SimpleDateFormat formatoMinuto = new SimpleDateFormat("mm");
    
    
    public DataAtual(Date d){
        this.d = d;
    }
    public String getDataHora(){
        return formatoHora.format(d);
    }
    
    public String getMinuto() {
        return formatoMinuto.format(d);
    }

    
    public String getDiaSemana(){
     String diaSemana = "";
     switch(d.getDay()){
         case 0:
             diaSemana = "Domingo";
             break;
         case 1:
             diaSemana = "Segunda-Feira";
             break;
         case 2:
             diaSemana = "Terça-Feira";
             break;
         case 3:
             diaSemana = "Quarta-Feira";
             break;
         case 4:
             diaSemana = "Quinta-Feira";
             break;
         case 5:
             diaSemana = "Sexta-Feira";
             break;
         case 6:
             diaSemana = "Sabado";
             break;
         default:
             break;
     }
     return diaSemana;
    }
   public String getDiaHora(){
        return formatoDH.format(d);
   }
}
