/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.ferramentas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author viniciusfs.senai
 */
public class tiraRepetidor {
     public static String[] removePalavrasRepetidas(String[] vetor) {
        HashSet<String> palavrasUnicas = new HashSet<>();
        List<String> resultado = new ArrayList<>();

        for (String word : vetor) {
            if (palavrasUnicas.add(word)) {
                resultado.add(word);
            }
        }

        return resultado.toArray(new String[0]);
    }
}
