
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
        //probarCadena();
    } 

    private void probarCadena() {
        String estadoAct = edoIni;
        
    }
}
