package com.basic.datastructure05.leetcode;

import com.basic.datastructure03.list.Node;

public class MergeTwoLists {
	public Node mergeTwoSortedLists(Node l1, Node l2){
		Node dummyHead = new Node(0,null);  //合并后的list的头节点是dummyHead.next
		Node p = dummyHead;
		while(l1 != null && l2 != null){
			if((Integer)l1.element < (Integer)l2.element){
				p.next = l1;  
				l1 = l1.next;
			}else{
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next; //始终指向新生成list的结尾
		}
		if (l1 != null){
			p.next = l1;
		}
		if(l2 != null){
			p.next = l2;
		}
		return dummyHead.next;
	}

}
