package algorithms;

import java.util.HashSet;

import leetcode.ListNode;

public class Node {
     public int value;  //值域
     public Node next;  //指针域，指向下一个节点
     Node head=null;
     public Node() {
	}
	 public Node(int value) {
		this.value = value;
	}
    public void inertNode(int data){
    	Node newNode = new Node(data);
    	if(head==null){
    		head = newNode;
    		return;
    	}
    	Node temp = head;
    	while(temp.next!=null){
    		temp = temp.next;
    	}
    	temp.next = newNode;
    }
	public  int lenght(){
		int length =0;
		Node temp = head;
		while(temp!=null){
			length++;
			temp = temp.next;
		}
		return length;
	}
	public void printList(){
		Node temp =head;
		while(temp!=null){
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	public Node getElement(Node list,int i){
		Node p = list.head;
		if(i==0) return list.head;
		if(i==list.lenght()) return null;
		int j=0;
		while(p!=null && j<i){
			p=p.next;
			j++;
		}
		return p;
	}
	/**
	 * 判断单链表有环
	 */
	public static boolean isLoop(Node l){
		    Node p1 = l;    //定义一个引用指向头结点  
	        Node p2 = l;    //定义另一个引用指向头结点的下一个结点  
	         // System.out.println(p2.value);
	        /** 
	         * 因为引用p2要比p1走的快，所以要用它作为循环的结束标志，为了防止当链表中个数为 
	         * 偶数时出现p2.next=null空指针异常，这时可以在循环中进行一下判断，如果这种情况 
	         * 出现一定是无环的。 
	         */  
	        while(p2 != null && p2.next != null){    
	            p1 = p1.next;  
	            p2 = p2.next.next;  
	            if(p2 == null){
	                return false;
	            }
	            //为了防止p2.val出现空指针异常，需要对p2进行判断  
	            int val1 = p1.value;  
	            int val2 = p2.value;  
	            if(val1 == val2)  
	                return true;  
	        }  
	        return false;  
	}
	/**
	 * 链表中有环入口
	 * @param l
	 * @return
	 */
	public static Node isLoop2(Node l){
	    Node p1 = l;    //定义一个引用指向头结点  
        Node p2 = l;    
        /** 
         *第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
         *第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;
         *可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。 
         */  
        while(p2 != null && p2.next != null){    
            p1 = p1.next;  
            p2 = p2.next.next;  
            if(p2 == null){
                return null;
            }
            //为了防止p2.val出现空指针异常，需要对p2进行判断  
            if(p1==p2){
            		p2 = l;
                    while(p1!= p2){
            		  p1 = p1.next;
            		  p2 = p2.next;
            		 }
            		 if(p1 == p2)
            		 return p1;
            }  
       }  
        return null;  
}
	public static Node isLoop3(Node pHead){
		HashSet<Node> set = new HashSet<Node>() ;
        while (pHead != null) {
            if (!set.add(pHead)) {       //对象值不重复时才加入，第一个重复的值即入口
            	return pHead ; 
            }
            pHead = pHead.next ;
        }
        return null ;
	}
	public static void main(String[] args) {
		Node node = new Node();
		node.inertNode(5);
		node.inertNode(3);
		node.inertNode(1);
		node.inertNode(2);
		node.inertNode(55);
		node.inertNode(36);
		node.printList();
		System.out.println("链表的长度："+node.lenght());
		Node element = node.getElement(node, 5);
		System.out.println("******************");
		System.out.println(element);
		System.out.println(node.head.value);
		/****************构造有环链表***********************/
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node4;
		System.out.println(Node.isLoop3(node1).value);
		
	}
	
}
