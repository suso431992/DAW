/*
Programa que permita dar de alta alumnos y grabar/leer
sus datos utilizando ficheros.
El fichero debe ser de tipo texto.
La entrada de datos desde teclado no podrá realizarse con la clase Scanner.
La clase alumno constará de: nombre (String), edad (int), nota (double)
Los alumnos se gestionarán utilizando un ArrayList
Al comenzar el programa se comprobará la existencia del fichero de datos
y en caso de que este exista se recuperán.
A continuación se dará la opción de introducir nuevos alumnos.
Al terminar el programa se grabarán automáticamente
todos los datos en el fichero.
 */
package p08_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JIM
 */
public class P08_01 {

    public static class Alumno {

        String nombre;
        int edad;
        Double nota;

        public Alumno(String nombre, int edad, Double nota) {
            this.nombre = nombre;
            this.edad = edad;
            this.nota = nota;
        }

        public String guardar() {
            return nombre + "," + edad + "," + nota;
        }
    }
    static BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String datostxt = "datos.txt";
        List<Alumno> clase = new ArrayList<>();

        if (!leerDatosFichero(datostxt, clase)) {
            System.out.println("No exite el fichero, introduzca alumnos");
            introducirAlumno(clase);
        } else {
            System.out.println("El fichero existe, desea introducir mas alumnos? ");
            introducirAlumno(clase);
        }
        grabarDatosFichero(datostxt, clase);

    }

    private static boolean leerDatosFichero(String datostxt, List<Alumno> clase) {
        /*Introducir datos del fichero a la estructura de datos del programa*/
        try {
            try (BufferedReader fc = new BufferedReader(new FileReader(datostxt))) {
                String linea = fc.readLine();
                while (linea != null) {
                    String[] partes = linea.split(",");
                    clase.add(new Alumno(partes[0], Integer.parseInt(partes[1]), Double.parseDouble(partes[2])));
                    linea = fc.readLine();/*Siguiente linea*/
                }
                fc.close();
                return true;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero " + datostxt + " no encontrado");
            return false;
        } catch (IOException ex) {
            System.out.println("Posible error de lectura");
            return false;
        }
    }

    private static void introducirAlumno(List<Alumno> listaAlumnos) {
        String nombre = "";
        int edad = 0;
        Double nota = 0.0;
        while (true) {
            try {
                System.out.print("Introduzca el nombre del alumno (vacío para salir): ");
                nombre = tec.readLine();
                if (nombre.isEmpty()) {
                    break;
                }
                System.out.print("Introduzca la edad del alumno: ");
                edad = Integer.parseInt(tec.readLine());
                System.out.print("Introduzca la nota del alumno: ");
                nota = Double.parseDouble(tec.readLine());
                listaAlumnos.add(new Alumno(nombre, edad, nota));
            } catch (IOException ex) {
                System.out.println("Error de dato");
            }
        }
    }

    private static void grabarDatosFichero(String datostxt, List<Alumno> clase) {
        /*Introducir datos de la estructura del programa en un fichero*/
        try {
            BufferedWriter fc = new BufferedWriter(new FileWriter(datostxt));
            for (Alumno aux : clase) {
                fc.write(aux.guardar());
                fc.newLine();
            }
            fc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero " + datostxt + " no encontrado");
        } catch (IOException ex) {
            System.out.println("Posible error de guardar");
        }
    }

}
