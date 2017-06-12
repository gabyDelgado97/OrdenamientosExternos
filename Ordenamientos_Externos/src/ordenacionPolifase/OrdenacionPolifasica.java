package ordenacionPolifase;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrdenacionPolifasica {

    public static void particion(String rutaOriginal, String rutaF1, String rutaF2, int campo) throws FileNotFoundException, IOException, ParseException {
        
        /*Estos son analizadores basados en secuencias que analizan datos de texto delimitados de un archivo o secuencia.*/
        CsvReader F = new CsvReader(rutaOriginal, ',');
        CsvWriter F1 = new CsvWriter(new FileWriter(rutaF1), ',');
        CsvWriter F2 = new CsvWriter(new FileWriter(rutaF2), ',');
        
        String R, Aux;
        boolean band = true;
        
        /*Este metodo devuelve FALSE si lee otro registro*/
        if (F.readRecord()) {
            band = false;
        }
        
        /*Pasamos al metodo get los 4 campos del archivo F
        y devuelve el valor actual de la columna para un indice de columna o campo dado,
        esto lo almacenamos en String R y a su vez en F1*/
        R = F.get(0);
        F1.write(R);
        R = F.get(1);
        F1.write(R);
        R = F.get(2);
        F1.write(R);
        R = F.get(3);
        F1.write(R);
        
        /*Aqui almacena todos los valores que se encuentren especificamente en ese campo
        y lo guarda en F1*/
        R = F.get(campo);
        F1.endRecord();
        
        /*Aux tendra todos los valores que se encuentran en el campo que queremos ordenar*/
        Aux = R;
        band = true;
        
        /*Este while no se acabara hasta que lea todo el Registro que queremos, caso contrario devolvera FALSE 
        si ya acabo o no entrara si el archivo no existe */
        while (F.readRecord()) {
            R = F.get(campo);//se centra espeficamente en el campo que le pasamos 
            if (orderIt(Aux, R, campo)) {//devuelve TRUE si el campo ya esta ordenado
                Aux = R;// aux y R son iguales, contienen los mismo valores
                if (band == true) {
                    /*Entra aqui cuando ya termino de ordenar y se ordeno compleamente en F1
                    por eso band==true */
                    R = F.get(0);
                    F1.write(R);
                    R = F.get(1);
                    F1.write(R);
                    R = F.get(2);
                    F1.write(R);
                    R = F.get(3);
                    F1.write(R);
                    F1.endRecord();
                } else {
                     /*Entra aqui cuando ya termino de ordenar y se ordeno completamente en F2
                    por eso band==false*/
                    R = F.get(0);
                    F2.write(R);
                    R = F.get(1);
                    F2.write(R);
                    R = F.get(2);
                    F2.write(R);
                    R = F.get(3);
                    F2.write(R);
                    F2.endRecord();
                }
            } else { //Entra cuando R no esta ordenado, llena primero F2 y luego F1 hasta que esten ordenados
                Aux = R;
                if (band == true) {
                    /*Pasamos al metodo get los 4 campos del archivo F
                    y devuelve el valor actual de la columna para un indice de columna o campo dado,
                    esto lo almacenamos en String R y a su vez en F2*/ 
                    R = F.get(0);
                    F2.write(R);
                    R = F.get(1);
                    F2.write(R);
                    R = F.get(2);
                    F2.write(R);
                    R = F.get(3);
                    F2.write(R);
                    F2.endRecord();
                    band = false;
                    //hasta aqui F2 tiene todos los valores del archivo y R tiene todos los valores del ultimo campo
                } else {
                    /*Pasamos al metodo get los 4 campos del archivo F
                    y devuelve el valor actual de la columna para un indice de columna o campo dado,
                    esto lo almacenamos en String R y a su vez en F1*/ 
                    R = F.get(0);
                    F1.write(R);
                    R = F.get(1);
                    F1.write(R);
                    R = F.get(2);
                    F1.write(R);
                    R = F.get(3);
                    F1.write(R);
                    F1.endRecord();
                    band = true;
                }
            }
        }
        F.close();
        F1.close();
        F2.close();
    }

    public static void Fusiona(String rutaOriginal, String rutaF1, String rutaF2, int campo) throws FileNotFoundException, IOException, ParseException {
        int limit = 1;
        CsvWriter Original = new CsvWriter(new FileWriter(rutaOriginal), ',');
        CsvReader F1 = new CsvReader(rutaF1, ',');
        CsvReader F2 = new CsvReader(rutaF2, ',');
        String auxR1 = "", auxR2 = "";
        boolean end1 = true, end2 = true;
        if (F1.readRecord()) {
            auxR1 = F1.get(campo);
            end1 = false;
        }
        if (F2.readRecord()) {
            auxR2 = F2.get(campo);
            end2 = false;
        }
        while ((!end1 || !end2)){
            while (!end1 && !end2 && (orderIt(auxR1, F1.get(campo), campo) && orderIt(auxR2, F2.get(campo), campo))) {
                if (orderIt(F1.get(campo), F2.get(campo), campo)) {
                    Original.write(F1.get(0));
                    Original.write(F1.get(1));
                    Original.write(F1.get(2));
                    Original.write(F1.get(3));
                    auxR1 = F1.get(campo);
                    Original.endRecord();
                    end1 = true;
                    if (F1.readRecord()) {
                        if (orderIt(auxR1, F1.get(campo), campo)) {
                            auxR1 = F1.get(campo);
                        }
                        end1 = false;
                    }
                } else {
                    Original.write(F2.get(0));
                    Original.write(F2.get(1));
                    Original.write(F2.get(2));
                    Original.write(F2.get(3));
                    auxR2 = F2.get(campo);
                    Original.endRecord();
                    end2 = true;
                    if (F2.readRecord()) {
                        end2 = false;
                        if (orderIt(auxR2, F2.get(campo), campo)){
                            auxR2 = F2.get(campo);
                        }
                    }

                }
            }
            //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Antes de terminar tramoF1");
            while (!end1 && orderIt(auxR1, F1.get(campo), campo)) {
                Original.write(F1.get(0));
                Original.write(F1.get(1));
                Original.write(F1.get(2));
                Original.write(F1.get(3));
                auxR1 = F1.get(campo);
                Original.endRecord();
                end1 = true;
                if (F1.readRecord()) {
                    end1 = false;
                }
            }
            //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Antes de terminar tramoF2");
            while (!end2 && orderIt(auxR2, F2.get(campo), campo)) {
                Original.write(F2.get(0));
                Original.write(F2.get(1));
                Original.write(F2.get(2));
                Original.write(F2.get(3));
                auxR2 = F2.get(campo);
                Original.endRecord();
                end2 = true;
                if (F2.readRecord()) {
                    end2 = false;
                }
            }
            if (!end1) {
                auxR1 = F1.get(campo);
            }
            if (!end2) {
                auxR2 = F2.get(campo);
            }
            limit++;
        }
        Original.close();
        F1.close();
        F2.close();
    }

    public static boolean orderIt(String R1, String R2, int campo) throws ParseException {
        switch (campo) {
            case 0:
                return Integer.parseInt(R1) <= Integer.parseInt(R2);
            case 1:
                return R1.compareTo(R2) <= 0;
            case 2:
                if (R1.equals("TRUE")) {
                    R1 = "0";
                } else {
                    R1 = "1";
                }
                if (R2.equals("TRUE")) {
                    R2 = "0";
                } else {
                    R2 = "1";
                }
                return Integer.parseInt(R1) <= Integer.parseInt(R2);
            case 3:
                SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date fecha1 = sd.parse(R1);
                    Date fecha2 = sd.parse(R2);
                    return fecha1.compareTo(fecha2) <= 0;
                } catch (ParseException e) {
                    // Error, la cadena de texto no se puede convertir en fecha.
                }
        }
        return false;
    }

    public static void eliminarAux(String rutaF1, String rutaF2) throws IOException {
        CsvWriter F1 = new CsvWriter(new FileWriter(rutaF1), ',');
        CsvWriter F2 = new CsvWriter(new FileWriter(rutaF2), ',');
        F1.close();
        F2.close();
        boolean existe = new File(rutaF1).exists();
        if (existe) {
            File ficheroAux = new File(rutaF1);
            ficheroAux.delete();
        }
        existe = new File(rutaF2).exists();
        if (existe) {
            File ficheroAux = new File(rutaF2);
            ficheroAux.delete();
        }
    }
}
