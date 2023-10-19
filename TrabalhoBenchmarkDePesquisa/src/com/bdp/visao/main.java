/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.visao;
import com.bdp.buscadores.BuscaBinaria;
import static com.bdp.buscadores.BuscaBinaria.buscaBinaria;
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
                        
                        long inicioTemp = System.currentTimeMillis();
                        boolean encontrou = buscaBinaria(vetor, palavra);
                        if (encontrou) {
                        System.out.println("A palavra foi encontrada no vetor.");
                        } else {
                        System.out.println("A palavra não foi encontrada no vetor.");
                        }
                        long fimTemp = System.currentTimeMillis();
                }
                    if (opc == 2) {
                        long inicio = System.currentTimeMillis(); //codigo de medir o tempo
                        for (int i = 0; i < vetor.length; i++) {
                            arvAVL.insert(vetor[i]);
                        }
                        arvAVL.printAVLTree();
                long fim = System.currentTimeMillis();
                    long tempoFinal = fim-inicio;
                        System.out.println("\n"+arvAVL.getNumeroDeComparacaoAVL()+" comparações\n"+tempoFinal+" segundos");
                }
                    if (opc == 3) {
                        for (int i = 0; i < vetor.length; i++) {
                            arvB.insert(vetor[i]);
                        }
                        arvB.printAVLTree();
                }
                    
                    if (opc == 4) {
                    
                    int ordem = 0;
                   long inicioTemp = System.currentTimeMillis();
                   Scanner scanner = new Scanner(System.in);
                   System.out.println("Qual a ordem que você deseja?");
                   ordem = scanner.nextInt();
   
                    BTree bTree = new BTree(ordem);
                    
                    for (String word : vetor) {
                    bTree.insert(word);
                }
                     
                    System.out.println("Árvore B:");
                    bTree.printBTree();
                    long fim = System.currentTimeMillis();
                    long tempoFinal = fim-inicioTemp;
                    System.out.println("Tempo:"+tempoFinal);

                }
                    
                    if (opc ==5){
                long inicio = System.currentTimeMillis();
              
                
         
            String[] removePalavrasRepetidas = tiraRepetidor.removePalavrasRepetidas(vetor);
            
            
            
                for (String word : removePalavrasRepetidas) {
                tree.insertNode(word);
        }
                System.out.println("Árvore RB:");
                tree.printTree();
                long fim = System.currentTimeMillis();
                long tempoFinal = fim-inicio;
                
                System.out.println("\n"+tree.getContador()+" comparações\n"+tempoFinal+" segundos");

                
                }
                    
                System.out.println("\nfrequencia das palavras");   
                contadorRepetidas.contarPalavras();
                    
    }
    }
