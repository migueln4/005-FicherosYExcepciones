package com.negrillismo.ejercicios.ejercicio2;

/*
En este ejercicio vamos a realizar el módulo del programa de gestión de notas encargado de la
grabación de estas en el fichero.
 */

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("src/ejercicio2.txt",false);
            System.out.println("Vamos a introducir 5 notas");
            for (int i = 0; i<5; i++) {
                System.out.print("Introduce la nota número "+(i+1)+": ");
                String nota = sc.nextLine();
                fw.write(nota+"|");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("No se ha podido acceder al fichero para escribir en él.");
        }

        /*-------------------VOY A AÑADIR MÁS COSAS AL FICHERO--------*/

        try {
            FileWriter fw = new FileWriter("src/ejercicio2.txt",true);
            System.out.println("Introduce ahora otras 3 notas más");
            for(int i=0; i<3; i++) {
                System.out.println("Introduce la nota número "+(i+1)+": ");
                String nota = sc.nextLine();
                fw.write(nota+"|");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("No se ha podido acceder al fichero para escribir en él (2)");
        }

    }
}
