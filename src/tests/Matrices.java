package tests;

import java.util.logging.Level;
import java.util.logging.Logger;
import matrices.DimensionesIncompatibles;
import matrices.Matriz;

public class Matrices {

    public static void main(String[] args) {
        Matriz m1 = new Matriz(2, 3, true);
        System.out.println(m1);
        Matriz m2 = new Matriz(3, 2, true);
        System.out.println(m2);
        try {
            //System.out.println(Matriz.sumarDosMatrices(m1, m2));
            System.out.println(Matriz.multiplicarDosMatrices(m1, m2));
        } catch (DimensionesIncompatibles ex) {
            ex.printStackTrace();
        }
        System.out.println(Matriz.invertirMatriz(m1));
    }
    
}
