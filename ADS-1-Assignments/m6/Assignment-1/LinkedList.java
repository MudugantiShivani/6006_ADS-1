import java.util.*;
class Node {
	public int data;
	public Node next;
	Node(int data) {
		this.data = data;
		next = null;
	}
	public void setAddress(Node a) {
		next = a;
	}
	public Node getAddress() {
		return next;
	}
	public int getData() {
		return data;
	}
}
class LinkedList{
	Node head;
	Node tail;
	int size;
 LinkedList() {
		size = 0;
	}

	public void insertStart(int e) {
		Node obj = new Node(e);
		if (head == null) {
			head = obj;
			tail = obj;
		} else {
			obj.setAddress(head);
			head = obj;
		}
		size++;
	}
	public void insertEnd(int e) {
		Node obj = new Node(e);
		if (head == null) {
			head = obj;
			tail = obj;
		} else {
			tail.setAddress(obj);
			tail = obj;
		}
		size++;
	}
	public void insertAfter(int a, int b) {
		Node obj = new Node(b);
		Node temp = head;
		while (temp != null) {
			temp = temp.getAddress();
			if (temp.getData() == a) {
				Node temp1 = temp.getAddress();
				temp.setAddress(obj);
				obj.setAddress(temp1);
				size++;
				break;
			}
		}
	}
	public int deleteStart() {
		int data = head.data;
		Node temp = head;
		head = temp.next;
		size--;
		return data;
	}
	public int deleteEnd() {
		int data = head.data;
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.getAddress();
		}
		tail = temp;
		temp.next = null;
		size--;
		return data;
	}
	public void deleteAfter(int a) {
		Node temp = head;
		while (temp.data != a) {
			temp = temp.next;
		}
		temp.setAddress(temp.getAddress().getAddress());
	}
	public String print() {
		String str = "";
		Node temp = head;
		if (size == 0) {
			return " ";
		}
		if (size > 0) {
			while (temp.next != null) {
				str += temp.data;
				temp = temp.getAddress();
			}
			str += temp.data;
		}
		return str;
	}
}

