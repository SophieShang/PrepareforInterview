package com.basic.doublelinkedlist;

public class Node {
	private Node prev;
	private Node next;
	private Object element;
	
	
	public Node(Node prev, Node next, Object element) {
		super();
		this.prev = prev;
		this.next = next;
		this.element = element;
	}
	
	public Node() {
	}

	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Object getElement() {
		return element;
	}
	public void setElement(Object element) {
		this.element = element;
	}
	

}
