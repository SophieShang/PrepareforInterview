package com.basic.datastructure03.list;

import com.basic.datastructure02.stack_queue.ExceptionQueueEmpty;
import com.basic.datastructure02.stack_queue.ExceptionQueueFull;
import com.basic.datastructure02.stack_queue.QueueInt;

public class Queue_List implements QueueInt{
	protected Node head;
	protected Node tail;
	protected int size;
	
	public Queue_List(){
		head=tail=null;
		size=0;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0)? true : false;
	}

	@Override
	public Object front() throws ExceptionQueueEmpty {
		// TODO Auto-generated method stub
		if(size == 0)
			throw new ExceptionQueueEmpty("队列为空，无法取出");
		return head.getElem();
	}

	@Override
	public Object dequeue() throws ExceptionQueueEmpty {
		// TODO Auto-generated method stub
		if(size == 0)
			throw new ExceptionQueueEmpty("队列为空，无法取出");
		Object temp = head.getElem();
		head = head.getNext();
		size--;
		if(size == 0) tail=null; //这种即队列只有一个元素的时候
		return temp;
	}

	@Override
	public void enqueue(Object obj) throws ExceptionQueueFull {
		// TODO Auto-generated method stub
		Node node = new Node(obj, null);
		if(size==0) head = node; //队列为空，直接插入，作为头
		else tail.setNext(node);
		tail = node;
		size++;
	}

	@Override
	public void Traversal() {
		// TODO Auto-generated method stub
		Node p = head;
		while(p!=null){
			System.out.print(p.getElem()+" ");
			p=p.getNext();
		}
	}

}
