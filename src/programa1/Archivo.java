/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programa1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Denisse Velecela
 */
public class Archivo {

    

    public static void crearArchivo(String archivo1, String msg) {
        try {
            File archivo = new File(archivo1);
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write(msg);
            escribir.close();
        } catch (IOException e) {
            System.out.println("Error al escribir");
        }
    }

    
   


  

    public static int getSizeFile(String archivo1) { ///// LECTURA EXTERNA
        int i = 0;

        try {
            String texto = "";
            FileReader lector = new FileReader(archivo1);
            BufferedReader contenido = new BufferedReader(lector);
            while ((texto = contenido.readLine()) != null) {

                i++;
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer ");
        }
        return i;
    }

    

    public static Persona descomponerDatos(String valor) {
        String letra[] = new String[valor.length()];
        Persona objeto = new Persona();
        String conca = "";
        int c = 0;
        for (int i = 0; i < letra.length; i++) {
            letra[i] = String.valueOf(valor.charAt(i));
            if ("¬".equals(String.valueOf(valor.charAt(i))) || "�".equals(String.valueOf(valor.charAt(i)))) {
                
                if (c == 0) {
                    objeto.setCodigo(conca);
                    conca = "";
                }
                if (c == 1) {
                    objeto.setNombre(conca); 
                    conca = "";
                }
                if (c == 2) {
                    objeto.setApellido(conca); 
                    conca = "";
                }
                if (c == 3) {
                    objeto.setTelefono(conca); 
                    conca = "";
                }
                if (c == 4) {
                   

                        objeto.setEmail(conca);  
                     conca = "";
                }
                if (c == 5) {
                    objeto.setDireccion(conca);
                    conca = "";
                }
                 
                c++;
            } else {
                conca = conca + letra[i];
            }
        }
        return objeto;
    }

    ////////////////////////*********************************** ARREGLOS
    public static Persona[] readDataArray(String archivo1) { ///// LECTURA EXTERNA
        Persona lista[] = new Persona[getSizeFile(archivo1)];
        String text = "";
        int i = 0;
        try {
            String texto = " ";
            FileReader lector = new FileReader(archivo1);
            BufferedReader contenido = new BufferedReader(lector);
            while ((texto = contenido.readLine()) != null) {
                text = text + texto + "\n";
                lista[i] = descomponerDatos(texto);
                i++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer ");
        }
        return lista;
    }

    
}
