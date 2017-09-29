package nowcoder;

import java.util.Stack;
/**
 * 两栈模拟队列
 * 
 *
 *@author {wqz}
 *
 * @date 2017年9月4日 下午5:13:00
 */
public class TwoStacksQueue {
	Stack<Integer> stack1 = new Stack<Integer>(); //入栈
    Stack<Integer> stack2 = new Stack<Integer>(); //出队列
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
         if(stack1.empty() && stack2.empty()){
        	 throw new RuntimeException("Queue is empty");
         }else if(stack2.empty()){
        	 while(!stack1.empty()){
        		 stack2.push(stack1.pop());
        	 }
         }
         return stack2.pop();
    }
}
