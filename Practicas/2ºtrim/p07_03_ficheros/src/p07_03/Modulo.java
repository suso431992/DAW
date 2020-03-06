/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p07_03;

import java.util.Objects;

/**
 *
 * @author alumno
 */
public class Modulo {

    private String nombre;
    private String nombreCorto;
    private Double[] nota;

    public Modulo(String nombre, String nombreCorto, int numeroDeExamenes) {
        this.nombre = nombre;
        this.nombreCorto = nombreCorto;
        this.nota = new Double[numeroDeExamenes];
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nombreCorto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modulo other = (Modulo) obj;
        return this.nombreCorto.equals(other.nombreCorto);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nombreCorto
     */
    public String getNombreCorto() {
        return nombreCorto;
    }

    /**
     * @param nombreCorto the nombreCorto to set
     */
    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public Double[] getNota() {
        return nota;
    }

    public void setNota(Double[] nota) {
        this.nota = nota;
    }

    /**
     * @return the notaFinal
     */
    public Double getNotaFinal() {
        return nota[nota.length - 1];
    }

    /**
     *
     */
    public void setNotaFinal() {
        Double notaFinal = 0.0;
        for (int i = 0; i < nota.length - 2; i++) {
            notaFinal += nota[i];
        }
        notaFinal /= (nota.length - 2);
        nota[nota.length - 1] = (double) Math.round(notaFinal);
    }

    @Override
    public String toString() {
        return "nombre corto = " + nombreCorto + ", nombre completo= " + nombre + ", notas = " + nota.length;
    }
}
