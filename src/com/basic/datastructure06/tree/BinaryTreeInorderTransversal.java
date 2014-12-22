package com.basic.datastructure06.tree;

import java.util.ArrayList;
import java.util.Stack;


public class BinaryTreeInorderTransversal
  {
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
    	return null;
    }
  
    class TreeNode{      //set get 方法
      protected TreeNode left;
      protected TreeNode right;
      Integer value;
    
    public TreeNode(TreeNode l, TreeNode r, Integer value){
      left = l;
      right = r;
      this.value = value;
    }
    
/*    public TreeNode getLeft(TreeNode tn){
    	
    }*/
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
  }
