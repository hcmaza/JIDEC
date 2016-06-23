/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author root
 */
public class Configuracion {

    public Configuracion() {
    }
    
    public String leerPropiedad(String propiedad){
        Properties propiedades = new Properties();
    InputStream entrada = null;

    try {

        entrada = new FileInputStream("configuracion.properties");

        // cargamos el archivo de propiedades
        propiedades.load(entrada);

        // obtenemos las propiedades y las imprimimos
        return propiedades.getProperty("pathcompilador");
       

    } catch (IOException ex) {
       
        System.out.println("Error al leer la propiedad de configuracion "+ex);
         return null;
       
    } finally {
        if (entrada != null) {
            try {
                entrada.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo de configuracion "+e);
            }
        }
    }
    }
    
    
    public void escribirPropiedad(String propiedad, String valor){
        Properties propiedades = new Properties();
    OutputStream salida = null;

    try {
        salida = new FileOutputStream("configuracion.properties");

        // asignamos los valores a las propiedades
        propiedades.setProperty(propiedad, valor);
      

        // guardamos el archivo de propiedades en la carpeta de aplicación
        propiedades.store(salida, null);

    } catch (IOException io) {
        System.out.println("Eror al escribir propiedad/valor en el archivo de configuracion " + io);
    } finally {
        if (salida != null) {
            try {
                salida.close();
            } catch (IOException e) {
                System.out.println("Eroor al cerrar el archivo de configuracion(Escritura) "+ e);
            }
        }

    }
  }
    
    
    
}
