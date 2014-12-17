package com.basic.datastructure03;

public class Node implements Position{
	private Object element;
	private Node next;
	public Node(){
		this(null,null);
	}
	public Node(Object ele, Node no){
		element =ele;
		next = no;
	}
	public Object getElem(){
		return element;
	}
	public Object setElem(Object e){
		Object oldElem = element;
		element = e;
		return oldElem;
	}
	public Node getNext(){
		return next;
	}
	public void setNext(Node n){
		next = n;
	}
	
	public static void main(String args[]){
		Node n1 = new Node(4,null);
		Node n2 = new Node(3,n1);
		Node n3 = new Node(),n4 = new Node();
		n3.setElem(2);
		n4.setElem(1);
		n3.setNext(n2);
		n4.setNext(n3);
		System.out.println(n4.getElem());
		System.out.println(n3.getElem());
		System.out.println(n2.getElem());
		System.out.println(n1.getElem());
		
	}
}
