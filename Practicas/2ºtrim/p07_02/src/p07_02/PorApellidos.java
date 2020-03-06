/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p07_02;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author MrNobody
 */
public class PorApellidos implements Comparator<Alumno>{
    private final Collator primaryCollator = Collator.getInstance(new Locale("es"));
    @Override
    public int compare(Alumno arg0, Alumno arg1) {
        primaryCollator.setStrength(Collator.PRIMARY);
        if (primaryCollator.compare(arg0.getApellido1(), arg1.getApellido1())==0) {
            if (primaryCollator.compare(arg0.getApellido2(), arg1.getApellido2())==0) {
                return primaryCollator.compare(arg0.getNombre(), arg1.getNombre());
            }
            return primaryCollator.compare(arg0.getApellido2(), arg1.getApellido2());
        }
        return primaryCollator.compare(arg0.getApellido1(), arg1.getApellido1());
    }
    
}
