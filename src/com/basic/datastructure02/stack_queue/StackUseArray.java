package com.basic.datastructure02.stack_queue;

public class StackUseArray {
	
	public interface Stack{
		public int getSize();
		public boolean isEmpty();
		public Object pop() throws ExceptionStackEmpty;
		public Object top() throws ExceptionStackEmpty;
		public void push(Object ele);
	}
	
	public static class ExceptionStackEmpty extends RuntimeException{//对空栈用pop，top方法时抛出异常
		public ExceptionStackEmpty(String err){
			super(err);
		}
	}
	
	public static class ExceptionStackFull extends RuntimeException{//对满栈进行push操作时抛出异常
		public ExceptionStackFull(String err){
			super(err);
		}
	}
	
	static class Stack_Array implements Stack{
		public static final int CAPACITY = 1024;
		protected int capacity;
		protected Object[] s;
		protected int top=-1; //栈顶元素
		
		public Stack_Array(){
			this(CAPACITY);
		}
		
		public Stack_Array(int cap){
			capacity = cap;
			s = new Object[capacity];
		}
		
		public int getSize(){
			return top+1;//数组是从零开始计数的
		}
		
		public boolean isEmpty(){
			return (top<0);
		}
		
		public Object pop() throws ExceptionStackEmpty{
			Object ele;
			if(isEmpty()){
				throw new ExceptionStackEmpty("栈是空的，无法弹出");
			}
			ele = s[top];
			s[top--]=null;
			return ele;
		}
		public Object top() throws ExceptionStackEmpty{
			if(isEmpty()){
				throw new ExceptionStackEmpty("栈是空的，无法弹出");
			}
			return s[top];
		}
		public void push(Object ele) throws ExceptionStackFull{
			if(getSize() == capacity){
				throw new ExceptionStackFull("栈满了,无法插入");
			}
			s[++top] = ele;
		}
		
	}
	
	//利用栈实现数组倒置
	public static Integer[] Reverse(Integer[] a){
		//StackUseArray sua = new StackUseArray();
		Stack_Array sa = new Stack_Array(a.length);
		Integer[] b = new Integer[a.length];
		for(int i=0; i<a.length;i++){
			sa.push(a[i]);
		}
		for(int i=0;i<a.length;i++){
			b[i] = (Integer)(sa.pop());
		}
		return b;
	}

}
