/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.ferramentas;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author aluno
 */


public class ContadorDePalavras {
    private final String[] listaDePalavras;

    public ContadorDePalavras(String[] listaDePalavras) {
        this.listaDePalavras = listaDePalavras;
    }

    public void contarPalavras() {
        Map<String, Integer> palavrasRepetidas = new HashMap<>();
        for (String palavra : listaDePalavras) {
            if (palavrasRepetidas.containsKey(palavra)) {
                palavrasRepetidas.put(palavra, palavrasRepetidas.get(palavra) + 1);
            } else {
                palavrasRepetidas.put(palavra, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : palavrasRepetidas.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}

