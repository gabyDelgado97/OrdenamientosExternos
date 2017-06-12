package ordenacionBalanceada;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class OrdBalanceada {

    public int sort(int campo, String rutaOriginal) throws FileNotFoundException, IOException, ParseException {
        long contador1, contador2, contadoGen;
        rutaOriginal += ".csv";
        String rutaF1 = "F1.csv";
        String rutaF2 = "F2.csv";
        String rutaF3 = "F3.csv";

        int pasada = 1;

        contadoGen = contar(rutaOriginal);
        MezclaBalanceada.particionInicial(rutaOriginal, rutaF2, rutaF3, campo);
        MezclaBalanceada.particionFusion(rutaF2, rutaF3, rutaOriginal, rutaF1, campo);
        boolean band = false;
        contador1 = contar(rutaOriginal);
        contador2 = contar(rutaF1);
        while (contador1 != 0 || contador2 != 0) {
            if (band) {
                MezclaBalanceada.particionFusion(rutaF2, rutaF3, rutaOriginal, rutaF1, campo);
                band = false;
                contador1 = contar(rutaOriginal);
                contador2 = contar(rutaF1);
                if (contador1 == 0 || contador2 == 0) {
                    break;
                }
            } else {
                MezclaBalanceada.particionFusion(rutaOriginal, rutaF1, rutaF2, rutaF3, campo);
                band = true;
                contador1 = contar(rutaF2);
                contador2 = contar(rutaF3);
                if (contador1 == 0 || contador2 == 0) {
                    break;
                }
            }

            pasada++;
        }
        if (contador1 == contadoGen) {
            System.out.println("ARCHIVO ORDENADO");
        } else {
            MezclaBalanceada.copiarTodo(rutaOriginal, rutaF2);
            System.out.println("ARCHIVO ORDENADO");
        }
        MezclaBalanceada.eliminarAux(rutaF1, rutaF2, rutaF3);
        return pasada;

    }

    public static long contar(String ruta) throws IOException {
        long count = 0;
        FileReader fr = new FileReader(ruta);
        BufferedReader bf = new BufferedReader(fr);
        boolean sCad;
        while (sCad = bf.readLine() != null) {
            count++;
        }
        bf.close();
        fr.close();
        return count;
    }
}
