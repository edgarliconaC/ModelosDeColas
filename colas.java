package colas;

import java.util.Scanner;

public class Colas {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in); 

        double lq, p, wq, w;

        byte opcion = 0;
        do {    

            System.out.println("Menu");
            System.out.println("Que modelo de cola desea utilizar?");
            System.out.println("1. M/M/1");
            opcion = lector.nextByte();

            switch(opcion){
                case 1:
                    //MM!
                    System.out.println("Cuantos pedidos atiende por hora?");
                    int miu = lector.nextDouble();//Pedidos atendidos por hora
                    System.out.println("Cuantos cliente atiende por hora?");
                    int landa = lector.nextDouble();//Clientes atendidos por hora

                    //Utilizacion de sistema
                    p = landa /miu;
                    System.out.println("P ="+ p);





                    break;
            }

            
        } while (opcion != 5);
    }

}