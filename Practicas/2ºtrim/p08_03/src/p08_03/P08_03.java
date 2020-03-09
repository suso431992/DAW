/*
Programa que simule el funcionamiento del comando cp del SO
(limitado a un único fichero)
Los parámetros han de ser pasados por línea de comandos.
 */
package p08_03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author JIM
 */
public class P08_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error de parametros");
            System.out.println("Requiere de Origen y Destino");
            System.exit(0);
        }

        if (copiarFichero(args[0], args[1])) {
            System.out.println("Se ha copiado correctamente " + args[0] + " a " + args[1]);
        } else {
            System.out.println("No se ha copiado");
        }
    }

    private static boolean copiarFichero(String orixe, String destino) {
        try {
            FileReader forigen = new FileReader(orixe);
            FileWriter fdestino = new FileWriter(destino);
            int aux;
            while ((aux = forigen.read()) != -1) {
                fdestino.write(aux);
            }
            forigen.close();
            fdestino.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero origen " + orixe + " no encontrado");
            return false;
        } catch (IOException ex) {
            System.out.println("Posible error de lectura del fichero " + orixe);
            return false;
        }
    }
}
