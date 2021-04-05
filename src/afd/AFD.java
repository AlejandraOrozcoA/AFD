
package afd;

import java.util.Scanner;

public class AFD {

    public static void main(String[] args) {
        LecturaTabla tbl = new LecturaTabla("src\\afd\\resources\\Pruebas.txt");
        tbl.imprimirLenguaje();
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese la cadena a verificar: ");
        String cad = in.nextLine();
        Transiciones tra = new Transiciones(tbl , cad);
    }
    
}
