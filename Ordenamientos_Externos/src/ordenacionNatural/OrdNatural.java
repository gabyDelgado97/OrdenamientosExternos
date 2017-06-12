package ordenacionNatural;

import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class OrdNatural {
    public void sort(int campo, String rutaOriginal) throws FileNotFoundException, IOException, ParseException{
        rutaOriginal += ".csv";
        String rutaF1 = "F1.csv";
        String rutaF2 = "F2.csv";
        int part = 1;
        int pasada = 1;
        CsvReader Original = new CsvReader(rutaOriginal, ',');
        Original.close();
        while((part=OrdenacionNatural.Particiona(rutaOriginal, rutaF1, rutaF2, campo)) > 1 ){
            //System.out.println(part+":part");
            OrdenacionNatural.Fusiona(rutaOriginal, rutaF1, rutaF2, part, campo);
            pasada++;
        }
        Tools.DeleteFile(rutaF1, rutaF2); 
        System.out.println("ARCHIVO ORDENADO!");
    }
}
