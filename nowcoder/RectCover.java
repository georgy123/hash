package nowcoder;
/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 斐波那契数列
 * 相应的结论应该是：
（1）1 * 3方块 覆 盖3*n区域：f(n) = f(n-1) + f(n - 3)， (n > 3)
（2） 1 *4 方块 覆 盖4*n区域：f(n) = f(n-1) + f(n - 4)，(n > 4)
更一般的结论，如果用1*m的方块覆盖m*n区域，递推关系式为f(n) = f(n-1) + f(n-m)，(n > m)。 
 *@author {wqz}
 *
 * @date 2017年9月5日 上午9:48:26
 */
public class RectCover {
	public int rectCover(int target) {
         int res =1;
         int a=1;
         int b=1;
         for (int i = 1; i < target; i++) {
			 res=a+b;
			 a=b;
	         b=res;
		}
         return res;
    }
}
