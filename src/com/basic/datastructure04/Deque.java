package com.basic.datastructure04;

import com.basic.datastructure02.ExceptionQueueEmpty;

public interface Deque {
	public int getSize();
	public boolean isEmpty();
	public Object first() throws ExceptionQueueEmpty; //取首元素
	public Object last() throws ExceptionQueueEmpty;//取末元素
	public void insertFirst(Object obj);//将新元素作为首元素插入
	public void insertLast(Object obj); //将新元素作为末元素插入
	
	
}
