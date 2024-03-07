package org.example;

import java.util.Random;

public class EstrazioneDelLotto {
    public static void main(String[] args) {

        GeneraRuote();

    }

    public static int[] EstrazioneRuota() {

        boolean palline[] = new boolean[90];
        int estratto = 0;
        int[] listaNumeri = new int[5];
        int j = 1;

        Random random = new Random();

        for (int i = 0; i < 90; i++) {
            palline[i] = true;
        }

        while (j < 6) {
            estratto = random.nextInt(90) + 1;

            if (palline[estratto - 1]) {
                listaNumeri[j - 1] = estratto;
                palline[estratto - 1] = false;
                j = j + 1;
            }
        }
        return listaNumeri;
    }

    public static void GeneraRuote() {
        String[] listaRuote = {"-BARI      ", "-CAGLIARI  ", "-FIRENZE   ", "-GENOVA    ", "-MILANO    ", "-NAPOLI    ",
                "-PALERMO   ", "-ROMA      ", "-TORINO    ", "-VENEZIA   ", "-NAZIONALE ",};

        for (int i = 0; i < listaRuote.length; i++) {
            System.out.print(listaRuote[i]);
            Wait(1200);
            int[] numeriRuota;

            for (int j = 0; j < 5; j++) {
                numeriRuota = EstrazioneRuota();
                System.out.format("       %2d \t", numeriRuota[j]);
                Wait(1200);
            }
            System.out.println();
        }
    }

    public static void Wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
