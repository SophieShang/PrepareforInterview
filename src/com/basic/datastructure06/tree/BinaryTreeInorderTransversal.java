package com.basic.datastructure06.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.basic.datastructure03.*;


public class BinaryTreeInorderTransversal{

    static class TreeNode{      //set get 方法
        protected TreeNode left;
        protected TreeNode right;
        Integer value;

        public TreeNode(TreeNode l, TreeNode r, Integer value){
            left = l;
            right = r;
            this.value = value;
        }
    }

    public ArrayList<Integer> inOrderTransversal(TreeNode root){
        ArrayList<Integer> inOrder = new ArrayList<Integer> ();
        if(root == null){
            return inOrder;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        TreeNode p;
        p = root.left;
        while(!s.empty()){
            while(p != null){
                s.add(p);
                p = p.left;
            }
            TreeNode n = s.pop();
            inOrder.add(n.value);
            p =n.right;
            if(p != null){
                s.add(p);
                p = p.left;
            }
        }
        return inOrder;
    }

    public ArrayList<Integer> preOrderTrans(TreeNode root){
        ArrayList<Integer> preOrder = new ArrayList<Integer>();
        if(root == null) return preOrder;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root.left;
        s.add(root);
        preOrder.add(root.value);
        while(!s.isEmpty()){
            while(p != null){
                preOrder.add(p.value);
                s.add(p);
                p = p.left;
            }
            TreeNode n = s.pop();
            p = n.right;
            if(p != null){
                preOrder.add(p.value);
                s.add(p);
                p = p.left;
            }
        }
        return preOrder;

    }

    public ArrayList<Integer> postOrderTrans(TreeNode root){
        ArrayList<Integer> postOrder = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        postOrder.add(root.value);
        TreeNode p = root.right;
        while(!s.isEmpty()){
            while(p != null){
                postOrder.add(p.value);
                s.add(p);
                p = p.right;
            }
            TreeNode n = s.pop();
            p = n.left;
            if(p != null){
                postOrder.add(p.value);
                s.add(p);
                p = p.right;
            }
        }

        int i=0, j = postOrder.size()-1;
        while(i < j){
            Integer temp = postOrder.get(i);
            postOrder.set(i, postOrder.get(j));
            postOrder.set(j, temp);
            i++;
            j--;
        }
        return postOrder;
    }

    public ArrayList<ArrayList<Integer>> levelOrderTrans(TreeNode root){
        ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return levelOrder;
        ArrayList<Integer> levelele = new ArrayList<Integer>();
        int currentlevel = 1; //记录当前层的节点个数
        int nextlevel = 0;  //记录下一层的节点个数
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            levelele.add(node.value);
            currentlevel --;
            if(node.left != null){
                queue.add(node.left);
                nextlevel++;
            }
            if(node.right != null){
                queue.add(node.right);
                nextlevel++;
            }
            if(currentlevel == 0){
                levelOrder.add(levelele);
                levelele = new ArrayList<Integer>();
                currentlevel = nextlevel;
                nextlevel = 0;
            }
        }
        int i=0, j=levelOrder.size()-1;
        while(i < j){
            ArrayList<Integer> temp = levelOrder.get(i);
            levelOrder.set(i,levelOrder.get(j));
            levelOrder.set(j, temp);
            i++;
            j--;
        }
        return levelOrder;
    }



    //递归方法实现
    
    //错误事例
    /*public static ArrayList<Integer> inOrderTraversalRecur(TreeNode root){
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        if (root == null)
            return inOrder;
        if(root.left != null)
            inOrder = inOrderTraversalRecur(root.left);
        inOrder.add(root.value);
        if(root.right != null)
            inOrder = inOrderTraversalRecur(root.right);
        return inOrder;
    }*/

    public static ArrayList<Integer> preOrderTraversalRecur(TreeNode root){
        ArrayList<Integer> preOrder = new ArrayList<Integer>();
        if (root == null)
            return preOrder;
        preOrder.add(root.value);
        if(root.left != null)
            preOrder.addAll(preOrderTraversalRecur(root.left));
        if(root.right != null)
            preOrder.addAll(preOrderTraversalRecur(root.right));
        return preOrder;
    }

    public static ArrayList<Integer> postOrderTraversalRecur(TreeNode root){
        ArrayList<Integer> postOrder = new ArrayList<Integer>();
        if (root == null)
            return postOrder;
        if(root.left != null)
            postOrder.addAll(postOrderTraversalRecur(root.left));
        if(root.right != null)
            postOrder.addAll(postOrderTraversalRecur(root.right));
        postOrder.add(root.value);
        return postOrder;
    }

    public static ArrayList<Integer> inOrderTraversalRecurSlow(TreeNode root){
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        if (root == null)
            return inOrder;
        if(root.left != null)
            inOrder.addAll(inOrderTraversalRecurSlow(root.left));
        inOrder.add(root.value);
        if(root.right != null)
            inOrder.addAll(inOrderTraversalRecurSlow(root.right));
        return inOrder;
    }

    public static void inOrderTraversalRecurFast(TreeNode root, ArrayList<Integer> inOrder){
        if (root == null)
            return;
        if(root.left != null)
            inOrderTraversalRecurFast(root.left, inOrder);
        inOrder.add(root.value);
        if(root.right != null)
            inOrderTraversalRecurFast(root.right, inOrder);
    }


    public static ArrayList<Integer> inOrderTraversalRecurFast(TreeNode root){
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        inOrderTraversalRecurFast(root, inOrder);
        return inOrder;
    }

    static void printList(List<Integer> order){
        for(int i : order){
            System.out.format("%d ", i);
        }
        System.out.println();
    }
    
    static void printList02(ArrayList<ArrayList<Integer>> order){
        for(List<Integer> ll : order){
            System.out.print(ll);
        }
        System.out.println();
    }
    
    //convert a sorted array to height balanced binary search tree
    
    public TreeNode sortedArraytoBST(int[] in){ //返回的是二分查找树的根节点
    	return sortedArraytoBST(in, 0, in.length-1);
    }

    public TreeNode sortedArraytoBST(int[] in, int begin, int end) {
    	while(begin <= end){
    		int mid = (begin+end)/2;
    		TreeNode left = sortedArraytoBST(in, begin, mid-1);
    		TreeNode right = sortedArraytoBST(in, mid+1, end);
    		TreeNode n = new TreeNode(null, null,in[mid]);
    		n.left = left;
    		n.right = right;
    		return n;
    	}
		return null;
	}
    
    //Given a singly linked list where elements are sorted in ascending order
    //convert it to a height balanced BST.
    
    public TreeNode sortedLinkedListtoBST(Node head){
    	return sortedLinkedListtoBST(head, null);
    }

	private TreeNode sortedLinkedListtoBST(Node begin, Node end) {
		if(begin == end){  //此处意味着这是个空的单链表，直接返回空
			return null;
		}else if(begin.next == end){ //即只有一个头节点元素
			return new TreeNode(null, null, (Integer)begin.getElem());
		}else{
			Node slow = begin;  //此处即通过两个指针去获得单链表的中间节点
			Node fast = begin;  //类似于mid = (begin + end)/2
			while(fast.next != null && fast.next.next != null){
				slow = slow.next;
				fast = fast.next.next;
			}
			TreeNode left = sortedLinkedListtoBST(begin,slow);
			TreeNode right = sortedLinkedListtoBST(slow.next,end);
			TreeNode root = new TreeNode(null, null, (Integer)slow.getElem());
			root.left = left;
			root.right = right;
			return root;
		}
	}
	
	//Given a binary tree, find the lowest common ancestor of two given nodes in the tree
	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
		//已知二叉树的根节点，寻找节点p和q的最小公共父节点
		
		if(root == null)
			return null;
		if(root == p || root == q)
			return root;
		TreeNode left = LCA(root.left, p, q);
		TreeNode right = LCA(root.right, p, q);
		if(left!=null && right!=null)
			return root;
		return left!=null? left:right;
		
	}

	public static void main(String[] args){
        TreeNode root = new TreeNode(null, null, 1);
        root.left = new TreeNode(null, null, 2);
        root.left.left = new TreeNode(null, null, 3);
        root.left.right = new TreeNode(null, null,5);
        root.right = new TreeNode(null, null, 4);
        root.right.left = new TreeNode(null, null, 6);
        root.right.right = new TreeNode(null, null, 7);

      /*  printList(inOrderTraversalRecurSlow(root));
        printList(inOrderTraversalRecurFast(root));
        printList(postOrderTraversalRecur(root));
        printList(preOrderTraversalRecur(root));*/
        
        BinaryTreeInorderTransversal bt = new BinaryTreeInorderTransversal();
        
        int[] in = {1,2,3,4,5,6,7};
        for(int i:in){
        	System.out.print(i+", ");
        }
        System.out.println();
        printList02(bt.levelOrderTrans(root));
        
        TreeNode rt = bt.sortedArraytoBST(in);
        System.out.print("二分搜索树根节点是："+rt.value);
        System.out.println();
        ArrayList<ArrayList<Integer>> al = bt.levelOrderTrans(rt);
        printList02(al);
        //printList(bt.postOrderTrans(rt));
        
        SingleLinkedList sl = new SingleLinkedList();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        System.out.println("原链表是：");
		sl.print();
		//System.out.print(sl.head.getElem());
		BinaryTreeInorderTransversal bt02 = new BinaryTreeInorderTransversal();
		System.out.println("链表的前序遍历二分搜索树：");
		//printList(bt02.preOrderTrans(bt02.sortedLinkedListtoBST(sl.head)));
    }
}
