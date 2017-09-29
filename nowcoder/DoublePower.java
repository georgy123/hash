package nowcoder;
/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。 
 * 不用库函数 
 *
 *@author {wqz}
 *
 * @date 2017年9月5日 下午2:18:28
 */
public class DoublePower {
	public double Power(double base, int exponent) {
      // return Math.pow(base,exponent);
		double res =1;
		for(int i=0;i<(exponent<0?-exponent:exponent);i++){
			res*=base;
		}
		if(exponent<0)
			res=1/res;
		return res;
  }
public static void main(String[] args) {
	   
	   System.out.println(new DoublePower().Power(2, -3));
}
}
