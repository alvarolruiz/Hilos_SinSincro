package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int NUMERO_VECTORES = 60;
    private static final int TAMANO_VECTOR = 1000000;
    private static final int RANGO_NUMEROS = 10000;
    public static List <int[]> listaVectores= generarListaVectores();
    public static List <Thread> listaHilos= new ArrayList<Thread>();

    public static void main(String[] args) {

        for (int i = 0; i <listaVectores.size() ; i++) {
            listaHilos.add((new Thread(new HiloCalculosVector(i+1,listaVectores.get(i)))));
        }
        establecerPriority();


        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        for(Thread hilo : listaHilos){
        if(hilo.isAlive()){
            hilo.interrupt();
        }
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
    
    public static void establecerPriority(){
        for(int i = 0; i < listaHilos.size(); i++){
            if(i<20) {
                listaHilos.get(i).setPriority(Thread.MAX_PRIORITY);
            }else if(i<40){
                listaHilos.get(i).setPriority(Thread.NORM_PRIORITY);
            }else{
                listaHilos.get(i).setPriority(Thread.MIN_PRIORITY);
            }
        }
    }

    public static void iniciarHilos(){
        for (int i = 0; i < listaHilos.size(); i++) {
            listaHilos.get(i).start();
        }
    }
}
