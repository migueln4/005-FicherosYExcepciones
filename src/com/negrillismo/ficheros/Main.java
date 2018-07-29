package com.negrillismo.ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("src/fichero.txt");
            BufferedReader br = new BufferedReader(fr);
            String lineaFichero;
            try {
                while ((lineaFichero = br.readLine()) != null) {
                    System.out.println(lineaFichero);
                }
            }
            catch (IOException excepcionIO) {
                System.out.println("No se ha podido acceder al fichero.");
            }
        }
        catch(FileNotFoundException excepcion) {
            System.out.println("Fichero no encontrado.");
        }

    }
}
