package com.basic.datastructure05.leetcode;

import java.util.LinkedList;  
import java.util.Queue;  
  
  
public class MyStack {  
    private Queue<String> queueFirst = new LinkedList<String>();  
    private Queue<String> queueSecond = new LinkedList<String>();  
      
    public String push(String str){  
        if(queueSecond.isEmpty()){  
            queueFirst.offer(str);  
        }else if(queueFirst.isEmpty()){  
            queueSecond.offer(str);  
        }  
        return str;  
    }  
      
    public String pop(){  
        if(!queueFirst.isEmpty()){  
            while(queueFirst.size() > 1){  
                queueSecond.offer(queueFirst.poll());  
            }  
            return queueFirst.poll();  
        }else if(!queueSecond.isEmpty()){  
            while(queueSecond.size() > 1){  
                queueFirst.offer(queueSecond.poll());  
            }  
            return queueSecond.poll();  
        }  
        return null;  
    }  
      
    public boolean empty(){  
        if(queueFirst.isEmpty() && queueSecond.isEmpty())  
            return true;  
        return false;  
    }  
      
    public static void main(String[] args){  
        MyStack stack = new MyStack();  
        stack.push("hello");  
        stack.push("baby");  
        stack.push("!");  
          
        while(!stack.empty()){  
            System.out.print(stack.pop());  
        }  
    }  
}  