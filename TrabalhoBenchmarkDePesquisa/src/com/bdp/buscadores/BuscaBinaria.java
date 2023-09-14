/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.buscadores;
import com.bdp.ferramentas.StopWords;
import java.util.ArrayList;
/**
 *
 * @author aluno
 */
public class BuscaBinaria {
        public static boolean BuscaBin(ArrayList<String> vetorPalavra, String x, int inicio, int fim){
        try{
        int meio;
        int i = 0;
        if(inicio > fim){
            return false;
        }
        meio = (inicio + fim)/2;
        
        if(x.length() == vetorPalavra.get(meio).length()){
            
            while (vetorPalavra.get(meio).length() == vetorPalavra.get(meio+i).length()){
                if(x.equalsIgnoreCase(vetorPalavra.get(meio+i))){
                    return true;
                }
                
                i++;
            }
            
            i = 0;
            
            while(vetorPalavra.get(meio).length() == vetorPalavra.get(meio-i).length()){
                if(x.equalsIgnoreCase(vetorPalavra.get(meio+i))){
                    return true;
                }
                
                i++;
            }
            
            
            return false;
            
        } 
        else if(x.length()<vetorPalavra.get(meio).length()){
            return (BuscaBin(vetorPalavra, x, inicio, meio-1));
        }
        else{
            return (BuscaBin(vetorPalavra, x, meio+1, fim));
        }
        
  
    }catch(Exception e){
            System.out.println(e);

}
        return false;
}
}
