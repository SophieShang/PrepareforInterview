package com.basic.doublelinkedlist;

public class DoubleLinkedList {
	private Node header;
	private Node tailer;
	private int size;
	public DoubleLinkedList(){
		header = new Node();
		tailer = new Node();
		header.setNext(tailer);
		tailer.setPrev(header);
	}
	
	public int getSize(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public Object first(){
		if(isEmpty()){
			throw new RuntimeException("Empty List");
		}
		return header.getNext().getElement();
	}
	
	public Object last(){
		if(isEmpty()){
			throw new RuntimeException("Empty List");
		}
		return tailer.getPrev().getElement();
	}
	
	public void insertFirst(Object o){
		Node first = header.getNext();
		Node newFirst = new Node(header, first, o);
		first.setPrev(newFirst);
		header.setNext(newFirst);
		size++;
	}
	
	public void insertLast(Object o){
		Node last = tailer.getPrev();
		Node newLast = new Node(last, tailer, o);
		last.setNext(newLast);
		tailer.setPrev(newLast);
		size++;
	}
	
	public Object removeFirst(){
		if (isEmpty())
			throw new RuntimeException("Empty List");
		
		Node first = header.getNext();
		Object obj = first.getElement();
		Node newFirst = first.getNext();
		first.setPrev(header);
		header.setNext(newFirst);
		size--;
		return obj;
	}

	public Object removeLast() {
		if (isEmpty())
			throw new RuntimeException("Empty List");
		
		Node last = tailer.getPrev();
		Object obj = last.getElement();
		Node newLast = last.getPrev();
		last.setNext(tailer);
		tailer.setPrev(newLast);
		size--;
		return obj;
	}
}
