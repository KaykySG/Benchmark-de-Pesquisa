/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.visao;
import com.bdp.buscadores.BuscaBinaria;
import static com.bdp.buscadores.BuscaBinaria.buscaBinaria;
import com.bdp.ferramentas.StopWords;
import java.util.Scanner;
/**
 *
 * @author ageuv
 */
    public class main { public static void main(String[] args) throws Exception {
                    StopWords spw = new StopWords();
                    String vetor[] = spw.processFile(".\\src\\com\\bdp\\dados\\textoTeste.txt");
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Digite a palavra:");
                    String palavra = sc.nextLine();
                    boolean resultado = buscaBinaria(vetor, palavra);
                                       
                       if (resultado){
                            System.out.println("Encontrado!");
                        }else{
                            System.out.println("Não encontrado!");
                            }
    }}
