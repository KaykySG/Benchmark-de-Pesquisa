/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.ferramentas;

/**
 *
 * @author aluno
 */
public class ContatorDePalavrasERepeticoes {
    private int contVerificacoes = 0;

    public ContatorDePalavrasERepeticoes() {
    }
    
   public void contarVerificacoes(){
       contVerificacoes++;
   }

    public int getContVerificacoes() {
        return contVerificacoes;
    }

    @Override
    public String toString() {
        return  contVerificacoes + " comparações"+"\n";
    }

    
    
   
   
   
   
   
   
}
