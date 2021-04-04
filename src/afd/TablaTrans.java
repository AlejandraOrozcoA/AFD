/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Ale
 */
public class TablaTrans {
    String dir;
    ArrayList <String> estados = new ArrayList <String> ();
    ArrayList <String> alfabeto  = new ArrayList <String> ();
    ArrayList trans = new ArrayList ();
    String edoAcep; 
    FileReader fr;

    public TablaTrans(String direccion) {
        this.dir = direccion;
        leerDoc(dir);
    }
    
    //Lee el archivo
    private void leerDoc(String dir){
        try {
            File archivo = new File(dir);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader (fr);
            
            String linea;
            int aux = 0;
            while((linea = br.readLine()) != null){
                if (aux == 0) {
                    String ar []= linea.split(",");
                    for (int i = 2; i < ar.length ; i++) {
                        alfabeto.add(ar[i]); 
                    }
                }
                else if(aux > 0){
                    String ar []= linea.split(",");
                    estados.add(ar[1]);
                    System.out.println(ar[0]);
                    if(ar[0].equals("*")){
                        edoAcep = ar[1];
                    }
                }
                
                ++aux;
            }
        }
        catch (Exception e) {
            System.out.println("No se puedo leer el archivo");
        }
        finally{
            try {
                if(null != fr ){
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }    
}
