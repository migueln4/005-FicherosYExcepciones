package com.negrillismo.ejercicios.ejercicio3.logica;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private AlmacenNumeros almacen;
    private int[] OPCIONES_VALIDAS = {0,1,2};
    private Scanner sc = new Scanner(System.in);

    public App() {
        this.almacen = new AlmacenNumeros();
    }

    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opcion = 0;
        do {
            System.out.println("\nElige una opción:\n"+
                    "\t1. Insertar un número"+
                    "\t2. Mostrar todos los números"+
                    "\t0. Salir");
            opcion = leerEntero();
        } while(!opcionValida(opcion));
        opcionElegida(opcion);
    }

    private void opcionElegida(int opcion) {
        switch(opcion) {
            case 1:
                insertarNumero();
                break;
            case 2:
                mostrarNumeros();
                break;
            default:
                almacen.cerrarProcesos();
                break;
        }
    }

    private void mostrarNumeros() {
        System.out.println("Estos son todos los números que contiene el documento");
        ArrayList<Integer> contenido = almacen.obtenerNumeros();
        System.out.println(contenido);
        imprimirMenu();
    }

    private void insertarNumero() {
        System.out.print("Introduce el número que quieras añadir al fichero: ");
        int n = leerEntero();
        almacen.anadirNumero(n);
        imprimirMenu();
    }

    private boolean opcionValida(int n) {
        boolean salida = false;
        for (int m : OPCIONES_VALIDAS) {
            if (n == m) {
                salida = true;
                break;
            }
        }
        return salida;
    }

    private int leerEntero() {
        return Integer.parseInt(sc.nextLine());
    }

}
