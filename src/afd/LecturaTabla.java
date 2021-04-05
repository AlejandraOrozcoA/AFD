// Instituto Politécnico Nacional - ESCOM 
// Alejandra Orozco Aguilar 
// Teoría Computacional  Grupo: 2CV12
// Prof. Luna Benoso Benjamin
// Ciclo escolar 21/2

package afd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaTabla {
    private String dir;
    private ArrayList <String> estados = new ArrayList <String> ();
    private ArrayList <String> alfabeto  = new ArrayList <String> ();
    private ArrayList <ArrayList> trans = new ArrayList <ArrayList> ();
    private ArrayList <String> edoAcep = new ArrayList <String> (); 
    private String edoIni;
    private FileReader fr;
    
    public LecturaTabla(String direccion) {
        this.dir = direccion;
        leerDoc(dir);
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public ArrayList<String> getAlfabeto() {
        return alfabeto;
    }

    public ArrayList<ArrayList> getTrans() {
        return trans;
    }

    public ArrayList<String> getEdoAcep() {
        return edoAcep;
    }

    public String getEdoIni() {
        return edoIni;
    }
    
    //Lee el archivo
    private void leerDoc(String dir){
        try {
            File archivo = new File(dir);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader (fr);
            String linea;
            //Recorre el archivo
            int aux = 0;
           
            while((linea = br.readLine()) != null){
                ArrayList <String>  tr = new ArrayList <String> ();
                //Guarda el Alfabeto 
                if (aux == 0) {
                    String ar []= linea.split(",");
                    for (int i = 2; i < ar.length ; i++) {
                        alfabeto.add(ar[i]); 
                    }
                }
                //Guarda los estados
                else if(aux > 0){
                    String ar []= linea.split(",");
                    estados.add(ar[1]);
                    //Guarda el estado inicial
                    if(ar[0].equals("-") || ar[0].equals("*-") ){
                        edoIni = ar[1];
                    }
                    //Guarda el estado de aceptacion
                    if(ar[0].equals("*") || ar[0].equals("*-")){
                        edoAcep.add(ar[1]);
                    }
                    //Identifica las tansiciones de cada estado
                    for (int i = 2; i < ar.length ; i++) {
                        tr.add(ar[i]);
                        
                    }
                    trans.add(tr);
                }
                
                ++aux;
            }
        }
        catch (IOException e) {
            System.out.println("No se puedo leer el archivo");
        }
        finally{
            try {
                if(null != fr ){
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo");
            }
        }
    }
    //Imprime el Lenguaje del automata 
    public void imprimirLenguaje(){
        System.out.print("El Lenguaje de este automata es: ");
        for (int i = 0; i < alfabeto.size(); i++) {
            System.out.print(alfabeto.get(i)+ ",");
        }
        System.out.println(" ");
    }    
}
