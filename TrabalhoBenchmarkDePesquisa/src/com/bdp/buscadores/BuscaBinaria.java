/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.buscadores;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ageuv
 */

    
public class BuscaBinaria {
    private int contComparacao = 0;

    public BuscaBinaria() {
    }
    
    
    public boolean buscaBinaria(String[] vetor, String palavra) {
        
        Arrays.sort(vetor);
        
        
//        System.out.println(Arrays.toString(vetor));
        
        System.out.println("a palavra que está sendo procurada é " + palavra);
        int inicio = 0;
        int meio = 0;
        int fim = vetor.length - 1;
        
        while (inicio <= fim) {
            
            meio = (fim + inicio) / 2;
            int comparacao = vetor[meio].compareTo(palavra);

            if (comparacao == 0) {
                contComparacao += 1;
                return true;               
            } else if (comparacao < 0) {
                contComparacao += 1;
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return false;
    }

    public int getContComparacao() {
        return contComparacao;
    }
    
    
}