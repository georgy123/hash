package nowcoder;
/**
 * 找可以整除k的最长字串
 * 
 *
 *@author {wqz}
 *
 * @date 2017年9月1日 上午10:03:00
 */
public class MeituanMianshi1 {
    public static int getKMax(int[] a,int k){
    	int count=0;
    	for(int i=0; i<a.length; i++){
    		int sum =0;
    		if(count>a.length-i-1)
    			break;               //当前字符串的长度大于后续字符串的总长度，没必要往下比了
    		for(int j=i; j<a.length;j++){
    			sum+=a[j];
    			if(sum%k==0) 
    				count=Math.max(count, j-i+1);
    		}
    	}
    	return count;
    }
    public static void main(String[] args) {
//		int[] a = {1,2,3,4,5};
//		int k=6;
		int[] a = {3,1,2,7,7,7};
		int k=7;
		System.out.println(getKMax(a, k));
	}
}
