package com.negrillismo.ejercicios.ejercicio3.logica;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlmacenNumeros {

    private File fichero;
    private FileReader fr;
    private BufferedReader br;
    private FileWriter fw;

    public AlmacenNumeros() {
        arrancarProcesos();
    }

    private void arrancarProcesos() {
        this.fichero = new File("src/ejercicio3.txt");
        try {
            if (!this.fichero.exists())
                this.fichero.createNewFile();
            this.fr = new FileReader(fichero);
            this.br = new BufferedReader(fr);
            this.fw = new FileWriter(fichero,true);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public boolean anadirNumero(int n) {
        boolean salida = false;
        try {
            this.fw.write(String.valueOf(n));
            this.fw.append(';');
            this.fw.flush();
            salida = true;
        }catch(IOException e) {
            e.printStackTrace();
        } finally {
            return salida;
        }
    }

    public ArrayList<Integer> obtenerNumeros() {
        List<Integer> salida = null;
//Esto es lo que tiene hecho Gustavo. No casca, pero tampoco funciona imprimiendo todo.
            salida = br.lines()
                    .flatMap(cadena -> Arrays.asList(cadena.split(";"))
                    .stream()
                    .map(dato -> Integer.parseInt(dato)))
                    .collect(Collectors.toList());
        return (ArrayList<Integer>) salida;
    }

    public void cerrarProcesos() {
        try {
            this.fr.close();
            this.br.close();
            this.fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
