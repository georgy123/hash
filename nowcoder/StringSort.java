package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * 字符串排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *（在线编程剑指offer）
 *@author {wqz}
 *
 * @date 2017年8月20日 上午9:55:36
 */
public class StringSort {
	 public ArrayList<String> Permutation(String str) {
		     ArrayList<String> strlist = new ArrayList<String>();
		    TreeSet<String> set = new TreeSet<String>();
		    if(str==null || str.length()==0)  return strlist ; //return null不能通过测试用例，""空的情况未考虑
	       char[] charArray = str.toCharArray();
	       Arrays.sort(charArray);
	       permutation(charArray,0,set);
	       strlist.addAll(set);
		   return strlist;
	}
	 public static void permutation(char[]ss,int start,TreeSet<String> res){  
	        if(ss==null||start<0 ||start>ss.length){  
	            return;  
	        }  
	        if(start==ss.length-1){  
	            res.add(String.copyValueOf(ss));     //字符创若为'aa'时会显示‘aa’,‘aa’两个是不对的，得去重，hashset无序 或者在else的for循环加一个
	                                                   //判断ss[j]!=ss[start]
	        }else{  
	            for(int j=start;j<ss.length;j++){  
	                char temp=ss[j];//交换前缀,使之产生下一个前缀  
	                ss[j]=ss[start];  
	                ss[start]=temp;  
	                permutation(ss,start+1,res);  
	                temp=ss[j]; //将前缀换回来,继续做上一个的前缀排列.  
	                ss[j]=ss[start];  
	                ss[start]=temp;  
	            }  
	        }  
	    } 
	 /**
	  * 输入一个字符串，输出该字符串中字符的所有组合。举个例子，如果输入abc，它的组合有a、b、c、ab、ac、bc、abc。
             假设我们想在长度为n的字符串中求m个字符的组合。我们先从头扫描字符串的第一个字符。针对第一个字符，我们有两种选择：一是把这个字符放到组合中去，
             接下来我们需要在剩下的n-1个字符中选取m-1个字符；二是不把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选择m个字符。
             这两种选择都很容易用递归实现。
	  * @param cstr
	  */
	 public static void combination(String cstr){
		 if(cstr==null||cstr.length()==0){  
	            return ;  
	        }  
	        List<String> list=new ArrayList<String>();  
	        char[] chs = cstr.toCharArray();
	        for(int i=1;i<=chs.length;i++){  
	            combination(chs,0,i,list); 
	        }   
	 }
	 public static void combination(char[] c,int begin,int m,List<String> res){
		 if(m==0){
			 System.out.println(res.toString());
			 return;
		 }
		 if(begin==c.length){
			 return;
		 }
		   res.add(String.valueOf(c[begin]));
		   combination(c,begin+1,m-1,res);  
	       res.remove(String.valueOf(c[begin]));  
	       combination(c,begin+1,m,res);  
	 }
	 public static void main(String[] args) {
		System.out.println(new StringSort().Permutation("asdf").toString());
		StringSort.combination("asdf");
	}
}
