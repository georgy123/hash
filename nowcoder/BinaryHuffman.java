package nowcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 给一个字符串进行二进制编码，使得编码后字符串的长度最短。
 * 
 *
 *@author {wqz}
 *
 * @date 2017年8月31日 上午11:07:42
 */
public class BinaryHuffman {
		public static int hafuman(String s) {
		        char[] chars = s.toCharArray();
		        //hash表存放每个字符和出现的次数
		        Map<Character, Integer> hash = new HashMap<>();
		        for (int i = 0; i < chars.length; i++) {
		            if (hash.containsKey(chars[i])) {
		                hash.put(chars[i], hash.get(chars[i]) + 1);
		            } else {
		                hash.put(chars[i], 1);
		            }
		        }
		        //优先队列（最小推），每次能得到weigh最小的node
		        Queue<TreeNode> q = new PriorityQueue<>(hash.size(), new Comparator<TreeNode>() {
		            @Override
		            public int compare(TreeNode o1, TreeNode o2) {
		                return Integer.compare(o1.weight, o2.weight);
		            }
		        });
		        for (Map.Entry<Character, Integer> entry : hash.entrySet()) {
		            q.offer(new TreeNode(entry.getValue(), entry.getKey()));
		        }
		        while (q.size() > 1) {
		            //弹出两个最小的，合并为一个node
		            TreeNode left = q.poll();
		            TreeNode right = q.poll();
		            TreeNode father = new TreeNode(left.weight + right.weight);
		            father.left = left;
		            father.right = right;
		            q.offer(father);
		        }
		        TreeNode root = q.poll();
		        //计算长度     
		        return valLength(root, 0);
		    }
		    public static int valLength(TreeNode node, int depth) {
		        if (node == null) return 0;//仅计算ch有值的
		        return (node.ch == null ? 0 : node.weight) * depth + valLength(node.left, depth + 1) + valLength(node.right, depth + 1);
		    }
		    static class TreeNode {
		        int weight;//权重，出现次数
		        Character ch;//如果是初始字符，则ch为字符，如果是合并的，则为null
		        TreeNode left;
		        TreeNode right;
		 
		        public TreeNode(int weight) {
		            this.weight = weight;
		        }
		        public TreeNode(int weight, Character ch) {
		            this.weight = weight;
		            this.ch = ch;
		        }
		    }
	public static void main2(String args[]){
		    	        Scanner sc = new Scanner(System.in);
		    	        while(sc.hasNext()){
		    	            String s = sc.next();
		    	            char c[] = s.toCharArray();
		    	            int n = s.length();
		    	            Arrays.sort(c);
		    	            PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		    	            int cnt = 0;
		    	            for(int i = 0,j;i < n;){
		    	                j = i;
		    	                while(j < n && c[j] == c[i]) ++ j;
		    	                heap.offer(j - i);
		    	                i = j;
		    	                ++ cnt;
		    	            }
		    	           // System.out.println(cnt);
		    	           // System.out.println(heap.toString());
		    	            int ret = 0;
		    	            for(int i = 0;i < cnt - 1;++ i){
		    	                int a = heap.poll();
		    	                int b = heap.poll();
		    	                ret += a + b;
		    	                heap.offer(a + b);
		    	                //System.out.println(heap.toString());
		    	            } 
		    	            System.out.println(ret);
		    	        }
		    	 }
	public static void main(String[] args) {
		hafuman2("MT-TECH-TEAM");
	}
   public static int  hafuman2(String s){
	   char[] c = s.toCharArray();
	   Map<Character,Integer> map = new HashMap<>();
	   for (int i = 0; i < c.length; i++) {
		if(map.containsKey(c[i])) map.put(c[i], map.get(c[i])+1);
		else map.put(c[i], 1);
	    }
	   PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
	    for(Integer a : map.values()){
	    	 heap.offer(a);
	    }
	    int sum =0;
	    for (int i = 0; i<map.size()-1; i++) {
			int a = heap.poll();
			int b = heap.poll();
			System.out.println(b);
			sum+=a+b;
			heap.offer(a+b);
		}
	    System.out.println(sum);
	   return sum;
   }
}
