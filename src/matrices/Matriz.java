/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matrices;

import java.awt.Dimension;
import java.util.Random;

/**
 *
 * @author galvez
 */
public class Matriz {
    private int[][]datos;
    private Random rnd = new Random();
    
    public Matriz(int filas, int columnas, boolean inicializarAleatorio){
        datos = new int[filas][];
        for(int i=0; i<filas; i++){
            datos[i] = new int[columnas];
            if (inicializarAleatorio)
                for(int j=0; j<columnas; j++)
                    datos[i][j] = rnd.nextInt(100);
        }
    }
    public Matriz(Dimension d, boolean inicializarAleatorio){
        this(d.height, d.width, inicializarAleatorio);
    }
    
    public Dimension getDimension(){
        //return new Dimension(datos.length, datos[0].length);
        return new Dimension(datos[0].length, datos.length);
    }
    
    public static Matriz sumarDosMatrices(Matriz a, Matriz b) throws DimensionesIncompatibles { 
        if(! a.getDimension().equals(b.getDimension())) throw new DimensionesIncompatibles("La suma de matrices requiere matrices de las mismas dimensiones");        
        int i, j, filasA, columnasA; 
        filasA = a.getDimension().height; 
        columnasA = a.getDimension().width; 
        Matriz matrizResultante = new Matriz(filasA, columnasA, false);
        for (i = 0; i < filasA; i++) { 
            for (j = 0; j < columnasA; j++) { 
                matrizResultante.datos[i][j] += a.datos[i][j] + b.datos[i][j]; 
            } 
        } 
        return matrizResultante;
    } 

<<<<<<< .merge_file_pgftcZ
    
    public static Matriz invertirMatriz(Matriz a){ 
        int i, j, filasA, columnasA; 
        filasA = a.getDimension().height; 
        columnasA = a.getDimension().width; 
        Matriz matrizResultante = new Matriz(columnasA, filasA, false);
        for (i = 0; i < filasA; i++) { 
            for (j = 0; j < columnasA; j++) { 
                matrizResultante.datos[j][i] += a.datos[i][j]; 
            } 
        } 
        return matrizResultante;
    } 

    
    
=======
    public static Matriz multiplicarDosMatrices(Matriz a, Matriz b) throws DimensionesIncompatibles { 
        int i, j, k, filasA, columnasA, filasB, columnasB; 
        filasA = a.getDimension().height; 
        columnasA = a.getDimension().width; 
        filasB = b.getDimension().height; 
        columnasB = b.getDimension().width;
        if(columnasA!=filasB) throw new DimensionesIncompatibles("El producto de matrices requiere que la primera sea de tamaño nxp y la segunda pxm.");        
        
        Matriz matrizResultante = new Matriz(filasA, columnasB, false);
        for (k = 0; k < columnasB; k++) { 
            for (i = 0; i < filasA; i++) { 
                for (j = 0; j < columnasA; j++) { 
                    matrizResultante.datos[i][k] += a.datos[i][j] * b.datos[j][k]; 
                } 
            } 
        }
        return matrizResultante;
    } 

>>>>>>> .merge_file_QjB42Y
    @Override
    public String toString(){
        String ret = "";
        ret += "[\n";
        int i, j;
        for (i=0; i<getDimension().height; i++){
            ret += "(";
            for ( j = 0; j < getDimension().width; j++) {                     
                ret += String.format("%3d", datos[i][j]); 
                if (j<getDimension().width-1) ret += ",";
            }
            ret += ")";
            if (i < getDimension().width - 1) ret += ",";
            ret += "\n";
        }
        
        ret += "]\n";
        //ret += String.format("%3d", datos[0][2]); 
        return ret;
    }
}
