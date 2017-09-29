package mianshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;

public class Main {
  public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	Map<Integer, String> map = new HashMap<Integer, String>();
	int count=0;
	for (int i = 0; i < n; i++) {
		int a= in.nextInt();
		String b = in.nextLine();
		if(map.containsKey(a)){
			map.put(a, map.get(a)+" "+b);
			count++;
		}else{
			map.put(a,b);
		}
	}	
	if(count>0){
		 for (Map.Entry<Integer, String> entry : map.entrySet()) {
			   if(entry.getValue().length()>7){
				   String temp=entry.getKey()<10?"0"+entry.getKey():entry.getKey()+"";
				   System.out.println(temp + "" + entry.getValue());  
			   }  
	 }  
	}else{
		System.out.println("YES");
	}
}
}
