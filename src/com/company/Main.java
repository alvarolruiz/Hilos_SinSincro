package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int NUMERO_VECTORES = 20;
    private static final int TAMANO_VECTOR = 1000000;
    private static final int RANGO_NUMEROS = 10000;
    public static List <int[]> listaVectores= generarListaVectores();
    public static List <Thread> listaHilos= new ArrayList<Thread>();

    public static void main(String[] args) {

        for (int i = 0; i <listaVectores.size() ; i++) {
            listaHilos.add((new Thread(new HiloCalculosVector(i+1,listaVectores.get(i)))));

        }
        Thread.sleep(100);


        for (int i = 0; i < listaHilos.size(); i++) {
            listaHilos.get(i).start();
        }


    }

    public static int[] generarVectorAleatorio(){
        int[]array= new int[TAMANO_VECTOR];
        Random aleatorio = new Random();
        for (int i = 0; i < array.length ; i++) {
            array[i]=aleatorio.nextInt(RANGO_NUMEROS+1);
        }
        return array;
    }
    
    public static List<int []> generarListaVectores(){
        List <int[]> listaVectores= new ArrayList<int[]>();
        for (int i = 0; i < NUMERO_VECTORES; i++) {
            listaVectores.add(generarVectorAleatorio());
        }
        return listaVectores;
    }
}
