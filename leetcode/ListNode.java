package leetcode;

public class ListNode {

	 public int val;
     ListNode next;
     ListNode head=null;
	 ListNode (){}	
	 ListNode(int x) {
		this.val = x;
		this.next = null;
	}
	public void inertNode(int data){
		ListNode newNode = new ListNode(data);
    	if(head==null){
    		head = newNode;
    		return;
    	}
    	ListNode temp = head;
    	while(temp.next!=null){
    		temp = temp.next;
    	}
    	temp.next = newNode;
    }
	public int lenght(){
		int length =0;
		ListNode temp = head;
		while(temp!=null){
			length++;
			temp = temp.next;
		}
		return length;
	}
	public void printList(){
		ListNode temp =head;
		while(temp!=null){
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}
