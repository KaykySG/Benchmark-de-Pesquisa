/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.visao;
import com.bdp.buscadores.BuscaBinaria;
import com.bdp.ferramentas.StopWords;
import java.util.Scanner;
/**
 *
 * @author ageuv
 */
    public class main { public static void main(String[] args) throws Exception {
                    Scanner sc = new Scanner(System.in);
                    String palavra = sc.nextLine();
                    String vetor[] = null;
                       if (BuscaBinaria.BuscaBin(vetor, palavra, 0, vetor[vetor.length-1].length())){
                            System.out.println("Encontrado!");
                        }else{
                            System.out.println("Não encontrado!");
                            }
    }}
