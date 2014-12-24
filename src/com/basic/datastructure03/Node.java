package com.basic.datastructure03;

public class Node implements Position{
	public Object element;
	public Node next;
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
	public void display(){
		Node cursor = this;
		while(cursor!=null){
			System.out.print(cursor.getElem());
			cursor = cursor.getNext();
		}
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
		Node cursor = n4;
		System.out.println("输出链表");
		n4.display();
		//while(cursor!=null){
		//	System.out.print(cursor.getElem());
		//	cursor = cursor.getNext();
		//}
		
	}
}
