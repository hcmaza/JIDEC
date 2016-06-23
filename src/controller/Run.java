/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author root
 */
public class Run {
    public String run(String filename, String path){
        try {
            
            String line;
            String salida ="";
            //Process p = Runtime.getRuntime().exec("g++ /root/uuu.c -o mio.out ");
            Process p = Runtime.getRuntime().exec(path+"/"+filename+".out");
            System.out.println("sdfsdf+++++");
            BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = bri.readLine()) != null) {
                
              salida = salida + "\n" + line;
            }
            bri.close();
            while ((line = bre.readLine()) != null) {
                
              salida = salida + "\n Error ->" + line;
            }
            bre.close();
            p.waitFor();
            salida = salida + "\n Ejecucion Finalizado \n --------------------------------------";
            System.out.println("salida " +salida);
           return salida;
        }
        catch (Exception err){
          //err.printStackTrace();
          return ""+err.getMessage();
        }
    }
    
}
