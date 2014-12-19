package com.basic.datastructure04;

import com.basic.datastructure03.List;

public class DLinkedListSS02 implements List {
	private DLNode header;
	private DLNode tailer;
	private int size; //链表的大小

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		if(header == null){//说明是个空链表
			header = new DLNode(o,null,null);
			tailer = header;
			size++;
			return;
		}
		DLNode temp = new DLNode(o,tailer,null);
		tailer.setNext(temp);
		tailer = tailer.getNext();
		size ++;
	}

	@Override
	public Object get(int i) {
		// TODO Auto-generated method stub
		DLNode temp = header;
		int index = 0;
		while(temp!=null){
			if(i == index)
				return temp.getElem();
			index++;
			temp = temp.getNext();
		}
		return null;
	}

	/*public void remove(int i) {
		// TODO Auto-generated method stub
		if(i ==0){
			if(header == null)
				throw new RuntimeException("invalid index");
			header = header.getNext();
			return;
		}
		DLNode temp = header;
		int index = 1;
		while(temp!=null){
			if(i == index){
				temp.getPrev().setNext(temp.getNext());
				temp.getNext().setPrev(temp.getPrev());
				if(temp == tailer){
					temp.getPrev().setNext(null);
				}
			}
			index ++;
			temp = temp.getNext();
		}

	}*/

	public void remove(int i){
		if(i<0 || i>=size){
			throw new RuntimeException("不正确下标："+i);
		}
		DLNode temp = header;
		int index = 0;
		while(temp != null){
			if(i == index){
				DLNode prev = temp.getPrev();
				DLNode next = temp.getNext();
				/*if(prev != null){//说明有直接前序，不是头节点
					prev.setNext(next);
				}
				if(next != null){
					next.setPrev(prev);
				}
				if(temp == header){
					header = temp.getNext();
				}
				if(temp == tailer){
					tailer = temp.getPrev();
				}*/
				
				if(prev != null || next != null){
					if(temp == tailer){
						tailer = prev;
						prev.setNext(null);
					}
					else if(temp == header){
						header = next;
						header.setPrev(null);
					}else{
						next.setPrev(prev);
						prev.setNext(next);
					}
				}else{//相当于只有一个节点
					header = tailer =null;
				}
				size --;
				return;
			}
			index++;
			temp = temp.getNext();
		}
		throw new RuntimeException("链表为空");
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		/*int size=0;
		DLNode temp = header;
		while(temp!=null){
			size++;
			temp = temp.getNext();
		}*/
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (header == tailer)? true:false;
	}

	@Override
	public void insert(int index, Object o) {
		// TODO Auto-generated method stub

	}
	
	public void print(){
		DLNode cur = header;
		while(cur != null){
			System.out.print(cur.getElem()+" ");
			cur = cur.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		DLinkedListSS02 dll = new DLinkedListSS02();
		//dll.remove(1);
		dll.add(9);
		dll.add(16);
		dll.add(3);
		dll.print();
		System.out.print("双向链表长度为：" + dll.size()+"\n");
		dll.remove(0);
		dll.print();
		dll.remove(1);
		dll.print();
	}
	
}
