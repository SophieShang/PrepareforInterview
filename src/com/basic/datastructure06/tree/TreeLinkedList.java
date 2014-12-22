package com.basic.datastructure06.tree;

public class TreeLinkedList implements Tree {
	private Object element;
	private TreeLinkedList parent, firstchild, nextsibling;

	public TreeLinkedList(){
		this(null, null, null, null);
	};
	

	public TreeLinkedList(Object e, TreeLinkedList p, TreeLinkedList c,
			TreeLinkedList s) {
		element = e;
		parent = p;
		firstchild = c;
		nextsibling = s;
	}
	
//Tree接口中方法的实现

	@Override
	public Object getElem() {
		return element;
	}

	@Override
	public Object setElem(Object obj) {
		Object bak = element;
		element = obj;
		return bak;
	}

	@Override
	public TreeLinkedList getParent() {
		return parent;
	}

	@Override
	public TreeLinkedList getFirstChild() {
		return firstchild;
	}

	@Override
	public TreeLinkedList getNextSibling() {
		return nextsibling;
	}

	@Override
	public int getSize() {
		int size = 1;
		TreeLinkedList subtree = firstchild;
		while(subtree != null){
			size = size + firstchild.getSize();
			subtree = subtree.getNextSibling();
			
		}
		return size;
	}

	@Override
	public int getHeight() {
		int height = -1;
		TreeLinkedList subtree = firstchild;
		while(subtree != null){
			height = Math.max(height, subtree.getHeight()); //再所有孩子中取最大高度
			subtree = subtree.getNextSibling();
		}
		return height+1;
	}

	@Override
	public int getDepth() {//p127
		int depth = 0;
		TreeLinkedList p = parent;
		while(p != null){
			depth ++;
			p = p.getParent();
		}
		return 0;
	}
	
}
