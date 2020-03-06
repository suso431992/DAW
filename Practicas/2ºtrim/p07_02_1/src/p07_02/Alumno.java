/*
Crear una clase para guardar información de los alumnos del curso
(la que pueda ser relevante para el profesor).
 */
package p07_02;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author alumno
 */
public class Alumno implements Comparable<Alumno> {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private ArrayList<Modulo> modulos;
    private Double notaMediaModulos;

    public Alumno(String nombre, String apellido1, String apellido2, String dni) {
        modulos = new ArrayList<Modulo>();
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
    }

    public Double getNotaMediaModulos() {
        return notaMediaModulos;
    }

    public void setNotaMediaModulos() {
        double nota = 0.0;
        for (Modulo m : modulos) {
            m.setNotaFinal();
            nota += m.getNotaFinal();
        }
        if (modulos.size() > 0) {
            nota /= modulos.size();
        } else {
            nota = 1.0;
        }
        notaMediaModulos = nota;
    }

    @Override
    public String toString() {
        return getApellido2() + " " + getApellido1() + " " + getNombre();
    }

    /*
    <0 si this es menor que t
    0 si son iguales
    >0 si this es mayor
     */
    @Override
    public int compareTo(Alumno t) {
        Collator primaryCollator = Collator.getInstance(new Locale("es"));
        primaryCollator.setStrength(Collator.PRIMARY);
        if (primaryCollator.compare(this.apellido1, t.apellido1) == 0) {
            if (primaryCollator.compare(this.apellido2, t.apellido2) == 0) {
                return primaryCollator.compare(this.nombre, t.nombre);
            }
            return primaryCollator.compare(this.apellido2, t.apellido2);
        }
        return primaryCollator.compare(this.apellido1, t.apellido1);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Modulo modulo) {
        modulos.add(modulo);
    }

}
