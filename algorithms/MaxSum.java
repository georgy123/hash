package algorithms;

public class MaxSum {
       /**
        * 最大字段和一般方法
        * @param a
        * @return sum
        */
	public static int maxSum(int[] a){
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			int tempSum = 0;
			for (int j = i; j < a.length; j++) {
				tempSum += a[j];
				if(tempSum > sum){
					sum = tempSum;
				}
			}
		}
		return sum;
	}
	/**
	 * 动态规划法
	 * @param a
	 * @return
	 */
	public static int maxSumByDp(int[] a){
		int sum = 0;
		int b = 0;
		for (int i = 0; i < a.length; i++) {
			if(b > 0){
				b += a[i];
			}else{
				b = a[i];
			}
			if(b > sum){
				sum = b;
			}
		}
		return sum;
	}
	public static int MaxSumDiv(int [] a,int left,int right){
		int sum =0;
		if(left == right) sum = a[left]>0?a[left]:0;
		else{
			int center = (left+right)/2;
			int leftSum = MaxSumDiv(a, left, center);
			int rightSum = MaxSumDiv(a, center+1, right);
			int s1 = 0;
			int lefts = 0;
			for(int i = center; i>=left; i--){
				lefts+= a[i];
				if(lefts > s1) s1 = lefts;
			}
			int s2 = 0;
			int rights = 0;
			for (int i = center+1; i <=right; i++) {
				rights +=a[i];
				if(rights >s2) s2 =rights;
			}
			sum = s1 + s2;
			if(sum < leftSum) sum = leftSum;
			if(sum < rightSum) sum = rightSum;
			System.out.println("S1:"+s1);
			System.out.println("leftsum:"+leftSum);
		}
		return sum;
	}
}
