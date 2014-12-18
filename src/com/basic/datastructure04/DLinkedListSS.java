package com.basic.datastructure04;

import com.basic.datastructure03.List;

public class DLinkedListSS implements List {
	private DLNode header;
	private DLNode tailer;
	private int size;
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		if(header == null){
			header = new DLNode(o,null,null);
			tailer = header;
			size++;
			return;
		}
		DLNode temp = new DLNode(o,tailer,null);
		tailer.setNext(temp);
		tailer = tailer.getNext();
		size++;
	}

	@Override
	public Object get(int i) {
		if(i<0 || i >= size){
			throw new RuntimeException("Invalid Index " + i);
		}
		DLNode temp = header;
		int index = 0;
		while(temp != null){
			if(i == index)
				return temp.getElem();
			index++;
			temp = temp.getNext();
		}
		throw new RuntimeException("Bad list");
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
		if(i<0 || i >= size){
			throw new RuntimeException("Invalid Index " + i);
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
					}else if(temp == header){
						header = temp.getNext();
						temp.setPrev(null);
					}else{
						next.setPrev(prev);
						prev.setNext(next);
					}
				}else{//相当于只有一个结点
					header = tailer = null;
				}
				size--;
				return;
			}
			index++;
			temp = temp.getNext();
		}
		
		throw new RuntimeException("Bad list");
	}
	
	@Override
	public int size() {
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
	
	public static void main(String [] args){
		DLinkedListSS list = new DLinkedListSS();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.print();
		System.out.println("Size: " + list.size());
		list.remove(2);
		list.remove(2);
		list.print();
		System.out.println("Size: " + list.size());
		
		try{
			list.get(2);
		}catch(Exception e){
			System.out.println("Bad index");
		}
		
		try{
			list.remove(2);
		}catch(Exception e){
			System.out.println("Bad index");
		}
	}
}
