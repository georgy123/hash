package nowcoder;

import java.util.Scanner;

/**
 小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。
 当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,
 小易希望你来帮他计算一下他最多能独立生活多少天。
输入描述:
输入包括一行,四个整数x, f, d, p(1 ≤ x,f,d,p ≤ 2 * 10^9),以空格分割
输出描述:
输出一个整数, 表示小易最多能独立生活多少天。
输入例子1:
3 5 100 10
输出例子1:
11
 *@author {wqz}
 *
 * @date 2017年8月19日 上午11:07:12
 */
public class WYduli {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			long x = in.nextLong();
			long f = in.nextLong();                //开始没有考虑整数的范围，超出了int的范围，应该设为long型
			long d = in.nextLong();
			long p = in.nextLong();
			long res=0;
			if(d/x<=f){
				res = d/x;                 //开始未考虑水果个数比租金多的情况
				System.out.println(res);
			}
			else{
				 res = (f*p+d)/(p+x);
				 System.out.println(res);
			}
		}
		in.close();
	}
}
