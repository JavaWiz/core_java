package com.javawiz.algorithm.binarytree;

import java.util.Scanner;

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
		if(root == null) {
			return new Node(data);
		} else {
			Node current;
			if(data <= root.data) {
				current = insert(root.left, data);
				root.left = current;
			}else {
				current = insert(root.right, data);
				root.right = current;
			}
		}
		return root;
	}
	
	public static void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
}