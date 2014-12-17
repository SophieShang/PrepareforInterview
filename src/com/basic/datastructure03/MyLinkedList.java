package com.basic.datastructure03;

public class MyLinkedList implements List{
	private Node head;
	private Node tail;
	
	//private int size;
	public MyLinkedList(){
		
	}
	
	@Override
	public Object get(int i) {
		Node cur = head;
		while(cur != null){
			i--;
			if(i == 0)
				return cur;
			
			cur = cur.getNext();
		}
		
		throw new RuntimeException("Invalid index");
	}
	@Override
	public void remove(int i) {
		if(i == 0) {
			if(head == null){
				throw new RuntimeException("Invalid index"); 
			}
			head = head.getNext();
			return;
		}
		
		Node prev = head;
		Node cur = head.getNext();
		while(cur != null){
			i--;
			if(i == 0){
				prev.setNext(cur.getNext());
				if(tail == cur){
					tail = prev;
				}
				return;
			}
			prev = cur;
			cur = cur.getNext();
		}
		throw new RuntimeException("Invalid index");
	}
	@Override
	public int size() {
		int size = 0;
		Node cur = head;
		while(cur != null){
			size++;
			cur = cur.getNext();
		}
		return size;
	}
	@Override
	public boolean isEmpty() {
		return head == null;
	}
	@Override
	public void insert(int index, Object o) {
		throw new RuntimeException("NotImpelmented");
	}
	
	public void printAll(){
		Node cur = head;
		while(cur != null){
			System.out.print(cur.getElem());
			System.out.print(" ");
			cur = cur.getNext();
		}
		System.out.println();
	}

	@Override
	public void add(Object o) {
		if(head == null){
			head = new Node(o, null);
			tail = head;
			return;
		}
		
		tail.setNext(new Node(o, null));
		tail = tail.getNext();
	}
	
	public static void main(String[] args){
		MyLinkedList list = new MyLinkedList();
		
		list.add("1");
		list.add("2");
		list.add("3");
		
		System.out.println("Size: " + list.size());
		
		list.printAll();
		
		list.remove(1);
		list.printAll();
		
		list.remove(1);
		list.printAll();
	}
}
