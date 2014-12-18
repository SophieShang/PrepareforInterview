package com.basic.datastructure04;

import com.basic.datastructure03.List;

public class DLinkedList implements List {
	private DLNode header;
	private DLNode tailer;

	@Override
	public void add(Object o) {
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
		DLNode temp = header;
		int index = 0;
		while(temp != null){
			if(i == index)
				return temp.getElem();
			index++;
			temp = temp.getNext();
		}
		return null;
	}


	/*public void remove(int i) {
		// TODO Auto-generated method stub
		if(i ==0){
			if(header == null)
				throw new RuntimeException("invalid index");
			header = header.getNext();
			return;
		}
=======
	@Override
	public void remove(int i) {
>>>>>>> 06f9692d6080fed714cf5583b951dec16a542286
		DLNode temp = header;
		int index = 0;
		while(temp != null){
			if(i == index){
				DLNode prev = temp.getPrev();
				DLNode next = temp.getNext();
				
				if(prev != null){
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
				}
				return;
			}
			index ++;
			temp = temp.getNext();
		}
<<<<<<< HEAD

	}
		throw new RuntimeException("Invalid Index!");
	}*/


	public void remove(int i){
		DLNode temp = header;
		int index = 0;
		if(temp == null){
			throw new RuntimeException("invalid index");
		}
		while(temp != null){
			if(i == index){
				DLNode prev = temp.getPrev();
				DLNode next = temp.getNext();
				/*if(prev != null){//è¯´æ˜Žæœ‰ç›´æŽ¥å‰�åº�ï¼Œä¸�æ˜¯å¤´èŠ‚ç‚¹
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
					}else if(temp == header){
						header = temp.getNext();
					}else{
						next.setPrev(prev);
						prev.setNext(next);
						
					}
				}else{//ç›¸å½“äºŽå�ªæœ‰ä¸€ä¸ªç»“ç‚¹
					header = tailer = null;
				}
			}
			index++;
			temp = temp.getNext();
		}
	}
	
	@Override
	public int size() {
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
	
	public void print(){
		DLNode cur = header;
		while(cur != null){
			System.out.print(cur.getElem()+" ");
			cur = cur.getNext();
		}

		System.out.println();
	}
	
	public void printReverse(){
		DLNode cur = tailer;
		while(cur != null){
			System.out.print(cur.getElem());
			System.out.print(" ");
			cur = cur.getPrev();
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		DLinkedList dll = new DLinkedList();
		dll.add("1");
		dll.add("2");
		dll.add("3");
		dll.add("4");
		
		dll.print();
		dll.printReverse();
		
		dll.remove(1);
		
		dll.print();
		dll.printReverse();
		
		dll.remove(0);
		
		dll.print();
		dll.printReverse();
		
		dll.remove(1);
		
		dll.print();
		dll.printReverse();
		
		dll.remove(0);
		
		dll.print();
		dll.printReverse();
	}
}	
