package com.basic.datastructure02.stack_queue;

public class Josephus {
	
	//利用队列模拟josephus环
	public static Object Josephus(Queue_Array Q, int k) throws ExceptionQueueFull, ExceptionQueueEmpty{
		if(Q.isEmpty())
			return null;
		while(Q.getSize()>1){
			Q.Traversal();
			for(int i=0;i<k;i++){
				Q.enqueue(Q.dequeue());
			}
			Object e = Q.dequeue();
			System.out.println("\n"+e+"孩子退出");
		}
		return Q.dequeue();
	}
	
	//将孩子组织成队列
	public static Queue_Array buildQueue(Object[] obj) throws ExceptionQueueFull{
		Queue_Array qa = new Queue_Array();
		for(int i=0;i<obj.length;i++){
			qa.enqueue(obj[i]);
		}
		return qa;
	}

	public static void main(String[] args) throws ExceptionQueueFull, ExceptionQueueEmpty {
		// TODO Auto-generated method stub
		String[] str = {"shangxing","zengyi","yali","lize","tiger"};
		int k=5; //数组下标示从0开始的，所以是6为周期
		Josephus js = new Josephus();
		Queue_Array aa = js.buildQueue(str);
		Object mm = js.Josephus(aa,k);
		
		System.out.println("最后的幸运者是" + mm);
	}

}
