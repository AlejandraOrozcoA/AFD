
package afd;

import java.util.Scanner;

public class AFD {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese la cadena a verificar: ");
        String cad = in.nextLine();
        Transiciones tra = new Transiciones("src\\afd\\resources\\Pruebas.txt", cad);
        
    }
    
}
