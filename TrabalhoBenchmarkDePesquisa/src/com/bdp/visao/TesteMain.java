/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.visao;

import com.bdp.modelo.ArvoreAVL;

/**
 *
 * @author aluno
 */
public class TesteMain {
    public static void main(String[] args) {
        // TODO code application logic here
         ArvoreAVL arvore = new ArvoreAVL();
        String str1 = "banana";
        String str2 = "abacaxi";
        int result = str1.compareTo(str2);
        if (result < 0) {
            System.out.println(str1 + " vem antes de " + str2 + " em ordem alfabética");
        } else if (result == 0) {
            System.out.println(str1 + " e " + str2 + " s?o iguais em ordem alfabética");
        } else {
            System.out.println(str1 + " vem depois de " + str2 + " em ordem alfabética");
        }
      
    
        arvore.insert("banana");
        arvore.insert("abacaxi");
      
        arvore.printAVLTree();
        
        
        
        System.out.println("O número de comparações foi de: "+arvore.getNumeroDeComparacaoAVL());
    }
}
