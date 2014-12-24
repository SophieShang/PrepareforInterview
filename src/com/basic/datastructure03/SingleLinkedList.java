package com.basic.datastructure03;

import com.basic.datastructure04.DLNode;

public class SingleLinkedList implements List {
	public Node head;
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
		tail = head;
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
	

	static int compare(Object o1, Object o2){
		String s1 = (String)o1;
		String s2 = (String) o2;
		return s1.compareTo(s2);//s1<s2,返回值小于0；s1>s2,返回值大于0
	}
	
	public void InsertSort(){   //无序链表变为有序的,此处用的应该是冒泡排序原因如下
		Node p, q;
		for(p=head; p!=null;p=p.getNext()){//每次都是从后半部分无序链表中挑出最小的
			Object min = p.getElem();
			for(q=p.getNext();q!=null;q=q.getNext()){
				Object oq = q.getElem();
				if(compare(oq,min)<0){
					p.setElem(oq);
					q.setElem(min);
					min = oq;
				}
			}
		}
	}

	public void Sort(){   //无序链表变为有序的
		for(int i=this.size();i>0;i--){
			for(int j=i;j>0;j--){
				Object m = this.get(i);
				Object n = this.get(j);
				/*if(m < n){
					Object temp;
					temp = m;
					m = n;
					n = temp;
				}*/

			}
		}
	}
	
	
	//检测一个单链表中是否有环
	
	public boolean isExistLoop(SingleLinkedList ls){
		Node slow = ls.head;
		Node fast = ls.tail;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false;
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
		ls.InsertSort();
		System.out.println("排序后的链表为：");
		ls.print();
	}

}
