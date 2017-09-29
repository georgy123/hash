package nowcoder;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。
 * 请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效
给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
测试样例：
[1,2,3,2,2],5
返回：2
 * 
 *
 *@author {wqz}
 *
 * @date 2017年9月13日 上午8:42:58
 */
public class WeixinHongB {
  public static void main(String[] args) {
	int[] a ={1,2,3,2,2};
	System.out.println(WeixinHongB.getNum2(a));
}
  public static int getNum(int[] gifts){
	  int count=1; //统计出现的次数
	  Arrays.sort(gifts);
	  int num=gifts[0];
	  for (int i = 1; i < gifts.length; i++) {
		if(num==gifts[i]){
			count++;
			if(count>gifts.length/2){
				return num;
			}
		}else{
			num=gifts[i];
			count=1;
		}
	}
	  return 0;
  }
  public static int getNum2(int[] gifts){
      HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
      for (int i = 0; i < gifts.length; i++) {
		if(map.containsKey(gifts[i])){
			map.put(gifts[i], map.get(gifts[i])+1);
		}else{
			map.put(gifts[i], +1);
		}
	}
      for(int key:map.keySet()){
    	  if(map.get(key)>gifts.length/2){
    		  return key;
    	  }
      }
	  return 0;
  }
}
