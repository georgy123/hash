package nowcoder;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值
 * 
 * 
 *
 * @author {wqz}
 *
 * @date 2017年9月4日 上午11:47:02
 */
public class PrintListTail {
	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	        ArrayList<Integer> list = new ArrayList<>();
	        ListNode temp =listNode;
	        if(listNode==null) return list;
	        while(temp!=null){
	        	list.add(0,temp.val);
	        	temp=temp.next;
	        }
	        return list; 
	}
  public static void main(String[] args) {
	  ArrayList list = new ArrayList<>();
	  list.add(0, 1);
	  list.add(0, 2);
	  list.add(0, 3);
	  list.add(0, 4);
	  for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i));
	}
	  
}
}
