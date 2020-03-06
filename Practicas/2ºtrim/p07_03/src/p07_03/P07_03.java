/*
Programa que gestione los módulos de los ciclos SRM, DAW y DAM.
Se debe crear un conjunto para cada curso de cada ciclo,
introduciendo en el mismo los módulos correspondientes.

Se le permitirá al usuario realizar uniones e intersecciones entre los conjuntos,
de modo que pueda ver, por ejemplo: todos los módulos de un ciclo,
los módulos comunes entre dos ciclos, ....
 */
package p07_03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author JIM
 */
public class P07_03 {

    static final Set<Modulo> SMR1 = new HashSet<>();
    static final Set<Modulo> SMR2 = new HashSet<>();
    static final Set<Modulo> DAW1 = new HashSet<>();
    static final Set<Modulo> DAW2 = new HashSet<>();
    static final Set<Modulo> DAM1 = new HashSet<>();
    static final Set<Modulo> DAM2 = new HashSet<>();
    static final List<Set<Modulo>> CATALAGO = new LinkedList<>();
    static final String[] NOMBRE_CATALOGO = {"1.SMR1", "2.SMR2", "3.DAM1", "4.DAM2", "5.DAW1", "6.DAW2"};
    static Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {
        DAW1.add(new Modulo("programacion", "p", 3));
        DAW1.add(new Modulo("Bases de datos", "BBDD", 3));
        DAW1.add(new Modulo("Lenguaje de Marcas", "LM", 3));
        DAW1.add(new Modulo("Sistemas informaticos", "SINF", 3));
        DAW1.add(new Modulo("Entornos de desarrollo", "ED", 3));
        DAW1.add(new Modulo("Formacion y orientación laboral", "FOL", 3));

        DAW2.add(new Modulo("Desarrollo web en entorno cliente", "DWC", 3));
        DAW2.add(new Modulo("Desarrollo web en entorno servidor", "DWS", 3));
        DAW2.add(new Modulo("Despliegue de aplicaciones web", "DAW", 3));
        DAW2.add(new Modulo("Diseño de interfaces web", "DIW", 3));
        DAW2.add(new Modulo("Empresa e iniciativa emprendedora", "EIE", 3));
        DAW2.add(new Modulo("Proyecto de desarrollo de aplicaciones web", "PDA", 3));
        DAW2.add(new Modulo("Formación en Centros de Trabajo", "FTC", 1));

        DAM1.add(new Modulo("Sistemas informáticos", "SINF", 3));
        DAM1.add(new Modulo("Bases de Datos", "BBDD", 3));
        DAM1.add(new Modulo("Programación", "p", 3));
        DAM1.add(new Modulo("Lenguajes de marcas y sistemas de gestión de información", "LMSGI", 3));
        DAM1.add(new Modulo("Entornos de desarrollo", "ED", 3));
        DAM1.add(new Modulo("Formación y Orientación Laboral", "FOL", 3));

        DAM2.add(new Modulo("Acceso a datos", "AD", 3));
        DAM2.add(new Modulo("Desarrollo de interfaces", "DI", 3));
        DAM2.add(new Modulo("Programación multimedia y dispositivos móviles", "PMDM", 3));
        DAM2.add(new Modulo("Programación de servicios y procesos", "PSP", 3));
        DAM2.add(new Modulo("Sistemas de gestión empresarial", "SGE", 3));
        DAM2.add(new Modulo("Empresa e iniciativa emprendedora", "EIE", 3));
        DAM2.add(new Modulo("Formación en Centros de Trabajo", "FTC", 3));

        SMR1.add(new Modulo("Montaje y mantenimiento de equipos", "MME", 3));
        SMR1.add(new Modulo("Redes locales", "RL", 3));
        SMR1.add(new Modulo("Aplicaciones ofimáticas", "AO", 3));
        SMR1.add(new Modulo("Sistemas operativos monopuesto", "SOM", 3));
        SMR1.add(new Modulo("Formación y Orientación Laboral", "FOL", 3));
        SMR1.add(new Modulo("Inglés", "I", 3));

        SMR2.add(new Modulo("Sistemas operativos en red", "SOR", 3));
        SMR2.add(new Modulo("Seguridad informática", "SI", 3));
        SMR2.add(new Modulo("Servicios en la red", "SR", 3));
        SMR2.add(new Modulo("Aplicaciones web", "AW", 3));
        SMR2.add(new Modulo("Empresa e iniciativa emprendedora", "EIE", 3));
        SMR2.add(new Modulo("Formación en Centros de Trabajo", "FCT", 3));

        CATALAGO.add(SMR1);
        CATALAGO.add(SMR2);
        CATALAGO.add(DAM1);
        CATALAGO.add(DAM2);
        CATALAGO.add(DAW1);
        CATALAGO.add(DAW2);

        boolean salir = false;
        int a, b;
        while (!salir) {
            System.out.println("Estas son las opciones:");
            System.out.println("\t 1. Union de modulos");
            System.out.println("\t 2. Intersección de modulos");
            System.out.println("\t 3. Salir");
            System.out.print("Que desea hacer?: ");

            switch (Integer.parseInt(tec.nextLine())) {
                case 1:
                    System.out.println("Muestra de modulos para la union");
                    for (String string : NOMBRE_CATALOGO) {
                        System.out.print(string + " ");
                    }
                    System.out.println("");
                    System.out.print("Introduzca la posicion del modulo: ");
                    a = Integer.parseInt(tec.nextLine()) - 1;
                    System.out.print("Introduzca la posicion del otro modulo: ");
                    b = Integer.parseInt(tec.nextLine()) - 1;
                    imprimirModulo("Union de: " + NOMBRE_CATALOGO[a] + " con " + NOMBRE_CATALOGO[b], union(CATALAGO.get(a), CATALAGO.get(b)));
                    break;
                case 2:
                    System.out.println("Muestra de modulos para la intersección");
                    for (String string : NOMBRE_CATALOGO) {
                        System.out.print(string + " ");
                    }
                    System.out.println("");
                    System.out.print("Introduzca la posicion del modulo: ");
                    a = Integer.parseInt(tec.nextLine()) - 1;
                    System.out.print("Introduzca la posicion del otro modulo: ");
                    b = Integer.parseInt(tec.nextLine()) - 1;
                    imprimirModulo("intersección de: " + NOMBRE_CATALOGO[a] + " con " + NOMBRE_CATALOGO[b], interseccion(CATALAGO.get(a), CATALAGO.get(b)));
                    break;
                case 3:
                    salir = true;
                    break;
            }
        }
    }

    public static void guardarEnFichero(String ruta, Set<Modulo> curso) {
        try {
            FileReader fichero = new FileReader(ruta);
            BufferedReader linea = new BufferedReader(fichero);
            String dato = linea.readLine();
            while (dato != null) {
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            System.out.println("dato no valido, creo...");
        }
    }
    
    public static void imprimirModulo(String nombre, Set<Modulo> x) {
        System.out.println("Imprimiendo " + nombre);
        for (Iterator i = x.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
    }

    public static Set<Modulo> union(Set<Modulo> a, Set<Modulo> b) {
        Set<Modulo> aux = new HashSet<>();
        aux.addAll(a);//si hago asignación copio la dir de memoria y destruyo loque hay en a
        aux.addAll(b);
        return aux;
    }

    public static Set<Modulo> interseccion(Set<Modulo> a, Set<Modulo> b) {
        Set<Modulo> aux = new HashSet<>();
        aux.addAll(a);
        aux.retainAll(b);
        return aux;
    }

}
