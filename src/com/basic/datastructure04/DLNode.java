package com.basic.datastructure04;

import com.basic.datastructure03.Position;

public class DLNode implements Position{
	
	private Object element;
	private DLNode prev;//指向前驱结点
	private DLNode next;//指向后继结点
	
	//构造函数
	public DLNode(){
		this(null, null, null);
	}
	public DLNode(Object obj, DLNode p, DLNode n){
		element = obj;
		prev = p;
		next = n;
	}
	
	@Override
	public Object getElem() {
		// TODO Auto-generated method stub
		return element;
	}

	@Override
	public Object setElem(Object obj) {
		// TODO Auto-generated method stub
		Object oldElem = element;
		element = obj;
		return oldElem;
	}
	
	public DLNode getNext(){
		return next;
	}
	
	public DLNode getPrev(){
		return prev;
	}
	
	public void setNext(DLNode dn){
		next = dn;
	}
	
	public void setPrev(DLNode dn){
		prev = dn;
	}

}
