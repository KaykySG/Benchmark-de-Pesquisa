/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.modelo;

/**
 *
 * @author aluno
 */
public class ArvoreAVL {
    	private int numeroDeComparacaoAVL = 0;
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
        //colocar contador de tempo
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
       //colocar contador de tempo
        if (node == null) {
            numeroDeComparacaoAVL++;
            return new Node(key);
        } 
         int compare = node.key.compareTo(key);
        if (compare > 0) {
            node.left = insert(node.left, key);
            numeroDeComparacaoAVL++;
        } else if (compare < 0) {
            node.right = insert(node.right, key);
            numeroDeComparacaoAVL++;
        } else {
            numeroDeComparacaoAVL++;
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    private Node delete(Node node, String key) {
        //colocar contador de tempo
        if (node == null) {
            numeroDeComparacaoAVL++;
            return node;
        } 
        int compare = node.key.compareTo(key);
        if (compare > 0) {
            node.left = delete(node.left, key);
            numeroDeComparacaoAVL++;
        } else if (compare < 0) {
            node.right = delete(node.right, key);
            numeroDeComparacaoAVL++;
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
                numeroDeComparacaoAVL++;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
                numeroDeComparacaoAVL++;
            }
        }
        if (node != null) {
            node = rebalance(node);
            numeroDeComparacaoAVL++;
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

    private Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }
    
    public void printAVLTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("└─");
                indent += "  ";
            } else {
                System.out.print("├─");
                indent += "│ ";
            }
            System.out.println(node.key);

            printAVLTree(node.left, indent, false);
            printAVLTree(node.right, indent, true);
        }
    }

    
    public void printAVLTree() {
    	printAVLTree(root, "", true);
    }

    public int getNumeroDeComparacaoAVL() {
        return numeroDeComparacaoAVL;
    }

    
    
    
}
