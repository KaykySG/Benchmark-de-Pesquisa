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
 
    public static boolean buscaBinaria(String[] vetor, String palavra) {
        Arrays.sort(vetor);
        int inicio = 0;
        int fim = vetor.length - 1;
        int contComparacao = 0;
        while (inicio <= fim) {
            
            int meio = (inicio + fim) / 2;
            int comparacao = vetor[meio].compareTo(palavra);
            System.out.println(vetor[meio]);
            System.out.println(vetor[meio].compareTo(palavra));
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
}

