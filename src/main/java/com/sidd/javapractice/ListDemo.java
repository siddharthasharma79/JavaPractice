package com.sidd.javapractice;

public class ListDemo {

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.insert(1);
		list.insert(2);
		list.insert(4);
		list.insert(5);
		list.showList();
		System.out.println("List size : " + list.size());

		list.insertAt(30000, 3);

		list.showList();
		System.out.println("List size : " + list.size());

	}

}

class LinkList {
	// define the head of link list
	Node head;

	// insert node at specific index
	public void insertAt(int data, int index) {
		if(head == null ) {
			System.out.println("List is empty so node has been added as head node.");
			insert(data);
		}
		else if (index == 0) { 
			Node n = new Node();
			n.data = data;
			n.next = head;
			head = n;
		}	
		else {
			int size = this.size();
			if(index >= size) {
				if(index - size >= 2) 
					System.out.println("Index value is grater than last index of list so adding the node as last node of the list.");
				insert(data);
			}
			else {
				
				Node n = new Node();
				n = head;
				for(int i = 0; i <= size; i++) {
					if(i + 1 == index) {
						Node tn = new Node();
						tn.data = data;
						tn.next = n.next;
						n.next = tn;
						break;
					}
					n = n.next;
				}
			}	
		}

	}

	// insert node at the end of list
	public void insert(int data) {

		// create new node to be added
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;

		// checking if head node is null
		if (head == null) {
			head = newNode;
		} else {

			// create temporary node to traverse the list
			Node n = new Node();
			// assign it to head node
			n = head;
			while (n.next != null) {
				// move to next node
				n = n.next;
			}
			// after reaching last node which next node is null assign temporary node to new
			// node
			n.next = newNode;
		}

	}

	// get size of link list
	public int size() {

		if (this.head == null)
			return 0;
		else {
			int count = 1;
			Node n = this.head;
			while (n.next != null) {
				count++;
				n = n.next;
			}
			return count;
		}
	}

	// display all nodes of linked list
	public void showList() {
		Node n = head;
		while (n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data + " # " + n.next);
	}
}

class Node {

	public int data;
	public Node next;

}
