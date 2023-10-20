/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.visao;
import com.bdp.buscadores.BuscaBinaria;
import com.bdp.ferramentas.ContadorDePalavras;
import com.bdp.ferramentas.StopWords;
import com.bdp.ferramentas.tiraRepetidor;
import com.bdp.modelo.ArvoreAVL;
import com.bdp.modelo.ArvoreBinariaSem;
import java.util.Scanner;
import com.bdp.modelo.*;

/**
 *
 * @author ageuv
 */
    public class main { public static void main(String[] args) throws Exception {
                    
                    
        
        
                    StopWords spw = new StopWords();
                    String vetor[] = spw.processFile(".\\src\\com\\bdp\\dados\\textoTeste.txt");
                    ContadorDePalavras contadorRepetidas = new ContadorDePalavras(vetor);
                    ArvoreAVL arvAVL = new ArvoreAVL();
                    ArvoreBinariaSem arvB = new ArvoreBinariaSem();
                    BuscaBinaria buscaBi = new BuscaBinaria();
                    

                    RedBlackTree tree = new RedBlackTree();
                    
                    Scanner sc = new Scanner(System.in);
                    
                    
                    System.out.println("Escolha o tipo de busca:\n"
                                     + "(1)Busca Binária\n"
                                     + "(2)Árvore AVL\n"
                                     + "(3)Árvore Binária sem balanceamento\n"
                                     + "(4)Árvore B\n"
                                     + "(5) Árvore Rubro-negra");
                    
                    int opc = sc.nextInt();
                    
                    if (opc == 1) {
                        System.out.println("Digite a palavra que deseja procurar:");
                        sc.nextLine();
                        String palavra = sc.nextLine();
                        
                        palavra = palavra.toLowerCase();
                        
                        double inicioTemp = System.currentTimeMillis();
                        boolean encontrou = buscaBi.buscaBinaria(vetor, palavra);
                        if (encontrou) {
                        System.out.println("A palavra foi encontrada no vetor.");
                        } else {
                        System.out.println("A palavra não foi encontrada no vetor.");
                        }
                        double fimTemp = System.currentTimeMillis();
                        System.out.println("\n"+buscaBi.getContComparacao()+" comparações\n"+ (fimTemp - inicioTemp)/1000+" segundos");
                }
                    if (opc == 2) {
                        double inicio = System.currentTimeMillis(); //codigo de medir o tempo
                        for (int i = 0; i < vetor.length; i++) {
                            arvAVL.insert(vetor[i]);
                        }
                        arvAVL.printAVLTree();
                        double fim = System.currentTimeMillis();
                        double tempoFinal = (fim-inicio)/1000;
                        System.out.println("\n"+arvAVL.getNumeroDeComparacaoAVL()+" comparações\n"+tempoFinal+" segundos");
                }
                    if (opc == 3) {
                        double inicio = System.currentTimeMillis();
                        for (int i = 0; i < vetor.length; i++) {
                            arvB.insert(vetor[i]);
                        }
                        double fim = System.currentTimeMillis();
                        double tempoFinal = (fim-inicio)/1000;
                        
                        arvB.printAVLTree();
                        
                        System.out.println("\n"+arvB.getContComparacao()+" comparações\n"+tempoFinal+" segundos");
                }
                    
                    if (opc == 4) {
                    
                    int ordem = 0;
                   double inicioTemp = System.currentTimeMillis();
                   Scanner scanner = new Scanner(System.in);
                   System.out.println("Qual a ordem que você deseja?");
                   ordem = scanner.nextInt();
   
                    BTree bTree = new BTree(ordem);
                    
                    for (String word : vetor) {
                    bTree.insert(word);
                }
                     
                    System.out.println("Árvore B:");
                    bTree.printBTree();
                    double fim = System.currentTimeMillis();
                    double tempoFinal = (fim-inicioTemp)/1000.0;
                    
                    System.out.println("\n"+bTree.getContConparador()+" comparações\n"+tempoFinal+" segundos");

                }
                    
                    if (opc ==5){
                double inicio = System.currentTimeMillis();
              
                
         
            String[] removePalavrasRepetidas = tiraRepetidor.removePalavrasRepetidas(vetor);
            
            
            
                for (String word : removePalavrasRepetidas) {
                tree.insertNode(word);
        }
                System.out.println("Árvore RB:");
                tree.printTree();
                double fim = System.currentTimeMillis();
                double tempoFinal = (fim-inicio)/1000;
                
                System.out.println("\n"+tree.getContador()+" comparações\n"+tempoFinal+" segundos");

                
                }
                    
                System.out.println("\nfrequencia das palavras");   
                contadorRepetidas.contarPalavras();
                    
    }
    }
