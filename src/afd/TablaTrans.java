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
    
    ArrayList <String> estados = new ArrayList <String> ();
    ArrayList alfabeto = new ArrayList ();
    String dir;
    String edoAcep; 
    FileReader fr;

    public TablaTrans(String direccion) {
        this.dir = direccion;
        leerDoc(dir);
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

    public ArrayList getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(ArrayList alfabeto) {
        this.alfabeto = alfabeto;
    }

    private void leerDoc(String dir){
        try {
            File archivo = new File(dir);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader (fr);
            
            String linea;
            while((linea = br.readLine()) != null){
                System.out.println(linea);
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
