package nowcoder;

/**
 * 合并有序的单链表
 * 
 *
 * @author {wqz}
 *
 * @date 2017年9月6日 下午3:48:28
 */
public class MergeList {
	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null || list2 == null) {
			return list1 == null ? list2 : list1;
		}
		ListNode head = list1;   //没有判断两个头结点谁谁小
		ListNode pa = list1.next;
		ListNode pb = list2;
		while (pa != null && pb != null) {
			if (pa.val <= pb.val) {
				head.next = pa;
				head = pa;
				pa = pa.next;

			} else {
				head.next = pb;
				head = pb;
				pb = pb.next;
			}
		}
		head.next = pa == null ? pb : pa;
		if(list1.val>list1.next.val){
			ListNode temp =list1.next;
			list1.next=list1.next.next;    //比较头结点和次节点的大小
			list1=temp;
			
		}
		return list1;
	}
    //递归形式
	public ListNode Merge2(ListNode list1, ListNode list2) {
		// if(list1==null){
		// return list2;
		// }else if(list2==null){
		// return list1;
		// }
		// ListNode pMergeHead = null;
		// if(list1.val<list2.val){
		// pMergeHead = list1;
		// pMergeHead.next = Merge(list1.next,list2);
		// }else{
		// pMergeHead = list2;
		// pMergeHead.next = Merge(list1,list2.next);
		// }
		// return pMergeHead;
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.val <= list2.val) {
			list1.next = Merge(list1.next, list2);
			return list1;
		} else {
			list2.next = Merge(list1, list2.next);
			return list2;
		}
	}

	public ListNode Merge3(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null)
			return null;
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode dummy = new ListNode(-1);
		ListNode list = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val > list2.val) {
				list.next = list2;
				list = list.next;
				list2 = list2.next;
			} else {
				list.next = list1;
				list = list.next;
				list1 = list1.next;
			}
		}
		while (list1 != null) {
			list.next = list1;
			list = list.next;
			list1 = list1.next;
		}
		while (list2 != null) {
			list.next = list2;
			list = list.next;
			list2 = list2.next;
		}
		return dummy.next;
	}
}
