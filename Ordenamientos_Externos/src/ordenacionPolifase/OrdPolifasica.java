package ordenacionPolifase;

import com.csvreader.CsvWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class OrdPolifasica {
    public int sort(int campo, String rutaOriginal) throws IOException, FileNotFoundException, ParseException {
        rutaOriginal += ".csv";
        String rutaF1="F1.csv";
        String rutaF2 = "F2.csv";
        String rutaF3="F3.csv";
        int pasada = 1;
        int z=1,w=1;
        while(z!=0 && w!=0){//hasta que ya no halla mas datos por ordenar
           OrdenacionPolifasica.particion(rutaOriginal, rutaF1, rutaF2, campo);/*busca tramos y los coloca en los archivos 
           auxiliares (F1 y F2)*/
           OrdenacionPolifasica.Fusiona(rutaOriginal, rutaF1, rutaF2, campo);/*compara cada elemento de los archivo (F1 y F2) 
            buscando siempre el menor y los pone en los archivos auxiliares (F1, F2)*/
           w=(int) contar(rutaF2);//devuelve un long de cuantos datos hay en el archivo auxiliar (F2)
           z=(int) contar(rutaF1);//devuelve un long de cuantos datos hay en el archivo auxiliar (F1)
           pasada++;
        }
        OrdenacionPolifasica.eliminarAux(rutaF1, rutaF2);
        return pasada;
    }
    
    public static long contar(String ruta) throws IOException{
            long count=0;
            FileReader fr = new FileReader(ruta);
            BufferedReader bf = new BufferedReader(fr);
            boolean sCad;
            while (sCad = bf.readLine()!=null){
                count++;
            }
            fr.close();
            bf.close();
            return count; 
    }
}
