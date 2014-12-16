package com.basic.datastructure02;

public class Queue_Array implements QueueInt {
	
	public static final int CAPACITY=1000;
	protected int capacity;
	protected int r=0,f=0;   //r是队尾元素，f是队首元素 
	protected Object[] Q;
	
	//无参及带参的构造函数
	
	public Queue_Array(){
		this(CAPACITY);
	}

	public Queue_Array(int cap){
		capacity = cap;
		Q = new Object[capacity];
	}
			

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return ((capacity-f+r)%capacity);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(f ==r ) return true;
		else return false;
	}

	@Override
	public Object front() throws ExceptionQueueEmpty {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new ExceptionQueueEmpty("队列是空的，没有队头");
		}
		return Q[f];
	}

	@Override
	public Object dequeue() throws ExceptionQueueEmpty {
		// TODO Auto-generated method stub
		Object obj;
		if(isEmpty()){
			throw new ExceptionQueueEmpty("队列是空的，没有队头");
		}
		obj = Q[f];
		Q[f]=null;
		f = (f+1)%capacity;
		return obj;
	}

	@Override
	public void enqueue(Object obj) throws ExceptionQueueFull {
		// TODO Auto-generated method stub
		if(getSize() == capacity-1){//队列里必须空出一个数组元素
			throw new ExceptionQueueFull("队列是满的，没有办法再加入元素了");
		}
		Q[r]= obj;
		r = (r+1)%capacity;
	}

	@Override
	public void Traversal() {
		// TODO Auto-generated method stub
		for(int i=f;i<(f+((capacity-f+r)%capacity));i++){
			System.out.print(Q[i]+ ", ");
		}
		System.out.println();
		
	}

}
