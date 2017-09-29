package nowcoder;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 *
 *@author {wqz}
 *
 * @date 2017年8月27日 下午3:39:19
 */
public class FindKNode {
	class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	 }
	/**
	 * mime
	 * 设置两个指针，第一个指针先移动K个，第二个指针开始移动，当第一个指针移动到链表尾，第二个指针正好移动到倒数K个；
	 * @param head
	 * @param k
	 * @return q
	 */
	public ListNode FindKthToTail(ListNode head,int k) {
        int countP =0;
        int countQ =0;
        ListNode p = head;
        ListNode q = head;
        while(p!=null){
             p=p.next;
            countP++;
            if(countP>k){
                countQ++;
                q=q.next;  //因为p=p.next所以判断时要比K小一个  
            }
        }
        return countP<k?null:q; //当K大于链表的长度时，返回null
    }
	/**
	 * other1
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthToTail2(ListNode head,int k) {
		if(k<=0) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        //p2向前移动k个节点
        for(int i=0;i<k-1;i++) {
            if(p2==null) return null;
            p2 = p2.next;
        }
        if(p2==null) return null;
        while(p2.next!=null) {
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
	/**
	 * other2
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthToTail3(ListNode list,int k) {
		if (list == null)   return list;
        ListNode node = list;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        if (count < k)  return null;
        ListNode p = list;
        for (int i = 0; i < count - k; i++) {
            p = p.next;
        }
         
        return p;
    }
}
