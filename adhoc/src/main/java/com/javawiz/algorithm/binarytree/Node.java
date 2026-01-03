package com.javawiz.algorithm.binarytree;

public class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}