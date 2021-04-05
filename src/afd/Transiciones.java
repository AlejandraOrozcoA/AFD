
package afd;

import java.util.ArrayList;


public class Transiciones {
    private ArrayList <String> estados = new ArrayList <String> ();
    private ArrayList <String> alfabeto  = new ArrayList <String> ();
    private ArrayList <ArrayList> trans = new ArrayList <ArrayList> ();
    private String edoAcep; 
    private String edoIni;
    private String cadena;

    public Transiciones(String dir, String cadena) {
        LecturaTabla tbl = new LecturaTabla("src\\afd\\resources\\Pruebas.txt");
        this.estados = tbl.getEstados();
        this.alfabeto = tbl.getAlfabeto();
        this.trans = tbl.getTrans();
        this.edoAcep = tbl.getEdoAcep();
        this.edoIni = tbl.getEdoIni();
        this.cadena = cadena;
        probarCadena(cadena);
    } 

    private void probarCadena(String cadena) {
        String estadoAct = edoIni;  
        for (int i = 0; i < cadena.length() ; i++) {
            for (int j = 0; j < trans.get(estados.indexOf(estadoAct)).size() ; j++) {
               
                if (String.valueOf(cadena.charAt(i)).equals(alfabeto.get(j))) {
                    estadoAct = trans.get(estados.indexOf(estadoAct)).get(alfabeto.indexOf(alfabeto.get(j))).toString();
                    System.out.println(estadoAct);
                }
            }
        }
        if (estadoAct.equals(edoAcep)) {
            System.out.println("La cadena es aceptada");
        }else{
            System.out.println("La cadena no es aceptada");
        }

    }
}
