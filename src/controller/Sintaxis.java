/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author root
 */
public class Sintaxis {
    
    public Sintaxis(){
        
    }
    
    public String ControllSintaxis(String str){
        switch(str){
                case "(" :
                    str = str + ")";
                    break;
                case "[" :
                    str = str + "]";
                    break;
                case "\"" :
                    str = str + "\"";
                    break;
                case "{" :
                    str = str + "\n}";
                    break;
                    
            }
        return str;
                
    }
    
    
    
}
