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
                    int opc = 0;
                    System.out.println("Escolha o tipo de busca:\n"
                                     + "(1)Busca Binária\n"
                                     + "(2)Árvore Binária sem balanceamento\n"
                                     + "(3)Árvore AVL");
                    if (opc == 1) {
                        System.out.println("Digite a palavra que deseja procurar:");
                        String palavra = sc.nextLine();
                        long inicio = System.currentTimeMillis();
                    boolean resultado = buscaBinaria(vetor, palavra);
                                       
                       if (resultado){
                            System.out.println("Encontrado!");
                        }else{
                            System.out.println("Não encontrado!");
                            }
                        long fim = System.currentTimeMillis();
                }
                    if (opc == 2) {
                //long inicio = System.currentTimeMillis();    //codigo de medir o tempo
                //long fim = System.currentTimeMillis();
                
                }
                    if (opc == 3) {
                    
                }
    }
    }
