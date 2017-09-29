package sort;

import java.util.Arrays;

public class HeapSort {
  
	public static void main(String[] args) {
		int[] a = {53,17,78,9,45,65,87,32};
		//HeapSort.buildMaxHeap(a);
		HeapSort.heapSort(a);
		
	}
	static void adjustDown(int[] a,int key,int len){
		    int x =a[key-1]; //临时保存要调整值得位置 //数组从0开始的，key是从1开始的
		    for(int i=key*2-1;i<len;i=i*2+1){
		    	if(i<len && i+1<len && a[i]<a[i+1]){
		    		i++;
		    	}
		    	if(x>a[i]){
		    		break;
		    	}else{
		    		a[key-1] = a[i];
		    		key=i+1;
		    	}
		    }
		    a[key-1]=x;
	}
	static void buildMaxHeap(int a[]){
		for(int i=a.length/2;i>=1;i--){
			adjustDown(a,i,a.length);
		}
		System.out.println(Arrays.toString(a));
	}
	static void heapSort(int[] a){
		buildMaxHeap(a);
		for(int i=a.length-1;i>=1;i--){
			 int temp =a[i];
			 a[i]=a[0];
			 a[0]=temp;
	    	 adjustDown(a,1,i);
		}
		System.out.println(Arrays.toString(a));
	}
}
