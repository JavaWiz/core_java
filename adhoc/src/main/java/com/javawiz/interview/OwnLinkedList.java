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
public class OwnLinkedList {
	// Driver code
    public static void main(String[] args)
    {
        /* Start with the empty list. */
    	OwnLinkedList list = new OwnLinkedList();
   
        //
        // ******INSERTION******
        //
   
        // Insert the values
        list = list.insert(list, 1);
        list = list.insert(list, 10);
        list = list.insert(list, 3);
        list = list.insert(list, 12);
        list = list.insert(list, 5);
        list = list.insert(list, 6);
        list = list.insert(list, 7);
        list = list.insert(list, 8);
   
        // Print the LinkedList
        print(list);
    }
	
	Node head; // head of list
	// Linked list Node.
	class Node {
		Node next;
		int data;

		Node(int data) {//single linked list
			this.data = data;
		}
	}

	// Method to insert a new node
	// |data|head| = null then new_node
	// |data|next| -> |data|head|
	// last = list.head then we should check is there any element next node present or node
	// if exit then assign back last = last.next
	
	public OwnLinkedList insert(OwnLinkedList list, int data) {
		// Create a new node with given data
		Node new_node = new Node(data);

		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}
	
	// **************DELETION BY KEY**************
	 
    // Method to delete a node in the LinkedList by KEY
    public static OwnLinkedList deleteByKey(OwnLinkedList list,
                                         int key)
    {
        // Store head node
        Node currNode = list.head, prev = null;
 
        //
        // CASE 1:
        // If head node itself holds the key to be deleted
 
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head
 
            // Display the message
            System.out.println(key + " found and deleted");
 
            // Return the updated List
            return list;
        }
 
        //
        // CASE 2:
        // If the key is somewhere other than at head
        //
 
        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }
 
        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;
 
            // Display the message
            System.out.println(key + " found and deleted");
        }
 
        //
        // CASE 3: The key is not present
        //
 
        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }
 
        // return the List
        return list;
    }
	
	 // Method to print the LinkedList.
    public static void print(OwnLinkedList list)
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
}
