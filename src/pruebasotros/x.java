/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasotros;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author root
 */
public class x {
    
    
    public static void main(String args[]) {
    try {
      String line;
      //Process p = Runtime.getRuntime().exec("g++ /root/uuu.c -o mio.out ");
      Process p = Runtime.getRuntime().exec("./mio.out ");
      BufferedReader bri = new BufferedReader
        (new InputStreamReader(p.getInputStream()));
      BufferedReader bre = new BufferedReader
        (new InputStreamReader(p.getErrorStream()));
      while ((line = bri.readLine()) != null) {
        System.out.println(line);
      }
      bri.close();
      while ((line = bre.readLine()) != null) {
        System.out.println(line);
      }
      bre.close();
      p.waitFor();
      System.out.println("Done.");
    }
    catch (Exception err) {
      err.printStackTrace();
    }
  }
    
}
