package com.javawiz.interview;

/**
 * @author BeautifulMind
 * 
 *         In Java, LinkedList can be represented as a class and a Node as a
 *         separate class. The LinkedList class contains a reference of Node
 *         class type.
 * 
 *         Insertion in the list is done at the end, that is the new node is
 *         added after the last node of the given Linked List. For example, if
 *         the given Linked List is 5->10->15->20->25 and 30 is to be inserted,
 *         then the Linked List becomes 5->10->15->20->25->30. Since a Linked
 *         List is typically represented by the head pointer of it, it is
 *         required to traverse the list till the last node and then change the
 *         next to last node to the new node.
 *
 */
public class DoubleLinkedList {
	// Driver code
    public static void main(String[] args)
    {
        DoubleLinkedList list2 = new DoubleLinkedList();
        list2.add(10);
        list2.add(2);
        list2.add(8);
        list2.add(5);
        list2.add(3);
        print(list2);
        printMiddleElement(list2);
    }
	
	// Linked list Node.
	class Node {
		Node next, prev;
		int data;

		Node(Node prev, int data, Node next) {//double linked list
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
	}
	
	Node head; // head of list
	Node tail;
    int size;
	public boolean add(int data) {
		Node current_node = tail;
		Node newNode = new Node(current_node, data, null);
		tail = newNode;
		if (current_node == null)
			head = newNode;
		else
			current_node.next = newNode;
		
		size++;
		return true;
	}
	
	public int size() {
		return size;
	}

	 // Method to print the LinkedList.
    public static void print(DoubleLinkedList list)
    {
        Node currNode = list.head;
    
        System.out.print("LinkedList: ");
    
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
    
            // Go to next node
            currNode = currNode.next;
        }
    }
    
    public static void printMiddleElement(DoubleLinkedList list) {
		Node current_node = list.head;
		System.out.print("Middle element: ");
		
		while(current_node!=null) {
			if(current_node.prev!= null && current_node.next!=null)
				System.out.print(" "+current_node.data);
			current_node = current_node.next;
		}
	}
}
