package nowcoder;

import java.util.HashMap;

public class PreIntoTree {
	class TreeNode {
		     int val;
		      TreeNode left;
		       TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	        if(pre==null || in ==null){
	        	return null;
	        }
	        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
	        for(int i=0;i< in.length; i++){
	        	map.put(in[i], i);                     //存储中序数组结点及位置
	        }
	        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
	    }
	//对于中序遍历，根节点左边的节点位于二叉树的左边，根节点右边的节点位于二叉树的右边
	 
     //利用上述这点，对二叉树节点进行归并
	private TreeNode preIn(int[] pre, int pi, int pj, int[] in, int ni, int nj, HashMap<Integer, Integer> map) {
		if(pi>pj){
			return null;
		}
		TreeNode head = new TreeNode(pre[pi]);
		int index = map.get(pre[pi]);
		head.left=preIn(pre,pi+1,pi+index-ni,in,ni,index-1,map);
		head.right=preIn(pre,pi+index-ni+1,pj,in,index+1,nj,map);
		return head;
		
	}
}
