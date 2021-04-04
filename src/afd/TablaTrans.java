
package afd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class TablaTrans {
    String dir;
    ArrayList <String> estados = new ArrayList <String> ();
    ArrayList <String> alfabeto  = new ArrayList <String> ();
    ArrayList <ArrayList> trans = new ArrayList <ArrayList> ();
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
                    //Guarda el estado de aceptacion
                    if(ar[0].equals("*")){
                        edoAcep = ar[1];
                    }
                    //Identifica las tansiciones de cada estado
                    for (int i = 2; i < ar.length ; i++) {
                        tr.add(ar[i]);
                        
                    }
                    trans.add(tr);
                    //tr.clear();
                }
                
                ++aux;
            }
            imprimirTrans();
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
                System.out.println("Error al cerrar el archivo");
            }
        }
    }    

    private void imprimirTrans() {
        for (int i = 0; i < estados.size() ; i++) {
            System.out.println("Estado: "+ estados.get(i));
            for (int j = 0; j < trans.size() ; j++) {
                System.out.println("Si: "+alfabeto.get(j)+" pasa a: "+ trans.get(i).get(j));
            }
        }
    }
}
