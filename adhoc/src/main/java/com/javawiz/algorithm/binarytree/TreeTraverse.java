package com.javawiz.algorithm.binarytree;

import java.util.Scanner;

public class TreeTraverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt(); //6
        Node root = null;
        //1 2 5 3 6 4
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        System.out.print("In order :");
        inOrder(root);//1 2 3 4 5 6
        System.out.print("\nPre order :");
        preOrder(root);//1 2 5 3 4 6
        System.out.print("\nPost order :");
        postOrder(root);//4 3 6 5 2 1
        scan.close();
    }

    /*
    In order (Left, Root, Right) makes sorted order for BST
    Pre order (Root, Left, Right)
    Post order (Left, Right, Root)
    1
      \
       2
        \
         5
        /  \
       3    6
        \
         4
     */

    private static void inOrder(Node root) {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+  " ");
        inOrder(root.right);
    }

    private static void preOrder(Node root) {
        if(root == null)
            return;
        System.out.print(root.data+  " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void postOrder(Node root) {
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+  " ");
    }

    // Insert method to add nodes to the BST
    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            if(data <= root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }
    }
}
