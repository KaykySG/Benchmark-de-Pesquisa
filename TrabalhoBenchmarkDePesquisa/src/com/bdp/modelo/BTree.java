/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.modelo;

/**
 *
 * @author viniciusfs.senai
 */
import java.util.ArrayList;
import java.util.List;

class BTreeNode {
    List<String> keys;           // Lista de palavras armazenadas no nó
    List<BTreeNode> children;    // Lista de filhos do nó
    boolean leaf;                // Indica se o nó é uma folha

    // Construtor para criar um novo nó
    BTreeNode(boolean leaf) {
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
        this.leaf = leaf;
    }
}

public class BTree {
    private BTreeNode root;  // Raiz da árvore B
    private int t;           // Grau mínimo da árvore

    // Construtor para criar uma nova árvore B
    public BTree(int t) {
        this.t = t;
        this.root = new BTreeNode(true);  // Inicializa a raiz como uma folha
    }

    // Método para inserir uma palavra na árvore B
    public void insert(String word) {
        BTreeNode r = root;
        // Se a raiz estiver cheia, divide-a
        if (r.keys.size() == 2 * t - 1) {
            BTreeNode s = new BTreeNode(false);  // Cria um novo nó interno
            root = s;  // Atualiza a raiz para o novo nó interno
            s.children.add(r);  // Adiciona o nó cheio como filho do novo nó interno
            splitChild(s, 0);   // Divide o filho (nó cheio)
            insertNonFull(s, word);  // Insere a palavra no nó interno não cheio
        } else {
            insertNonFull(r, word);  // Insere a palavra no nó não cheio
        }
    }

    // Método auxiliar para inserção em um nó não cheio
    private void insertNonFull(BTreeNode x, String word) {
        int i = x.keys.size() - 1;

        if (x.leaf) {  // Se x é uma folha
            // Encontre a posição correta para a palavra e insira-a
            while (i >= 0 && word.compareTo(x.keys.get(i)) < 0) {
                i--;
            }
            x.keys.add(i + 1, word);
        } else {  // Se x é um nó interno
            // Encontre o filho apropriado para a palavra e insira-a recursivamente
            while (i >= 0 && word.compareTo(x.keys.get(i)) < 0) {
                i--;
            }
            i++;

            // Se o filho está cheio, divida-o antes de continuar a inserção
            if (x.children.get(i).keys.size() == 2 * t - 1) {
                splitChild(x, i);
                if (word.compareTo(x.keys.get(i)) > 0) {
                    i++;
                }
            }

            insertNonFull(x.children.get(i), word);
        }
    }

    // Método auxiliar para dividir um filho de um nó
    private void splitChild(BTreeNode x, int i) {
        BTreeNode y = x.children.get(i);
        BTreeNode z = new BTreeNode(y.leaf);

        // Move a palavra do meio de y para x
        x.keys.add(i, y.keys.get(t - 1));
        // Adiciona o novo filho z de y como filho de x
        x.children.add(i + 1, z);

        // Move as palavras da metade superior de y para z
        z.keys.addAll(y.keys.subList(t, 2 * t - 1));
        y.keys.subList(t - 1, 2 * t - 1).clear();

        // Se y não é uma folha, move os filhos correspondentes de y para z
        if (!y.leaf) {
            z.children.addAll(y.children.subList(t, 2 * t));
            y.children.subList(t, 2 * t).clear();
        }
    }

    // Método para verificar se uma palavra está presente na árvore B
    public boolean search(String word) {
        return search(root, word);
    }

    // Método auxiliar de busca
    private boolean search(BTreeNode x, String word) {
        int i = 0;
        // Encontre a posição correta para a palavra em x
        while (i < x.keys.size() && word.compareTo(x.keys.get(i)) > 0) {
            i++;
        }
        // Se a palavra foi encontrada, retorne true
        if (i < x.keys.size() && word.equals(x.keys.get(i))) {
            return true;
        } else if (x.leaf) {  // Se x é uma folha e a palavra não foi encontrada
            return false;
        } else {
            return search(x.children.get(i), word);
        }
    }

    // Método para imprimir a árvore B (percurso em ordem)
    // Novo método printBTree

    // Método para imprimir a árvore B (percurso em ordem)
    public void printBTree() {
        if (root == null) {
            System.out.println("A árvore está vazia.");
            return;
        }

        printBTree(root, 0);
    }

    private void printBTree(BTreeNode node, int level) {
        if (node == null) {
            return;
        }

        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("    "); // Use quatro espaços por nível
        }

        System.out.print(indent.toString());

        if (node.leaf) {
            System.out.print("L: ");
            System.out.println(String.join(", ", node.keys));
        } else {
            for (int i = 0; i < node.keys.size(); i++) {
                if (i != 0) {
                    System.out.print(" | ");
                }
                System.out.print("[" + node.keys.get(i) + "]");
            }
            System.out.println();

            for (int i = 0; i <= node.keys.size(); i++) {
                if (i < node.children.size()) {
                    System.out.print(indent.toString() + "  Child " + i + ": ");
                }
                printBTree(node.children.get(i), level + 1);
            }
        }
    }
    
      
    
}
