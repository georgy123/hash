package leetcode;
/*
 * You are given two linked lists representing two non-negative numbers. The 
 * digits are stored in reverse 
 * order and each of their nodes contain a single digit. Add the two numbers 
 * and return it as a linked list.

 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8 
 */
/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) {
*         val = x;
*         next = null;
*     }
* }
*/
public class AddTwoNumber {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		    int carry = 0;
	        ListNode dummy = new ListNode(0);
	        ListNode cur = dummy;
	        while (l1 != null || l2 != null) {
	            int a = 0;
	            int b = 0;
	            if (l1 != null) {
	                a = l1.val;
	                l1 = l1.next;
	            }
	            if (l2 != null) {
	                b = l2.val;
	                l2 = l2.next;
	            }
	            cur.next = new ListNode((a + b + carry) % 10);
	            carry = (a + b + carry) / 10;
	            cur = cur.next;
	        }
	        if (carry != 0)
	            {cur.next = new ListNode(carry);}
	        return dummy.next;
	    }
	 public static void main(String[] args) {
		ListNode node = new ListNode();
		ListNode node2 = new ListNode();
		node.inertNode(2);
		System.out.println(node.val);
		node.inertNode(4);
		node.inertNode(3);
		node2.inertNode(5);
		node2.inertNode(6);
		node2.inertNode(4);
		
		ListNode list = new AddTwoNumber().addTwoNumbers(node, node2);
		//list.printList();
		//node.printList();
	}
}
