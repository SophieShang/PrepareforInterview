package com.basic.datastructure06.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTreeInorderTransversal{
	
	class TreeNode{      //set get 方法
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
    	int i=0, j=levelOrder.size();
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
 
    public static ArrayList<Integer> inOrderTraversalRecur(TreeNode root){
      ArrayList<Integer> inOrder = new ArrayList<Integer>();
      if (root == null)
        return inOrder;
      if(root.left != null)
        inOrder = inOrderTraversalRecur(root.left);
      inOrder.add(root.value);
      if(root.right != null)
        inOrder = inOrderTraversalRecur(root.right);
      return inOrder;
    }
    
    public static ArrayList<Integer> preOrderTraversalRecur(TreeNode root){
    	ArrayList<Integer> preOrder = new ArrayList<Integer>();
    	if (root == null)
            return preOrder;
    	preOrder.add(root.value);
    	if(root.left != null)
            preOrder = preOrderTraversalRecur(root.left);
          if(root.right != null)
            preOrder = preOrderTraversalRecur(root.right);
          return preOrder;
    }
    
    public static ArrayList<Integer> postOrderTraversalRecur(TreeNode root){
    	ArrayList<Integer> postOrder = new ArrayList<Integer>();
    	if (root == null)
            return postOrder;
    	if(root.left != null)
            postOrder = postOrderTraversalRecur(root.left);
          if(root.right != null)
            postOrder = postOrderTraversalRecur(root.right);
          postOrder.add(root.value);
          return postOrder;
    }
  }
