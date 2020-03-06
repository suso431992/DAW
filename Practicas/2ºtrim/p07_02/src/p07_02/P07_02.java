/*
Basado en el ejercicio anterior, realizar un programa que presente un
menú de opciones:
    1-Añadir alumno
    2-Añadir módulos
    3-Asignar módulo a alumno
    4-Introducir notas (indicar alumno, módulo y evaluación)
    5-Eliminar alumno (por posición)
    6-Mostrar información de un alumno (por posición)
    7-Indicar número de alumnos
    8-Listar alumnos
    9-Listar módulos
    10-Ordenar alumnos
            1- Por apelliido1, apellido2, nombre
            2- Por DNI
            3- Por nota media
    0-Salir
 */
package p07_02;

import java.lang.reflect.Field;
import java.util.*;

/**
 *
 * @author JIM
 */
public class P07_02 {

    static ArrayList<Alumno> clase1 = new ArrayList<>(30);
    static ArrayList<Modulo> modulos = new ArrayList<>(15);
    static Scanner tec = new Scanner(System.in);
    static Field[] cabezeraClaseAlumno = Alumno.class.getDeclaredFields();
    static String[] CABEZERA_ALUMNO = {cabezeraClaseAlumno[0].getName(),
        cabezeraClaseAlumno[1].getName(),
        cabezeraClaseAlumno[2].getName(), cabezeraClaseAlumno[3].getName()};
    static Field[] cabezeraClaseModulo = Modulo.class.getDeclaredFields();
    static String[] CABEZERA_MODULO = {cabezeraClaseModulo[0].getName(),
        cabezeraClaseModulo[1].getName(), cabezeraClaseModulo[2].getName()};
    static final String[] OPCIONES = {"1. Añadir alumno", "2. Añadir módulos", "3. Asignar módulo a alumno",
        "4. Introducir notas (indicar alumno, módulo y evaluación)", "5. Eliminar alumno (por posición)",
        "6. Mostrar información de un alumno (por posición)", "7. Indicar número de alumnos", "8. Listar alumnos",
        "9. Listar módulos", "10. Ordenar alumnos ", "0. Salir"};
    static final String[] OPCIONES1 = {"1. Por apellido1, apellido2, nombre",
        "2. Por DNI", "3. Por nota media", "4. volver atras"};

    public static void main(String[] args) {
        int opcion;
        boolean salir = false;
        //preLista de alumnos
        clase1.add(new Alumno("Jesus", "Iglesias", "Miguelez", "45906637V"));
        clase1.add(new Alumno("Árbol", "Álvarez", "Míguez", "35906637V"));
        clase1.add(new Alumno("Bárbol", "Álvarez", "Míguez", "15906637A"));
        clase1.add(new Alumno("Paquito", "El", "Chocolatero", "12345678X"));
        clase1.add(new Alumno("Abc", "Del valiente", "Cortés", "55906737D"));
        clase1.add(new Alumno("Cba", "No valiente", "No Cortés", "67654321X"));
        //preLista de modulos
        modulos.add(new Modulo("Desarrollo de aplicaciones web", "DAW", 5));
        modulos.add(new Modulo("Bases de datos", "BBDD", 6));
        while (!salir) {
            System.out.println("Opciones: ");
            for (String a : OPCIONES) {
                System.out.println("\t" + a);
            }
            System.out.print("Introduzca una opcion:");
            opcion = Integer.parseInt(tec.nextLine());
            switch (opcion) {
                case 1: {
                    //Añadir alumno
                    clase1.add(insertarAlumno());
                    break;
                }
                case 2: {
                    //Añadir modulo
                    modulos.add(insertarModulo());
                    break;
                }
                case 3: {
                    // imprimir una guia de alumnos, una vez seleccionado
                    // imprimir una guia de modulos disponibles
                    //asignar modulo a alumno
                    System.out.println(asignarModuloAlumno()
                        ? "Se ha asignado correctamente" : "No se pudo asignar");
                    break;
                }
                case 4: {
                    //introducir notas del modulo al alumno
                    //imprimir guia de alumnos
                    System.out.print("Alumnos: [");
                    int i = 1;
                    for (Alumno alumno : clase1) {
                        System.out.print(i++ + ", ");
                    }
                    System.out.print("]\n");
                    //seleccionar alumno
                    System.out.print("Introduzca la posicion del alumno: ");
                    int posi = Integer.parseInt(tec.nextLine());
                    if (esPosValida(posi, clase1)) {
                        //listar sus modulos
                        System.out.println("Matriculado en: ");
                        if (!clase1.get(posi - 1).getModulos().isEmpty()) {
                            int j = 1;
                            for (Modulo modulo : clase1.get(posi - 1).getModulos()) {
                                System.out.print(j++ + " " + modulo.getNombreCorto() + " ");
                            }
                            System.out.println("");
                            System.out.print("Introduzca el numero del modulo: ");
                            int seleccion = Integer.parseInt(tec.nextLine());
                            //comprobar posicion valida para sus modulos... mañana....
                            int nNotas = clase1.get(posi - 1).getModulos().get(seleccion - 1).getNota().length;
                            // pedir notas
                            Double[] notillas = new Double[nNotas];
                            for (int k = 0; k < nNotas - 1; k++) {
                                System.out.print("Nota (" + (k + 1) + "): ");
                                notillas[k] = Double.parseDouble(tec.nextLine());
                            }
                            clase1.get(posi - 1).getModulos().get(seleccion - 1).setNota(notillas);
                            clase1.get(posi - 1).getModulos().get(seleccion - 1).setNotaFinal();

                        } else {
                            System.out.println("No tiene modulos asignados");
                        }
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    break;
                }
                case 5: {
                    //eliminar alumno
                    System.out.print("Alumnos: [");
                    int i = 1;
                    for (Alumno alumno : clase1) {
                        System.out.print(i++ + ", ");
                    }
                    System.out.print("]\n");
                    System.out.print("Introduzca la posicion del alumno a eliminar: ");
                    int posAlumno = Integer.parseInt(tec.nextLine());
                    if (esPosValida(posAlumno, clase1)) {
                        clase1.remove(posAlumno - 1);
                    } else {
                        System.out.println("No se pudo eliminar");
                    }
                    break;
                }
                case 6: {
                    //mostrar alumno x
                    //listar guia alumnos
                    System.out.print("Alumnos: [");
                    int i = 1;
                    for (Alumno alumno : clase1) {
                        System.out.print(i++ + ", ");
                    }
                    System.out.print("]\n");
                    System.out.print("Introduzca la posicion del alumno: ");
                    int posi = Integer.parseInt(tec.nextLine());
                    if (esPosValida(posi, clase1)) {
                        imprimirDetallado(posi);
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    break;
                }
                case 7: {
                    //Indicar el nº de alumnos
                    System.out.println("El numero de alumnos actual es: " + clase1.size());
                    break;
                }
                case 8: {
                    //Listar alumnos
                    int i = 1;
                    System.out.println("Imprimir alumnos: ");

                    System.out.printf("%2$24s %3$20s %1$20s %4$-5s %10sMediaModulos \n",
                        CABEZERA_ALUMNO[0], CABEZERA_ALUMNO[1], CABEZERA_ALUMNO[2], CABEZERA_ALUMNO[3]);

                    for (Alumno x : clase1) {
                        System.out.printf("%1$2d: %2$20s %3$20s %4$20s %5$-5s %6$f \n",
                            (i++), x.getApellido1(), x.getApellido2(), x.getNombre(), x.getDni(), x.getNotaMediaModulos());
                    }
                    break;
                }
                case 9: {
                    //Listar modulos
                    int i = 1;
                    System.out.println("Imprimir modulos: ");

                    System.out.printf("%1$34s %2$20s %3$20ss \n",
                        CABEZERA_MODULO[0], CABEZERA_MODULO[1], CABEZERA_MODULO[2]);

                    for (Modulo x : modulos) {
                        System.out.printf("%1$2d: %2$30s %3$20s %4$20d \n",
                            (i++), x.getNombre(), x.getNombreCorto(), x.getNota().length);
                    }
                    break;
                }
                case 10: {
                    //ordenar alumnos
                    System.out.println("Opciones de ordenación: ");
                    for (String a : OPCIONES1) {
                        System.out.println("\t" + a);
                    }
                    System.out.print("Introduzca una opcion de ordenación:");
                    opcion = Integer.parseInt(tec.nextLine());
                    boolean atras = false;
                    while (!atras) {
                        switch (opcion) {
                            case 1: {
                                Collections.sort(clase1, new PorApellidos());
                                atras = true;
                                break;
                            }
                            case 2: {
                                Collections.sort(clase1, new PorDni());
                                atras = true;
                                break;
                            }
                            case 3: {
                                for (Alumno alumno : clase1) {
                                    alumno.setNotaMediaModulos();
                                }
                                Collections.sort(clase1, new PorNotaMedia());
                                atras = true;
                                break;
                            }
                            case 4: {
                                atras = true;
                                break;
                            }
                            default: {
                                System.out.println("Introduzca numeros del 0..4");
                            }
                        }
                    }
                    break;
                }
                case 0: {
                    salir = true;
                    break;
                }
                default: {
                    System.out.println("Introduzca numeros del 0..10");
                    break;
                }
            }
        }
    }

    private static void imprimirDetallado(int posiAlumno) {
        if (esPosValida(posiAlumno, clase1)) {
            Alumno buscado = clase1.get(posiAlumno - 1);
            System.out.printf("Nombre: %1$s, apellido1: %2$s apellido2: %3$s dni: %4$s\n", buscado.getNombre(), buscado.getApellido1(), buscado.getApellido2(), buscado.getDni());
            if (buscado.getModulos().isEmpty()) {
                System.out.println("\tNo tiene modulos asignados");
            } else {
                for (Modulo modulo : buscado.getModulos()) {
                    System.out.println("\t" + modulo.toString());
                }
            }
        }
    }

    private static boolean asignarModuloAlumno() {
        System.out.print("Alumnos: [");
        int i = 1;
        for (Alumno alumno : clase1) {
            System.out.print(i++ + ",");
        }
        System.out.print("] \n");
        System.out.print("Modulos [");
        int j = 1;
        for (Modulo m : modulos) {
            System.out.print(j++ + " " + m.getNombreCorto() + ", ");
        }
        System.out.print("] \n");

        System.out.print("Inserte la posicion del alumno: ");
        int nAlumno = Integer.parseInt(tec.nextLine());
        if (esPosValida(nAlumno, clase1)) {
            System.out.print("Inserte la posicion del modulo: ");
            int nModulo = Integer.parseInt(tec.nextLine());
            if (esPosValida(nModulo, modulos)) {
                Modulo aux = modulos.get(nModulo - 1);
                clase1.get(nAlumno - 1).setModulos(aux);
                return true;
            }
        }
        return false;
    }

    private static Modulo insertarModulo() {
        Modulo x;
        String[] datos = {"", "", ""};
        for (int i = 0; i < CABEZERA_MODULO.length; i++) {
            System.out.print(CABEZERA_MODULO[i] + ": ");
            datos[i] = tec.nextLine();
        }
        x = new Modulo(datos[0], datos[1], Integer.parseInt(datos[2]));
        return x;
    }

    private static Alumno insertarAlumno() {
        Alumno x;
        String[] datos = {"", "", "", ""};
        for (int i = 0; i < CABEZERA_ALUMNO.length; i++) {
            System.out.print(CABEZERA_ALUMNO[i] + ": ");
            datos[i] = tec.nextLine();
        }
        x = new Alumno(datos[0], datos[1], datos[2], datos[3]);
        return x;
    }

    private static boolean esPosValida(int Pos, ArrayList x) {
        return (Pos - 1) >= 0 && (Pos - 1) < x.size();
    }
}
