package com.basic.datastructure05.leetcode;

import java.util.Stack;  

public class MyQueue {  
    private Stack<String> stackFirst = new Stack<String>();  
    private Stack<String> stackSecond = new Stack<String>();  
      
    public boolean offer(String str){  
        if(stackSecond.empty()){  
            stackFirst.push(str);  
        }else{  
            while(!stackSecond.empty()){  
                stackFirst.push(stackSecond.pop());  
            }  
            stackFirst.push(str);  
        }  
        return true;  
    }  
      
    public String poll(){  
        if(!stackSecond.empty()){  
            return stackSecond.pop();  
        }else{  
            while(!stackFirst.empty()){  
                stackSecond.push(stackFirst.pop());  
            }  
            return stackSecond.pop();  
        }  
    }  
      
    public boolean empty(){  
        if(stackFirst.empty() && stackSecond.empty())  
            return true;  
        return false;  
    }  
      
    public static void main(String[] args){  
        MyQueue queue = new MyQueue();  
        queue.offer("hello ");  
        queue.offer("baby ");  
        queue.offer("!");  
          
        while(!queue.empty()){  
            System.out.print(queue.poll());  
        }  
    }  
}  