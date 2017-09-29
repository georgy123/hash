package algorithms;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
/**
 * 回文序列
 * 
 *@author wqz
 *
 * @date 2017年3月26日
 */
public class Main {
	
	
		/** 请完成下面这个函数，实现题目要求的功能 **/
		/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
		    static int pick(int[] peaches) {
		    	HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		    	int count =0;
		    	for (int i = 0; i < peaches.length; i++) {
		    		hash.put(peaches[i], 0);
					for (int j = i; j < peaches.length; j++) {
						if( peaches[j]< peaches[i]){
							hash.put(peaches[i], hash.get(peaches[i])+1);
						}
					}
				}
		    	Collection<Integer> values = hash.values();
				for (Integer num : values) {
					if (num==0) {
						count++;
					}
		    }
				return count;
		    }
		    public static void main(String[] args){
		        Scanner in = new Scanner(System.in);
		        int trees = Integer.parseInt(in.nextLine().trim());
		        int[] peaches = new int[trees];
		        for (int i = 0; i < peaches.length; i++) {
		            peaches[i] = Integer.parseInt(in.nextLine().trim());
		        }
		        System.out.println(pick(peaches));
		    }
		
  public static void main2(String[] args) {
	     
		    Scanner scanner = new Scanner(System.in);
		    while(scanner.hasNext()){
		    	int times =0;
		    	int n = scanner.nextInt();
		    	int[] inputArr = new int[n];
		    	for(int i=0;i<n;i++){
		    		inputArr[i] = scanner.nextInt();
		    	}
		    	int head =0;
		    	int tail =n-1;
		    	while(head<tail){
		    		if(inputArr[head]>inputArr[tail]){
		    			inputArr[--tail]+=inputArr[tail+1];
		    			times++;
		    		}else if(inputArr[head]<inputArr[tail]){
		    			inputArr[++head]+=inputArr[head-1];
		    			times++;
		    		}else{
		    			head++;
		    			tail--;
		    		}
		    	}
		    	System.out.println(times);
		    }
		    scanner.close();
	}
   
}
