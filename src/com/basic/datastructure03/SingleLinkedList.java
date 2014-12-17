package com.basic.datastructure03;

public class SingleLinkedList implements List {
	private Node head;
	private Node tail;
	
	public SingleLinkedList(){
		
	}

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		if(head == null){
			head = new Node(0,null);
			tail = head;
			return;
		}
		Node no = new Node(0,null);
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

}
