package com.basic.datastructure03;

import com.basic.datastructure04.DLNode;

public class SingleLinkedList implements List {
	private Node head;
	private Node tail;
	
	public SingleLinkedList(){
		
	}

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		if(head == null){
			head = new Node(o,null);
			tail = head;
			return;
		}
		Node no = new Node(o,null);
		tail.setNext(no);
		tail = tail.getNext();
	}

	@Override
	public Object get(int i) {//返回链表中第i个node的element值
		// TODO Auto-generated method stub
		Node temp = head;
		int index = 0;
		while(temp!=null){
			if(i==index){
				return temp.getElem();
			}
			temp = temp.getNext();
			index++;
		}
		throw new RuntimeException("invalid index");
	}

	@Override
	public void remove(int i) {
		// TODO Auto-generated method stub
		if(i == 0){//移除链表头
			if(head == null)//链表为空的话
				throw new RuntimeException("List是空的,invalid index");
			head = head.getNext();//链表不为空但是移除链表头结点
			return;
		}
		Node temp = head.getNext();
		int index = 1;
		Node pre = head;
		while(temp!=null){
			if(i==index){
				pre.setNext(temp.getNext());
			if(temp == tail){//如果是移除的链表尾结点的话
				pre.setNext(null);
			}
		  }
			index++;  //向后查找
			pre = temp;
			temp = temp.getNext();
		}
		

	}

	@Override
	public int size() {//返回链表中结点个数
		// TODO Auto-generated method stub
		int index=0;
		Node temp = head;
		while (temp!=null){
			temp = temp.getNext();
			index++;
		}
		return index;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head == tail)? true:false;
	}

	@Override
	public void insert(int index, Object o) {
		// TODO Auto-generated method stub

	}
	
/*	public void Reverse(){
		Node cur = head;
		Node prev = null;
		Node next = cur.getNext();
		while(next != null){
			cur.setNext(prev);
			prev = cur;
			cur = next;
			next = next.getNext();
		}
		cur.setNext(prev);
		head = cur;
	}*/
	
	public void Reverse(){
		Node prev = null;
		Node next = head.getNext();
		while(next != null){
			head.setNext(prev);
			prev = head;
			head = next;
			next = next.getNext();
		}
		head.setNext(prev);
	}
	
	public void Sort(){   //无序链表变为有序的
		for(int i=this.size();i>0;i--){
			for(int j=i;j>0;j--){
				Object m = this.get(i);
				Object n = this.get(j);
				if(m < n){
					Object temp;
					temp = m;
					m = n;
					n = temp;
				}
			}
		}
	}
	
	public void print(){
		Node cur = head;
		while(cur != null){
			System.out.print(cur.getElem()+" ");
			cur = cur.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		SingleLinkedList ls = new SingleLinkedList();
		ls.add("5");
		ls.add("7");
		ls.add("2");
		ls.add("3");
		ls.add("9");
		ls.print();
		ls.remove(3);
		System.out.println("原链表是：");
		ls.print();
		System.out.println("反转过的链表是：");
		ls.Reverse();
		ls.print();
	}

}
