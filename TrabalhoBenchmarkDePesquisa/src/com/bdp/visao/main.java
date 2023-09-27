/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.visao;
import com.bdp.buscadores.BuscaBinaria;
import static com.bdp.buscadores.BuscaBinaria.buscaBinaria;
import com.bdp.ferramentas.StopWords;
import com.bdp.modelo.ArvoreAVL;
import com.bdp.modelo.ArvoreBinariaSem;
import java.util.Scanner;
/**
 *
 * @author ageuv
 */
    public class main { public static void main(String[] args) throws Exception {
                    StopWords spw = new StopWords();
                    String vetor[] = spw.processFile(".\\src\\com\\bdp\\dados\\textoTeste.txt");
                    ArvoreAVL arvAVL = new ArvoreAVL();
                    ArvoreBinariaSem arvB = new ArvoreBinariaSem();
                    
                    Scanner sc = new Scanner(System.in);
                    
                    
                    System.out.println("Escolha o tipo de busca:\n"
                                     + "(1)Busca Binária\n"
                                     + "(2)Árvore AVL\n"
                                     + "(3)Árvore Binária sem balanceamento");
                    
                    int opc = sc.nextInt();
                    
                    if (opc == 1) {
                        System.out.println("Digite a palavra que deseja procurar:");
                        String palavra = sc.nextLine();
                        sc.nextLine();
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
                        for (int i = 0; i < vetor.length; i++) {
                            arvAVL.insert(vetor[i]);
                        }
                        arvAVL.printAVLTree();
                //long fim = System.currentTimeMillis();
                    
                }
                    if (opc == 3) {
                        for (int i = 0; i < vetor.length; i++) {
                            arvB.insert(vetor[i]);
                        }
                        arvB.printAVLTree();
                }
    }
    }
