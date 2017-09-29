package collections;

import java.util.Stack;
/**
 * stack的方法继承vector
 * 
 *
 *@author {wqz}
 *
 * @date 2017年8月24日 下午5:27:48
 */
public class StackDemo {
   public static void main(String[] args) {
	 Stack<Integer> stack = new Stack<Integer>();
	 stack.push(2);   //进站
	 stack.push(3);
	 stack.push(4);
	 stack.push(5);
	 stack.push(6);
	 stack.add(7);
	 System.out.println("stack:"+stack);
	System.out.println("栈顶元素："+stack.peek()) ;  //堆栈顶部的对象，但不从堆栈中移除它
	 boolean empty = stack.empty();   //判断是否为空
	 System.out.println("stack is or not empty:"+empty);
	 int search = stack.search(2); //查找2的位置
	 System.out.println("2 in stack pos is:"+search);
	 System.out.println("出栈：");
	 while(!stack.empty()){
		 System.out.print(+stack.pop()+",");   //出栈
	 }
}
}
