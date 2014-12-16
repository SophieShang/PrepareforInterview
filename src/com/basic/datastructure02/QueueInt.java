package com.basic.datastructure02;

public interface QueueInt {
	public int getSize();
	public boolean isEmpty();
	public Object front() throws ExceptionQueueEmpty;
	public Object dequeue() throws ExceptionQueueEmpty;
	public void enqueue(Object obj)throws ExceptionQueueFull;
	public void Traversal();

}
