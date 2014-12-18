package com.basic.datastructure03.txgu;
import com.basic.datastructure02.*;
import com.basic.datastructure02.StackUseArray.ExceptionStackEmpty;
import com.basic.datastructure02.StackUseArray.Stack;

public class Stack_List implements Stack{
	protected Node top;//指向栈顶元素
	protected int size; //栈中元素的数目
	
	public Stack_List(){
		top = null;
		size = 0;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() { //判断栈是否为空 -- 栈顶节点Node top是否为Null
		// TODO Auto-generated method stub
		return (top == null)? true:false;
	}

	@Override
	public Object pop() throws ExceptionStackEmpty {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new ExceptionStackEmpty("栈空");
		}
		Object oj = top.getElem();
		top = top.getNext();
		size--;
		return oj;
	}

	@Override
	public Object top() throws ExceptionStackEmpty {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new ExceptionStackEmpty("栈空");
		}
		return top.getElem();
	}

	@Override
	public void push(Object ele) {
		// TODO Auto-generated method stub
		Node v = new Node(ele, top);
		top = v;
		size++;
		
		
	}

}
