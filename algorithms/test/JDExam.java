package algorithms.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 交易处理中，需要把同类业务（买入或卖出）中相同价格的所有委托合并起来，形成一个清单。清单的第一部分为按价格降序排列的合并后的卖出委托，
 * 紧随其后的是按相同顺序排列的买入合并委托。证券公司比较关心的是比较抢手的s条合并委托信息，需要得到买入及卖出最抢手的s条合并委托。
 * 对于买入委托，抢手的是指报价高的委托，而卖出委托中报价低的较为抢手。若买或卖的合并委托数小于s条，则全部列入清单中。
     现在小东拿到的是n个委托，请你帮忙找出最抢手的s个合并委托。
     输入有若干组，每组的第一行为两个正整数n和s（1<=n<=1000，1<=s<=50），分别表示委托数和最抢手的清单数，接下来的n行为具体的委托信息，
     每行包含3部分，第一部分为一个字母‘B’或‘S’，表示买入或卖出，后两部分为两个整数p和q，表示报价和数量。任何卖出委托的报价都比买入委托的报价高。
 * 样例输入
6 2
B 10 3
S 50 2
S 40 1
S 50 6
B 20 4
B 25 10
   样例输出
S 50 8
S 40 1
B 25 10
B 20 4
 *@author Administrator
 *
 * @date 2017年4月6日
 */
public class JDExam {
      public static void main(String[] args) {
    	  Scanner in = new Scanner(System.in);
    	  while(in.hasNext()){
    		  int n = in.nextInt();
        	  int s = in.nextInt();
    		    Map<Integer,Integer> bmap = new HashMap<Integer,Integer>();
    		    Map<Integer,Integer> smap = new HashMap<Integer,Integer>();
    		   for(int i=0;i<n;i++){
    			   String c = in.next();
    	           if(c.equals("S")){
    	        	   int p = in.nextInt();
    	        	   int q = in.nextInt();
    	        	   if(smap.containsKey(p)){
    	        		   smap.put(p, smap.get(p)+q);
    	        	   }else{
    	        		   smap.put(p, q);
    	        	   }
    	           }else{
    	        	   int p = in.nextInt();
    	        	   int q = in.nextInt();
    	        	   if(bmap.containsKey(p)){
    	        		   bmap.put(p, bmap.get(p)+q);
    	        	   }else{
    	        		   bmap.put(p, q);
    	        	   }
    	           }
    		   }
    		   List<Map.Entry<Integer, Integer>> smaps = new ArrayList<Map.Entry<Integer,Integer>>(smap.entrySet());
    		   Collections.sort(smaps,new Comparator<Map.Entry<Integer, Integer>>(){
    	            //降序排序
    	            public int compare(Entry<Integer, Integer> o1,
    	                    Entry<Integer, Integer> o2) {
    	                return o2.getKey().compareTo(o1.getKey());
    	            }

    	        });
    		   int count1 =1;
    		   for(Entry<Integer, Integer> mapping:smaps){
    			   if(count1>s){
    				   break;
    			   }
                   System.out.println("S"+" "+mapping.getKey()+" "+mapping.getValue());
                   count1++;
              } 
    		   List<Map.Entry<Integer, Integer>> bmaps = new ArrayList<Map.Entry<Integer,Integer>>(bmap.entrySet());
//    		   Collections.sort(bmaps,new Comparator<Map.Entry<Integer, Integer>>(){
//    	            //升序排序
//    	            public int compare(Entry<Integer, Integer> o1,
//    	                    Entry<Integer, Integer> o2) {
//    	                return o2.getKey().compareTo(o1.getKey());
//    	            }
//
//    	        });
    		   Collections.sort(bmaps,(o1,o2)->{return o2.getKey().compareTo(o1.getKey());});
    		   int count =1;
    		   for(Entry<Integer, Integer> mapping:bmaps){
    			   if(count>s){
    				   break;
    			   }
                   System.out.println("B"+" "+mapping.getKey()+" "+mapping.getValue());
                   count++;
              } 
    		  
    	  }
 
	}
//	public static List<Map.Entry<Integer, Integer>> sortMap(HashMap<Integer, Integer> map) {
//		List<Map.Entry<Integer, Integer>> l = new ArrayList<>(map.entrySet());
//		Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>() {
//			@Override
//			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
//				return o2.getKey() - o1.getKey();
//			}
//		});
//		return l;
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		while (sc.hasNext()) {
//			int n = sc.nextInt();
//			int s = sc.nextInt();
//			HashMap<Integer, Integer> B = new HashMap<>();
//			HashMap<Integer, Integer> S = new HashMap<>();
//			for (int i = 0; i < n; i++) {
//				String str = sc.next();
//				if (str.equals("B")) {
//					Integer b = sc.nextInt();
//					int c = sc.nextInt();
//					if (B.containsKey(b))
//						B.put(b, B.get(b) + c);
//					else
//						B.put(b, c);
//				} else {
//					Integer b = sc.nextInt();
//					int c = sc.nextInt();
//					if (S.containsKey(b))
//						S.put(b, S.get(b) + c);
//					else
//						S.put(b, c);
//				}
//			}
//			List<Map.Entry<Integer, Integer>> l1 = sortMap(S);
//			List<Map.Entry<Integer, Integer>> l2 = sortMap(B);
//			for (int i = 0; i < s && !l1.isEmpty(); i++) {
//				System.out.println("S" + " " + l1.get(0).getKey() + " " + l1.get(0).getValue());
//				l1.remove(0);
//			}
//			for (int i = 0; i < s && !l2.isEmpty(); i++) {
//				System.out.println("B" + " " + l2.get(0).getKey() + " " + l2.get(0).getValue());
//				l2.remove(0);
//			}
//		}
//	}
}
