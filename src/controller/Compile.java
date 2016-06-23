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
public class Compile {
    public String compile(String file, String filename, String path ){
        try {
            
            String line;
            String salida ="";
            //Process p = Runtime.getRuntime().exec("g++ "+file+" -o "+path+"/"+filename+".out ");
            Process p = Runtime.getRuntime().exec("make -C /opt/picoCIAA -f Makefile");
           
            
            //Process p = Runtime.getRuntime().exec("./mio.out ");
            BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = bri.readLine()) != null) {
              salida = salida + "\n" + line;
            }
            bri.close();
            while ((line = bre.readLine()) != null) {
              //System.out.println(line);
               salida = salida + "\n Salida ->" + line;
            }
            bre.close();
            p.waitFor();
            salida = salida + "\n Finalizado \n ---------------------------------------";
           return salida;
        }
        catch (Exception err){
          //err.printStackTrace();
          return ""+err.getMessage();
        }
    }
}

