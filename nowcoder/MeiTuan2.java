package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 批改卷
 * 
 *师不想自己改试卷，于是让大家互相改试卷。把全班同学分为k组，每组有s(k)个同学，老师先选择一个组i，将这个组的所有试卷s(i)份都收上来放在讲台上

然后再选择一个组j，从讲台上拿s(j)份试卷随机分给j组的同学，然后把j组的所有试卷收上来，放在讲台上试卷的最下方

……重复上述过程，

最后把剩余的试卷随机分给i组的s(i)个同学。但是这样分配试卷是有缺陷的，比如：

1.有可能出现讲台上试卷不够的的情况

2.可能出现有的同学改到自己试卷的情况

题目给出k个组每个组同学的数量，请问是否可以找到一种策略使得不会出现缺陷
如果可以找到，输出"Yes"
否则输出"No"
输入：
4 
2 3 3 1
1.首先，老师选择的第一个组必须是数量最大的组；
假如我们选的第一组不是数量最大的组，对于接下来的每一个组，我们的操作都是先把讲台上的试卷减少s(i)份，然后再增加s(i)份，
讲台上的试卷数量稳定是第一组的数量，当我们碰到数量比第一组大的组时，会出现缺少试卷的缺陷，所以老师选择的第一个组必须是数量最大的组；
2.第一组的数量必须小于等于剩下各组的和
如果第一组的数量大于剩下各组的和，那么把第一组的试卷分给剩下的每个组中的同学后，还有剩余，剩余的试卷再分给第一组，就会出现自己改自己试卷的情况，出现缺陷。
3.只要第一组是数量最大的组，那么剩下各组分试卷的顺序是无所谓的
因为我们选择的第一组是数量最大的组，所以讲台上试卷数量始终都会大于等于各组的数量，必然不会出现缺少试卷的情况
 *@author {wqz}
 *
 * @date 2017年9月1日 上午10:33:31
 */
public class MeiTuan2 {
   public static void isOK(int[] a){
	   Arrays.sort(a);
	   int sum =0;
	   for (int i = 0; i < a.length-2; i++) {
		 sum+=a[i];
	}
	   if(a[a.length-1]>=sum){
		   System.out.println("Yes");
	   }else{
		   System.out.println("No");
	   }
	  
   }
   public static void main(String[] args) {
	   List list = new ArrayList<>();
	//int[] a ={2,3,3,1};
	  int[] a ={10,20,30,40,20};
	isOK(a);
}
}
