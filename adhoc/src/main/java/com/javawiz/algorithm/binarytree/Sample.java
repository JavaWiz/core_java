package com.javawiz.algorithm.binarytree;

import java.util.Scanner;
/**
 * In this example, we will demonstrate how to insert nodes into a binary search tree (BST)
 * and perform an in-order traversal to display the nodes in sorted order.
 * The insert method ensures that the BST properties are maintained,
 * where the left subtree contains values less than or equal to the root,
 * and the right subtree contains values greater than the root.
 * The inOrder method recursively visits the left subtree, the root node, and then the right subtree,
 * resulting in a sorted sequence of values when printed.
 *
 * @author JavaWiz
 *
 */

public class Sample {
	
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
        //preOrder(root);//1 2 5 3 4 6
        System.out.print("\nPost order :");
        //postOrder(root);//4 3 6 5 2 1
        scan.close();
    }
	
	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		if (data <= root.data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}
	
	public static void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data +  " ");
		inOrder(root.right);
	}
}