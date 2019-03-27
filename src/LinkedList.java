
public class LinkedList {
	
	// head node of the linked list
	Node head;
	
	// inner class is static so that main() can access it
	static class Node {
		int value;
		Node next;
		
		// constructor for Node
		Node(int val) {
			value = val;
			next = null;
		}
	}
	
	// prints the contents of the linked list starting from head
	public void printList() {
		Node n = head;
		
		while(n != null) {
			System.out.print(n.value + " ");
			n = n.next;
		}
	}
	
	// function to add node at the start of the list
	public void insertAtStart(int new_data) {
		Node n = new Node(new_data);
		
		n.next = head;
		head = n;
	}
	
	// function to add node after given node
	public void insertAfter(Node prev, int new_data) {
		if(prev == null) {
			System.out.println("prev cannot be null");
			return;
		}
		
		Node n = new Node(new_data);
		n.next = prev.next;
		prev.next = n;
	}
	
	// function to add node after given node
	public void insertAtEnd(int new_data) {
		Node n = new Node(new_data);
		
		if(head == null) {
			head = n;
			return;
		}
		
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		
		last.next = n;
		return;
	}
	
	// function to delete a node
	public void delete(int key) {
		Node temp = head, prev = null;
		
		if(temp != null && temp.value == key) {
			head = temp.next;
			return;
		}
		
		while(temp != null && temp.value != key) {
			prev = temp;
			temp = temp.next;
		}
		
		if(temp == null) {
			return;
		}
		
		prev.next = temp.next;  
	}

	public static void main(String[] args) {
		// Empty list
		LinkedList list = new LinkedList();
		
		list.insertAtEnd(6);
		list.insertAtStart(7);
		list.insertAtStart(1);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAfter(list.head.next, 8);
		
		System.out.print("\nCreated Linked List is: ");
		list.printList();
		
		list.delete(1);
		
		System.out.print("\nLinked List after deletion: ");
		list.printList();
	}

}
