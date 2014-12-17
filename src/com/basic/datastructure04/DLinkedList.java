package com.basic.datastructure04;

import com.basic.datastructure03.List;

public class DLinkedList implements List {
	private DLNode header;
	private DLNode tailer;

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		if(header == null){
			header = new DLNode(o,null,null);
			tailer = header;
			return;
		}
		DLNode temp = new DLNode(o,tailer,null);
		tailer.setNext(temp);
		tailer = tailer.getNext();
		

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

	@Override
	public void remove(int i) {
		// TODO Auto-generated method stub
		if(i ==0){
			if(header == null)
				throw new RuntimeException("invalid index");
			header = tailer = null;
			return;
		}
		DLNode temp = header;
		int index = 1;
		while(temp!=null){
			if(i == index){
				temp.getPrev().setNext(temp.getNext());
				temp.getNext().setPrev(temp.getPrev());
				if(temp == tailer){
					tailer = temp.getPrev();
				}
			}
			index ++;
			temp = temp.getNext();
		}

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size=0;
		DLNode temp = header;
		while(temp!=null){
			size++;
			temp = temp.getNext();
		}
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

}
