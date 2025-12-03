package colas;

import java.util.Scanner;

public class Colas {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in); 

        double lq, p, wq, w;

        byte opcion = 0;
        do {    

            System.out.println("\n \n \t \tMenu");
            System.out.println("Que modelo de cola desea utilizar?");
            System.out.println("1. M/M/1");
            System.println("4. Salir");
            opcion = lector.nextByte();

            switch(opcion){
                case 1:
                    //MM1
                    System.out.println("Cuantos pedidos atiende por hora?");
                    int miu = lector.nextDouble();//Pedidos atendidos por hora
                    System.out.println("Cuantos cliente atiende por hora?");
                    int landa = lector.nextDouble();//Clientes atendidos por hora

                    //Utilizacion de sistema
                    p = landa /miu;
                    System.out.println("P =" + p);

                    //Numero de promedio de cliente en la cola
                    lq = (Math.pow(landa, 2)) / ((miu) * (miu -landa));
                    System.out.println("Lq = " + lq);

                    //Tiempo promedio de espera en la colaa
                    wq = lq /landa;
                    System.out.println("Wq = " + wq + " hrs");

                    //Tiempo total en el sistema
                    w = wq + (1/miu);
                    System.out.println("W = "+ w + " hrs");

                    break;
            } 
        } while (opcion != 4);
    }
}