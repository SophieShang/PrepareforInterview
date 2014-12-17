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
		int index = 0;
		while(cur != null){
			if(i == index)
				return cur.getElem();
			index ++ ;
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
		int index = 1;
		while(cur != null){
			if(i == index){
				prev.setNext(cur.getNext());
				if(tail == cur){
					tail = prev;
				}
				return;
			}
			index++;
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

		System.out.println("Size: " + list.size());
		
		System.out.println(list.get(0));
		try{
			// invalid index
			list.get(1);
		}catch(Exception e){
			//e.printStackTrace();
			System.out.println("Yeah! Invlaid Index");
		}
		
		try{
			// invalid index
			list.remove(1);
		}catch(Exception e){
			System.out.println("Yeah! Invlaid Index");
		}
	}
}
