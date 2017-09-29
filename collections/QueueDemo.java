package collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
     public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer("a");
		queue.offer("b");   //添加一个元素并返回true如果队列已满，则返回false
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");
		queue.offer("f");
		queue.offer("g");
		queue.offer("h");
		queue.add("i");  // 增加一个元索  如果队列已满，则抛出一个IIIegaISlabEepeplian异常
		System.out.println("queue is :"+queue);
		System.out.println("frist element of queue is :"+queue.peek());//返回队列头部的元素,如果队列为空，则返回null
		System.out.println("element's way frist element of queue is :"+queue.element());//返回队列头部的元素   如果队列为空，则抛出一个NoSuchElementException异常
		System.out.println("remove移除队列元素:"+queue.remove());  //队列为空时会报异常
		System.out.println("poll移除队列元素:"+queue.poll());   //队列为空时返回null
		System.out.println("is null?"+queue.isEmpty());
		while(!queue.isEmpty()){
			System.out.print(queue.remove()+" ");
		}
		//System.out.println(queue.remove());//报异常
		System.out.println("\n"+queue.poll());
	}
}
