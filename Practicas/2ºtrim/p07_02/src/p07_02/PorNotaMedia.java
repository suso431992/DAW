/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p07_02;

import java.util.Comparator;

/**
 *
 * @author alumno
 */
public class PorNotaMedia implements Comparator<Alumno> {

    @Override
    public int compare(Alumno t, Alumno t1) {
        return  t.getNotaMediaModulos().compareTo(t1.getNotaMediaModulos());
    }

}
