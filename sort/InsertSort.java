package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
		int[] a={4,5,3,2};
		insertSort(a);
		System.out.println(Arrays.toString(a));
//		System.out.println(Integer.valueOf(String.valueOf('1')));
//		System.out.println(2*1.0);
    }
    public static void insertSort(int[] a){
    	for (int i = 1; i < a.length; i++) {
    		if(a[i]<a[i-1]){
    			int temp = a[i];
    			int j;
    			for( j=i-1;j>=0&&temp<a[j];j--){
    				a[j+1]=a[j];
    			}
    			a[j+1]=temp;
    		}
    		System.out.println(Arrays.toString(a));
		}
    }
}
