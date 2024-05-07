import connection.Conexion;
import models.Moneda;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
         /*Scanner teclado = new Scanner(System.in);
        System.out.println("Elija la pelicula de StarWars");
        System.out.println("1. A New Hope");
        System.out.println("2. The Empire Strikes Back");
        System.out.println("3. Return of the Jedi");
        System.out.println("4. The Phantom Menace");
        System.out.println("5. Attack of the Clones");
        System.out.println("6. Revenge of the Sith");
        int option= teclado.nextInt();
       switch (option){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            default: System.out.println("No se encuentra la pelicula");
        }*/
        Conexion con = new Conexion();
        System.out.println(con.convertir("EUR", "GBP", 50).conversion_result());
    }
}