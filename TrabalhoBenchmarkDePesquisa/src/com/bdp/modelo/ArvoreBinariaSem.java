/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.modelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author aluno
 */
public class ArvoreBinariaSem {
    	int contComparacao = 0;
	public class Node {
	    String key;
	    int height;
	    Node left;
	    Node right;

	    Node(String key) {
	        this.key = key;
	    }
	}

    private Node root;

    public Node find(String key) {              
        Node current = root;
        int compare = current.key.compareTo(key);
        while (current != null) {
            if (current.key == key) {
               break;
            }
            current = compare < 0 ? current.right : current.left;
        }
        return current;
    }

    public void insert(String key) {
        root = insert(root, key);
    }

    public void delete(String key) {
        root = delete(root, key);
    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private Node insert(Node node, String key) {
       
        if (node == null) {
            return new Node(key);
        } 
         int compare = node.key.compareTo(key);
        if (compare > 0) {
            contComparacao += 1;
            node.left = insert(node.left, key);          
        } else if (compare < 0) {
            contComparacao += 1;
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return node;
    }

    private Node delete(Node node, String key) {
        int compare = node.key.compareTo(key);
        if (node == null) {
            return node;
        } else if (compare > 0) {
            node.left = delete(node.left, key);
        } else if (compare < 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        return node;
    }

    private Node mostLeftChild(Node node) {
        Node current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    public void printAVLTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("??");
                indent += "  ";
            } else {
                System.out.print("??");
                indent += "? ";
            }
            System.out.println(node.key);

            printAVLTree(node.left, indent, false);
            printAVLTree(node.right, indent, true);
        }
    }

    
    public void printAVLTree() {
    	printAVLTree(root, "", true);
    }

  
  public void readFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                insert(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }



