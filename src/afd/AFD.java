// Instituto Politécnico Nacional - ESCOM 
// Alejandra Orozco Aguilar 
// Teoría Computacional  Grupo: 2CV12
// Prof. Luna Benoso Benjamin
// Ciclo escolar 21/2

package afd;

import java.util.Scanner;

public class AFD {

    public static void main(String[] args) {
        LecturaTabla tbl = new LecturaTabla("src\\afd\\resources\\Ej3.txt");
        tbl.imprimirLenguaje();
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese la cadena a verificar: ");
        String cad = in.nextLine();
        Transiciones tra = new Transiciones(tbl , cad);
    }
    
}
