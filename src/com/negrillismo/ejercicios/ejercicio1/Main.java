package com.negrillismo.ejercicios.ejercicio1;
/*
A continuación vamos a realizar un programa que, a partir de un fichero que
contiene un listado de notas de alumnos, realice la lectura de todas las notas y nos muestre en
pantalla la nota media total. Cada nota estará separada de la siguiente por una barra vertical
(“|”) y podrá tener cifras decimales, además, el conjunto total de notas puede ocupar varias
líneas dentro del archivo.

5|2.5|7|8|10|4|4.75|6.3|8
1
2.3|9.6|6.25|
4.7|
|
5.75|6
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String cadena;
        List listaNotas = new ArrayList();
        try {
            FileReader fr = new FileReader("src/ejercicio1.txt");
            BufferedReader br = new BufferedReader(fr);
            try {
                while ((cadena = br.readLine()) != null) {
                    String[] notas = cadena.split("\\|");
                    for(String nota : notas) {
                        double notaNumerica = Double.parseDouble(nota);
                        listaNotas.add(notaNumerica);
                    }
                }
                fr.close();
            }
            catch (IOException e) {
                System.out.println("No se ha podido leer el fichero.");
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("No se encuentra el fichero.");
        }
        System.out.println("Número de notas capturadas: "+listaNotas.size()); //¿16?
        System.out.println("Estas son las notas que se han sacado del fichero:");
        for(Object nota : listaNotas) {
            System.out.println(nota);
        }
        System.out.print("Aquí está la media de todas las notas: ");
        double suma = 0;
        for(Object nota : listaNotas) {
            suma += (Double)nota;
        }
        System.out.println(suma/listaNotas.size());

    }
}
