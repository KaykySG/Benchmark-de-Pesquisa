/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bdp.modelo;

/**
 *
 * @author viniciusfs.senai
 */

/**
 *
 * @author Kazumi
 */
public class Node {
      String data;

      Node left;
      Node right;
      Node parent;

      boolean color;

      public Node(String data) {
        this.data = data;
      }
              //IMPRIME A ÁRVORE
            public String buildRBTreeString() {
                StringBuilder treeString = new StringBuilder();
                buildRBTreeString(treeString, true, "");
                return treeString.toString();
            }   

            private void buildRBTreeString(StringBuilder treeString, boolean isRight, String indent) {
                if (right != null) {
                    right.buildRBTreeString(treeString, true, indent + (isRight ? "        " : " |      "));
                }
                treeString.append(indent);
                if (isRight) {
                    treeString.append(" /");
                } else {
                    treeString.append(" \\");
                }
                treeString.append("----- ");
                appendNodeValue(treeString);
                if (left != null) {
                    left.buildRBTreeString(treeString, false, indent + (isRight ? " |      " : "        "));
                }
            }

            private void appendNodeValue(StringBuilder treeString) {
                if (data == null) {
                    treeString.append("<null>\n");
                } else {
                    treeString.append(data).append('\n');
                }
            }
    }