package colas;

import java.util.Scanner;

public class Colas {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in); 

        double lq, p, wq, w, p2, sumatoria = 0, sumatoria2, P0, L, k;

        byte opcion = 0;
        do {    
            System.out.println("\n \n \t \tMenu");
            System.out.println("Que modelo de cola desea utilizar?");
            System.out.println("1. M/M/1");
            System.out.println("2. M/M/c");
            System.out.println("3. M/M/1/k");
            System.println("4. Salir");
            opcion = lector.nextByte();

            switch(opcion){
                case 1:
                    //MM1
                    System.out.println("Ingresa los pedidos que atiende por hora(μ)?");
                    double miu = lector.nextDouble();//Pedidos atendidos por hora
                    System.out.println("Ingresa los cliente que atiende por hora(λ)?");
                    double landa = lector.nextDouble();//Clientes atendidos por hora

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

                    case 2:
                        //M/M/c
                        System.out.println("Ingresa la taza de llegada(λ)");
                        landa = lector.nextDouble();
                        System.out.println("Ingresa la taza de servicio(μ)");
                        miu = lector.nextDouble();
                        System.out.println("Ingresa c (numero de servidores)");
                        double c = lector.nextDouble();

                        //
                        p2 = landa / (c * miu);
                        //Calcular sumatorio para P0
                        for (int i = 0; i < c; i++) {
                            sumatoria += (Math.pow(landa / miu, i) / factorial (i));
                        }
                        //
                        sumatoria2 = Math.pow (landa / miu, c) / (factorial((int)c) * (1 - p2));
                        //
                        P0 = 1 / (sumatoria + sumatoria2);
                        System.out.println("P0 = " + P0);
                        //
                        lq = (P0 *Math.pow(landa / miu, c) * sumatoria2) / (factorial((int) c) * Math.pow(1- sumatoria2, 2));
                        System.out.println("Lq = " + lq);
                        //
                        L = lq+(landa / miu);
                        System.out.println("L = " + L);
                        //
                        w = L /landa;
                        System.out.println("W = " + w);
                        //
                        wq = lq / landa;
                        System.out.println("Wq = " + wq);
                        //
                        System.out.println("p = " + p2);
                        break;

                        case 3:
                            //M/M/1/k
                            System.out.println("Ingresa la taza de llegada(λ)");
                            landa = lector.nextDouble();
                            System.out.println("Ingresa la taza de servicio(μ)");
                            miu = lector.nextDouble();
                            System.out.println("Ingresa la capacidad del sistema(K)");
                            k = lector.nextDouble();
                            //
                            p2 = landa / miu;
                            //
                            if (p2 != 1){
                                p0 = (1 - p2) / (1 - Math.pow(p2, k + 1));
                            } else {
                                p0 = 1.0 / (k + 1);
                            }
                            System.out.println("P0 = " + p0);
                            //
                            L = (p2 * (1 - (k + 1) * Math.pow(p2, k)+ k * Math.pow(p2, ((1 - p2) * (1 - Math.pow(p2, k + 1 ))))));
                            System.out.println("L = " + L);
                            //
                            lamda = landa * (1 - Math.pow(p2, k) * P0);
                            //
                            w = L / lamda;
                            //
                            wq = w - (1 - miu);
                            //
                            lq = lamda /wq;
                            System.out.println("Lq = " + lq);
                            System.out.println("w = " + w);
                            System.out.println("Wq = " + wq);
                            System.out.println("p = " + p2);
                            System.out.println("λ efectivo = " + lamda);
                            break;
                    }
            } while (opcion != 4);
    }

    public static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}