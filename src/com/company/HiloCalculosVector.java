package com.company;

public class HiloCalculosVector implements Runnable {

    public int id;
    public int[] vector;

    public HiloCalculosVector(int id, int[] vector) {
        this.id = id;
        this.vector = vector;
    }

    @Override
    public void run() {
        System.out.println(String.format("El hilo %s tiene media: %f máximo: %d y minimo: %d",
                id, calculoMedia(), calculoMaximo(), calculoMinimo()));

    }

    public double calculoMedia() {

        double media = 0;
        for (int a : vector) {
            media += (a/(double)vector.length);
        }
        return media;
    }

    public int calculoMinimo() {
        int minimo =vector[0];
        for (int a : vector) {
            if (a < minimo) {
                minimo = a;
            }
        }
        return minimo;
    }

    public int calculoMaximo() {
        int maximo = -1;
        for (int a : vector) {
            if (a > maximo) {
                maximo = a;
            }
        }
        return maximo;
    }
}
