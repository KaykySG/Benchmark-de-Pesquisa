/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.buscadores;

import java.util.ArrayList;

/**
 *
 * @author ageuv
 */
public class BuscaBinaria {
        public static boolean BuscaBin(String[] texto, String x, int inicio, int fim){
        try{
        int meio;
        int i = 0;
        if(inicio > fim){
            return false;
        }
        meio = (inicio + fim)/2;
        
        if(x.length() == texto[meio].length()){
            
            while (texto[meio].length() == texto[meio+i].length()){
                if(x.equalsIgnoreCase(texto[meio+i])){
                    return true;
                }
                
                i++;
            }
            
            i = 0;
            
            while(texto[meio].length() == texto[meio-i].length()){
                if(x.equalsIgnoreCase(texto[meio+i])){
                    return true;
                }
                
                i++;
            }
            
            
            return false;
            
        } 
        else if(x.length()<texto[meio].length()){
            return (BuscaBin(texto, x, inicio, meio-1));
        }
        else{
            return (BuscaBin(texto, x, meio+1, fim));
        }
        
  
    }catch(Exception e){
            System.out.println(e);

}
        return false;
}
}

